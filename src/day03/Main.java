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
        String binaryGamma = "";
        String binaryEpsilon = "";

        for (int i = 0; i < input.get(0).length(); i++) {
            int sum = 0;
            for (int j = 0; j < input.size(); j++) {
                char binaryChar = input.get(j).charAt(i);
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

        int gamma = Integer.valueOf(binaryGamma, 2);
        int epsilon = Integer.valueOf(binaryEpsilon, 2);
        System.out.println(binaryGamma);
        System.out.println(gamma);
        System.out.println(binaryEpsilon);
        System.out.println(epsilon);
        System.out.println(gamma * epsilon);
        System.out.println("-----------------");

        //part2

        String oxygenGeneratorRating = "";

        char oxygenBitCriteria;



        for (int i = 0; i < input.get(0).length(); i++) {
            int sum = 0;
            for (int j = 0; j < input.size(); j++) {
                char binaryChar = input.get(j).charAt(i);
                sum += Character.getNumericValue(binaryChar);
            }
            if (sum >= (0.5 * input.size())) {
                oxygenBitCriteria = '1';
            } else {
                oxygenBitCriteria = '0';
            }
            oxygenGeneratorRating += oxygenBitCriteria;

            ArrayList<String> newInput = new ArrayList<>();
            for (int j = 0; j < input.size(); j++) {
                if (input.get(j).charAt(oxygenGeneratorRating.length() - 1) == oxygenBitCriteria) {
                    newInput.add(input.get(j));
                }
            }
            input = newInput;
            if (input.size() == 1) {
                oxygenGeneratorRating = input.get(0);
                break;
            }
            System.out.println(input);
        }
        System.out.println(oxygenGeneratorRating);
        System.out.println(input);


        input = ReadFile.read(pathToInput);
        String co2ScrubberRating = "";
        char co2BitCriteria;

        for (int i = 0; i < input.get(0).length(); i++) {
            int sum = 0;
            for (int j = 0; j < input.size(); j++) {
                char binaryChar = input.get(j).charAt(i);
                sum += Character.getNumericValue(binaryChar);
            }
            if (sum >= (0.5 * input.size())) {
                co2BitCriteria = '0';
            } else {
                co2BitCriteria = '1';
            }
            co2ScrubberRating += co2BitCriteria;

            ArrayList<String> newInput = new ArrayList<>();
            for (int j = 0; j < input.size(); j++) {
                if (input.get(j).charAt(co2ScrubberRating.length() - 1) == co2BitCriteria) {
                    newInput.add(input.get(j));
                }
            }
            input = newInput;
            if (input.size() == 1) {
                co2ScrubberRating = input.get(0);
                break;
            }
            System.out.println(input);
        }
        System.out.println(co2ScrubberRating);
        System.out.println(input);

        System.out.println("--------");
        System.out.println();

        int oxygen = Integer.valueOf(oxygenGeneratorRating, 2);
        System.out.println(oxygen);
        int co2 = Integer.valueOf(co2ScrubberRating, 2);
        System.out.println(co2);

        System.out.println(oxygen * co2);
    }


}
