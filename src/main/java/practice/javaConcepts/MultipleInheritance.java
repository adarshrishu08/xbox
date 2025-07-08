package practice.javaConcepts;

public class MultipleInheritance {

    public static void main(String[] args) {
        C c = new C();
        c.getName();
    }
}

class C implements A,B{

}

interface A {
    default String getName(){
        return "Adarsh";
    }

    static String getId(){
        return "1";
    }
}

interface B {
    default String getNameById(){
        return "Ayendreyee";
    }
    static String getId(){
        return "2";
    }
}