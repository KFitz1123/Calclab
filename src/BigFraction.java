
import java.math.BigInteger;

import java.lang.String ;



public class BigFraction {
    // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+

  /*
   * (1) Denominators are always positive. Therefore, negative fractions are represented 
   * with a negative numerator. Similarly, if a fraction has a negative numerator, it 
   * is negative.
   * 

   * (2) Fractions are not necessarily stored in simplified form. To obtain a fraction 
   * in simplified form, one must call the `simplify` method.
   */


  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+


  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;
  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   */

  public BigFraction(BigInteger num, BigInteger denom) {
    this.num = num;
    this.denom = denom;
  } // Fraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   */

  public BigFraction(int num, int denom) {
  this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
  } // Fraction(int, int)


  /**
   * Build a new fraction by parsing a string.
   */

  public BigFraction(String str) {
    this.num = BigInteger.valueOf(2);
    this.denom = BigInteger.valueOf(7);

  } // Fraction
  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+
/* input *ArbitraryBigFraction*.fractoint(*fraction you want reduced*)
   * Reduce to number
   */
  public BigInteger fractoint(BigFraction frac){
    
    return frac.num.divide(denom);
  }//fractioint
  /*
   * Reduce to smallest fractional form
   */
   public BigFraction reduce(){
    BigFraction reduced = new BigFraction(1,1);
if(this.num.mod(this.denom) == BigInteger.valueOf(0)){
 reduced.num = this.num.divide(this.denom);
} // if num = denom
  else {
    BigInteger i = this.num.gcd(this.denom);
    reduced.num = this.num.divide(i);
    reduced.denom = this.denom.divide(i);
  }//if true fraction
  return reduced;
}
    
   
  /**
   * Express this fraction as a double.
   */

  public double doubleValue() {
  return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

    public BigFraction multiply1(BigFraction mult1) {     
        BigInteger numerator = (this.num.multiply(mult1.num));
        BigInteger denomenator = (this.denom.multiply(mult1.denom));
        return new BigFraction(numerator, denomenator);

    }//Muliply

    public BigFraction divide(BigFraction div) {     
        BigInteger numerator = (this.num.multiply(div.denom));
        BigInteger denomenator = (this.denom.multiply(div.num));
        return new BigFraction(numerator, denomenator);

    }//Divide



    public BigFraction toFraction(String string){
      BigFraction result = new BigFraction(1,1);
        int divisor = string.indexOf("/");
        if (divisor == -1){
      result.num = BigInteger.valueOf(Integer.valueOf(string)) ;
      result.denom = BigInteger.valueOf(1);
        }
        else{
        int num = Integer.valueOf(string.substring(0,divisor));
        int denom = Integer.valueOf(string.substring(divisor + 1, string.length()));
        result.num = BigInteger.valueOf(num);
        result.denom = BigInteger.valueOf(denom);
        }
      return result;

    }   

  /**
   * Add the fraction `addMe` to this fraction.
   */

  public BigFraction add(BigFraction addMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
   
    resultDenominator = this.denom.multiply(addMe.denom);  
    resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));
    return new BigFraction(resultNumerator, resultDenominator);
  }// add(Fraction)

  /**
   * Add the fraction `addMe` to this fraction.
   */

  public BigFraction subtract(BigFraction subMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
   
    resultDenominator = this.denom.multiply(subMe.denom);  
    resultNumerator = (this.num.multiply(subMe.denom)).subtract(subMe.num.multiply(this.denom));
    return new BigFraction(resultNumerator, resultDenominator);

  }// subtract(Fraction)

  /**
   * Get the denominator of this fraction.
  */

  public BigInteger denominator() {
    return this.denom;
  } // denominator()

  /**
   * Get the numerator of this fraction.
 */

  public BigInteger numerator() {
    return this.num;
  } // numerator()

  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero
    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()
}