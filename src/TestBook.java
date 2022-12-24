public class TestBook {
    public void start(EmployeeBook book) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        book.showAll();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Создаем сотруника");
        book.addEmployee("Фамилия", "Имя", "Отчество", 4, 120_000);
        book.addEmployee("Фамилия", "Имя", "Отчество", 7, -120_000);
        book.showAll();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Удаляем сотрудника с Id1 и последнего созданного");
        book.removeEmployee("Фамилия", "Имя", "Отчество");
        book.removeEmployee(1);
        book.showAll();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("изменим сотруднику зп и отдел ");
        book.changeSalary("Петров", "Петр", "Васильевич", 100);
        book.changeDepartment("Петров", "Петр", "Васильевич", 2);
        book.showAll();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Вывод сотрудников по отделам");
        book.showAllByDepartments();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("найдем сотрдуника с наименьшей и наибольшей зп");
        System.out.println("Сотрудник с наименьшей зп");
        System.out.println(book.findLowPaidEmployee());
        System.out.println("Сотрудник с наибольшей зп");
        System.out.println(book.findHighPaidEmployee());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        book.showAll();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Средняя зарпалата в компании " + book.getAverageSalary());
        System.out.println("Средняя зарпалата в 5 отделе " + book.getAverageSalary(5));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("проиндексируем зп всех сотрудников на 50 процентов");
        book.indexSalary(50);
        book.showAll();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("проиндексируем зп всех сотрудников 5 отдела на 50 процентов");
        book.indexSalary(5, 50);
        book.showAll();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("найдем сотрудников которые зарабатывают меньше чем 200 000");
        book.showEmployeesWithSalaryLessThan(200000);
        System.out.println("найдем сотрудников которые зарабатывают больше чем 200 000");
        book.showEmployeesWithSalaryMoreThan(200000);


    }
}