
import java.lang.String ;
import java.io.PrintWriter;
import java.util.Scanner;
import java.math.BigInteger;
/*
 * Class: InteracticeCalculator
 * Author: Kevin Fitzgerald
 * This class is a main() file which requires interaction on the command line. Input shares the same assumptions as BFCalculator
 */
public class InteractiveCalculator {
  
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner eye = new Scanner(System.in);
    String token = "";
    String store = "STORE";
    String quit = "QUIT";
    String result = "";
    BigFraction frac = new BigFraction(7,13);
    BigFraction[] necessary = new BigFraction[26];
    BFCalculator it = new BFCalculator(necessary);

/*Greeting message and explanation of valid input */
    pen.println(" Please input a function you want solved.\nViable non-function Instructions:\nSTORE 'char'- stores last in variable 'char'\n'char': returns the value STOREd at 'char'\nQUIT: exits the program\n");

    while(!(token.equals("QUIT"))){
pen.print("input : ");
pen.flush();
token = eye.nextLine();
  if ((token.length() >= 5) && store.equals(token.substring(0,5))){
    Scanner bifocal = new Scanner(token);
      bifocal.next(); // moves past STORE
    String rstring = bifocal.next(); // takes char after STORE
    char register = (char) rstring.codePointAt(0);
      it.store(register);
     bifocal.close();
    }// if token = STORE
  else if((token.length() == 4) && quit.equals(token.substring(0,4))){
    }// if token = QUIT
  else {
    frac = it.evaluate(token);
    }// evaluate any other token value

  frac = frac.reduce();

  if(frac.denom == BigInteger.valueOf(1)){
    BigInteger wholenum = frac.num; 
      result = wholenum.toString();
      pen.println("The result is : " + result.toString());
  }// if it can be simplified as a whole number  e
  else if((token.length() == 4) && quit.equals(token.substring(0,4))){
    }// if token = QUIT
  else {
    result = frac.toString();
    pen.println("The result is : " + result.toString());
  } // simplifying into a string 'result'
  
  }//Big While Loop

  eye.close();
}//main(String[] args)
}// InteractiveCalculator