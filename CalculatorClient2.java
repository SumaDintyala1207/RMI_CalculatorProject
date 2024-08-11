package rmi_calculator;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient2 {
    public static void main(String[] args) {
        try {
            //Locate registry
            Registry registry = LocateRegistry.getRegistry("1099");

            //Lookup CalculatorService
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            //Testing
            calculator.pushValue(555);
            calculator.pushValue(554);
            calculator.pushValue(556);
            calculator.pushOperation("min");
            System.out.println("Minimum value is " + calculator.pop()); //output: 554

            calculator.pushValue(555);
            calculator.pushValue(554);
            calculator.pushValue(556);
            calculator.pushOperation("max");
            System.out.println("Maximum value is " + calculator.pop()); //output: 556

            calculator.pushValue(4);
            calculator.pushValue(6);
            calculator.pushOperation("lcm");
            System.out.println("LCM is " + calculator.pop()); //output: 12

            calculator.pushValue(24);
            calculator.pushValue(36);
            calculator.pushOperation("gcd");
            System.out.println("GCD is " + calculator.pop()); //output: 12

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
