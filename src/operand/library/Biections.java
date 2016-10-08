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
 * This interface imposes a total ordering on the objects of each class that
 * implements it.
 * <p>
 * A class implements the <code>Biections</code> interface to indicate to
 * the realize Adding, supplying, multiplexing and dividing methods.
 * <p>
 * Methods on an instance implement the <code>Biections</code> interface
 * results in the exception <code>IllegalOperandException</code> being
 * thrown.
 * <p>
 * By convention, classes that implement this interface should override with
 * a public methods.
 * <p>
 * Note that this interface does <i>not</i> contain the <tt>clone</tt>
 * method. Therefore, it is not possible to clone an object merely by virtue
 * of the fact that it implements this interface. Even if the clone method
 * is invoked reflectively, there is no guarantee that it will succeed.
 *
 * @author Stas Semilietov
 * @version 1.0
 */
public interface Biections {


    /**
     * Returns {@code Operand} adding with {@code Operand} as parameter with
     * replacing of Operand
     *
     * @param Operand to be add
     * @return {@code Operand} with replacing fields
     * @throws IllegalOperandException
     */
     Operand add(Operand a) throws IllegalOperandException;

    /**
     * Returns {@code Operand} subtracting with {@code Operand} as parameter
     * with replacing of Operand
     *
     * @param Operand to be subtract
     * @return {@code Operand} with replacing fields
     * @throws IllegalOperandException
     */
     Operand sub(Operand a) throws IllegalOperandException;

    /**
     * Returns {@code Operand} multiplication with {@code Operand} as parameter
     * with replacing of Operand
     *
     * @param Operand to be multiplicate
     * @return {@code Operand} with replacing fields
     * @throws IllegalOperandException
     */
     Operand mul(Operand a) throws IllegalOperandException;

    /**
     * Returns {@code Operand} division with {@code Operand} as parameter with
     * replacing of Operand
     *
     * @param Operand to be divide
     * @return {@code Operand} with replacing fields
     * @throws IllegalOperandException
     */
     Operand div(Operand a) throws IllegalOperandException;

}
