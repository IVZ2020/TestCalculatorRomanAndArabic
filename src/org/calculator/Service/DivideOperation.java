package org.calculator.Service;


/**
 * Клосс, имплементирующий интерфейс {@link Operation}
 * Используется в {@link OperationFactory}, выполняя арифметическую операцию деления.
 * Внутри метода run проверяется деление на ноль. В случае попытки деления на ноль
 * выбрасывается ошибка {@link IllegalArgumentException}
 */
public class DivideOperation implements Operation {

    @Override
    public int run(int operandA, int operandB) {
        if (operandB != 0) {
            return operandA / operandB;
        } else {
            throw new IllegalArgumentException("Деление на 0 запрещено.");
        }
    }
}
