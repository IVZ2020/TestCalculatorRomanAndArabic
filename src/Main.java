import org.calculator.Service.Calculator;
import org.calculator.Utils.Writer;

import java.util.Scanner;

/**
 * Входная точка приложения для чтения параметров из консоли.
 */
public class Main {
    public static void main(String[] args) {
        Writer writer = new Writer();
        Calculator calculator = new Calculator(new Scanner(System.in), writer);
        try {
            calculator.calculator();
        } catch (Exception ex) {
            writer.writeLine(ex.getMessage());
        }
    }
}
