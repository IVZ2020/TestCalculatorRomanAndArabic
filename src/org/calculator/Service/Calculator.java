package org.calculator.Service;

import org.calculator.Utils.*;
import org.calculator.exceptions.IncorrectMathExpressionException;

import java.io.InputStream;
import java.text.ParseException;
import java.util.Scanner;

import static org.calculator.Utils.NumberStyleConversionUtils.romanToArabic;
import static org.calculator.Utils.NumberStyleValidationUtils.isExpressionArabic;
import static org.calculator.Utils.NumberStyleValidationUtils.isExpressionRoman;
import static org.calculator.Utils.NumberStyleValidationUtils.isOperandAMatchConditions;

/**
 * Основной класс, который читает строки из указанного {@link InputStream}
 * и выполняет простейшие арифметические операции.
 */
public class Calculator {
    private final Scanner inputScanner;
    private final Writer writer;

    public Calculator(Scanner scanner, Writer writer) {
        this.inputScanner = scanner;
        this.writer = writer;
    }

    /**
     * Основной метод взаимодейсвтия с пользователем.
     * Здесь происходит получение строки из консоли, проверка введенных данных,
     * приведение их к числовому значению нужного стиля (римского или арабского),
     * вычисление результата, проверка результата,
     * преобразование в нужный стиль вывода (римский или арабский) и вывод в консоль.
     */
    public void calculator () {
        while (true) {
            try {
                writer.writeLine("Введите выражение:");

                String mathExpression = inputScanner.nextLine().toUpperCase();
                boolean isRoman = isRomanExpression(mathExpression);

                String[] lineMatrix = NumberStyleConversionUtils.dividingString(mathExpression);
                String operationStr = lineMatrix[1];

                // конвертируем строковые значени в целочисленный тип вне зависимости от стиля написания цифр
                int operandA = getIntValueFromString(lineMatrix[0]);
                int operandB = getIntValueFromString(lineMatrix[2]);

                if (!isOperandAMatchConditions(operandA)
                    || !isOperandAMatchConditions(operandB)) {
                        throw new IncorrectMathExpressionException("Одно или оба числа не соответствуют диапазону");
                }

                Operation operation = OperationFactory.getOperation(operationStr);
                int result = operation.run(operandA, operandB);
                writeResult(result, isRoman);
            } catch (IncorrectMathExpressionException | NumberFormatException ex) {
                writer.writeLine(ex.getMessage());
                return;
            }
        }
    }

    /**
     * Возвращает логическое значение в зависимости от того, совпадает ли строка с маской ввода
     * Маска ввода должна включать левую часть примера, состоящего из римского числа, пробел, знак операции и правую часть римским числом
     * В случае провала проверки выбрасывается ошибка {@link IncorrectMathExpressionException}
     * @param mathExpression - входящий параметр - строка, полученная от пользователя в консоли
     * @return (boolean) результат проверки на то, что полученное выражение составлено из римских цифр и знакак операции
     * @throws IncorrectMathExpressionException - в случае, если строка содержит неверные символы в любой из частей: числа или знак операции
     */
    private boolean isRomanExpression(String mathExpression) throws IncorrectMathExpressionException {
        if (isExpressionRoman(mathExpression)) {
            return true;
        } else if (isExpressionArabic(mathExpression)) {
            return false;
        } else {
            throw new IncorrectMathExpressionException("Неверная маска ввода.");
        }
    }

    /**
     * Возвращает целочесленное значение для указанной строки.
     * Если строка представляет собой арабское число или римское число.
     * В противном случае выкидывает ошибку {@link NumberFormatException}
     * @param numberAsString - входящий параметр. Not null-safe.
     * @return (int) результат преобразования строки
     * @throws NumberFormatException - в случае, если строка не представляет собой римскую или арабску цифру
     */
    private int getIntValueFromString(String numberAsString) throws NumberFormatException {
        try {
            try {
                return Integer.parseInt(numberAsString);
            } catch (NumberFormatException ex) {
                return romanToArabic(numberAsString);
            }
        } catch (Exception ex) {
            throw new NumberFormatException(numberAsString + " не является римской или арабской цифрой");
        }
    }

    /**
     * Метод вывода в консоль результата вычислений арабскими или римскими цифрами в зависимости от того,
     * какое значение {@param isRomanStyle} передается. Если true - следует проверка на результат > 1.
     * В случае, если проверка на {@param result} > 1 не пройдена, то выбрасывается ошибка {@link IncorrectMathExpressionException}
     * Если {@param isRomanStyle} false - происходит конвертация в String результата в арабских цифрах и вывод в консоль.
     * @param result - входящий параметр - результат вычислений
     * @param isRomanStyle - входящий параметр для проверки какой стиль цифр должен быть при выводе в консоль
     * @throws IncorrectMathExpressionException - в случае, если результат вычисления рискими цифрами < 1
     */

    private void writeResult(int result, boolean isRomanStyle) throws IncorrectMathExpressionException {
        if (isRomanStyle) {
            if (result < 1) {
                throw new IncorrectMathExpressionException("Неверная пара чисел. Результат меньше единицы");
            }
            String resultRoman = NumberStyleConversionUtils.arabicToRoman(result);
            writer.writeLine(resultRoman);
        } else {
            writer.writeLine(String.valueOf(result));
        }
    }

}