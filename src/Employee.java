import java.util.Objects;

class Employee {
    private static int counter;

    private int id;
    private String firstName;
    private String secondName;
    private String middleName;
    private int department;
    private double salary;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    Employee(String secondName, String firstName, String middleName, int department, double salary) {
        counter++;

        id = counter;
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("[id=%d, %s %s %s. Отдел №%d. Зарпалата %,.2f рублей]", id, secondName, firstName, middleName, department, salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department && Double.compare(employee.salary, salary) == 0 && Objects.equals(firstName, employee.firstName) && Objects.equals(secondName, employee.secondName) && Objects.equals(middleName, employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, middleName, department, salary);
    }
}