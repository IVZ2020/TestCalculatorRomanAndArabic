package org.calculator.Service;

/**
 * Клосс, имплементирующий интерфейс {@link Operation}
 * Используется в {@link OperationFactory}, выполняя арифметическую операцию умножения.
 */
public class MultiplyOperation implements Operation {

    @Override
    public int run(int operandA, int operandB) {
        return operandA * operandB;
    }

}
