package day06;

import day00InputHelper.ReadFile;

import java.util.ArrayList;
import java.util.Arrays;

public class Lanternfish {
    public static void main(String[] args) {
        String pathToTestInput = ".\\src\\day06\\testinput.txt";
        String pathToInput = ".\\src\\day06\\input.txt";
//        ArrayList<String> input = ReadFile.read(pathToTestInput);
        ArrayList<String> input = ReadFile.read(pathToInput);

        String[] splitInput = input.get(0).split(",");
        ArrayList<Integer> formattedInput = new ArrayList<>();
        for (int i = 0; i < splitInput.length; i++) {
            formattedInput.add(Integer.parseInt(splitInput[i]));
        }

        System.out.println(formattedInput);
        for (int j = 0; j < 80; j++) {
            for (int i = 0; i < formattedInput.size(); i++) {
                formattedInput.set(i, (formattedInput.get(i) - 1));
            }

            for (int i = 0; i < formattedInput.size(); i++) {
                if (formattedInput.get(i) == -1) {
                    formattedInput.set(i, 6);
                    formattedInput.add(8);
                }
            }
            System.out.println(formattedInput);
        }
        System.out.println(formattedInput.size());
    }
}
