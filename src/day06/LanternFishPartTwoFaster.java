package day06;

import day00InputHelper.ReadFile;

import java.util.ArrayList;

public class LanternFishPartTwoFaster {
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
        ArrayList<Long> timers = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            timers.add(0L);
        }
        for (int i = 0; i < formattedInput.size(); i++) {
            int timerOfFish = formattedInput.get(i);
            long newEntry = timers.get(formattedInput.get(i)) + 1;
            timers.set(timerOfFish, newEntry);
        }
        System.out.println(timers);
        System.out.println();

        for (int i = 0; i < 256; i++) {
            System.out.println("days passed: " + (i+1));
            System.out.println(timers);

            long reproductions = timers.get(0);
            timers.set(0, 0L);
            System.out.println(timers);

            for (int j = 1; j < timers.size(); j++) {
                timers.set(j - 1, timers.get(j));
            }
            timers.set(6, timers.get(6) + reproductions);
            timers.set(8, reproductions);
            System.out.println(timers);
            System.out.println();
        }

        long counter = 0;
        for (int l = 0; l < timers.size(); l++) {
            counter += timers.get(l);
        }
        System.out.println("fish: " + counter);
    }
}
