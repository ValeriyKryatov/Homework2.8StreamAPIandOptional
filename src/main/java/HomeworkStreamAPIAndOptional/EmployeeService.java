package HomeworkStreamAPIAndOptional;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> returnList();

    Employee printMaxSalaryEmployee(Integer departmentEmployee, Integer salaryEmployee);

    Employee printMinSalaryEmployee(Integer departmentEmployee, Integer salaryEmployee);
}