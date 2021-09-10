package org.calculator.Service;

/**
 * Интерфейс для {@link OperationFactory}, который имплементируется в классах арифметических операций
 */
public interface Operation {

    public int run(int operandA, int operandB);

}
