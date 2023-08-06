package HomeworkStreamAPIAndOptional.Service;

import HomeworkStreamAPIAndOptional.Employee;
import HomeworkStreamAPIAndOptional.Exception.EmployeeAlreadyAddedException;
import HomeworkStreamAPIAndOptional.Exception.EmployeeNotFoundException;
import HomeworkStreamAPIAndOptional.Exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final Map<String, Employee> employees;
    private String firstName;
    private String lastName;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }

    public Employee add(String firstName, String lastName, int departmentEmployee, double salaryEmployee) {
        Employee employee = new Employee(firstName, lastName, departmentEmployee, salaryEmployee);
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.put(key, employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee remove(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }

    public Employee find(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }

    public List<Employee> returnList() {
        return new ArrayList<>(employees.values());
    }

    public String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }
}