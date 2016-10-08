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
 * Class {@code RealOperand} represents points of a straight line that serves as
 * abstraction for real numbers.
 *
 * @author Stas Semilietov
 * @version 1.0
 */
public class RealOperand extends Operand {

    /**
     * {@code realvalue} represents a quantity along a continuous line of Real
     * Number.
     **/
    private int realvalue;

    /**
     * Sets the realvalue of this <tt>RealOperand</tt> object.
     *
     * @param realvalue the value of real number.
     **/
    public void setRealvalue(int realvalue) {
        this.realvalue = realvalue;
    }

    /**
     * Returns realvalue of this <tt>RelOperand</tt> object. The value returned
     * represents a quantity along a continuous line of Real Number
     *
     * @return realvalue of this RealOperand
     **/
    public int getRealvalue() {
        return realvalue;
    }

    /**
     * Allocates a <code>RealOperand</code> object and initializes it. Default
     * realvalue equals to "0"
     */
    public RealOperand() {
        this.realvalue = 0;

    }

    /**
     * Allocates a <code>RealOperand</code> object and initializes it to
     * represent this with realvalue as parameter
     *
     * @param i realvalue of this RealOperand.
     */
    public RealOperand(int i) {

        this.realvalue = i;

    }

    /**
     * Returns {@code Operand} adding with {@code Operand} as parameter
     *
     * @param a Operand to be add
     * @return RealOperand as {@code Operand} (if both operands is Real),
     * or ComplexOperand  as {@code Operand} (if one of operands is Complex)
     * @throws IllegalOperandException
     */
    @Override
    public Operand add(Operand a) throws IllegalOperandException {

        if (a instanceof RealOperand)
            return new RealOperand(this.realvalue + ((RealOperand) a).getRealvalue());
        else if (a instanceof ComplexOperand) {
            ComplexOperand mediate = new ComplexOperand(this.realvalue, 0);
            return mediate.add(a);
        }
        throw new IllegalOperandException("Can't Add, Illegal Operand");
    }

    /**
     * Returns {@code Operand} subtraction with {@code Operand} as parameter
     *
     * @param a Operand to be subtract
     * @return RealOperand as {@code Operand} (if both operands is Real),
     * or ComplexOperand  as {@code Operand} (if one of operands is Complex)
     * @throws IllegalOperandException
     */
    @Override
    public Operand sub(Operand a) throws IllegalOperandException {

        if (a instanceof RealOperand)
            return new RealOperand(this.realvalue - ((RealOperand) a).getRealvalue());
        else if (a instanceof ComplexOperand) {
            ComplexOperand mediate = new ComplexOperand(this.realvalue, 0);
            return mediate.sub(a);
        }
        throw new IllegalOperandException("Can't Sub, Illegal Operand");
    }

    /**
     * Returns {@code Operand} multiplication  with {@code Operand} as parameter
     *
     * @param a Operand to be multiply
     * @return RealOperand as {@code Operand} (if both operands is Real),
     * or ComplexOperand with replacing fields as {@code Operand} (if one of operands is Complex)
     * @throws IllegalOperandException
     */
    @Override
    public Operand mul(Operand a) throws IllegalOperandException {
        if (a instanceof RealOperand)
            return new RealOperand(this.realvalue * ((RealOperand) a).getRealvalue());
        else if (a instanceof ComplexOperand) {
            ComplexOperand mediate = new ComplexOperand(this.realvalue, 0);
            return mediate.mul(a);
        }
        throw new IllegalOperandException("Can't Multiplex, Illegal Operand");
    }

    /**
     * Returns {@code Operand} division  with {@code Operand} as parameter
     *
     * @param a Operand to be divide
     * @return RealOperand as {@code Operand} (if both operands is Real),
     * or ComplexOperand with replacing fields as {@code Operand} (if one of operands is Complex)
     * @throws IllegalOperandException
     */
    @Override
    public Operand div(Operand a) throws IllegalOperandException {


        try {
            if (a instanceof RealOperand) {
                realvalue /= ((RealOperand) a).getRealvalue();
                return new RealOperand(this.realvalue / ((RealOperand) a).getRealvalue());
            } else if (a instanceof ComplexOperand) {
                ComplexOperand mediate = new ComplexOperand(this.realvalue, 0);
                return mediate.div(a);
            }
        } catch (ArithmeticException divZero) {
            System.out.println("Division by Zero!!!");
        }
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

        return "" + this.realvalue;
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

            return this.realvalue == ((RealOperand) o).getRealvalue();

        } else if (o instanceof ComplexOperand) {
            ComplexOperand mediate = new ComplexOperand(this.realvalue, 0);
            return (mediate.getReal() == ((ComplexOperand) o).getReal())
                    && (mediate.getImage() == ((ComplexOperand) o).getImage());
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

            return (((RealOperand) o).getRealvalue() < this.realvalue ? -1
                    : (((RealOperand) o).getRealvalue() == this.realvalue ? 0 : 1));

        } else if (o instanceof ComplexOperand) {

            ComplexOperand mediate = new ComplexOperand(this.realvalue, 0);
            return mediate.compareTo((ComplexOperand) o);

        }
        return -1;

    }

    /**
     * Returns a hash code for this Operand. The hash code for a
     * {@code Operand} is computed as
     * <blockquote><pre>
     *  (int)this.realvalue + 37*constant;
     * constant  = 17
     * </pre></blockquote>
     *
     * @return a hash code value for this Operand.
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + realvalue;
        return result;
    }

}
