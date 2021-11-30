package hw5;

public class Main {


    public static void main(String[] args) {
        Employee[] ourCompany = new Employee[10];

        initCompany(ourCompany);

        showOldEmployees(ourCompany);
    }

    public static void initCompany(Employee[] ourCompany){
        //заполнение разными способами, специально пропущенны порядковые номера

        ourCompany[0] = new Employee("Гадя Петрович Хренова","зам. директора по развлечениям",
                "gadia@ourcompany.com","+375(33)654-32-10", 965.70, 41);

        ourCompany[1] = new Employee("Иванов Иван Иванович", "самый полезный помощник директора",
                "iii@ourcompany.com", "80162-52-22-33", 666.66, 55);

        ourCompany[2] = new Employee("Сидорова Лариса Ивановна", 26);
        ourCompany[2].fillWorkInfo("секретарша","sidorova_koza@ourcompany.com", "+375(29)7940588",356.00);

        ourCompany[5] = new Employee("Кац Сигизмунд Абрамович", 66);
        ourCompany[5].setPosition("финансовый менеджер");
        ourCompany[5].setPhone("8-800-555-35-35");
        ourCompany[5].seteMail("fast_money@ourcompany.com");
        ourCompany[5].setSalary(1234.50d);

        ourCompany[7] = new Employee("Джон Смитт","мерчендайзер","Smitt1987@ourcompany.com","800.288.2020", 1111.11, 34);
    }

    public static void showOldEmployees(Employee[] ourCompany){
       System.out.println("Наши сотрудники старше 40 лет:");
        for (Employee employee : ourCompany) {
            if (employee != null && employee.getAge() > 40) {
                employee.showFullInfo();
            }
        }
    }
}
