/**
 * learnNATOv2 - Copyright (c) 2020, eluthro. All rights reserved.
 */

public class learnNATOv2 {

    public static void main(String[] args) {
        
        // Arrays
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String[] nato = { "Alfa", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliett",
                "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform",
                "Victor", "Whiskey", "X-ray", "Yankee", "Zulu" };
        int[] used = new int[26];

        // Scores and Trackers
        int index = 0;
        int correct = 0; int incorrect = 0;

        while (index <= 25) {

            // clear screen
            System.out.print("\033[H\033[2J");

            used = GenCheck(used, index);
            int genIndex = used[index];
            index++;

            // Prompt and Read Input
            System.out.println("Enter NATO for: " + alphabet[genIndex]);
            String input = StdIn.readString();

            if (checkAnswer(input, genIndex, nato) == true) {
                correct++; 
                System.out.println("Correct!");
            } else {
                incorrect++;
                System.out.println("Incorrect, answer is: " + nato[genIndex]);
            }

            pressEnterToContinue();

        }

        // Display Score
        System.out.println("# of Correct Reponses: " + correct);
        System.out.println("# of Incorrect Reponses: " + incorrect);
  
    }

    // Generate and Check Number
    public static int[] GenCheck (int[] used, int index) {
        int result = (int) (Math.random() * (26));
        if (index == 25) {
            used[index] = 0; return used;
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i] == result) return GenCheck(used, index);
        }
        used[index] = result;
        return used;
    }

    // Check Answer 
    public static boolean checkAnswer (String input, int genIndex, String[] nato) {
        input = input.substring(0, 1).toUpperCase() + input.substring(1);
        if (input.equals(nato[genIndex])) return true;
        return false;
    }

    // Press Enter to Continue
    public static void pressEnterToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }


}