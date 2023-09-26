import java.util.HashSet;
import javax.swing.JOptionPane;

class CreateException extends Exception{
           public CreateException() {
        super();
    }

    public CreateException(String message) {
        super(message);
    }

    public CreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
public class InputValidation  {

    double amount;
    String category;
    public static void main(String[] args) {
        
    }
    InputValidation(double a, String c){
           System.out.println("Came here");
        amount=a;
        category=c;

    }

    public String checkAmount() throws CreateException{
       

        
        if((amount>0 && amount <1000)){
            
                   return " ";

        }
        else{
            Exception e1Exception=new CreateException("Amount must be between 0 and 1000");
            return e1Exception.toString();
        }
    }
   public String checkCategory() throws CreateException{

            HashSet<String> hashSet=new HashSet<>();
        hashSet.add("food");hashSet.add("travel");hashSet.add("bills");hashSet.add("entertainment");hashSet.add("other");
        
        if(hashSet.contains(category)){
            return " ";
        }
        Exception e1Exception=new CreateException("Please select the correct category");
        return e1Exception.toString();
   }
   
}
