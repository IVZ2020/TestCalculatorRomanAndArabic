package org.calculator.Entity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Enum класс, содержащий римские цифры, удовлетворяющие техническому заданию
 * По заданию римские значения вводимых чисел не могу превышать X (10), значит максимальное значение
 * при выполнении арфиметических операций может быть только C (100), которое получается при умножении.
 */

public enum RomanNumbers {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100);

    private final int arabValue;

    RomanNumbers(int arabValue) {
        this.arabValue = arabValue;
    }

    public int getValue () {
        return arabValue;
    }

    /**
     * Метод выводит список римских цифр в обратном порядке
     * @return - список значений в обратном порядке типа RomanNumbers
     */

    public static List<RomanNumbers> getRomanReversedValue() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumbers e) -> e.arabValue).reversed())
                .collect(Collectors.toList());
    }
}
