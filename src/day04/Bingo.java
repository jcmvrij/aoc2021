package day04;

import day00InputHelper.ReadFile;

import java.util.ArrayList;
import java.util.Arrays;

public class Bingo {
    public static void main(String[] args) {
        String pathToTestInput = ".\\src\\day04\\testinput.txt";
        String pathToInput = ".\\src\\day04\\input.txt";
//        ArrayList<String> input = ReadFile.read(pathToTestInput);
        ArrayList<String> input = ReadFile.read(pathToInput);

        int boardDimension = 5;
        String inputBingoNumbers = input.remove(0);

        int[] bingoNumbers = parseBingoNumbers(inputBingoNumbers);
        ArrayList<int[][]> allBingoBoards = createBoards(input, boardDimension);
        int[][] winningBoard;
        int boardIndex;
        int lastBingoNumber;


        for (int i = 0; i < bingoNumbers.length; i++) {
            for (int j = 0; j < allBingoBoards.size(); j++) {
                markBoard(allBingoBoards.get(j), bingoNumbers[i]);
                winningBoard = evaluateBingo(allBingoBoards.get(j));
                boardIndex = j;
                lastBingoNumber = bingoNumbers[i];
                if (winningBoard != null) {
                    System.out.println(boardIndex);
                    int score = calculateBoardScore(winningBoard);
                    System.out.println(score + " * " + lastBingoNumber + " = " + score * lastBingoNumber);
                    allBingoBoards.remove(boardIndex);
                    j--;
                }
            }
        }

        //////////!! De eerste bingo (eerste in de output) is de eerst mogelijke bingo > part 1
        //////////!! De laatste bingo (laatste in de output) is de laatst mogelijke bingo > part 2
    }


    private static int calculateBoardScore(int[][] winningBoard) {
        int score = 0;
        for (int j = 0; j < winningBoard.length; j++) {
            int[] row = winningBoard[j];
            for (int k = 0; k < row.length; k++) {
                if (row[k] == -1) {
                    continue;
                }
                score += row[k];
            }
        }
        return score;
    }

    private static int[][] evaluateBingo(int[][] board) {
            int[] bingo = new int[]{-1, -1, -1, -1, -1};
            int[][] columnBoard = transformToColumnBoard(board);

            for (int i = 0; i < board.length; i++) {
                if (Arrays.equals(board[i], bingo) || Arrays.equals(columnBoard[i], bingo)) {
                    System.out.println("BINGO!");
                    System.out.println(Arrays.deepToString(board));
                    return board;
                }
            }
            return null;
    }

    private static int[][] transformToColumnBoard(int[][] board) {
        int[][] columnBoard = new int[5][5];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < columnBoard.length; j++) {
                columnBoard[i][j] = board[j][i];
            }
        }
        return columnBoard;
    }

    private static void markBoard(int[][] testBoard, int bingoNumber) {
        for (int i = 0; i < testBoard.length; i++) {
            for (int j = 0; j < testBoard[i].length; j++) {
                if (testBoard[i][j] == bingoNumber) {
                    testBoard[i][j] = -1;
                }
            }
        }
    }

    private static ArrayList<int[][]> createBoards(ArrayList<String> input, int boardDimension) {
        ArrayList<int[][]> allBoards = new ArrayList<>();
        int[][] board = new int[boardDimension][boardDimension];
        int rowCounter = 0;
        String[] splitRow;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).equals("")) {
                input.remove(i);
                i--;
                continue;
            }
            String boardRow = input.get(i).trim();
            splitRow = boardRow.split(" +");
            for (int j = 0; j < splitRow.length; j++) {
                board[rowCounter][j] = Integer.parseInt(splitRow[j]);
            }
            rowCounter++;

            if (rowCounter % boardDimension == 0) {
                allBoards.add(board);
                board = new int[5][5];
                rowCounter = 0;
            }
        }

        return allBoards;

    }

    private static int[] parseBingoNumbers(String inputBingoNumbers) {
        String[] splitInput = inputBingoNumbers.split(",");
        int[] bingoNumbers = new int[splitInput.length];
        for (int i = 0; i < splitInput.length; i++) {
            bingoNumbers[i] = Integer.parseInt(splitInput[i]);
        }
        return bingoNumbers;
    }
}
