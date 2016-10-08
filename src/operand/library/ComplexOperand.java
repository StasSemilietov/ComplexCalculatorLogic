/*
 * Copyright (c) 2016 Stas RED Semilietov & Dmytro Babiy Production. All rights reserved.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package operand.library;


/**
 * Class {@code ComplexOperand} represents the two-dimensional complex plane
 * by using the horizontal axis for the real part and the vertical axis for the imaginary part.
 *
 * @author Stas Semilietov
 * @version 1.0
 **/
public class ComplexOperand extends Operand {

    /**
     * {@code real} represents the real part of Complex Number
     **/
    private int real;

    /**
     * {@code real} represents the imaginary part of Complex Number
     **/
    private int image;

    /**
     * Sets the the real part of this <tt>ComplexOperand</tt> object.
     *
     * @param real the value of real part of Complex Number
     **/
    public void setReal(int real) {
        this.real = real;

    }

    /**
     * Sets the the imaginary part of this <tt>ComplexOperand</tt> object.
     *
     * @param image the value of imaginary part of Complex Number
     **/
    public void setImage(int image) {
        this.image = image;
    }

    /**
     * Returns real part of this <tt>ComplexOperand</tt> object.er
     *
     * @return real part of this RealOperand
     **/
    public int getReal() {
        return real;

    }

    /**
     * Returns imaginary part of this  <tt>ComplexOperand</tt> object.er
     *
     * @return imaginary part of this ComplexOperand
     **/
    public int getImage() {
        return image;
    }

    /**
     * Allocates a <code>ComplexOperand</code> object and initializes it. Default
     * real part and imaginary part equals to "0"
     */
    public ComplexOperand() {
        this.real = 0;
        this.image = 0;
    }

    /**
     * Allocates a <code>ComplexOperand</code> object and initializes it to
     * represent this with real and image as parameter
     *
     * @param realPart  real part of this RealOperand.
     * @param imagePart imaginary part of this RealOperand.
     */
    public ComplexOperand(int realPart, int imagePart) {
        this.real = realPart;
        this.image = imagePart;
    }

    /**
     * Allocates a <code>ComplexOperand</code> object and initializes it to
     * represent this as duplicate of ComplexOperand as parameter
     *
     * @param complexOperand <code>ComplexOperand</code> object
     */
    public ComplexOperand(ComplexOperand complexOperand) {
        this.real = complexOperand.real;
        this.image = complexOperand.image;
    }

    /**
     * Returns new {@code Operand} as sum of this {@code Operand} and {@code Operand} as parameter
     *
     * @param a Operand to be add
     * @return new ComplexOperand as sum of {@code Operands} ,
     * or new RealOperand as {@code Operand} if imaginary part of this equals to 0.
     * @throws IllegalOperandException
     */
    @Override
    public Operand add(Operand a) throws IllegalOperandException {

        if (a instanceof RealOperand)
            return new ComplexOperand(this.real + ((RealOperand) a).getRealvalue(), this.image);
        else if (a instanceof ComplexOperand) {
            int realPart = this.real + ((ComplexOperand) a).getReal();
            int imagePart = this.image + ((ComplexOperand) a).getImage();
            return (imagePart == 0) ? new RealOperand(realPart) : new ComplexOperand(realPart, imagePart);
        } else
            throw new IllegalOperandException("Can't Add, Illegal Operand");
    }

    /**
     * Returns new {@code Operand} subtraction with {@code Operand} as parameter
     *
     * @param a Operand to be subtract
     * @return new ComplexOperand as {@code Operand},
     * or new RealOperand as {@code Operand} if imaginary part of this equals to 0.
     * @throws IllegalOperandException
     */
    @Override
    public Operand sub(Operand a) throws IllegalOperandException {

        if (a instanceof RealOperand) {
            return new ComplexOperand(this.real - ((RealOperand) a).getRealvalue(), this.image);
        } else if (a instanceof ComplexOperand) {
            int realPart = this.real - ((ComplexOperand) a).getReal();
            int imagePart = this.image - ((ComplexOperand) a).getImage();
            return (imagePart == 0) ? new RealOperand(realPart) : new ComplexOperand(realPart, imagePart);
        } else
            throw new IllegalOperandException("Can't Sub, Illegal Operand");
    }

    /**
     * Returns new {@code Operand} multiplication with {@code Operand} as parameter
     *
     * @param a Operand to be multiply
     * @return new ComplexOperand as {@code Operand} ,
     * or new RealOperand as {@code Operand} if imaginary part of this equals to 0.
     * @throws IllegalOperandException
     */
    @Override
    public Operand mul(Operand a) throws IllegalOperandException {

        if (a instanceof RealOperand) {
            return new ComplexOperand(this.real * ((RealOperand) a).getRealvalue(), this.image * ((RealOperand) a).getRealvalue());
        } else if (a instanceof ComplexOperand) {
            int realPart = this.real * ((ComplexOperand) a).getReal() - this.image * ((ComplexOperand) a).getImage();
            int imagePart = this.image * ((ComplexOperand) a).getReal() + this.real * ((ComplexOperand) a).getImage();
            return (imagePart == 0) ? new RealOperand(realPart) : new ComplexOperand(realPart, imagePart);
        } else
            throw new IllegalOperandException("Can't Multiplex, Illegal Operand");
    }

    /**
     * Returns {@code Operand} division with {@code Operand} as parameter
     *
     * @param a Operand to be divide
     * @return new ComplexOperand as {@code Operand} ,
     * or new RealOperand as {@code Operand}  if imaginary part of this equals to 0.
     * @throws IllegalOperandException, ArithmeticException
     */
    @Override
    public Operand div(Operand a) throws IllegalOperandException, ArithmeticException {

        if (a instanceof RealOperand) {
            if (((RealOperand) a).getRealvalue() == 0) throw new ArithmeticException("Division by Zero!!!");
            else
                return new ComplexOperand(this.real * ((RealOperand) a).getRealvalue(), this.image * ((RealOperand) a).getRealvalue());
        } else if (a instanceof ComplexOperand) {
            int distance = (((ComplexOperand) a).real * ((ComplexOperand) a).real + ((ComplexOperand) a).image * ((ComplexOperand) a).image);
            if (distance == 0)
                throw new ArithmeticException("Division by Zero!!!");
            else {
                int realPart = (this.real * ((ComplexOperand) a).real + this.image * ((ComplexOperand) a).image) / distance;
                int imagePart = (this.image * ((ComplexOperand) a).real - this.real * ((ComplexOperand) a).image) / distance;
                return (imagePart == 0) ? new RealOperand(realPart) : new ComplexOperand(realPart, imagePart);
            }
        } else
            throw new IllegalOperandException("Can't Divide, Illegal Operand");
    }

    /**
     * Returns a string representation of the operand. In general, the
     * {@code toString} method returns a string that "textually represents" this
     * operand. The result should be a concise but informative representation
     * that is easy for a person to read  the operand.
     *
     * @return a string representation of the operand.
     **/
    public String toString() {
        String str = "";

        if (this.image == 0)
            str += real;
        else {
            str = String.format((this.real != 0 ? this.real : "") + ("%+d" + "i"), this.image);
        }

        return str;
    }

    /**
     * Compares this operand to the specified operand.  The result is
     * {@code true} if and only if  {@code Operand} object that
     * contains the same {@code Operand} value as this object.
     *
     * @param o the operand to compare with.
     * @return {@code true} if the operand are the same;
     * {@code false} otherwise.
     **/
    public boolean equals(Operand o) {

        if (o instanceof RealOperand) {

            return (this.getReal() == ((RealOperand) o).getRealvalue()) && (this.getImage() == 0);

        } else if (o instanceof ComplexOperand) {

            return (this.getReal() == ((ComplexOperand) o).getReal())
                    && (this.getImage() == ((ComplexOperand) o).getImage());
        }

        return false;

    }

    /**
     * Compares two {@code Operand} objects numerically.
     *
     * @param o the {@code Operand} to be compared.
     * @return the value {@code 0} if this {@code Operand} is
     * equal to the argument {@code Operand}; a value less than
     * {@code 0} if this {@code Operand} is numerically less
     * than the argument {@code Operand}; and a value greater
     * than {@code 0} if this {@code Operand} is numerically
     * greater than the argument {@code Operand} (signed
     * comparison).
     **/
    @Override
    public int compareTo(Operand o) {

        if (o instanceof RealOperand) {

            if (((RealOperand) o).getRealvalue() < this.getReal()) {
                return -1;
            }
            if (((RealOperand) o).getRealvalue() > this.getReal()) {
                return 1;
            } else
                return (0 < this.getImage() ? -1 : (0 == this.getImage() ? 0 : 1));

        } else if (o instanceof ComplexOperand) {

            if (((ComplexOperand) o).getReal() < this.getReal()) {
                return -1;
            }
            if (((ComplexOperand) o).getReal() > this.getReal()) {
                return 1;
            }

            return (((ComplexOperand) o).getImage() < this.getImage() ? -1
                    : (((ComplexOperand) o).getImage() == this.getImage() ? 0 : 1));

        }
        return -1;

    }

    /**
     * Returns a hash code for this Operand that was proposed in Josh Bloch's Effective Java
     *
     * @return a hash code value for this Operand.
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + real;
        result = 37 * result + image;

        return result;
    }
}

