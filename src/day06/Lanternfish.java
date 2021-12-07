package day06;

import day00InputHelper.ReadFile;

import java.util.ArrayList;

public class Lanternfish {
    public static long counter = 0;

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

        for (int i = 0; i < 80; i++) {
            int children = 0;
            for (int j = 0; j < formattedInput.size(); j++) {
                formattedInput.set(j, (formattedInput.get(j) - 1));
                if (formattedInput.get(j) == -1) {
                    formattedInput.set(j, 6);
                    children++;
                }
            }
            for (int j = 0; j < children; j++) {
                formattedInput.add(8);
            }
        }
        System.out.println("part1: " + formattedInput.size());

        //part2
        formattedInput = new ArrayList<>();
        for (int i = 0; i < splitInput.length; i++) {
            formattedInput.add(Integer.parseInt(splitInput[i]));
        }

        for (int i = 0; i < formattedInput.size(); i++) {
            counter++;
            countPopulation(formattedInput.get(i), 256);
            System.out.print(i + " / ");
            System.out.println(formattedInput.size());
        }
        System.out.println("part2: " + counter);
    }

    public static void countPopulation(int lifeDays, int days) {
        while (days > 0) {
            lifeDays--;
            days--;
            if (lifeDays == -1) {
                lifeDays = 6;
                countPopulation(8, days);
                counter++;
            }
        }
    }
}