/**
 * Java. Level 1. Lesson 4. Homework 4
 *
 * @author Olga Petrova
 * @version dated Sep 24, 2018
 */

import java.util.Random;
import java.util.Scanner;

class TicTacToe {

    final int SIZE = 5;
    final int SERIES = 4; // dots to win
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';
    char[][] map  = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    
    public static void main(String[] args){
        new TicTacToe().game();
    }

    void game() {
        initMap();
        while(true) {
            humanTurn();
            if (checkWin(DOT_X, SIZE, SERIES)){
                System.out.println("YOU WON!");
                break;
            }
            if (isMapFull()){
                System.out.println("Sorry, DRAW...");
                break; 
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O, SIZE, SERIES)){
                System.out.println("AI WON!");
                break;
            }
            if (isMapFull()){
                System.out.println("Sorry, DRAW...");
                break;
            }
        }
        System.out.println("GAME OVER!");
        printMap();
    }

    void initMap() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
        System.out.println("Size = " + SIZE + "    Dots to win = " + SERIES);
    }

    void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1.." + SIZE + "):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    void aiTurn() {
        int x, y;
        // block winning series
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (isCellValid(j,i)) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X, SIZE, SERIES)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
        // random choice
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == DOT_EMPTY)
                    return false;
        }
    return true;
    
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        return map[y][x] == DOT_EMPTY;
    }

    boolean checkWin(char dot, int size, int series) {
        for (int i = 0; i < size; i++) {
            int horiz = 0, vert = 0; // dots in a row horizontally & vertically
            for (int j = 0; j < size; j++) {
                horiz = (map[i][j] == dot) ? (horiz + 1) : 0;
                vert = (map[j][i] == dot) ? (vert + 1) : 0;
                if (horiz == series || vert == series)
                    return true;
                }
        }
        for (int i = series - 1; i < size; i++) {
            int incRightLeft = 0, decRightLeft = 0, incLeftRight = 0, decLeftRight = 0; // dots in a row diagonally
            for (int j = 0; j < i + 1; j++) {
                incRightLeft = (map[i - j][j] == dot) ? (incRightLeft + 1) : 0;
                decRightLeft = (map[size - 1 - j][size - 1 - i + j] == dot) ? (decRightLeft + 1) : 0;
                incLeftRight = (map[size - 1 - i + j][j] == dot) ? (incLeftRight + 1) : 0;
                decLeftRight = (map[j][size - 1 - i + j] == dot) ? (decLeftRight + 1) : 0;
                if (incRightLeft == series || decRightLeft == series || incLeftRight == series || decLeftRight == series)
                    return true;
            }
        }
        return false;
    }
}