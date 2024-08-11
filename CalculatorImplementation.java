package rmi_calculator;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;

public class CalculatorImplementation  extends UnicastRemoteObject implements Calculator {
    private Stack<Integer> stack;

    protected CalculatorImplementation() throws RemoteException {
        stack = new Stack<>();  //Initialize stack
    }


    @Override
    public void pushValue(int val) throws RemoteException {
        stack.push(val);
    }

    @Override
    public void pushOperation(String operator) throws RemoteException {
        if (stack.isEmpty()){
            throw new IllegalStateException("Empty stack");
        }

        switch (operator) {
            case "min":
                int min = stack.stream().min(Integer::compare).orElseThrow(IllegalStateException::new);
                stack.clear();
                stack.push(min);
                break;

            case "max":
                int max = stack.stream().max(Integer::compare).orElseThrow(IllegalStateException::new);
                stack.clear();
                stack.push(max);
                break;

            case "lcm":
                int lcm = stack.pop();
                while (!stack.isEmpty()) {
                    lcm = lcm(lcm, stack.pop());
                }
                stack.push(lcm);
                break;
            case "gcd":
                int gcd = stack.pop();
                while (!stack.isEmpty()) {
                    gcd = gcd(gcd, stack.pop());
                }
                stack.push(gcd);
                break;

            default:
                throw new IllegalArgumentException("Invalid" + operator);
        }
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return (a*b) / gcd(a, b);
    }

    @Override
    public int pop() throws RemoteException{
        if (stack.isEmpty()){
            throw new IllegalStateException("Empty stack");
        }
        return stack.pop();

    }

    @Override
    public boolean isEmpty() throws RemoteException {
        return stack.isEmpty();
    }

    @Override
    public int delayPop(int millis) throws RemoteException {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RemoteException("Interrupted", e);
        }
        return pop();
    }
}
