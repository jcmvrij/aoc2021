package day03;

import day00InputHelper.ReadFile;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String pathToTestInput = ".\\src\\day03\\testinput.txt";
        String pathToInput = ".\\src\\day03\\input.txt";
        ArrayList<String> input = ReadFile.read(pathToTestInput);
//        ArrayList<String> input = ReadFile.read(pathToInput);

        //part1
        String binaryGamma = "";
        String binaryEpsilon = "";

        for (int i = 0; i < input.get(0).length(); i++) {
            int sum = 0;
            for (String s : input) {
                char binaryChar = s.charAt(i);
                sum += Character.getNumericValue(binaryChar);
            }
            if (sum > (0.5 * input.size())) {
                binaryGamma += "0";
                binaryEpsilon += "1";
            } else {
                binaryGamma += "1";
                binaryEpsilon += "0";
            }
        }
        System.out.println(binaryGamma);
        System.out.println(binaryEpsilon);

        int gamma = Integer.valueOf(binaryGamma, 2);
        int epsilon = Integer.valueOf(binaryEpsilon, 2);
        System.out.println("Answer to part 1: " + (gamma * epsilon));

        //part2

        String oxygenGeneratorRating = "";
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

            ArrayList<String> narrowedDownDiagnostics = new ArrayList<>();
            for (String s : input) {
                if (s.charAt(oxygenRatingIndex) == oxygenBitCriteria) {
                    narrowedDownDiagnostics.add(s);
                }
            }
            oxygenRatingIndex++;
            input = narrowedDownDiagnostics;
            if (input.size() == 1) {
                break;
            }
        }
        oxygenGeneratorRating = input.get(0);



        input = ReadFile.read(pathToTestInput);
//        input = ReadFile.read(pathToInput);
        String co2ScrubberRating = "";
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

            ArrayList<String> narrowedDownDiagnostics = new ArrayList<>();
            for (String s : input) {
                if (s.charAt(co2RatingIndex) == co2BitCriteria) {
                    narrowedDownDiagnostics.add(s);
                }
            }
            co2RatingIndex++;
            input = narrowedDownDiagnostics;
            if (input.size() == 1) {
                break;
            }
        }
        co2ScrubberRating = input.get(0);

        System.out.println();
        System.out.println(oxygenGeneratorRating);
        System.out.println(co2ScrubberRating);
        int oxygen = Integer.valueOf(oxygenGeneratorRating, 2);
        int co2 = Integer.valueOf(co2ScrubberRating, 2);
        System.out.println("Answer to part 2: " + (oxygen * co2));
    }
}