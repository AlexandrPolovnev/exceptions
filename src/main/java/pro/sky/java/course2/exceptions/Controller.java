package pro.sky.java.course2.exceptions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final EmployeeService employeeService;
    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="employee/add")
    public String addEmployee (@RequestParam("firstName")String firstName,
                               @RequestParam("lastName") String lastName) {
        try {
            return employeeService.addEmployee(firstName, lastName);
        } catch (Exception a) {
            return "500 Internal Server Error";
        }
        catch (ArrayIndexOutOfBoundsException a){
            return "404 Not Found.";
        }
    }
    @GetMapping (path="employee/delete")
    public String deleteEmployee (@RequestParam ("firstName")String firstName,
                                  @RequestParam("lastName") String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }
    @GetMapping (path="employee/search")
    public String SearchEmployee (@RequestParam ("firstName")String firstName,
                                  @RequestParam("lastName") String lastName) {
        try {
            return employeeService.searchEmployee(firstName, lastName);
        } catch (ArrayIndexOutOfBoundsException | EmployeeNotFoundException a) {
            return "404 Not Found";
        }
    }
}
