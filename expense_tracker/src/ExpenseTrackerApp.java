import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    boolean exception=false;
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    

    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      
      // Get transaction data from view
       double amount=0;String category="";
       //Try catch block to ensure that amount and category have correct values stored in them.
      try{
           amount = view.getAmountField(); 
       category = view.getCategoryField();
      }catch (Exception e1){
        
        System.out.println("The following is exception is thrown due to mismatch in the input data- "+e1);
        //display Exception here 

                    JOptionPane.showMessageDialog(
                null, 
                "An error occurred: " + e1+" Please enter an integer or decimal value in Amount section and a string in category section", 
                "Error", 
                JOptionPane.ERROR_MESSAGE

            );
            

      }

      

      InputValidation inputValidation=new InputValidation(amount,category);

      // Create transaction object
      String  cat="c";
      String amt="c";
      //check if the cat and amt variables have valid input as spcified in the document.
      try {
        amt = inputValidation.checkAmount();
      } catch (CreateException e1) {
        // TODO Auto-generated catch block
    
      }
      try{
       cat =inputValidation.checkCategory();
      }catch(CreateException e1){
 
      }
      if(cat.equals(" ") && amt.equals(" ")){
       
       Transaction t = new Transaction(amount, category);
       view.addTransaction(t);
      }
      else {
       JOptionPane.showMessageDialog(
                null, 
                "An error occurred: " + amt+" "+cat, 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
   
      }
      

      // Call controller to add transaction
      
    });

  }

}