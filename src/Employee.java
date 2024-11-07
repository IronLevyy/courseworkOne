import java.util.Objects;

public class Employee {
    private static final int minDepartmentNumber = 1;
    private static final int maxDepartmentNumber = 5;
    private static int count = 0;
    private final String firstName;
    private final String lastName;
    private final String secondName;
    private double salary;
    private int department;
    private final int id;

    public Employee(String firstName, String lastName, String secondName, double salary, int department) {
        if (department < minDepartmentNumber || department > maxDepartmentNumber) {
            throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5. Текущий номер: " + department);
        } else {
            this.department = department;
        }
        this.firstName =  firstName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.salary = salary;
        this.id = count++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public String toString() {
        if (secondName == null) {
            return  "Имя: " + firstName + '\n' +
                    "Фамилия: " + lastName + '\n' +
                    "Зарплата: " + salary + "\n" +
                    "Отдел: " + department + "\n" +
                    "ID: " + id + "\n";
        }
        return  "Имя: " + firstName + '\n' +
                "Фамилия: " + lastName + '\n' +
                "Отчество: " + secondName + '\n' +
                "Зарплата: " + salary + "\n" +
                "Отдел: " + department + "\n" +
                "ID: " + id + "\n";
    }

    public String printName() {
        if (secondName == null) {
            return "Имя: " + firstName + '\n' +
                    "Фамилия: " + lastName + '\n';
        }
        return "Имя: " + firstName + '\n' +
                "Фамилия: " + lastName + '\n' +
                "Отчество: " + secondName + '\n';
    }

    public String printData() {
        if (secondName == null) {
            return "Имя: " + firstName + '\n' +
                    "Фамилия: " + lastName + '\n' +
                    "Зарплата: " + salary + "\n" +
                    "ID: " + id + "\n";
        }
        return "Имя: " + firstName + '\n' +
                "Фамилия: " + lastName + '\n' +
                "Отчество: " + secondName + '\n' +
                "Зарплата: " + salary + "\n" +
                "ID: " + id + "\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 && department == employee.department && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(secondName, employee.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, secondName, salary, department);
    }
}
