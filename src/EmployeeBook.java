import java.util.ArrayList;

public class EmployeeBook {
    private final Employee[] employees = new Employee[10];
    private int employeeCount = 0;

    public boolean newEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                employeeCount++;
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getId() == id) {
                employees[i] = null;
                employeeCount--;
                return true;
            }
        }
        return false;
    }

    public Employee findEmployee(int id) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new IllegalArgumentException("Сотрудника с ID: " + id + " не найдено.");
    }

    public void printAllEmployee() {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            System.out.println(employee);
        }
    }

    private Employee[] findEmployeeInDepartment(int department) {
        ArrayList<Employee> employeesInDepartment = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employeesInDepartment.add(employee);
            }
        }
        return employeesInDepartment.toArray(new Employee[0]);
    }

    public void printEmployeeInDepartment(int department) {
        Employee[] employeeInDepartnemt = findEmployeeInDepartment(department);
        for (Employee employee : employeeInDepartnemt) {
            System.out.println(employee.printData());
        }
    }

    public double getSalaryPerMonth() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            sum += employee.getSalary();
        }
        return sum;
    }

    public double getSalaryPerMonthInDepartment(int department) {
        double sum = 0;
        Employee[] employeeInDepartment = findEmployeeInDepartment(department);
        for (Employee employee : employeeInDepartment) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public Employee findEmployeeWithMinSalary() {
        if (employeeCount == 0) {
            throw new IllegalStateException("Список работников пуст.");
        }
        Employee targetEmployee = createTargetEmployee();
        targetEmployee.setSalary(Double.MAX_VALUE);
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() < targetEmployee.getSalary()) {
                targetEmployee = employee;
            }
        }
        return targetEmployee;
    }

    public Employee findEmployeeWithMaxSalary() {
        if (employeeCount == 0) {
            throw new IllegalStateException("Список работников пуст.");
        }
        Employee targetEmployee = createTargetEmployee();
        targetEmployee.setSalary(Double.MIN_VALUE);
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() > targetEmployee.getSalary()) {
                targetEmployee = employee;
            }
        }
        return targetEmployee;
    }

    public double calculateAverageSalary() {
        if (employeeCount == 0) {
            return 0;
        }
        return getSalaryPerMonth() / employeeCount;
    }

    public double calculateAverageSalaryInDepartment(int department) {
        Employee[] employeeInDepartment = findEmployeeInDepartment(department);
        if (employeeInDepartment.length == 0) {
            return 0;
        }
        return getSalaryPerMonthInDepartment(department) / employeeInDepartment.length;
    }

    public void printAllNames() {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            employee.printName();
        }
    }

    public Employee findMinSalaryInDepartment(int department) {
        if (employeeCount == 0) {
            throw new IllegalStateException("Список работников пуст.");
        }
        Employee[] employeeInDepartment = findEmployeeInDepartment(department);
        Employee targetEmployee = createTargetEmployee();
        targetEmployee.setSalary(Double.MAX_VALUE);
        for (Employee employee : employeeInDepartment) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() > targetEmployee.getSalary()) {
                targetEmployee = employee;
            }
        }
        return targetEmployee;
    }

    public Employee findMaxSalaryInDepartnemt(int department) {
        if (employeeCount == 0) {
            throw new IllegalStateException("Список работников пуст.");
        }
        Employee[] employeeInDepartment = findEmployeeInDepartment(department);
        Employee targetEmployee = createTargetEmployee();
        targetEmployee.setSalary(Double.MIN_VALUE);
        for (Employee employee : employeeInDepartment) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() > targetEmployee.getSalary()) {
                targetEmployee = employee;
            }
        }
        return targetEmployee;
    }

    private void riseSalary(Employee[] employees, double percent) {
        double newSalary;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            newSalary = employee.getSalary() * (1 + percent / 100);
            employee.setSalary(newSalary);
        }
    }

    public void riseSalary(double percent) {
        riseSalary(employees, percent);
    }

    public void riseSalaryByDeparnt(int department, double percent) {
        Employee[] targetEmployees = findEmployeeInDepartment(department);
        riseSalary(targetEmployees, percent);
    }

    private Employee[] findSalaryMoreThan(double salaryToCompare) {
        ArrayList<Employee> employeesWithSalaryMoreThan = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() >= salaryToCompare) {
                employeesWithSalaryMoreThan.add(employee);
            }
        }
        return employeesWithSalaryMoreThan.toArray(new Employee[0]);
    }

    private Employee[] findSalaryLessThan(double salaryToCompare) {
        ArrayList<Employee> employeesWithSalaryLessThan = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() >= salaryToCompare) {
                employeesWithSalaryLessThan.add(employee);
            }
        }
        return employeesWithSalaryLessThan.toArray(new Employee[0]);
    }

    public void printSalaryMoreThan(double salaryToCompare) {
        Employee[] employeesToPrint = findSalaryMoreThan(salaryToCompare);
        for (Employee employee : employeesToPrint) {
            employee.printData();
        }
    }

    public void printSalaryLessThan(double salaryToCompare) {
        Employee[] employeesToPrint = findSalaryLessThan(salaryToCompare);
        for (Employee employee : employeesToPrint) {
            employee.printData();
        }
    }

    private Employee createTargetEmployee() {
        return new Employee(null,null,null,0,2);
    }

}
