package rmi_calculator;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient3 {
    public static void main(String[] args) {
        try {
            //Locate registry
            Registry registry = LocateRegistry.getRegistry("1099");

            //Lookup CalculatorService
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            //Testing
            calculator.pushValue(1234);
            calculator.pushValue(1235);
            calculator.pushValue(1236);
            calculator.pushOperation("min");
            System.out.println("Minimum value is " + calculator.pop()); //output: 1234

            calculator.pushValue(1234);
            calculator.pushValue(1235);
            calculator.pushValue(1236);
            calculator.pushOperation("max");
            System.out.println("Maximum value is " + calculator.pop()); //output: 1236

            calculator.pushValue(10);
            calculator.pushValue(15);
            calculator.pushOperation("lcm");
            System.out.println("LCM is " + calculator.pop()); //output: 30

            calculator.pushValue(10);
            calculator.pushValue(15);
            calculator.pushOperation("gcd");
            System.out.println("GCD is " + calculator.pop()); //output: 5

            System.out.println("Empty Stack" + calculator.isEmpty()); //output: True

            calculator.pushValue(50);
            System.out.println("Delayed" + calculator.delayPop(2000)); /*waits 2 seconds
                                                                        output: 100 */
        } catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }
    }
}
