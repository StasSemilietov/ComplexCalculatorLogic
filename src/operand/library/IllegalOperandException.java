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
 * Thrown when an exceptional {@code Operand} has occurred for operation.
 * @author Stas Semilietov
 * @version 1.0
 */

public class IllegalOperandException extends Exception {
    private static final long serialVersionUID = -6291916146943601945L;
    /**
     * Constructs an {@code IllegalOperandException} with no detail
     * message.
     */
    public IllegalOperandException() {super();}

    /**
     * Constructs an {@code IllegalOperandException} with the specified
     * detail message.
     *
     * @param   message   the detail message.
     */
    public IllegalOperandException(String message) {
        super(message);
    }

}
