package org.calculator.Utils;

// Includes validation:
// is String expression Roman or Arabic
// are Roman or Arabic numbers match conditions of numbers


/**
 * Класс содержит утилиты для проверки различных данных на соответствие форме ввода, маске ввода, диапазону
 */
public class NumberStyleValidationUtils {
    /**
     * Строковые поля, содержание регулярные выражения, которые проверяют маску ввода римских или арабских значений,
     * знака операции на соответствие маске: (значение1)пробел(знак операции)пробел(значение2)
     */
    private static final String ROMAN_EXPRESSION_MATCH = "^[IVXLC]+\\s[+/*\\-]+\\s[IVXLC]+$";
    private static final String ARABIC_EXPRESSION_MATCH = "^[\\-?0-9]+\\s[+/*\\-]+\\s[\\-?0-9]+$";


    private NumberStyleValidationUtils() {    }

    /**
     * Метод проверяет строку, является ли она выражением для вычисления, состоящим из римских чисел и знака операции между ними
     */
    public static boolean isExpressionRoman (String mathExpression) {
        return mathExpression.matches(ROMAN_EXPRESSION_MATCH);
    }

    /**
     * Метод проверяет строку, является ли она выражением для вычисления, состоящим из арабских чисел и знака операции между ними
     */
    public static boolean isExpressionArabic (String mathExpression) {
        return mathExpression.matches(ARABIC_EXPRESSION_MATCH );
    }

    /**
     * Метод проверяет операнд на соответствие введенного значения заданному диапазону от 1 до 10
     */
    public static boolean isOperandAMatchConditions(int operand) {
        return operand > 0 && operand <= 10;
    }

}