/**
 * Java. Level 1. Lesson 3. Homework 3
 *
 * @author Olga Petrova
 * @version dated Sep 19, 2018
 */

import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {

    /**
     * 1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
     */
    public static void guessNum() {
        while (true) {
            Random rand = new Random();
            int origNum = rand.nextInt(10); // secret number
            Scanner sc = new Scanner(System.in);
            int i = 0;
            boolean res = false;
            do {
                int num;
                do {
                    System.out.println("Input number from 0 to 9");
                    num = sc.nextInt(); // input number
                } while (num < 0 || num > 9); // exit on 0 <= num <= 9
                if (num == origNum) {
                    res = true;
                    System.out.println("You guessed");
                }
                else if (num < origNum)
                    System.out.println("secret number is more");
                else
                    System.out.println("secret number is less");
                i++;
            } while (!res && i < 3); // exit on success or the end of attempts
            if (!res) // failure
                System.out.println("You failed. The number was " + origNum);
            System.out.println("Repeat once more?");
            int x;
            do {
                System.out.println("1 - yes, 0 - no");
                x = sc.nextInt();
                } while (x < 0 || x > 1); // exit on x = 0 or x = 1
            if (x == 0) // cancel
                break;
        }
     }

    /**
     * 2. Написать программу, которая загадывает слово из массива
     */
    public static void guessWord(String[] arr) {
        Random rand = new Random();
        String secret = arr[rand.nextInt(arr.length)]; // secret word
        Scanner sc = new Scanner(System.in);
        System.out.println("Guess a word");
        String variant = sc.nextLine().toLowerCase(); // input word, convert input to lowcase
        System.out.println(variant); // !!!!
        // compare words
        while (!secret.equals(variant)) { // exit on success
            System.out.println("No, you are wrong!");
            char[] sub = new char[15]; //replacement array
            for (int i = 0; i < sub.length; i++)
                sub[i] = '#';
            int i = 0;
            while (i < secret.length() && i < variant.length()) {
                if (secret.charAt(i) == variant.charAt(i))
                    sub[i] = secret.charAt(i);
                i++;
            }
            for (i = 0; i < sub.length; i++)
                System.out.print(sub[i]);
            System.out.println();
            System.out.println("Please try again");
            variant = sc.nextLine().toLowerCase();
        }
        System.out.println("Yes, you are right!");
    }

    public static void main(String[] args) {
        // call for task 1
        guessNum();

        // call for task 2
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear","pepper", "pineapple", "pumpkin", "potato"};
        guessWord(words);
    }
}

