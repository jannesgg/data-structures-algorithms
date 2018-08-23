import java.util.Stack;
import java.util.Arrays;
import java.util.Scanner;

class RPN {
  private Stack<Integer> operands = new Stack<Integer>();

  public RPN() {
  }

  public void loop() {
    Scanner in = new Scanner(System.in);

    final String prompt = "> ";
    System.out.print(prompt);

    int result = 0;
    int operand1;
    int operand2;

    while(in.hasNext()){
      if(in.hasNextInt()) {
        int x = in.nextInt();

        //push the integer to the operands stack
        operands.push(x);

        //print out all operands in the stack
        System.out.println(Arrays.toString(operands.toArray()).replace("[", "").replace("]", ""));;

      } else {
        String s=in.next();
        if(s.equals("quit")) {
          System.out.println("Quitting");
          break;
        }
        operand2 = operands.pop();
        operand1 = operands.pop();

        if(s.equals("+")){
          result = operand1 + operand2;
        } else if(s.equals("-")) {
          result = operand1 - operand2;
        } else if(s.equals("*")) {
          result = operand1 * operand2;
        } else if(s.equals("/")) {
          result = operand1 / operand2;
        }
        operands.push(result);
        System.out.println(result);
      }
      System.out.print(prompt);
    }

  }

  public static void main (String[] args) {
    RPN calc = new RPN();
    calc.loop();
  }
}
