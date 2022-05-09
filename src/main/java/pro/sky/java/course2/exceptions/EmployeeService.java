package pro.sky.java.course2.exceptions;


import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    Employee[] employees = {
            new Employee("Sergey", "Petrov"),
            new Employee("Mikhail", "Antonov"),
            new Employee("Alexey", "Sorokin"),
            new Employee("Maxim", "Diveev"),
            new Employee("Arthur", "Kim"),
            new Employee("Oleg", "Vasin"),
            new Employee("Svetlana", "Frolova"),
            new Employee("Dmitriy", "Chertov"),
            new Employee("Natasha", "Krylova"),
            new Employee("Petr", "Denisov")
    };

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        boolean progress;
        for (int i = 0; i < employees.length; i++) {
            progress = true;
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            } else if
            (employees[i] != null && i == employees.length) {
                progress = false;
            }
            if (progress == false) {
                throw new EmployeeIndexOutOfBoundsException();
            }
        }
        return employee;
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFirstName().equals(firstName) &&
                    employees[i].getLastName().equals(lastName)) {
                employee = employees[i];
                employees[i] = null;
                return employee;
            } else
                throw new EmployeeNotFoundException();
        }
        return null;
    }

    public Employee searchEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFirstName().equals(firstName) &&
                    employees[i].getLastName().equals(lastName)) {
                return employee;
            } else
                throw new EmployeeNotFoundException();
        }
        return null;
    }
}




