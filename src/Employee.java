public class Employee {
    private String firstName;
    private String lastName;
    private String secondName;
    private int salary;
    private int department;
    private int id;
    private static int count = 0;

    public Employee(String firstName, String lastName, String secondName, double salary, int department) {
        this.firstName =  firstName;
        this.lastName = lastName;
        this.secondName = secondName;
        salary = salary * 100;
        this.salary = (int) salary;
        if (0 < department && department < 6) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5.");
        }
        this.id = counter();
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
        return (double) salary / 100;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public void setSalary(double salary) {
        salary = salary * 100;
        this.salary = (int) salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    private int counter() {
        id = count;
        count++;
        return id;
    }

    public String toString() {
        return "Имя: " + firstName.toString() + "\n" +
               "Фамилия: " + lastName.toString() + "\n" +
               "Отчество: " + secondName.toString() + "\n" +
               "Id: "  + id + "\n" +
               "Отдел: " + department + "\n" +
               "Зарплата: " + salary + "\n";
    }

    public boolean equals(Employee comparable) {
        if (this == comparable) {
            return true;
        }
        if (this.getClass() != comparable.getClass() || comparable == null) {
            return false;
        }
        return firstName.equals(comparable.firstName) && lastName.equals(comparable.lastName) && secondName.equals(comparable.secondName) && salary == comparable.salary && department == comparable.department;
    }

    public int hashCode() {
        int result = firstName == null ? 0 : firstName.hashCode();
        result = 31 * result + lastName == null ? 0 : lastName.hashCode();
        result = 31 * result + secondName == null ? 0 : secondName.hashCode();
        result = 31 * result + salary;
        result = 31 * result + department;

        return result;
    }
}
