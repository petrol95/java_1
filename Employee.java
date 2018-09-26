/**
 * Java. Level 1. Lesson 5. Homework 5
 *
 * @author Olga Petrova
 * @version dated Sep 25, 2018
 */

import java.util.*;
import java.io.*;

public class Employee {
    // Создать класс "Сотрудник" с полями: фио, должность, email, телефон, зарплата, возраст;
    private String name;
    private String position;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    // Конструктор по умолчанию
    public Employee() {
        this.name  = "Unknown";
        this.position = "";
        this.email = "";
        this.telephone = "";
        this.salary = 0;
        this.age = 0;
    }

    // Конструктор с параметрами
    public Employee(String name, String position, String email, String telephone, int salary, int age) {
        this.name  = name;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public String getPosition(){
        return position;
    }

    public String getEmail(){
        return email;
    }

    public String getTelephone(){
        return telephone;
    }

    public int getSalary(){
        return salary;
    }

    public int getAge(){
        return age;
    }    

    public String toString() {
        return "Name: " + getName() + ", position: " + getPosition() + ", email: " + getEmail() + ", telephone: " + getTelephone() + ", salary: " + getSalary() + ", age: " + getAge();
    }

    // Чтение списка сотрудников из файла
    public int readFromFile(Employee[] arr, String fileName) {
        int i = 0, salary = 0, age = 0;
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine() && i < arr.length) {
                String[] par = sc.nextLine().split(", "); // split string
                try {
                    salary = Integer.parseInt(par[4]); // format salary
                } catch (NumberFormatException e) {
                    System.err.println("Wrong salary format!");
                }
                try {
                    age = Integer.parseInt(par[5]); // format age
                } catch (NumberFormatException e) {
                    System.err.println("Wrong age format!");
                }
                arr[i] = new Employee(par[0], par[1], par[2], par[3], salary, age);
                i++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return i; // number of read lines
    }
    
    public static void main(String[] args) {
        int num = 0; // number of lines, successfully read from file
        // Создать массив из 5 сотрудников
        Employee[] empArray = new Employee[5];
        // Чтение из файла
        num = new Employee().readFromFile(empArray, "emp.txt");
        // С помощью цикла вывести информацию только о сотрудниках старше 40 лет
        System.out.println("Employees older than 40:");
        for (int i = 0; i < num; i++)
            if (empArray[i].getAge() > 40)
                System.out.println(empArray[i].toString());
    }
}
 



 