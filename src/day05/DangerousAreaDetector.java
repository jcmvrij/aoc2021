package day05;

import day00InputHelper.ReadFile;

import java.util.ArrayList;

public class DangerousAreaDetector {
    public static void main(String[] args) {
        String pathToTestInput = ".\\src\\day05\\testinput.txt";
        String pathToInput = ".\\src\\day05\\input.txt";
//        ArrayList<String> input = ReadFile.read(pathToTestInput);
        ArrayList<String> input = ReadFile.read(pathToInput);

        int[][][] formattedInput = formatInput(input);
//        System.out.println(Arrays.deepToString(formattedInput));

        int diagramDimensions = 0;
        for (int i = 0; i < formattedInput.length; i++) {
            for (int j = 0; j < formattedInput[i].length; j++) {
                for (int k = 0; k < formattedInput[j].length; k++) {
                    if (formattedInput[i][j][k] > diagramDimensions) {
                        diagramDimensions = formattedInput[i][j][k];
                    }
                }
            }
        }

        int[][] diagram = new int[diagramDimensions + 1][diagramDimensions + 1];
//        printDiagram(diagram);

        for (int i = 0; i < formattedInput.length; i++) {
            fillDiagram(diagram, formattedInput[i]);
        }
//        printDiagram(diagram);

        int dangerousAreas = 0;
        for (int i = 0; i < diagram.length; i++) {
            for (int j = 0; j < diagram[i].length; j++) {
                if (diagram[i][j] >= 2) {
                    dangerousAreas++;
                }
            }
        }
        System.out.println(dangerousAreas);
    }

    private static void fillDiagram(int[][] diagram, int[][] coordinate) {
        int[] delta = calculateDelta(coordinate);

        if (isHorizontalLine(delta)){
            drawHorizontal(diagram, coordinate, delta);
        } else if (isVerticalLine(delta)) {
            drawVertical(diagram, coordinate, delta);
        } else if (isDiagonalLine(delta)) {
            drawDiagonal(diagram, coordinate, delta);
        } else {
            System.out.println("invalid");
        }
    }

    private static void drawDiagonal(int[][] diagram, int[][] input, int[] delta) {
        int[] beginCoordinate;
        int[] endCoordinate;
        if (input[0][0] < input[1][0]) {
            beginCoordinate = input[0];
            endCoordinate = input[1];
        } else {
            beginCoordinate = input[1];
            endCoordinate = input[0];
        }
        int deltaY;
        if (beginCoordinate[1] < endCoordinate[1]) {
            deltaY = 1;
        } else {
            deltaY = -1;
        }

        for (int i = 0; i <= delta[0]; i++) {
            diagram[(beginCoordinate[0] + i)][(beginCoordinate[1] + (i * deltaY))] += 1;
        }
    }

    private static boolean isDiagonalLine(int[] delta) {
        return delta[0] == delta[1];
    }

    private static void drawVertical(int[][] diagram, int[][] input, int[] delta) {
        int startX = input[0][0];
        int startY = Math.min(input[0][1], input[1][1]);
        for (int i = 0; i <= delta[1]; i++) {
            diagram[startX][startY + i] += 1;
        }
    }

    private static void drawHorizontal(int[][] diagram, int[][] input, int[] delta) {
        int startX = Math.min(input[0][0], input[1][0]);
        int startY = input[0][1];
        for (int i = 0; i <= delta[0]; i++) {
            diagram[startX + i][startY] += 1;
        }
    }

    private static boolean isVerticalLine(int[] delta) {
        return delta[0] == 0;
    }

    private static boolean isHorizontalLine(int[] delta) {
        return delta[1] == 0;
    }

    private static int[] calculateDelta(int[][] coordinates) {
        int d1 = Math.abs(coordinates[0][0] - coordinates[1][0]);
        int d2 = Math.abs(coordinates[0][1] - coordinates[1][1]);
        return new int[]{d1, d2};
    }

    private static void printDiagram(int[][] diagram) {
        for (int i = 0; i < diagram.length; i++) {
            for (int j = 0; j < diagram[i].length; j++) {
                System.out.print(diagram[j][i] + "  ");
            }
            System.out.println();
        }
    }

    private static int[][][] formatInput(ArrayList<String> input) {
        int[][][] formattedInput = new int[input.size()][2][2];
        for (int i = 0; i < input.size(); i++) {
            String[] splitInput = input.get(i).split(" -> ");
            String[] xCoordinates = splitInput[0].split(",");
            String[] yCoordinates = splitInput[1].split(",");
            formattedInput[i][0][0] = Integer.parseInt(xCoordinates[0]);
            formattedInput[i][0][1] = Integer.parseInt(xCoordinates[1]);
            formattedInput[i][1][0] = Integer.parseInt(yCoordinates[0]);
            formattedInput[i][1][1] = Integer.parseInt(yCoordinates[1]);
        }
        return formattedInput;
    }
}