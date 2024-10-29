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
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getId() == id) {
                employees[i] = null;
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
        throw new IllegalArgumentException("Сотрудника с таким Id не существует.");
    }

    public void printAllEmployee() {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            System.out.println(Employee.toString(employee));
        }
    }

    public void printEmployeeInDepartment(int department) {
        for (Employee employee : employees) {
            if (employee == null || employee.getDepartment() != department) {
                continue;
            }
            printEmployeeData(employee);
        }
    }

    public double salaryPerMonth() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            sum += employee.getSalary();
        }
        return sum;
    }

    public double salaryPerMonthInDepartment(int department) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee == null || employee.getDepartment() != department) {
                continue;
            }
            sum += employee.getSalary();
        }
        return sum;
    }

    public Employee findMinSalary() {
        int idEmployee = -1;
        double salary = findMaxSalary().getSalary();
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() < salary) {
                salary = employee.getSalary();
                idEmployee = employee.getId();
            }
        }
        if (idEmployee < 0) {
            throw new ArrayStoreException("Список работников пуст.");
        }
        return findEmployee(idEmployee);
    }

    public Employee findMaxSalary() {
        int idEmployee = -1;
        double salary = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() > salary) {
                salary = employee.getSalary();
                idEmployee = employee.getId();
            }
        }
        if (idEmployee < 0) {
            throw new ArrayStoreException("Список работников пуст.");
        }
        return findEmployee(idEmployee);
    }

    public double calculateAverageSalary() {
        int quantityEmployee = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            quantityEmployee++;
        }
        if (quantityEmployee == 0) {
            return 0;
        }
        return salaryPerMonth() / quantityEmployee;
    }

    public double calculateAverageSalaryInDepartment(int department) {
        int quantityEmployee = 0;
        for (Employee employee : employees) {
            if (employee == null || employee.getDepartment() != department) {
                continue;
            }
            quantityEmployee++;
        }
        if (quantityEmployee == 0) {
            return 0;
        }
        return salaryPerMonthInDepartment(department) / quantityEmployee;
    }

    public void printAllNames() {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            System.out.printf("%-10s%s\n", "Фамилия: ", employee.getLastName());
            System.out.printf("%-10s%s\n", "Имя: ", employee.getFirstName());
            System.out.printf("%-10s%s\n", "Отчество: ", employee.getSecondName());
            System.out.print("\n");
        }
    }

    public Employee findMinSalaryInDepartment(int department) {
        int idEmployee = -1;
        double salary = findMaxSalaryInDepartnemt(department).getSalary();
        for (Employee employee : employees) {
            if (employee == null || employee.getDepartment() != department) {
                continue;
            }
            if (employee.getSalary() < salary) {
                salary = employee.getSalary();
                idEmployee = employee.getId();
            }
        }
        if (idEmployee < 0) {
            throw new ArrayStoreException("Список работников пуст.");
        }
        return findEmployee(idEmployee);
    }

    public Employee findMaxSalaryInDepartnemt(int department) {
        int idEmployee = -1;
        double salary = 0;
        for (Employee employee : employees) {
            if (employee == null || employee.getDepartment() != department) {
                continue;
            }
            if (employee.getSalary() > salary) {
                salary = employee.getSalary();
                idEmployee = employee.getId();
            }
        }
        if (idEmployee < 0) {
            throw new ArrayStoreException("Список работников пуст.");
        }
        return findEmployee(idEmployee);
    }

    public void salaryIndexation(double percentIndexation) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            employee.setSalary(employee.getSalary() * (1 + percentIndexation / 100));
        }
    }

    public void salaryIndexationInDepartment(int department, double percentIndexation) {
        for (Employee employee : employees) {
            if (employee == null || employee.getDepartment() != department) {
                continue;
            }
            employee.setSalary(employee.getSalary() * (1 + percentIndexation / 100));
        }
    }

    public void findSalaryMoreN(double N) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() >= N) {
                printEmployeeData(employee);
            }
        }
    }

    public void findSalaryLessN(double N) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() < N) {
                printEmployeeData(employee);
            }
        }
    }

    private void printEmployeeData(Employee employee) {
        System.out.printf("%-10s%s\n", "Фамилия: ", employee.getLastName());
        System.out.printf("%-10s%s\n", "Имя: ", employee.getFirstName());
        System.out.printf("%-10s%s\n", "Отчество: ", employee.getSecondName());
        System.out.printf("%-10s%s\n", "Id: ", employee.getId());
        System.out.printf("%-10s%s\n", "Зарплата: ", employee.getSalary());
        System.out.println();
    }

}
