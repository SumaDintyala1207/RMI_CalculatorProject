package rmi_calculator;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient1 {
    public static void main(String[] args) {
        try {
            //Locate registry
            Registry registry = LocateRegistry.getRegistry("1099");

            //Lookup CalculatorService
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            //Testing
            calculator.pushValue(20);
            calculator.pushValue(61);
            calculator.pushValue(50);
            calculator.pushOperation("min");
            System.out.println("Minimum value is " + calculator.pop()); //output: 20

            calculator.pushValue(20);
            calculator.pushValue(61);
            calculator.pushValue(50);
            calculator.pushOperation("max");
            System.out.println("Maximum value is " + calculator.pop()); //output: 61

            calculator.pushValue(20);
            calculator.pushValue(4);
            calculator.pushOperation("lcm");
            System.out.println("LCM is " + calculator.pop()); //output: 20

            calculator.pushValue(30);
            calculator.pushValue(15);
            calculator.pushOperation("gcd");
            System.out.println("GCD is " + calculator.pop()); //output: 15

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
