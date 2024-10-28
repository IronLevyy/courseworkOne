public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("123", "123", "123", 123.12,4);
        Employee employee2 = new Employee("123", "123", "123", 123.12,4);
        System.out.println(employee1.getId());
        System.out.println(employee2.getId());
        System.out.println(employee1.equals(employee2));
        System.out.println(employee1.hashCode());
        System.out.println(employee2.hashCode());
    }
}