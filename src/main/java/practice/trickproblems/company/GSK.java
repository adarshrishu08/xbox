package practice.trickproblems.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GSK {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1,3,2,3,4,1);
//        List<Integer> isEarlyExists = new ArrayList<>();
//        List<Integer> isLaterExists = new ArrayList<>();
//        StringBuilder sb1 = new StringBuilder();
//        StringBuilder sb2 = new StringBuilder();
//        for(int i=0; i<list.size(); i++){
//            int element = list.get(i);
//            sb1.append(isEarlyExists(list, element, i));
//            sb2.append(isLaterExists(list, element, i));
//        }
//        System.out.println(sb1.toString());
//        System.out.println(sb2.toString());
//        new ArrayList();

        List<String> list1 = new ArrayList(Arrays.asList("CC01","CC02","CC03"));
        List<String> list2 = new ArrayList(Arrays.asList("CC01","CC02","CC03","CC04","CC05"));
        System.out.println(list1.containsAll(null));
    }


    public static Integer isEarlyExists(List<Integer> list, Integer element, int index){
        for(int i=index; i>0; i--){
            if(list.get(i-1).intValue() == element){
                return 1;
            }
        }
        return 0;
    }

    public static Integer isLaterExists(List<Integer> list, int element, int index){
        for(int i=index+1 ; i<list.size(); i++){
            if(list.get(i).intValue() == element){
                return 1;
            }
        }
        return 0;
    }

}
