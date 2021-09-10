package org.calculator.Utils;
import org.calculator.Entity.RomanNumbers;

import java.util.List;

/**
 * Класс, содержаний методы конвертации данных в разные типы
 */
// There are four methods
// Three methods convert numbers: Roman to Arabic, Arabic to Roman, String to Integer.
// Fourth method put String expression to array diving using split symbol " " (space)

public class NumberStyleConversionUtils {


    private NumberStyleConversionUtils() {
    }

    /**
     * Метод конвертирует римские числа в арабские
     * Возвращает тип int
     */
    public static int romanToArabic(String input) throws NumberFormatException {
        int result = 0;
        int i = 0;
        List<RomanNumbers> romanList = RomanNumbers.getRomanReversedValue();
        while ((input.length() > 0) && (i < romanList.size())) {
            RomanNumbers digit = romanList.get(i);
            if (input.startsWith(digit.name())) {
                result += digit.getValue();
                input = input.substring(digit.name().length());
            } else {
                i++;
            }
        }
        if (input.length() > 0) {
            throw new NumberFormatException(input + " не является римской цифрой");
        }
        return result;
    }

    /**
     * Метод конвертирует арабские числа в римские
     * Возвращает значение типа String
     */
    public static String arabicToRoman(int input) {

        List<RomanNumbers> romanList = RomanNumbers.getRomanReversedValue();
        StringBuilder romanNumber = new StringBuilder();
        int i = 0;
        while ((input > 0) && (i < romanList.size())) {
            RomanNumbers currentDigit = romanList.get(i);
            if (currentDigit.getValue() <= input) {
                romanNumber.append(currentDigit.name());
                input -= currentDigit.getValue();
            } else {
                i++;
            }
        }
        return romanNumber.toString();
    }

    /**
     * Метод конвертирует строку типа String в арабское числов
     * Возвращает тип Integer
     */
    public static int stringToNumber (String line) {
        return Integer.parseInt(line);
    }

    /**
     * Делит любую строку на части, используя как разделитель пробел
     * Возвращает массив String
     * Если пробелов нет, то вернет массив с одним элементом
     */
    public static String[] dividingString (String string) {
        return string.split(" ");
    }
}