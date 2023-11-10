package coe318.lab3;

/**
In mathematics, a number is expressed in positional notation to a certain base, B
For example, the 3-digit number 123 in base 4 represents 16+8+3=27 (base 10).
In this code, each digit is represented as a Counter object. A Counter object has an optional left
neighbour which is also a Counter object. (The absence of a left neighbour is indicated with the
keyword null.
The important methods to implement are getCount() and increment(). If there is no left
neighbour, the count is the same as the digit.
If there is a left neighbour, the count is the sum of the digit and the modulus times the count of
the left neighbour.
The increment() method increment's the Counter's digit and, if it reaches its maximum
(modulus) value, it is reset to zero. Furthermore, if there is a left neighbour and if the Counter
has rolled over, its left neighbour should be incremented as well.
*  * This project was code for the COE 318 Course
**/

public class Counter {
    // Instance variables here
    private int mod;
    private Counter lef;
    private int count;

    public Counter(int modulus, Counter left) {
        this.mod = modulus;
        this.lef = left;
        this.count = 0;
    }

    /**
     * @return the modulus
     */
    public int getModulus() {
        return mod;
    }

    /**
     * Returns the Counter to the left attached to this Counter. Returns null if there is no Counter to the left.
     *
     * @return the left
     */
    public Counter getLeft() {
        return lef;
    }

    /**
     * @return the digit
     */
    public int getDigit() {
        return count;
    }

    /**
     * @param digit the digit to set
     */
    public void setDigit(int digit) {
        mod = digit;
    }

    /**
     * Increment this counter. If it rolls over, its left Counter is also incremented if it exists.
     */
    public void increment() {
        count++;
        if (count == mod) { //mod, which is 3, rolls over the count value when it's equal
            count = 0;
            if (lef != null) {
                lef.increment(); //I need to use .increment because I'm using a counter variable
            }
        }
    }
    

    /**
     * Return the count of this Counter combined with any Counter to its left.
     *
     * @return the count
     */
    public int getCount() { //based off a formula
        if (lef != null) {
            return (count + mod * lef.getDigit());
        } else {
            return count;
        }
    }
    

    /**
     * Returns a String representation of the Counter's total count (including its left neighbor).
     *
     * @return the String representation
     */
    @Override
    public String toString() {
        // DO NOT MODIFY THIS CODE
        return "" + getCount();
    }
}
