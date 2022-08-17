
/**
 * Write a description of class testProperty here.
 *
 * @author (Ivan Potgieter)
 * @version (16/04/2022)
 */
import java.util.ArrayList;
public class testProperty
{
    public static void main (String [] args)
    {
        ArrayList <Propable> arrProperties = new <Propable> ArrayList(); //Declaring new ArrayList of type Propable
        
        FileClass file = new FileClass(); //Creating new file class
        
        file.readFromFile(); //Reading from file method
        arrProperties = file.getArray(); //Getting array method
        
        displayResidential(arrProperties); //Displaying arrays
        displayBusiness(arrProperties);
        
        file.writeTownHToFile(); //Writing to file method
    }
    
    public static void displayResidential(ArrayList arrProperties)
    {
        System.out.println("Residential Properties");
        System.out.printf("%-20s%-20s%-10s%-10s%-10s%-10s %-13s\n", "Name", "Cell num", "Months", "Type", "Beds", "Baths", "Rent(pm)");
        for (int i = 0; i < arrProperties.size(); i++)
        {
            if (arrProperties.get(i) instanceof ResProperty) //Condition if instance of ResProperty
            {
                ResProperty Res = (ResProperty)arrProperties.get(i);
                System.out.printf("%-10s R %-13.2f\n",Res.toString(), Res.calcMonthRent()); //Displaying residential properties
            }   
        }
    }
    
    public static void displayBusiness(ArrayList arrProperties)
    {
        System.out.println("\nBusiness Properties");
        System.out.printf("%-20s%-20s%-10s%-10s%-16s%-10s\n", "Name", "Cell num", "Months", "Size", "Insurance", "Rent(pm)");
        for (int i = 0; i < arrProperties.size(); i++)
        {
            if (arrProperties.get(i) instanceof BussProperty) //Condition if instance of BussProperty
            {
                BussProperty Bus = (BussProperty)arrProperties.get(i);
                System.out.printf("%-5s R %-13.2fR %-5.2f\n", Bus.toString(), Bus.calcMonthInsurance(), Bus.calcMonthRent()); //Displaying Business properties
            }   
        }
    }
}
