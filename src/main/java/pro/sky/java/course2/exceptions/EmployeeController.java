package pro.sky.java.course2.exceptions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/employee")

public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/add")
    public Employee addEmployee (@RequestParam("firstName")String firstName,
                               @RequestParam("lastName") String lastName) {
      return employeeService.addEmployee(firstName, lastName);
    }
    @GetMapping (path="/delete")
    public Employee deleteEmployee (@RequestParam ("firstName")String firstName,
                                    @RequestParam("lastName") String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }
    @GetMapping (path="/search")
    public Employee searchEmployee (@RequestParam ("firstName")String firstName,
                                  @RequestParam("lastName") String lastName) {
        return employeeService.searchEmployee(firstName, lastName);
    }
}
