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

    public String addEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(firstName, lastName);
                break;
            }
            if (employees[i].equals(employees)){
                throw new EmployeeExistsException();
            }
            if (employees[i] != null)
                throw new EmployeeIndexOutOfBoundsException();
        }
        return firstName  + lastName;
    }

    public String deleteEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].equals(employees)) {
                employees[i] = null;
            }
            else
                throw new Exception();
        }
        return null;
    }

    public String searchEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null & employees[i] == new Employee(firstName, lastName)) {
                return employees[i].getFirstName() + " " + employees[i].getLastName();
            }
            if (employees[i] != null & employees[i] != new Employee(firstName, lastName)) {
                throw new EmployeeNotFoundException();
            }
        }return "404 Not Found ";
    }
    }



