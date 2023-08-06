package HomeworkStreamAPIAndOptional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("/departments")
@RestController
public class SalAndDepartController {
    private final SalAndDepartServiceImpl employeeService;

    public SalAndDepartController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/max-salary")
    public Employee printMaxSalaryEmployee(@RequestParam Integer departmentEmployee,
                                           @RequestParam Integer salaryEmployee) {
        return employeeService.printMaxSalaryEmployee(departmentEmployee, salaryEmployee);
    }

    @GetMapping("/min-salary")
    public Employee printMinSalaryEmployee(@RequestParam Integer departmentEmployee,
                                           @RequestParam Integer salaryEmployee) {
        return employeeService.printMinSalaryEmployee(departmentEmployee, salaryEmployee);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,
                         @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping("/returnList")
    public Collection<Employee> returnList() {
        return employeeService.returnList();
    }
}