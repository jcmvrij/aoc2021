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
            if (sum < (0.5 * input.size())) {
                binaryGamma += "0";
                binaryEpsilon += "1";
            } else {
                binaryGamma += "1";
                binaryEpsilon += "0";
            }
        }

        int gamma = Integer.valueOf(binaryGamma, 2);
        int epsilon = Integer.valueOf(binaryEpsilon, 2);
        System.out.println(gamma * epsilon);

        //part2



    }
}
