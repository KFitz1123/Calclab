
import java.lang.String ;
import java.io.PrintWriter;
import java.math.BigInteger;

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

    pen.println("Success");
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