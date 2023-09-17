
import java.lang.String ;
import java.io.PrintWriter;
import java.util.Scanner;
import java.math.BigInteger;

/*
 * Class: QuickClaculator
 * Author: Kevin Fitzgerald
 * This class is a main() class. with input to command line. this should be in the form of multiple strings which contain the 
 * specifications of BFCalculator
 */

public class  QuickCalculator {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    
    BigFraction frac = new BigFraction(1,2);
    BigFraction[] necessary = new BigFraction[26];
    BFCalculator it = new BFCalculator(necessary);
    String result = "";
 for (int i = 0; i < args.length; i++){
  
  String store = "STORE";
  if ((args[i].length() >= 5) && store.equals(args[i].substring(0,5))){
    Scanner eye = new Scanner(args[i]);
    eye.next();
    String rstring = eye.next();
    pen.println(rstring);
    char register = (char) rstring.codePointAt(0);
    pen.println(register);
    it.store(register);
    eye.close();
  }// if command is to store
else {
  frac = it.evaluate(args[i]);
  
  frac = frac.reduce();
  if(frac.denom == BigInteger.valueOf(1)){
    BigInteger wholenum = frac.num; 
      result = wholenum.toString();
  }
  else {
    result = frac.toString();
  } // simplifying into a string 'result'

  pen.println(result.toString());
}// For each arg
  }// else (if not STORE)
} //Main

}// QuickCalculator