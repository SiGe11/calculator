import java.util.Scanner;
import java.io.PrintWriter;

public class dorcalc {
    
   /* Methods:
   usrInput - is for input the numbers.
   usrOpInput - is for input the operator.
   mkCalc - is for the calculating.
   letOutput - is for printing the results.
   saveRsl - is for saveing the results. */

    public static void main(String[] args) {
    double firstNumber;
    char oOperator;
    double secondNumber;
    double result;
    String beginning;
    
    if (System.getProperty("os.name").equals("Linux")){
            System.out.print("\033[0;1m DorCalc\033[0m");
        } else {
            System.out.print("DorCalc");
        }
        System.out.println(" v0.3b");
        System.out.println();
        System.out.println("The simple, open source calculator.");
        System.out.println();
        System.out.println("Type \'help\' to see the usage.");
        System.out.println();
        
        //Opening help.
        Scanner scanner = new Scanner( System.in );
        beginning = scanner.nextLine();
        if (beginning.equals("help"))
        {
            System.out.println();
            System.out.println("Please give the first number, then press enter; the operator, then press enter; the second number; then press enter.\nThen you will see the result.\n\nPlease make attention to follow the rules. Wrong inputs aren't handled yet.");
            firstNumber = usrInput();
        }
        //Handle if not the "help" was typed.
        else 
        {
                firstNumber = Double.parseDouble(beginning);
        }
        
       //Input data.
       
       //fistNumber=usrInput(); Given above.
       oOperator = usrOpInput();
       secondNumber = usrInput();
       
       //Make the calculations.
       result = mkCalc(firstNumber, oOperator, secondNumber);
       
       //Print the result.
       letOutput(result);
       
       //Possibility to save the result.
       //TODO y/N.
       System.out.println("Would you like to save the result (y/n)");
       char save = scanner.next().charAt(0);
       
       if (save=='y')
           saveRsl(result);
    }
    
    
   
    public static double usrInput()
    {
        Scanner reader = new Scanner(System.in);
        double x = reader.nextDouble();
        return x;
    }
    
    public static char usrOpInput()
    {
        Scanner reader = new Scanner(System.in);
        char x = reader.next().charAt(0);
        return x;
    }
    
    public static double mkCalc(double x, char z, double y)
    {
        double result;
        
    switch(z)
    {
    case '+' :
        result=x+y;
        break;
    case '-' :
        result=x-y;
        break;
    case '*' :
        result=x*y;
        break;
    case '/' :
    case ':' :
        result=x/y;
        break;
     default : {
        System.out.println(z + "  is not a valid operator. (+, -, /, *)");
        result=-1;
        }
        break;
    }
    return result;
    }
    
    public static void letOutput (double result)
    {
        if (System.getProperty("os.name").equals("Linux")){
            System.out.println("\033[0;1m"+result+"\033[0m");
        } else {
            System.out.println(result);
        }
    }
    
    public static void saveRsl (double result)
    {
       try{
        PrintWriter writer = new PrintWriter("result.txt", "UTF-8");
        writer.println(result);
        writer.close();
        } catch (Exception e) {
           System.out.println("Unable to save the result.");
        } 
    }
}
