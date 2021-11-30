package hw5;


import java.io.PrintStream;

public class Employee {
    private String fullName;
    private String position;
    private String eMail;
    private String phone;
    private double salary;
    private int age;

    //полный вариант конструктора
    public Employee(String fullName, String position, String eMail, String phone, double salary, int age){
        this.fullName       = fullName;
        this.position       = position;
        this.eMail          = eMail;
        this.phone          = phone;
        this.salary         = salary;
        this.age            = age;
    }

    //упрощённый вариант конструктора
    public Employee(String fullName, int age){
        this.fullName       = fullName;
        this.position       = "";
        this.eMail          = "";
        this.phone          = "";
        this.salary        = 0;
        this.age            = age;
    }

    //заполнение рабочей информации
    public void fillWorkInfo(String position, String eMail, String phone, double salary) {
        this.position       = position;
        this.eMail          = eMail;
        this.phone          = phone;
        this.salary        = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void showFullInfo()
    {
        System.out.println(">>>"+fullName+":");
        System.out.println("\tage: "+age);
        System.out.println("\tposition: "+position);
        System.out.println("\tE-mail: "+eMail);
        System.out.println("\tphone: "+phone);
        System.out.printf("\tsalary: $%.2f\n",salary);
    }
}
