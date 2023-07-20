import java.util.*;

public class Main {

    public static void main(String[] args) {
        Company company = new Company(new ArrayList<>());

        ArrayList<Employee> operators = new ArrayList<>();
        for (int i = 0; i < 180; i++) {
            operators.add(new Operator());
        }
        company.hireAll(operators);

        ArrayList<Employee> managers = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            managers.add(new Manager());
        }
        company.hireAll(managers);

        ArrayList<Employee> topManagers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            topManagers.add(new TopManager());
        }
        company.hireAll(topManagers);

        System.out.println("Список сотрудников компании с зарплатами по возрастанию:");
        for (Employee employee : company.getEmployees()) {
            System.out.println(employee);
        }
        company.highSalary(12);
        company.lowSalary(30);

        System.out.println("\n" + "Кризис. В компании прошло массовое увольнение (50% сотрудников)");
        int temp = company.getEmployees().size() / 2;
        for (int i = 0; i < temp; i++) {
            company.getEmployees().remove((int) (Math.random() * temp));
        }
        company.highSalary(12);
        company.lowSalary(30);
    }
}