package org.calculator.Service;

/**
 * Класс {@link OperationFactory} содержит метод вычислений
 * Включает в себя метод getOperation, принимающий параметр типа Srting,
 * который позволяет выбрать типо операции и запустить нужное вычисление посредством классов
 * {@link SubstractOperation}, {@link SumOperation}, {@link MultiplyOperation},{@link DivideOperation}
 */
public class OperationFactory {

    private OperationFactory() {}

    public static Operation getOperation(String operationName) {
        switch (operationName) {
            case "-": return new SubstractOperation();
            case "+": return new SumOperation();
            case "*": return new MultiplyOperation();
            case "/": return new DivideOperation();
            default:
                throw new IllegalArgumentException("Операция с именем <" + operationName + "> не поддерживается");
        }
    }
}
