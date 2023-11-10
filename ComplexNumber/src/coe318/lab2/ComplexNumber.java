package coe318.lab2;

/**
 * ComplexNumber models a complex number expressed in rectangular form (real and
 * imaginary parts). It is an <em>immutable</em> object.
 *
 * @author Your Name
 */
public class ComplexNumber {
//Instance variable declarations
    double re;
    double im;

    /**
     * Construct a ComplexNumber given its real and imaginary parts.
     *
     * @param re The real component
     * @param im The imaginary component
     */
    public ComplexNumber(double re, double im) {
//Initialize the instance variables
        this.re = re;
        this.im = im;

    }

    /**
     * Returns the real component.
     *
     * @return the real
     */
    public double getReal() {
        return re; //A stub: to be fixed
    }

    /**
     * Returns the imaginary component.
     *
     * @return the imaginary
     */
    public double getImaginary() {
        return im; //A stub: to be fixed
    }

    /**
     * Returns a new ComplexNumber number that is the negative of <em>this</em>.
     * Note: the original ComplexNumber is <b>NOT</b>
     * modified.
     *
     * @return -this
     */
    public ComplexNumber negate() {
        double negativeReal = 0-re;
        double negativeImaginary = 0-im;
        return new ComplexNumber(negativeReal, negativeImaginary); 
    }

    /**
     * Returns a new ComplexNumber that is the sum of <em>this</em> and
     * <em>z</em>. Note: the original ComplexNumber is
     * <b>NOT</b> modified.
     *
     * @param z
     * @return this + z
     */
    public ComplexNumber add(ComplexNumber z) {
        double additionReal = re + z.getReal();
        double additionImaginary = im + z.getImaginary();
        return new ComplexNumber(additionReal, additionImaginary); 
    }

    /**
     * Returns a new ComplexNumber that is the difference of <em>this</em> and
     * <em>z</em>. Note: the original ComplexNumber is
     * <b>NOT</b> modified.
     *
     * @param z
     * @return this + z
     */
    public ComplexNumber subtract(ComplexNumber z) {
        double subReal = re - z.getReal();
        double subImaginary = im - z.getImaginary();
        return new ComplexNumber(subReal, subImaginary); 
    }

    /**
     * Returns a new ComplexNumber that is the product of <em>this</em> and
     * <em>z</em>. Note: the original ComplexNumber is
     * <b>NOT</b> modified.
     *
     * @param z
     * @return this * z
     */
    public ComplexNumber multiply(ComplexNumber z) {
        double timesReal = re * z.getReal() - im * z.getImaginary();
        double timesImaginary = re * z.getImaginary() + im * z.getReal();
        return new ComplexNumber(timesReal, timesImaginary); 
    }

    /**
     * Returns a new ComplexNumber that is the reciprocal of <em>this</em>.
     * Note: the original ComplexNumber is
     * <b>NOT</b> modified.
     *
     * @return 1.0 / this
     */
    public ComplexNumber reciprocal() {
        double denominator = re * re + im * im;  //The general form of the multiplicative inverse of a complex number is (a-bi)/(a^2+b^2).
        double reciprocalReal = re / denominator;
        double reciprocalImaginary = -im / denominator;
        
        return new ComplexNumber(reciprocalReal,reciprocalImaginary); 
    }

    /**
     * Returns a new ComplexNumber that is
     * <em>this</em> divided by <em>z</em>. Note: the original ComplexNumber is
     * <b>NOT</b> modified.
     *
     * @param z
     * @return this / z
     */
    public ComplexNumber divide(ComplexNumber z) {  //the formula being used involves taking the conjugate of z and multiplying that by the expression
        double numeratorReal = (re * z.re + im * z.im);
        double numeratorImaginary = (im * z.re - re * z.im);
        double denominator = (z.re * z.re + z.im * z.im);
        
       if (denominator == 0) {
            System.out.println("Error, division by 0");
            return null;
        }
        double divideReal = numeratorReal / denominator;
        double divideImaginary = numeratorImaginary / denominator;
        
        return new ComplexNumber(divideReal, divideImaginary); 
    }

    /**
     * Returns a String representation of
     * <em>this</em> in the format:
     * <pre>
     * real +-(optional) i imaginary
     * </pre> If the imaginary part is zero, only the real part is converted to
     * a String. A "+" or "-" is placed between the real and imaginary parts
     * depending on the the sign of the imagrinary part.
     * <p>
     * Examples:
     * <pre>
     * ..println(new ComplexNumber(0,0); -> "0.0"
     * ..println(new ComplexNumber(1,1); -> "1.0 + i1.0"
     * ..println(new ComplexNumber(1,-1); -> "1.0 - i1.0"
     * </pre>
     *
     * @return the String representation.
     */
    @Override
    public String toString() {
        String str = "" + this.getReal();
        if (this.getImaginary() == 0.0) {
            return str;
        }
        if (this.getImaginary() > 0) {
            return str + " + i" + this.getImaginary();
        } else {
            return str + " - i" + -this.getImaginary();
        }
    }
}