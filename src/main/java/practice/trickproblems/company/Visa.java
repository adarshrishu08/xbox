package practice.trickproblems.company;


//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Visa {
    public static void main(String[] args) throws Exception {
        //getCountries("un", 100090);
        System.out.println(prime(15));
    }

    private static int prime(long number){
        if(number == 1 || number == 2){
            return 1;
        }
        if(number > 0 && number % 2 == 0){
            return 2;
        }
        //long sqrt = floorSqrt(number);
        double sqrt = Math.floor(Math.sqrt(number));
        for(long i = 3; i<=sqrt; i+=2){
            if(number % i == 0){
                return (int)i;
            }
        }
        return 1;
    }

    private static long floorSqrt(long number){
        if(number == 0 || number == 1){
            return number;
        }
        long start = 0;
        long end = number;
        long answer = 0;
        while(start <= end){
            long mid = (start+end)/2;
            if(mid*mid == number){
                return mid;
            }
            if(mid*mid < number){
                start = mid+1;
                answer = mid;
            } else {
                end = mid-1;
            }
        }
        return answer;
    }

    static int getCountries(String s, int p) throws Exception {
        String str = "https://jsonmock.hackerrank.com/api/countries/search?name="+s;
        URL url = new URL(str);
        HttpURLConnection connection =  (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();

        if(responseCode != 200){
            throw new RuntimeException("HttpResponseCode :"+responseCode);
        } else {
            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()){
                inline += scanner.nextLine();
            }

            scanner.close();

            /*JSONParser parse = new JSONParser();
            JSONObject dataObj = (JSONObject) parse.parse(inline);

            JSONArray arr = (JSONArray) dataObj.get("data");
            List<JSONObject> filteredList = new ArrayList<>();
            for(int i=0; i<arr.size(); i++){
                JSONObject obj = (JSONObject) arr.get(i);
                long population = (Long)obj.get("population");
                if(population > p){
                    filteredList.add(obj);
                }
            }*/
            /*return filteredList.size();*/
            return 0;

        }
    }
}
