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
        String oxygenGeneratorRating;
        char oxygenBitCriteria;
        int oxygenRatingIndex = 0;

        for (int i = 0; i < input.get(0).length(); i++) {
            int sum = 0;
            for (String s : input) {
                char binaryChar = s.charAt(i);
                sum += Character.getNumericValue(binaryChar);
            }
            if (sum >= (0.5 * input.size())) {
                oxygenBitCriteria = '1';
            } else {
                oxygenBitCriteria = '0';
            }

            input = narrowDownDiagnosticsAtIndexByBitCriteria(input, oxygenRatingIndex, oxygenBitCriteria);
            oxygenRatingIndex++;
            if (input.size() == 1) {
                break;
            }
        }
        oxygenGeneratorRating = input.get(0);


//        input = ReadFile.read(pathToTestInput);
        input = ReadFile.read(pathToInput);

        String co2ScrubberRating;
        char co2BitCriteria;
        int co2RatingIndex = 0;

        for (int i = 0; i < input.get(0).length(); i++) {
            int sum = 0;
            for (String s : input) {
                char binaryChar = s.charAt(i);
                sum += Character.getNumericValue(binaryChar);
            }
            if (sum >= (0.5 * input.size())) {
                co2BitCriteria = '0';
            } else {
                co2BitCriteria = '1';
            }

            input = narrowDownDiagnosticsAtIndexByBitCriteria(input, co2RatingIndex, co2BitCriteria);
            co2RatingIndex++;
            if (input.size() == 1) {
                break;
            }
        }
        co2ScrubberRating = input.get(0);

        System.out.println(oxygenGeneratorRating);
        System.out.println(co2ScrubberRating);
        int oxygen = Integer.valueOf(oxygenGeneratorRating, 2);
        int co2 = Integer.valueOf(co2ScrubberRating, 2);
        System.out.println("Answer to part 2: " + (oxygen * co2));
    }

    public static ArrayList<String> narrowDownDiagnosticsAtIndexByBitCriteria(ArrayList<String> diagnostics, int index, char bitCriteria) {
        ArrayList<String> narrowedDownDiagnostics = new ArrayList<>();
        for (String s : diagnostics) {
            if (s.charAt(index) == bitCriteria) {
                narrowedDownDiagnostics.add(s);
            }
        }
        return narrowedDownDiagnostics;
    }
}