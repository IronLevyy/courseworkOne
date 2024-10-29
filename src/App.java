import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        EmpoyeeBook empoyeeBook = new EmpoyeeBook();
        mainMenu(empoyeeBook);
    }

    public static void mainMenu(EmpoyeeBook empoyeeBook){
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
        actionSelection(choice, empoyeeBook);
    }

    public static void printLine(){
        System.out.println("==============================================================================================================");
    }

    public static void actionSelection(int action, EmpoyeeBook empoyeeBook){
        switch(action){
            case 1:
                System.out.print("\033[H\033[J");
                empoyeeBook.printAllEmployee();
                pauseAndBack(empoyeeBook);
                break;
            case 2:
                System.out.print("\033[H\033[J");
                System.out.printf("Траты на ЗП за месяц составляют %.0f рублей и %.0f копеек.\n", empoyeeBook.salaryPerMonth(), empoyeeBook.salaryPerMonth() % 1 * 100);
                pauseAndBack(empoyeeBook);
                break;
            case 3:
                System.out.print("\033[H\033[J");
                System.out.println(Employee.toString(empoyeeBook.findMinSalary()));
                pauseAndBack(empoyeeBook);
                break;
            case 4:
                System.out.print("\033[H\033[J");
                System.out.println(Employee.toString(empoyeeBook.findMaxSalary()));
                pauseAndBack(empoyeeBook);
                break;
            case 5:
                System.out.print("\033[H\033[J");
                System.out.printf("Средняя ЗП равна: %.2f\n", empoyeeBook.calculateAverageSalary());
                pauseAndBack(empoyeeBook);
                break;
            case 6:
                System.out.print("\033[H\033[J");
                empoyeeBook.printAllNames();
                pauseAndBack(empoyeeBook);
                break;
            case 7:
                System.out.print("\033[H\033[J");
                System.out.println(Employee.toString(empoyeeBook.findMinSalaryInDepartment(insertDepartment())));
                pauseAndBack(empoyeeBook);
                break;
            case 8:
                System.out.print("\033[H\033[J");
                System.out.println(Employee.toString(empoyeeBook.findMaxSalaryInDepartnemt(insertDepartment())));
                pauseAndBack(empoyeeBook);
                break;
            case 9:
                System.out.print("\033[H\033[J");
                empoyeeBook.salaryIndexationInDepartment(insertDepartment(), insertPercent());
                System.out.println("Индексация выполнена!");
                pauseAndBack(empoyeeBook);
                break;
            case 10:
                System.out.print("\033[H\033[J");
                System.out.println("ЗП отдела в месяц равна: " + empoyeeBook.salaryPerMonthInDepartment(insertDepartment()));
                pauseAndBack(empoyeeBook);
                break;
            case 11:
                System.out.print("\033[H\033[J");
                System.out.println("Средняя ЗП отдела равна: " + empoyeeBook.calculateAverageSalaryInDepartment(insertDepartment()));
                pauseAndBack(empoyeeBook);
                break;
            case 12:
                System.out.print("\033[H\033[J");
                empoyeeBook.printEmployeeInDepartment(insertDepartment());
                pauseAndBack(empoyeeBook);
                break;
            case 13:
                System.out.print("\033[H\033[J");
                empoyeeBook.findSalaryLessN(insertSalary());
                pauseAndBack(empoyeeBook);
                break;
            case 14:
                System.out.print("\033[H\033[J");
                empoyeeBook.findSalaryMoreN(insertSalary());
                pauseAndBack(empoyeeBook);
                break;
            case 15:
                System.out.print("\033[H\033[J");
                empoyeeBook.newEmployee(insertFirstName(), insertLastName(), insertSecondName(), insertSalary(), insertDepartment());
                pauseAndBack(empoyeeBook);
                break;
            case 16:
                System.out.print("\033[H\033[J");
                empoyeeBook.deleteEmployee(insertId());
                pauseAndBack(empoyeeBook);
                break;
            case 17:
                System.out.print("\033[H\033[J");
                empoyeeBook.salaryIndexationInDepartment(insertDepartment(), insertPercent());
                pauseAndBack(empoyeeBook);
                break;
            default:
                System.out.print("\033[H\033[J");
                System.out.print("Неверный номер действия.\n");
                pauseAndBack(empoyeeBook);
                break;
        }
    }

    public static void pauseAndBack(EmpoyeeBook empoyeeBook){
        Scanner sc = new Scanner(System.in);
        System.out.print("Нажмите [Enter], чтобы вернуться...\n");
        String exit;
        exit = sc.nextLine();
        System.out.print("\033[H\033[J");
        mainMenu(empoyeeBook);
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
