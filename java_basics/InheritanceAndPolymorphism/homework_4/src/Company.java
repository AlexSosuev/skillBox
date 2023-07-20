import java.util.*;

public final class Company {
    private int income = (int) (Math.random() * 150_000_000);

    private ArrayList<Employee> employees;

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public Company(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(ArrayList<Employee> employeesList) {
        employees.addAll(employeesList);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public int getIncome() {
        return income;
    }

    private List<Employee> getTopSalaryStaff(int count) {
        return getFilteredList(count, (o1, o2) -> o2.getMonthSalary() - o1.getMonthSalary());
    }

    private List<Employee> getLowestSalaryStaff(int count) {
        return getFilteredList(count, Comparator.comparingInt(Employee::getMonthSalary));
    }

    private List<Employee> getFilteredList(int count, Comparator<Employee> comparator) {
        List<Employee> copyList = new ArrayList<>(employees);
        copyList.sort(comparator);
        return copyList.subList(0, count);
    }

    public void highSalary(int count) {
        System.out.println("\n" + "Список " + count + " сотрудников компании с наибольшими, зарплатами по убыванию:");
        for (Employee employee : getTopSalaryStaff(count)) {
            System.out.println(employee.getClass().getName() + " с месячной зарплатой - " + employee.getMonthSalary());
        }
    }

    public void lowSalary(int count) {
        System.out.println("\n" + "Список " + count + " сотрудников компании с наименьшими зарплатами по возрастанию:");
        for (Employee employee : getLowestSalaryStaff(count)) {
            System.out.println(employee.getClass().getName() + " с месячной зарплатой - " + employee.getMonthSalary());
        }
    }
}