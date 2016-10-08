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

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Class {@code StringOperand} represents strings for testing this project
 *
 * @author Stas Semilietov
 * @version 1.0
 */
public class StringOperand extends Operand {
    /**
     * {@code name} represents this string
     **/
    private String name;

    /**
     * Returns name of this <tt>StringOperand</tt> object as string.
     *
     * @return name of this RealOperand
     **/
    public String getName() {
        return this.name;
    }

    /**
     * Allocates a <code>StringOperand</code> object and initializes it. Default
     * name equals to ""
     */
    public StringOperand() {
        this.name = "";
    }

    /**
     * Allocates a <code>StringOperand</code> object and initializes it to
     * represent this with name as parameter
     *
     * @param name name of this RealOperand.
     */
    public StringOperand(String name) {
        this.name = name;
    }

    /**
     * Returns {@code Operand} adding with {@code Operand} as parameter
     *
     * @param a Operand to be add
     * @return StringOperand as {@code Operand} where chars of new StringOperand's name contains chars of both operands sorted according to the
     * natural ordering of its elements
     * @throws IllegalOperandException
     */
    @Override
    public Operand add(Operand a) throws IllegalOperandException {

        SortedSet<Character> sortedString = new TreeSet<Character>();
        char[] charSet = (this.name + a.toString()).toCharArray();
        for (char c : charSet) {
            sortedString.add(c);
        }
        return new StringOperand(sortedString.toString());
    }

    /**
     * Returns {@code Operand} subtraction with {@code Operand} as parameter
     *
     * @param a Operand to be add
     * @return StringOperand as {@code Operand} where chars of new StringOperand's name  contains chars of both operands sorted according to the
     * natural ordering of its elements
     * @throws IllegalOperandException
     */
    @Override
    public Operand sub(Operand a) throws IllegalOperandException {

        SortedSet<Character> sortedString = new TreeSet<Character>();
        SortedSet<Character> set2 = new TreeSet<Character>();
        char[] initCharSet = (this.name).toCharArray();
        char[] operandCharSet = (a.toString()).toCharArray();
        for (char c : initCharSet) {
            sortedString.add(c);
        }
        for (char c : operandCharSet) {
            set2.add(c);
        }
        sortedString.removeAll(set2);
        return new StringOperand(sortedString.toString());
    }

    /**
     * This operation can not be used for <code>StringOperand</code> object
     *
     * @param a Operand to be add
     * @throws IllegalOperandException
     */
    @Override
    public Operand mul(Operand a) throws IllegalOperandException {
        throw new IllegalOperandException("Can't working with String, Illegal Operand");
    }

    /**
     * This operation can not be used for <code>StringOperand</code> object
     *
     * @param a Operand to be add
     * @throws IllegalOperandException
     */
    @Override
    public Operand div(Operand a) throws IllegalOperandException {
        throw new IllegalOperandException("Can't working with String, Illegal Operand");
    }

    /**
     * Returns name of the operand. In general, the
     * {@code toString} method returns a string that "textually represents" this
     * operand. The result should be a concise but informative representation
     * that is easy for a person to read  the operand.
     *
     * @return name of the operand.
     **/
    public String toString() {
        return this.name;
    }

    /**
     * Compares two {@code Operand} objects lexicographically.
     * The result is a negative integer if this {@code StringOperand} object
     * lexicographically precedes the argument {@code StringOperand}. The result is a
     * positive integer if this {@code StringOperand} object lexicographically
     * follows the argument string. The result is zero if the {@code StringOperand}s
     * are equal
     *
     * @param o the {@code Operand} to be compared.
     * @return the value {@code 0} if this {@code Operand} is
     * equal to the argument {@code Operand}; a value less than
     * {@code 0} if this {@code Operand} is lexicographically less
     * than the argument {@code Operand}; and a value greater
     * than {@code 0} if this {@code Operand} is lexicographically
     * greater than the argument {@code Operand} (signed
     * comparison).
     **/
    @Override
    public int compareTo(Operand o) {
        if (o instanceof StringOperand)
            return (this.name).compareTo(((StringOperand) o).getName());
        else
            return -1;
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
        if (o instanceof StringOperand)
            return (this.name).equals(((StringOperand) o).getName());
        return false;
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
        result = 37 * result + name.hashCode();
        return result;
    }
}
