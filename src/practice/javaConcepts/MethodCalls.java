package practice.javaConcepts;

public class MethodCalls {
    public static void main(String[] args) {
        new MethodCalls().printNum(4);
    }

    public void printNum(Integer i){
        System.out.println("Inside Integer");
    }

    public void printNum(int i){
        System.out.println("Inside int");
    }

    public void printNum(long i){
        System.out.println("Inside long");
    }

    public void printNum(Long i){
        System.out.println("Inside Long");
    }
}
