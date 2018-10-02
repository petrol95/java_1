/**
 * Java. Level 1. Lesson 6. Homework 6
 *
 * @author Olga Petrova
 * @version dated Sep 29, 2018
 */

import java.util.*;
import java.io.*;

class HomeWork6 {

    public static void main(String[] args) {
        Animal[] animals = {new Cat(200, 0, 2.0f), new Cat(100, 1, 1.0f), new Dog(500, 10, 0.5f), new Dog(600, 50, 0.3f)};
        for (Animal animal : animals) {
            System.out.println(animal);
            System.out.println("run 100 m: " + animal.run(100) + ", swim 5 m: " + animal.swim(5) + ", jump 0.5 m: " + animal.jump(0.5f) + "\n");
        }
    }
}

abstract class Animal {

    protected int runLength;
    protected int swimLength;
    protected float jumpHeight;

    // Constructor
    Animal(int runLength, int swimLength, float jumpHeight) {
        if(runLength < 0 || swimLength < 0 || jumpHeight < 0) {
            System.out.println("Wrong bound for creating animal! " + this.getClass().getName() + " {" + runLength + ", " + swimLength + ", " + jumpHeight + "}");
            return;
        }
        this.runLength = runLength;
        this.swimLength = swimLength;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " {" + runLength + ", " + swimLength + ", " + jumpHeight + "}";
    }

    // Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается
    // величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
    boolean run(int length) { // бег
        if(length < 0 || length > runLength) {
            System.out.println("Wrong length to run!");
            return false;
        } else
            return true;
     }

    boolean swim(int length) { // плавание
        if(length < 0 || length > swimLength) {
            System.out.println("Wrong length to swim!");
            return false;
        } else
            return true;
     }

    boolean jump(float height) {
         if(height < 0 || height > jumpHeight) { // прыжок
            System.out.println("Wrong height to jump!");
            return false;
        } else
            return true;
     }
}

class Cat extends Animal {
    Cat(int runLength, int swimLength, float jumpHeight) {
        super(runLength, 0, jumpHeight);
        if (swimLength != 0)
            System.out.println("Cat cannot swim! Wrong swim length for creating " + this.getClass().getName() + " {" + runLength + ", " + swimLength + ", " + jumpHeight + "}\n");
    }
}

class Dog extends Animal {
    Dog(int runLength, int swimLength, float jumpHeight) {
        super(runLength, swimLength, jumpHeight);
    }
}

 