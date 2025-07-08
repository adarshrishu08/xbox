package practice.javaConcepts;


import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Case A :  If The SuperClass doesn't declares an exception
 *      Case 1: If SuperClass doesn’t declare any exception and subclass declare checked exception. (Not Allowed-Compile Time Error)
 *      Case 2: If SuperClass doesn’t declare any exception and SubClass declare Unchecked exception. (Allowed)
 *
 * Case B : If The SuperClass declares an exception
 *      Case 1: If SuperClass declares an exception and SubClass declares exceptions other than the child exception
 *          of the SuperClass declared Exception.
 *          (Not Allowed-Compile Time Error)
 *      Case 2: If SuperClass declares an exception and SubClass declares a child exception of the
 *          SuperClass declared Exception. (Allowed)
 *      Case 3: If SuperClass declares an exception and SubClass declares without exception. (Allowed)
 *
 * Case C :
 *      Case 1: If Superclass Extends Narrower Exception Than Child Class Exception.(Not Allowed-Compile Time Error) EG: IOException, FileNotFoundException
 *      Case 1: If Superclass Extends Broader Exception Than Child Class Exception.(Allowed) EG: IOException, FileNotFoundException
 */

public class ExceptionHandeling {

    public static void main(String[] args)  {
        System.out.println("From Main ->" + method());
    }

    public static String method(){
        SuperClass s = new SubClass();
        try {
            System.out.println("Try Block Before Call");
            //s.method();
            System.out.println("Try Block After Call");
            return "From Try";
        } finally {
            System.out.println("Finally Block");
            return "From Finally";
        }
    }
}

class SuperClass {

    // SuperClass doesn't declare any exception
    void method() throws Exception{
        System.out.println("SuperClass");
        throw new IOException("IO Exception Occurred");
    }
}

class SubClass extends SuperClass {

    // method() declaring Checked Exception IOException
    void method() throws FileNotFoundException {

        // IOException is of type Checked Exception
        // so the compiler will give Error

        System.out.println("SubClass");
    }
}
