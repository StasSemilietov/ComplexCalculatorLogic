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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class {@code OperandFactory} is the class that represents Factory pattern method to construct {@code Operand} from String
 * This is no available to initialise Object of this class
 *
 * @author Stas Semilietov
 * @version 1.0
 */
public class OperandFactory {
    /**
     * Private constructor a <code>RealOperand</code> object and initializes it to
     * This is no available to initialise Object of this class
     **/
    private OperandFactory(){}

    /**
     * This is a Factory method that allocates and initialise {@code Operand} as subclass directly to string
     *
     * @param s String representation of {@code Operand} that must be create.
     * @return {@code Operand} as <code>RealOperand</code>, <code>ComplexOperand</code> or <code>StringOperand</code> following string representation
     **/
    public static Operand CreateOperandFromString(String s){
        Pattern pattern1 = Pattern.compile("([\\-]?\\d+)([\\+\\-])(\\d+)i");
        Pattern pattern2 = Pattern.compile("[\\-]?\\d+");
        Matcher matcher1 = pattern1.matcher(s);
        Matcher matcher2 = pattern2.matcher(s);
        if(matcher1.matches())
            if(matcher1.group(2).equals("+"))
                return new ComplexOperand(Integer.parseInt(matcher1.group(1)),
                                          Integer.parseInt(matcher1.group(3)));
            else return new ComplexOperand(Integer.parseInt(matcher1.group(1)),
                    -Integer.parseInt(matcher1.group(3)));
        else if(matcher2.matches())
            return new RealOperand(Integer.parseInt(matcher2.group(0)));
        return new StringOperand(s);
    }
}
