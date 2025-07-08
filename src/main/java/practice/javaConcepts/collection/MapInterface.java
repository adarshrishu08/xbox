package practice.javaConcepts.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MapInterface {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee(31,"Adarsh", 20000),
                new Employee(30,"Ayendreyee", 18000),new Employee(28,"Yashu", 18000),
                new Employee(64,"L.K.Ojha", 15000),new Employee(59,"Bibha Ojha", 10000),
                new Employee(25,"Arghya", 10000));

        Map<Integer, String> idToEmpNameMap = employees.stream().collect(Collectors.toMap(Employee::getEmpId, Employee::getEmpName));
        System.out.println(idToEmpNameMap);
        Map<Double, List<Employee>> salaryToEmployeeList = employees.stream().collect(Collectors.groupingBy(Employee :: getSalary));
        System.out.println("salaryToEmployeeList -> " + salaryToEmployeeList);


        List<Employee> uniqueEmployees = Arrays.asList(new Employee(31,"Adarsh", 20000),
                new Employee(30,"Ayendreyee", 18000),new Employee(28,"Yashu", 19000),
                new Employee(64,"L.K.Ojha", 15000),new Employee(59,"Bibha Ojha", 10000),
                new Employee(25,"Arghya", 8000));
        TreeMap<Employee, String> salaryToEmpNameMapSortedBySalary = new TreeMap(new EmployeeSalaryComparator());
        uniqueEmployees.forEach(employee -> salaryToEmpNameMapSortedBySalary.put(employee, employee.getEmpName()));
        System.out.println("salaryToEmpNameMapSortedBySalary ->" + salaryToEmpNameMapSortedBySalary);
    }
}

class EmployeeSalaryComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.getSalary() == o2.getSalary()){
            return 0;
        } else if(o1.getSalary() > o2.getSalary()){
            return 1;
        } else {
            return -1;
        }
    }
}

class Employee {
    private int empId;
    private String empName;
    private double salary;

    public Employee(int empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(empName, employee.empName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
