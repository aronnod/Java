package coe318.lab2;

import java.util.Scanner;

public class ComplexTry {


    public static void main(String[] args) {
        ComplexNumber a, b, c, d, e, f, g, h;
        
        //value for a
        Scanner ascanreal = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter a value for a's Real Part");
        String ascanr = ascanreal.nextLine();  // Read user input
        //System.out.println("A's Real Part is " + ascanr);  // test       
        Scanner ascanim = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter a value for a's Imaginary Part");
        String ascani = ascanim.nextLine();  // Read user input
        a = new ComplexNumber(Double.parseDouble(ascanr), Double.parseDouble(ascani));
        System.out.println("a = " + a);
        
        //b is negative a
        b = a.negate();
        System.out.println("-a = " + b);
        
        //value for c
        Scanner cscanreal = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter a value for c's Real Part");
        String cscanr = cscanreal.nextLine();  // Read user input   
        Scanner cscanim = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter a value for c's Imaginary Part");
        String cscani = cscanim.nextLine();  // Read user input      
        c = new ComplexNumber(Double.parseDouble(cscanr), Double.parseDouble(cscani));
        System.out.println("c = " + c);
        
        //d is a + c
        d = a.add(c);
        System.out.println("a + c = " + d);
        
        //e is a - c
        e = a.subtract(c);
        System.out.println("a - c = " + e);
        
        //f is reciprical of a
        f = a.reciprocal();
        System.out.println("1 / a = " + f);
        
        //g is a divide c
        g = a.divide(c);
        System.out.println("a / c = " + g);
        
        //h is a multiply c
        h = a.multiply(c);
        System.out.println("a * c = " + h);
    }
}