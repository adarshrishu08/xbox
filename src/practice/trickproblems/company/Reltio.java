package practice.trickproblems.company;

import java.util.Arrays;
import java.util.List;

public class Reltio {
    public static void main(String[] args) {

        int[] arr = {3,-6,5,-2,1};
        List<Integer> array = Arrays.asList(3,-6,5,-2,1);
        System.out.println(minStart(array));

    }

    public static long minStart(List<Integer> arr) {
        // Write your code here
        int min=0;
        int total=0;
        for(int num : arr){
            total+= num;
            min=Math.min(min, total);
        }
        return -min+1;
    }

}


class Acquaintance {
    String name;

    public Acquaintance(){};

    public Acquaintance(String name){
        this.name = name;
    }

    public void getStatus (){
        System.out.println(name +" is just an acquaintance");
    }
}

class Friend extends Acquaintance{
    String homeTown;
    public  Friend(){};
    public Friend(String name, String homeTown){
        this.name = name;
        this.homeTown = homeTown;
    }

    public void getStatus (){
        System.out.println(name +" is just a friend and he is from "+ homeTown);
    }
}

class BestFriend extends Friend{
    String favoriteSong;
    public BestFriend(String name,String homeTown, String favoriteSong){
        this.name = name;
        this.homeTown = homeTown;
        this.favoriteSong = favoriteSong;
    }

    public void getStatus (){
        System.out.println(name +" is my best friend.He is from "+ homeTown+" and his favorite song is "+favoriteSong);
    }
}
