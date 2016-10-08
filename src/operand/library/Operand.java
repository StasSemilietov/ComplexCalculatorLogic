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

import java.util.Date;
import java.text.*;
/**
 * Class {@code Operand} is the root of the Operands hierarchy. Every operand
 * has {@code Operand} as a superclass. All operands implement the methods of
 * this class. Its ready to create unique classes such as real or copmplex
 * numbers, strings, quaternions etc. All abstract methods must be override
 *
 * @author Stas Semilietov
 * @version 1.0
 */
public abstract class Operand implements Biections, Cloneable, Comparable<Operand> {

    /**
     * Private long {@code time} use to get time of operand's creation in
     * milliseconds
     **/
    private final long time = System.currentTimeMillis();

    /**
     * Getter for {@code time}
     **/
    private long getTime() {
        return time;
    }

    /**
     * Returns {@code Operand} adding with {@code Operand} as parameter
     *
     * @param a Operand  to be add
     * @return {@code Operand}
     * @throws IllegalOperandException
     */
    public abstract Operand add(Operand a) throws IllegalOperandException;

    /**
     * Returns {@code Operand} subtracting with {@code Operand} as parameter
     *
     * @param a Operand to be subtract
     * @return {@code Operand}
     * @throws IllegalOperandException
     */
    public abstract Operand sub(Operand a) throws IllegalOperandException;

    /**
     * Returns {@code Operand} multiplication with {@code Operand} as parameter
     *
     * @param a Operand to be multiplicate
     * @return {@code Operand}
     * @throws IllegalOperandException
     */
    public abstract Operand mul(Operand a) throws IllegalOperandException;

    /**
     * Returns {@code Operand} division with {@code Operand} as parameter
     *
     * @param a Operand to be divide
     * @return {@code Operand}
     * @throws IllegalOperandException
     */
    public abstract Operand div(Operand a) throws IllegalOperandException;

    /**
     * Creates and returns a copy of this operand( as object). The precise
     * meaning of "copy" may depend on the class of the object. The general
     * intent is that, for any object {@code x}, the expression: <blockquote>
     * <p>
     * <pre>
     * x.clone() != x
     * </pre>
     * <p>
     * </blockquote> will be true, and that the expression: <blockquote>
     * <p>
     * <pre>
     * x.clone().getClass() == x.getClass()
     * </pre>
     * <p>
     * </blockquote> will be {@code true}, but these are not absolute
     * requirements. While it is typically the case that: <blockquote>
     * <p>
     * <pre>
     * x.clone().equals(x)
     * </pre>
     * <p>
     * </blockquote> will be {@code true}, this is not an absolute requirement.
     *
     * @return a clone of this instance.
     * @throws CloneNotSupportedException if the object's class does not support the {@code Cloneable}
     *                                    interface.
     * @see java.lang.Cloneable
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

    /**
     * Returns a string representation of the operand with time of creation of concrete operand . In general, the
     * {@code toString} method returns a string that "textually represents" this
     * operand. The result should be a concise but informative representation
     * that is easy for a person to read and control timing of initialization of the operand.
     *
     * @param i any integer
     * @return a string representation of the operand with time of initialization.
     **/
    public String toString(int i) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy.MMMMM.dd");

        return toString() + simpleDate.format(new Date(time));
    }
}

