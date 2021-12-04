package day03;

import day00InputHelper.ReadFile;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String pathToTestInput = ".\\src\\day03\\testinput.txt";
        String pathToInput = ".\\src\\day03\\input.txt";
//        ArrayList<String> input = ReadFile.read(pathToTestInput);
        ArrayList<String> input = ReadFile.read(pathToInput);

        //part1
        StringBuilder binaryGamma = new StringBuilder();
        StringBuilder binaryEpsilon = new StringBuilder();

        for (int i = 0; i < input.get(0).length(); i++) {
            int sum = 0;
            for (String s : input) {
                char binaryChar = s.charAt(i);
                sum += Character.getNumericValue(binaryChar);
            }
            if (sum > (0.5 * input.size())) {
                binaryGamma.append("0");
                binaryEpsilon.append("1");
            } else {
                binaryGamma.append("1");
                binaryEpsilon.append("0");
            }
        }
        System.out.println(binaryGamma);
        System.out.println(binaryEpsilon);

        int gamma = Integer.valueOf(binaryGamma.toString(), 2);
        int epsilon = Integer.valueOf(binaryEpsilon.toString(), 2);
        System.out.println("Answer to part 1: " + (gamma * epsilon));

        //part2
        String oxygenGeneratorRating = getRating(input, true);
        String co2ScrubberRating = getRating(input, false);

        System.out.println(oxygenGeneratorRating);
        System.out.println(co2ScrubberRating);
        int oxygen = Integer.valueOf(oxygenGeneratorRating, 2);
        int co2 = Integer.valueOf(co2ScrubberRating, 2);
        System.out.println("Answer to part 2: " + (oxygen * co2));
    }

    public static ArrayList<String> narrowDownAtIndexByBitCriteria(ArrayList<String> diagnostics, int index, char bitCriteria) {
        ArrayList<String> narrowedDownDiagnostics = new ArrayList<>();
        for (String s : diagnostics) {
            if (s.charAt(index) == bitCriteria) {
                narrowedDownDiagnostics.add(s);
            }
        }
        return narrowedDownDiagnostics;
    }

    public static String getRating(ArrayList<String> diagnostics, boolean isByMostCommon) {
        char bitCriteria;
        int ratingIndex = 0;

        int i = 0;
        while (i < diagnostics.get(0).length() && diagnostics.size() > 1) {
            int sum = 0;
            for (String s : diagnostics) {
                char binaryChar = s.charAt(i);
                sum += Character.getNumericValue(binaryChar);
            }
            if (sum >= (0.5 * diagnostics.size())) {
                if (isByMostCommon) {
                    bitCriteria = '1';
                } else {
                    bitCriteria = '0';
                }
            } else {
                if (isByMostCommon) {
                    bitCriteria = '0';
                } else {
                    bitCriteria = '1';
                }
            }

            diagnostics = narrowDownAtIndexByBitCriteria(diagnostics, ratingIndex, bitCriteria);
            ratingIndex++;
            i++;
        }
        return diagnostics.get(0);
    }
}