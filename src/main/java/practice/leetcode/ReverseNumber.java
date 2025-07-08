package practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReverseNumber {

    public static void main(String[] args) {
        int n=1534236469;
        System.out.println(new ReverseNumber().reverseNumber(n));
        Employee e1 = new Employee(1, "Adarsh", "Bangaore");
        Employee e2 = new Employee(2, "Adarsh", "Patna");
        Employee e3 = new Employee(3, "Yashu", "Bangaore");
        Employee e4 = new Employee(4, "Ayendreyee", "Bangaore");
        Employee e5 = new Employee(5, "Yashu", "Patna");
        Employee e6 = new Employee(6, "Ayendreyee", "Barrackpore");
        Employee e7 = new Employee(7, "Ayendreyee", "Patna");
        List<Employee> list = new ArrayList<>();
        list.add(e1);list.add(e2);list.add(e3);list.add(e4);list.add(e5);
        list.add(e6);list.add(e7);

        Map<String,List<Employee>> map = list.stream().collect(Collectors.groupingBy(
                Employee::getName, Collectors.toList()
        ));

        System.out.println(map);

    }

//    123/10 = 12, R=3
//    12/10 = 1, R=2
//    1/10 = 0, R=1
    public int reverseNumber(int x){
        int reverse_Num = 0;
        while(x!=0){
            if(reverse_Num > Integer.MAX_VALUE/10 || reverse_Num < Integer.MIN_VALUE/10){
                return 0;
            }
            int r = x%10;
            x /= 10;
            reverse_Num = (reverse_Num*10)+r;
        }
        return reverse_Num;
    }
}


class Employee{
    private int empId;
    private String name;
    private String address;

    public Employee(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}