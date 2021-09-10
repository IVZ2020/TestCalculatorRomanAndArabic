package org.calculator.exceptions;

public class IncorrectMathExpressionException extends Exception {


    /**
     * Исключение {@link IncompatibleClassChangeError} выбрасывается в случае провала проверки математического выражения
     * на соответствие заданным в классе {@link org.calculator.Service.Calculator} парамерам
     * @param message - входящий параметр. Сообщение, которое выводится при выбрасывании ошибки
     */
    public IncorrectMathExpressionException(String message) {
        super(message);
    }

}
