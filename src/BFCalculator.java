import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.String ;

public class BFCalculator { 
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+


  /*the register */
  BigFraction[] exp = new BigFraction[26];
  BigFraction last = new BigFraction(1,1);

// sets the register to a default of 1/1
   // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+
  //builds register

public BFCalculator(BigFraction[] str){
  this.exp = str;
}
   // +---------+------------------------------------------------------
  // | Methods |
  // +---------+
/*
 * evaluates a string from left to right. inputs allowed are ints, fractions, STORE 'char', and 'char'
 * If a 'char' is not STOREd before you call it, it will have the default value of 0
 */
  public BigFraction evaluate(String str) {

    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner eye = new Scanner(str);
    String temp = "";
    int operator = 0;
    Object test2 = null; 
    BigFraction firstnum = new BigFraction(1,1);
    BigFraction scndnum = new BigFraction(1,1);
    temp = eye.next();
    /* For First Token */
    if ( ( 65 <= temp.codePointAt(0) && temp.codePointAt(0) <= 90) || ( 97 <= temp.codePointAt(0) && temp.codePointAt(0) <= 122)){
        temp = temp.toLowerCase();
        Object test1 = exp[temp.codePointAt(0) - 97];
      if(test1 == test2){ //if location in registry is null
        firstnum = new BigFraction(0,1);
        }// if nothing STOREd
      else{
        firstnum = exp[(temp.codePointAt(0) - 97)];
        }//else if location has something STOREd
      }// if next token is a char, store
    else {
      firstnum = firstnum.toFraction(temp);
  }// first argument in the string (first case)

  /*For Each Subsequent Token Until There Are No More*/
  while(eye.hasNext())
  {
    
    temp = eye.next();
    pen.println("for second temp read: " + temp);
    if ( ( 65 <= temp.codePointAt(0) && temp.codePointAt(0) <= 90) || ( 97 <= temp.codePointAt(0) && temp.codePointAt(0) <= 122)){
      temp = temp.toLowerCase();
      Object test1 = exp[temp.codePointAt(0) - 97];
      if(test1 == test2){ // if location is null
        scndnum = new BigFraction(0,1);
        }//if there is no value STOREd
      else{
        scndnum = exp[temp.codePointAt(0) - 97];
        }//if there is a value STOREd
      firstnum = firstnum.Calculate(scndnum, operator);
      }// if next token is a char get from register

    else if (temp.codePointAt(0) == 42 || temp.codePointAt(0) == 43 || temp.codePointAt(0) == 45|| temp.codePointAt(0) == 47){
      operator = temp.codePointAt(0);
      }//if Token is an operator

    else{
     // two cases - either toFraction or its an operator 42 43 45 57
      scndnum = firstnum.toFraction(temp);
      firstnum = firstnum.Calculate(scndnum, operator);
      pen.println("Firstnum post calculation is : " + firstnum.toString() + "\n");
    }// if not an operator or character (We assume this means it is either an int or a fraction)
  }// While eye.next() == true
  eye.close();
last = firstnum; //remember last evaluation
return firstnum;
}//evaluate

public void store(char register){
  exp[register - 97];
  }//store(char)
  // +------------------+---------------------------------------------
  // | (static) Methods |
  // +------------------+
  

  
    
}//BFCalculator
