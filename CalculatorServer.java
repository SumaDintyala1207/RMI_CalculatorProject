package rmi_calculator;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // Create Registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Instance of CalculatorImplementation
            Calculator calculator = new CalculatorImplementation();

            //Binding instance to a name in registry
            registry.rebind("CalculatorService", calculator);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println(e. toString());
            e.printStackTrace();
        }
    }
}
