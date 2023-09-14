
import java.lang.String ;
import java.io.PrintWriter;


public class  QuickCalculator {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
String Block1 = "";
String Block2 = "";
 for (int i = 0; i < args.length; i++)
 {BFCalculator it = new BFCalculator("");
  //pen.println(it.evaluate(args[i]));
  pen.println(args[i]);
  if(!(args[i].indexOf("+") == -1)){
    int funcloc = args[i].indexOf("+");
Block1 = args[i].substring(0,funcloc - 1);
Block2 = args[i].substring(funcloc + 2, args[i].length());
pen.println(Block1 + " and " + Block2);
BigFraction test = new BigFraction(2,3);
String sum = addstring(Block1, Block2);
pen.println("summmmm = " + sum);
test = test.toFraction(sum);
pen.println(test.reduce());
  }
 }
    pen.println();
} //Main

 
public static String addstring(String str1, String str2) {
  BigFraction first = new BigFraction(2,3); 
  BigFraction scnd = new BigFraction(2,3);
  BigFraction result = new BigFraction(2,3);
first = first.toFraction(str1);
scnd = scnd.toFraction(str2);
result = first.add(scnd); 
  return result.toString();
}


}// QuickCalculator