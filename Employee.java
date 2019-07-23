import java.util.*;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;

/**
 * Java. Level 1. Lesson 5. Homework 5
 *
 * @author Olga Petrova
 * @version dated Jul 23, 2019
 */

public class Employee {
    // Создать класс "Сотрудник" с полями: фио, должность, email, телефон, зарплата, возраст;
    private String name;
    private String position;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    // Конструктор
    public Employee(String name, String position, String email, String telephone, int salary, int age) {
        this.name  = name;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge(){
        return age;
    }    

    public String toString() {
        return  "Name: " + name + ", position: " + position + 
                ", email: " + email + ", telephone: " + telephone + 
                ", salary: " + salary + ", age: " + age;
    }

    // Чтение списка сотрудников из файла
    // вариант 1
    public static void readScanner(String fileName) {
        int ind = 0;
        String str = "";
        try(Scanner sc = new Scanner(new File(fileName))){
            while(sc.hasNextLine()) {
                str += sc.nextLine() + "\n";
                ind++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Employee[] arr = new Employee[ind];
        String[] lines = str.split("\n");
        int i = 0;
        for (String line : lines) {
            String[] par = line.split(", ");
            arr[i] = new Employee(par[0], par[1], par[2], par[3],
                Integer.parseInt(par[4]), Integer.parseInt(par[5]));
            i++;
        }
        getEmp(arr, 40);
    }
    
    // вариант 2
    public static void readFiles(String fileName) {
        List<String> arrList = new ArrayList<>();
        try {
            arrList = Files.readAllLines(Paths.get(fileName),
                StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int i = 0;
        Employee[] arr = new Employee[arrList.size()];
        for (String str : arrList) {
            String[] par = str.split(", ");
            arr[i] = new Employee(par[0], par[1], par[2], par[3],
                Integer.parseInt(par[4]), Integer.parseInt(par[5]));
            i++;
        }
        getEmp(arr, 40);
    }
    
    // С помощью цикла вывести информацию только о сотрудниках старше 40 лет
    public static void getEmp(Employee[] arr, int age) {
        System.out.println("Employees older than 40:");
        for (int i = 0; i < arr.length; i++)
            if (arr[i].getAge() > age)
                System.out.println(arr[i]);
    }
    
    public static void main(String[] args) {
        // Чтение из файла, печать сотрудников старше 40 лет
        // readScanner("emp.txt");
        readFiles("emp.txt");
    }
}