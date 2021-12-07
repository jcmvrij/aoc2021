package day07;

import day00InputHelper.ReadFile;

import java.util.ArrayList;
import java.util.Arrays;

public class Whale {
    public static void main(String[] args) {
//        ArrayList<String> input = ReadFile.read(".\\src\\day07\\testinput.txt");
        ArrayList<String> input = ReadFile.read(".\\src\\day07\\input.txt");
        String[] splitInput = input.get(0).split(",");

        //part1
        int[] formattedInput = new int[splitInput.length];
        for (int i = 0; i < splitInput.length; i++) {
            formattedInput[i] = Integer.parseInt(splitInput[i]);
        }

        Arrays.sort(formattedInput);
        int median = formattedInput[formattedInput.length/2];
        int fuelSpent = 0;
        for (int i = 0; i < formattedInput.length; i++) {
            int fuelNeeded = Math.abs(formattedInput[i] - median);
            fuelSpent += fuelNeeded;
        }
        System.out.println("day07 part 1\nminimum fuel use: " + fuelSpent);

        //part2
        formattedInput = new int[splitInput.length];
        for (int i = 0; i < splitInput.length; i++) {
            formattedInput[i] = Integer.parseInt(splitInput[i]);
        }

        int max = 0;
        for (int i = 0; i < formattedInput.length; i++) {
            if (formattedInput[i] > max) {
                max = formattedInput[i];
            }
        }

        int[] combinedFuels = new int[max];
        for (int i = 0; i < max; i++) {
            int combinedFuel = 0;
            int[] fuels = new int[formattedInput.length];
            for (int j = 0; j < formattedInput.length; j++) {
                int position = formattedInput[j];
                int steps = Math.abs(position - i);
                int fuel = 0;
                for (int k = 0; k <= steps; k++) {
                    fuel += k;
                }
                combinedFuel += fuel;
                fuels[j] = fuel;
            }
            combinedFuels[i] = combinedFuel;
        }
        System.out.println();

        int minimumFuel = combinedFuels[0];
        for (int i = 1; i < combinedFuels.length; i++) {
            if (combinedFuels[i] < minimumFuel) {
                minimumFuel = combinedFuels[i];
            }
        }
        System.out.println("day07 part 2\nminimum fuel use: " + minimumFuel);
    }
}