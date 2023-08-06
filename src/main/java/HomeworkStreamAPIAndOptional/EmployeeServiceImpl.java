package HomeworkStreamAPIAndOptional;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int LIMIT = 10;
    private final Map<String, Employee> employees;
    private String firstName;
    private String lastName;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.put(employee.getFullName(), employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        return null;
    }

    @Override
    public Collection<Employee> returnList() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public Employee printMaxSalary(int departmentEmployee, int salaryEmployee) {
        return null;
    }
}