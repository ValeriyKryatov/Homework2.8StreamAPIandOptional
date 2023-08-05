package HomeworkStreamAPIAndOptional;

import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;
    private final int departmentEmployee;
    private final int salaryEmployee;

    public Employee(String firstName, String lastName, int departmentEmployee, int salaryEmployee) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentEmployee = departmentEmployee;
        this.salaryEmployee = salaryEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentEmployee() {
        return departmentEmployee;
    }

    public int getSalaryEmployee() {
        return salaryEmployee;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return departmentEmployee == employee.departmentEmployee && salaryEmployee == employee.salaryEmployee && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentEmployee, salaryEmployee);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentEmployee=" + departmentEmployee +
                ", salaryEmployee=" + salaryEmployee +
                '}';
    }
}