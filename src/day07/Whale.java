package day07;

import day00InputHelper.ReadFile;

import java.util.ArrayList;
import java.util.Arrays;

public class Whale {
    public static void main(String[] args) {
        String pathToTestInput = ".\\src\\day07\\testinput.txt";
        String pathToInput = ".\\src\\day07\\input.txt";
//        ArrayList<String> input = ReadFile.read(pathToTestInput);
        ArrayList<String> input = ReadFile.read(pathToInput);
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
        System.out.println("Answer part 1: " + fuelSpent);

        //part2
        formattedInput = new int[splitInput.length];
        for (int i = 0; i < splitInput.length; i++) {
            formattedInput[i] = Integer.parseInt(splitInput[i]);
        }
        System.out.println(Arrays.toString(formattedInput));

        int max = 0;
        for (int i = 0; i < formattedInput.length; i++) {
            if (formattedInput[i] > max) {
                max = formattedInput[i];
            }
        }
        System.out.println("max: " + max);


//        int bestLocation = 0;
//        for (int i = 0; i < formattedInput.length; i++) {
//            int smallestFuel = 0;
//            for (int j = 0; j < formattedInput.length; j++) {
//                int steps = Math.abs(formattedInput[i] - formattedInput[j]);
//                System.out.println(steps);
//
//                int fuel = 0;
//                for (int k = 0; k <= steps; k++) {
//                    System.out.println(k);
//                    fuel += k;
//                }
//                if (fuel < smallestFuel) {
//                    bestLocation = i;
//                }
//            }
//
//        }
//        System.out.println(bestLocation);

//        //converge to 5



        int[] combinedFuels = new int[max];

        for (int k = 0; k < max; k++) {
            int combinedFuel = 0;
            System.out.println(k);
            int[] fuels = new int[formattedInput.length];
            for (int i = 0; i < formattedInput.length; i++) {
                int position = formattedInput[i];
                int steps = Math.abs(position - k);
                int fuel = 0;
                for (int j = 0; j <= steps; j++) {
                    fuel += j;
                }
                combinedFuel += fuel;
                fuels[i] = fuel;
            }
            System.out.println(Arrays.toString(fuels));
            combinedFuels[k] = combinedFuel;

        }
        System.out.println();
        System.out.println(Arrays.toString(combinedFuels));
        int minimumFuel = combinedFuels[0];
        for (int i = 1; i < combinedFuels.length; i++) {
            if (combinedFuels[i] > minimumFuel) {
                continue;
            }
            minimumFuel = combinedFuels[i];
        }

        System.out.println(minimumFuel);

//        int[] fuels = new int[formattedInput.length];
//        for (int i = 0; i < formattedInput.length; i++) {
//            int position = formattedInput[i];
//            int steps = Math.abs(position - convergePoint);
//            int fuel = 0;
//            for (int j = 0; j <= steps; j++) {
//                fuel += j;
//            }
//            combinedFuel += fuel;
//            fuels[i] = fuel;
//        }
//        System.out.println(Arrays.toString(fuels));
//        System.out.println();
//        System.out.println(combinedFuel);








    }
}
