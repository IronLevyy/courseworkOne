import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        mainMenu(employeeBook);
    }

    public static void mainMenu(EmployeeBook employeeBook){
        printLine();
        System.out.printf("%1$78s\n","Добро пожаловать в программу учёта работников!");
        System.out.println("Выберите нужное действие:");
        System.out.printf("%1$-55s%2$-55s\n","1)Получить список всех сотрудников","10)Найти сумму затрат на ЗП по отделу");
        System.out.printf("%1$-55s%2$-55s\n","2)Посчитать сумму затрат на ЗП в месяц","11)Найти среднюю зп по отделу");
        System.out.printf("%1$-55s%2$-55s\n","3)Найти сотрудника с минимальной ЗП","12)Показать всех сотрудников отдела");
        System.out.printf("%1$-55s%2$-55s\n","4)Найти сотрудника с максимальной ЗП;","13)Показать всех у кого ЗП меньше \"N\"");
        System.out.printf("%1$-55s%2$-55s\n","5)Подсчитать среднее значение зарплат","14)Показать всех у кого ЗП больше (или равно) \"N\"");
        System.out.printf("%1$-55s%2$-55s\n","6)Распечатать ФИО всех сотрудников","15)Добавить нового сотрудника");
        System.out.printf("%1$-55s%2$-55s\n","7)Найти сотрудника с минимальной ЗП по отделу","16)Удалить сотрудника");
        System.out.printf("%1$-55s%2$-55s\n","8)Найти сотрудника с максимальной ЗП по отделу","17)Проиндексировать ЗП сотрудников на процент");
        System.out.print("9)Проиндексировать ЗП сотрудников отдела на процент\n");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        actionSelection(choice, employeeBook);
    }

    public static void printLine(){
        System.out.println("==============================================================================================================");
    }

    public static void actionSelection(int action, EmployeeBook employeeBook){
        switch(action){
            case 1:
                System.out.print("\033[H\033[J");
                employeeBook.printAllEmployee();
                pauseAndBack(employeeBook);
                break;
            case 2:
                System.out.print("\033[H\033[J");
                System.out.printf("Траты на ЗП за месяц составляют %.0f рублей и %.0f копеек.\n", employeeBook.getSalaryPerMonth(), employeeBook.getSalaryPerMonth() % 1 * 100);
                pauseAndBack(employeeBook);
                break;
            case 3:
                System.out.print("\033[H\033[J");
                System.out.println(employeeBook.findEmployeeWithMinSalary());
                pauseAndBack(employeeBook);
                break;
            case 4:
                System.out.print("\033[H\033[J");
                System.out.println(employeeBook.findEmployeeWithMaxSalary());
                pauseAndBack(employeeBook);
                break;
            case 5:
                System.out.print("\033[H\033[J");
                System.out.printf("Средняя ЗП равна: %.2f\n", employeeBook.calculateAverageSalary());
                pauseAndBack(employeeBook);
                break;
            case 6:
                System.out.print("\033[H\033[J");
                employeeBook.printAllNames();
                pauseAndBack(employeeBook);
                break;
            case 7:
                System.out.print("\033[H\033[J");
                System.out.println(employeeBook.findMinSalaryInDepartment(insertDepartment()));
                pauseAndBack(employeeBook);
                break;
            case 8:
                System.out.print("\033[H\033[J");
                System.out.println(employeeBook.findMaxSalaryInDepartnemt(insertDepartment()));
                pauseAndBack(employeeBook);
                break;
            case 9:
                System.out.print("\033[H\033[J");
                employeeBook.riseSalaryByDeparnt(insertDepartment(), insertPercent());
                System.out.println("Индексация выполнена!");
                pauseAndBack(employeeBook);
                break;
            case 10:
                System.out.print("\033[H\033[J");
                System.out.println("ЗП отдела в месяц равна: " + employeeBook.getSalaryPerMonthInDepartment(insertDepartment()));
                pauseAndBack(employeeBook);
                break;
            case 11:
                System.out.print("\033[H\033[J");
                System.out.println("Средняя ЗП отдела равна: " + employeeBook.calculateAverageSalaryInDepartment(insertDepartment()));
                pauseAndBack(employeeBook);
                break;
            case 12:
                System.out.print("\033[H\033[J");
                employeeBook.printEmployeeInDepartment(insertDepartment());
                pauseAndBack(employeeBook);
                break;
            case 13:
                System.out.print("\033[H\033[J");
                employeeBook.printSalaryLessThan(insertSalary());
                pauseAndBack(employeeBook);
                break;
            case 14:
                System.out.print("\033[H\033[J");
                employeeBook.printSalaryMoreThan(insertSalary());
                pauseAndBack(employeeBook);
                break;
            case 15:
                System.out.print("\033[H\033[J");
                Employee newEmployee = new Employee(insertFirstName(), insertLastName(), insertSecondName(), insertSalary(), insertDepartment());
                if (employeeBook.newEmployee(newEmployee)) {
                    System.out.println("Сотрудник создан успешно.");
                }else System.out.println("Создание сотрудника не удалось.");
                pauseAndBack(employeeBook);
                break;
            case 16:
                System.out.print("\033[H\033[J");
                if (employeeBook.deleteEmployee(insertId())) {
                    System.out.println("Сотрудник удалён.");
                }else System.out.println("Удаление не выполнено.");
                pauseAndBack(employeeBook);
                break;
            case 17:
                System.out.print("\033[H\033[J");
                employeeBook.riseSalary(insertPercent());
                pauseAndBack(employeeBook);
                break;
            default:
                System.out.print("\033[H\033[J");
                System.out.print("Неверный номер действия.\n");
                pauseAndBack(employeeBook);
                break;
        }
    }

    public static void pauseAndBack(EmployeeBook employeeBook){
        Scanner sc = new Scanner(System.in);
        System.out.print("Нажмите [Enter], чтобы вернуться...\n");
        String exit;
        exit = sc.nextLine();
        System.out.print("\033[H\033[J");
        mainMenu(employeeBook);
    }

    public static int insertDepartment() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер отдела: ");
        return sc.nextInt();
    }

    public static int insertId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID: ");
        return sc.nextInt();
    }

    public static double insertPercent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите нужный процент: ");
        return sc.nextDouble();
    }

    public static String insertLastName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Фамилию: ");
        return sc.nextLine();
    }

    public static String insertFirstName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Имя: ");
        return sc.nextLine();
    }

    public static String insertSecondName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Отчество: ");
        return sc.nextLine();
    }

    public static double insertSalary() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите зарплату: ");
        return sc.nextDouble();
    }
}
