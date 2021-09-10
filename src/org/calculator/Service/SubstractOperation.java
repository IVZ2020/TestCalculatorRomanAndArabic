package org.calculator.Service;

/**
 * Клосс, имплементирующий интерфейс {@link Operation}
 * Используется в {@link OperationFactory}, выполняя функцию вычитания.
 */
public class SubstractOperation implements Operation {

    @Override
    public int run(int operandA, int operandB) {
        return operandA - operandB;
    }

}
