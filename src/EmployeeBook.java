
public class EmployeeBook {
    private Employee[] employees = new Employee[10];

    {
        addEmployee("Афанасьев", "Анатолий", "Евгеньевич", 2, 145_000);
        addEmployee("Петров", "Петр", "Васильевич", 1, 350_000);
        addEmployee("Иванов", "Иван", "Иванович", 5, 120_000);
        addEmployee("Болдырев", "Сергей", "Никитич", 5, 95_000);
        addEmployee("Серебряков", "Алексей", "Евгеньевич", 1, 150_000);
    }

    /*
    Добавить/удалить сотрудника
     */
    public void addEmployee(String secondName, String firstName, String middleName, int department, double salary) {
        if (department > 5 || department < 1 || salary < 0) {
            System.out.println("Всего 5 отделов в компании от 1 до 5. Зарплата не может быть отрицательной");
            return;
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(secondName, firstName, middleName, department, salary);
                return;
            }
        }
        System.out.println("В книге сотрудников нет места");
    }

    public void removeEmployee(String secondName, String firstName, String middleName) {
        Employee temp = find(secondName, firstName, middleName);
        if (temp == null) {
            System.out.printf("В книге сотрудников нет сотрудника %s %s %s\n", secondName, firstName, middleName);
            return;
        }
        for (int i = 0; i < employees.length; i++) {
            if (temp.equals(employees[i])) {
                employees[i] = null;
                return;
            }
        }
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getId() == id) {
                employees[i] = null;
                return;
            }
        }
        System.out.println("В книге сотрудников нет сотрудника с указанным id");
    }

    /*
    Изменить сотрудника
     */
    public void changeSalary(String secondName, String firstName, String middleName, double newSalary) {
        if (newSalary < 0) {
            System.out.println("Зарплата не может быть отрицательной");
            return;
        }
        Employee temp = find(secondName, firstName, middleName);
        if (temp != null) {
            temp.setSalary(newSalary);
        } else {
            System.out.println("Сотрудник не найден.");
        }
    }
    public void changeDepartment(String secondName, String firstName, String middleName, int department) {
        if (department < 1 || department > 5) {
            System.out.println("В компании есть всего 5 отедлов. 1-5");
            return;
        }
        Employee temp = find(secondName, firstName, middleName);
        if (temp != null) {
            temp.setDepartment(department);
        } else {
            System.out.println("Сотрудник не найден.");
        }
    }


    /*
    Методы которые работают сразу для всего массива сотрудников
     */
    public void showAll() {
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp);
            }
        }
    }

    public void showAllByDepartments() {
        int counter;
        for (int i = 1; i < 6; i++) {
            counter = 0;
            System.out.println("Отдел №" + i);
            for (Employee emp : employees) {
                if (emp != null && emp.getDepartment() == i) {
                    System.out.printf("%s %s %s\n", emp.getSecondName(), emp.getFirstName(), emp.getMiddleName());
                    counter++;
                }
            }
            if (counter == 0) {
                System.out.println("В этом отделе ещё нет сотрудников.");
            }
        }
    }
    public double getMonthSumSalary() {
        double sum = 0;
        for (Employee emp : employees) {
            if (emp != null) {
                sum += emp.getSalary();
            }
        }
        return sum;
    }

    public Employee findLowPaidEmployee() {
        double min = Integer.MAX_VALUE;
        for (Employee emp : employees) {
            if (emp != null) {
                if (emp.getSalary() < min) {
                    min = emp.getSalary();
                }
            }
        }
        for (Employee emp : employees) {
            if (emp != null) {
                if (emp.getSalary() == min) {
                    return emp;
                }
            }
        }
        return null;
    }

    public Employee findHighPaidEmployee() {
        double max = Integer.MIN_VALUE;
        for (Employee emp : employees) {
            if (emp != null) {
                if (emp.getSalary() > max) {
                    max = emp.getSalary();
                }
            }
        }
        for (Employee emp : employees) {
            if (emp != null) {
                if (emp.getSalary() == max) {
                    return emp;
                }
            }
        }
        return null;
    }

    public double getAverageSalary() {
        return getMonthSumSalary() / getNumberOfEmployees();
    }

    public void showAllFullName() {
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println((emp.getSecondName() + " " + emp.getFirstName() + " " + emp.getMiddleName()));
            }
        }
    }

    public void indexSalary(int percent) {
        for (Employee emp : employees) {
            if (emp != null) {
                emp.setSalary(emp.getSalary() + emp.getSalary() * percent / 100);
            }
        }
    }

    /*
    Методы которые принимают номер отдела в качестве параметра
     */
    public Employee findLowPaidEmployee(int department) {
        if (department < 1 || department > 5) {
            System.out.println("Такого отдела нет.");
            return null;
        }

        double min = Integer.MAX_VALUE;
        for (Employee emp : employees) {
            if (emp != null && emp.getDepartment() == department) {
                if (emp.getSalary() < min) {
                    min = emp.getSalary();
                }
            }
        }
        for (Employee emp : employees) {
            if (emp != null && emp.getDepartment() == department) {
                if (emp.getSalary() == min) {
                    return emp;
                }
            }
        }
        return null;
    }

    public Employee findHighPaidEmployee(int department) {
        if (department < 1 || department > 5) {
            System.out.println("Такого отдела нет.");
            return null;
        }

        double max = Integer.MIN_VALUE;
        for (Employee emp : employees) {
            if (emp != null && emp.getDepartment() == department) {
                if (emp.getSalary() > max) {
                    max = emp.getSalary();
                }
            }
        }
        for (Employee emp : employees) {
            if (emp != null && emp.getDepartment() == department) {
                if (emp.getSalary() == max) {
                    return emp;
                }
            }
        }
        return null;
    }

    public double getMonthSumSalary(int department) {
        if (department < 1 || department > 5) {
            System.out.println("Такого отдела нет.");
            return -1;
        }
        double sum = 0;
        for (Employee emp : employees) {
            if (emp != null && emp.getDepartment() == department) {
                sum += emp.getSalary();
            }
        }
        return sum;
    }

    public double getAverageSalary(int department) {
        if (getNumberOfEmployees(department) == 0) {
            System.out.println("В отделе нет сотдруников");
            return -1;
        }
        if (department < 1 || department > 5) {
            System.out.println("Такого отдела нет.");
            return -1;
        }
        return getMonthSumSalary(department) / getNumberOfEmployees(department);
    }

    public void indexSalary(int department, int percent) {
        if (department < 1 || department > 5) {
            System.out.println("Такого отдела нет.");
            return;
        }
        for (Employee emp : employees) {
            if (emp != null && emp.getDepartment() == department) {
                emp.setSalary(emp.getSalary() + emp.getSalary() * percent / 100);
            }
        }
    }

    public void showAll(int department) {
        for (Employee emp : employees) {
            if (emp != null && emp.getDepartment() == department) {
                System.out.printf("[id=%d, %s %s %s, зарплата %,.2f рублей]\n", emp.getId(), emp.getSecondName(), emp.getFirstName(), emp.getMiddleName(), emp.getSalary());
            }
        }
    }

    /*
    Методы которые принимают размер зарплаты и выводят сотрудников с зп больше или меньше переданной
     */
    public void showEmployeesWithSalaryLessThan(double salary) {
        for (Employee emp : employees) {
            if (emp != null && emp.getSalary() < salary) {
                System.out.printf("[id=%d, %s %s %s, зарплата %,.2f рублей]\n", emp.getId(), emp.getSecondName(), emp.getFirstName(), emp.getMiddleName(), emp.getSalary());
            }
        }
    }

    public void showEmployeesWithSalaryMoreThan(double salary) {
        for (Employee emp : employees) {
            if (emp != null && emp.getSalary() > salary) {
                System.out.printf("[id=%d, %s %s %s, зарплата %,.2f рублей]\n", emp.getId(), emp.getSecondName(), emp.getFirstName(), emp.getMiddleName(), emp.getSalary());
            }
        }
    }

    /*
     вспомогательные методы
     */
    private Employee find(String secondName, String firstName, String middleName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getSecondName().equals(secondName) && employees[i].getFirstName().equals(firstName) && employees[i].getMiddleName().equals(middleName)) {
                return employees[i];
            }
        }
        return null;
    }
    private int getNumberOfEmployees() {
        int number = 0;
        for (Employee emp : employees) {
            if (emp != null) {
                number++;
            }
        }
        return number;
    }

    private int getNumberOfEmployees(int department) {
        int number = 0;
        for (Employee emp : employees) {
            if (emp != null && emp.getDepartment() == department) {
                number++;
            }
        }
        return number;
    }
}





/*
public void removeEmployee(String secondName, String firstName, String middleName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getSecondName().equals(secondName) && employees[i].getFirstName().equals(firstName) && employees[i].getMiddleName().equals(middleName)) {
                employees[i] = null;
                return;
            }
        }
        System.out.println("В книге сотрудников нет сотрудника с указанными ФИО.");
    }
 */
