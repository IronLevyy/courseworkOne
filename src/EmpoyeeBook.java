public class EmpoyeeBook {
    private final Employee[] employees = new Employee[10];

    public void newEmployee(String firstName, String lastName, String secondName, double salary, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(firstName, lastName, secondName, salary, department);
                return;
            }
        }
    }

    public boolean deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
                return true;
            }
        }
        return false;
    }

    public Employee searchEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        throw new IllegalArgumentException("Сотрудника с таким Id не существует.");
    }

}
