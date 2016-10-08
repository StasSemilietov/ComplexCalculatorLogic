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
package operand.library.utility;

import operand.library.ComplexOperand;
import operand.library.Operand;
import operand.library.RealOperand;
import operand.library.StringOperand;

import java.util.Random;

/**
 * Class {@code Randoms} represents Generator for random RealOperand or ComplexOperand
 * with random values
 *
 * @author Stas Semilietov
 * @version 1.0
 **/
public class Randoms {

    /**
     * Allocates a <code>ComplexOperand</code> or <code>RealOperand</code> or
     * <code>StringOperand</code> object and initializes it
     * with random values for RealOperand and ComplexOperand,
     * and value of "Number" for StringOperand
     */
    static public Operand setRandom() {
        Random r = new Random();
        int a = r.nextInt(3);
        switch (a) {
            case 0:
                return new RealOperand(r.nextInt(100));
            case 1:
                return new ComplexOperand(r.nextInt(100), r.nextInt(100));
            case 2:
                return new StringOperand("Number" + r.nextInt(100));
        }
        return null;
    }
}

