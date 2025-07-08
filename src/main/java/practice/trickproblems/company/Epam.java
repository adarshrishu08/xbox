package practice.trickproblems.company;

import java.util.HashMap;
import java.util.Map;

public class Epam {
    public static void main(String[] args) {
        Map<String,Double> map1 =  new HashMap<>();
        map1.put("Adarsh", new Double(20000));
        CustomImmutable c1 = new CustomImmutable("Adarsh", new Double(20000), map1);
        System.out.println("Before Setting" + c1.getMap());
        c1.getMap().put("Adarsh", new Double(21000));
        System.out.println("After Setting" + c1.getMap());
    }
}


final class CustomImmutable{
    private final String name;
    private final Double salary;
    private final Map<String,Double> map;

    public CustomImmutable(String name, Double salary, Map<String, Double> map) {
        this.name = name;
        this.salary = salary;
        Map<String,Double> tempMap = new HashMap<>();
        for(Map.Entry<String,Double> entry : map.entrySet()){
            tempMap.put(entry.getKey(), entry.getValue());
        }
        this.map = tempMap;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public Map<String, Double> getMap() {
        Map<String,Double> tempMap = new HashMap<>();
        for(Map.Entry<String,Double> entry : this.map.entrySet()){
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}