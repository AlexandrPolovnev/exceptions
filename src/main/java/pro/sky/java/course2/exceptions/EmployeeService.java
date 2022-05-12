package pro.sky.java.course2.exceptions;


import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final Employee[] employees = {


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
        int index = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                index = i;
            }
            if (employees[i].equals(employee)) {
                throw new EmployeeExistsException();
            }
            if (index != -1) {
                employees[index] = employee;
            } else
                throw new EmployeeIndexOutOfBoundsException();
        }
        return employee;
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].equals(employee)) {
                employees[i] = null;
                return employee;
            } else {
                throw new EmployeeNotFoundException();
            }
        }
            return null;
    }

    public Employee searchEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].equals(employee)) {
                return employee;
            } else
                throw new EmployeeNotFoundException();
        }
        return employee;
    }
}




