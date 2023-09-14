
import java.lang.String ;
import java.io.PrintWriter;
public class 
InteractiveCalculator {
  
  public static void main(String[] args) {
    BigFraction test = new BigFraction(1,1);
    BigFraction test2 = new BigFraction(2,1); 
    BigFraction test3 = new BigFraction(1,1);
    
    test = test.toFraction(args[0]);
test3 = test.divide(test2);
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println(test + "  " + test2 + "  " + test3);
    test = test.reduce();
    pen.println(test);
    pen.println(test.fractoint(test) + "  " + test.fractoint(test3));
}
}