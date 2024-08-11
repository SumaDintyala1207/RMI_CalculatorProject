# RMI_CalculatorProject
The  RMI_CalculatorProject shows how Remote Method Invocation (RMI) works in Java. This example shows a simple Java RMI system - A Calculator. <br/>
This project has the following files: <br/>
- Calculator
- CalculatorImplementation
- CalculatorServer
- CalculatorClient
- CalculatorClient1
- CalculatorClient2
- CalculatorClient3
<br/>
**Calculator** <br/>
<br/>
- In this interface, an interface named 'Remote' is imported from the 'java.rmi' package. 'Remote' interface is necessary for any object in an RMI project to be used remotely. <br/>
- The class 'RemoteException' is imported from the 'java.rmi' package which is a checked exception that can occur during remote method calls to various network-related issues. <br/>
- 'extends' indicates that the Calculator interface is meant for remote access. <br/>
- pushValue(int val): Pushes a given integer value onto a stack managed by the server. <br/>
- pushOperation(String operator): Pushes the operations - min, max, lcm, gcd - onto the stack to perform specified operations. <br/>
- int pop(): Removes and returns the top element from the stack.<br/>
- boolean isEmpty(): Returns 'True' if the stack is empty. <br/>
- int delayPop(int millis): Waits for speciefied milliseconds before performing the 'pop' operation. <br/>
<br/>
In summary, Calculator defines the remote operations that can be performed.
<br/>
<br/>
**CalculatorImplementation** <br/>
<br/>
- UnicastRemoteObject: A class from the java.rmi.server package which exports a remote object to make it available for recieving incoming calls. <br/>
- Stack: The stack class is imported from the java.util package.<br/>
- implements: Declares that CalculatorImplementation implements the Calculator interface.<br/>
- Stack<Integer>: Used to store integer values.<br/>
- @Override: Indicates that he method is overriding a method in the Calculator interface.<br/>
- IllegealStateException: Throws exception if the stack is empty.<br/>
- switch: Determines which operation to perform based on the 'operator' string.<br/>
- min: Pushes the min values of all popped values.<br/>
- max: Pushes the max value of all popped values.<br/>
- lcm: pushes the lcm of popped values.<br/>
- gcd: Pushes the gcd of popped values.<br/>
- int min = stack.stream().min(Integer::compare).orElseThrow(IllegalStateException::new);: Finds min value in the stack using a stream and comparator, throwing an exception if no min value is found. (Similar for max value) <br/>
- while (!stack.isEmpty()) { lcm = lcm(lcm, stack.pop()); } : Iterates over the stack, calculating lcm of values. (Similar for gcd) <br/>
<br/>
<br/>
**CalculatorServer**<br/>
<br/>
- LocateRegistry: Import class from 'java.rmi.registry' package.<br/>
- Registry: Import interface from the 'java.rmi.registry' package.<br/>
- Create an RMI registry on local host. This allows clients to lookup remote remote objects by name.<br/>
- Initiate new object of 'CalculatorImplementation', which implements 'Calculator' interface.<br/>
- Bind 'calculator' instance to 'CalculatorService' to obtain a reference to remote object using 'rebind' method.<br/>
-  Catch exceptions which occur during execution.<br/>
<br/>
<br/>
**CalculatorClient CalculatorClient1, CalculatorClient2, CalculatorClient3**<br/>
<br/>
- Import 'LocateRegistry' and 'Registry' from 'java.rmi.registry' package.<br/>
- Get the reference to the RMI registry running on 'localhost' with 'getRegistry'.<br/>
- Lookup 'CalculatorService' in the registry and cast the remote object object reference to the 'Calculator' interface.<br/>
- Then push the values to perform the required operations (min, max, lcm, gcd).<br/>
- Print outputs.<br/>
<br/>


  




