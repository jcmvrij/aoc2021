package day05;

import day00InputHelper.ReadFile;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String pathToTestInput = ".\\src\\day05\\testinput.txt";
        String pathToInput = ".\\src\\day05\\input.txt";
//        ArrayList<String> input = ReadFile.read(pathToTestInput);
    ArrayList<String> input = ReadFile.read(pathToInput);

        int[][][] formattedInput = formatInput(input);
        System.out.println(Arrays.deepToString(formattedInput));

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
        System.out.println(diagramDimensions);

        int[][] diagram = new int[diagramDimensions + 1][diagramDimensions + 1];
        printDiagram(diagram);

        for (int i = 0; i < formattedInput.length; i++) {
            fillDiagram(diagram, formattedInput[i]);
        }
        printDiagram(diagram);

        int counter = 0;
        for (int i = 0; i < diagram.length; i++) {
            for (int j = 0; j < diagram[i].length; j++) {
                if (diagram[i][j] >= 2) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }

    private static void fillDiagram(int[][] diagram, int[][] coordinate) {
        int[] delta = calculateDelta(coordinate);
        System.out.println(Arrays.toString(delta));
        if (isHorizontalLine(delta)){
            drawHorizontal(diagram, coordinate, delta);
        } else if (isVerticalLine(delta)) {
            drawVertical(diagram, coordinate, delta);
        } else {
            System.out.println("invalid");
        }
        System.out.println("-");
    }

    private static void drawVertical(int[][] diagram, int[][] input, int[] delta) {
        int startY;
        if (input[0][1] <= input[1][1]) {
            startY = input[0][1];
        } else {
            startY = input[1][1];
        }

        int x = input[0][0];
        System.out.println(startY);
        System.out.println(x);

        for (int i = 0; i <= delta[1]; i++) {
            diagram[startY + i][x] += 1;
        }
    }

    private static void drawHorizontal(int[][] diagram, int[][] input, int[] delta) {
        int startX;
        if (input[0][0] <= input[1][0]) {
            startX = input[0][0];
        } else {
            startX = input[1][0];
        }

        int y = input[0][1];
        for (int i = 0; i <= delta[0]; i++) {
            System.out.println(i);
            System.out.println("D: " + (startX+i) + " , " + y);
            diagram[y][startX + i] += 1;
        }
    }

    private static boolean isVerticalLine(int[] delta) {
        return delta[0] == 0;
    }

    private static boolean isHorizontalLine(int[] delta) {
        return delta[1] == 0;
    }

    private static int[] calculateDelta(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        int d1;
        int d2;
        if (x1 <= x2) {
            d1 = x2 - x1;
        } else {
            d1 = x1 - x2;
        }
        if (y1 <= y2) {
            d2 = y2 - y1;
        } else {
            d2 = y1 - y2;
        }

        return new int[]{d1, d2};
    }

    private static void printDiagram(int[][] diagram) {
        for (int i = 0; i < diagram.length; i++) {
            for (int j = 0; j < diagram[i].length; j++) {
                System.out.print(diagram[i][j] + "  ");
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
