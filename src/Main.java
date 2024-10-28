public class Main {
    public static void main(String[] args) {
        EmpoyeeBook empoyeeBook = new EmpoyeeBook();
        empoyeeBook.newEmployee("123", "123", "123", 123.12,4);
        empoyeeBook.newEmployee("Олег","Калинин","Витальевич", 153452.32, 5);
        empoyeeBook.deleteEmployee(0);
        System.out.println(Employee.toString(empoyeeBook.searchEmployee(1)));
    }
}