
/**
 * Write a description of class FileClass here.
 *
 * @author (Ivan Potgieter)
 * @version (16/04/2022)
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.PrintWriter;
import java.io.FileWriter;
public class FileClass
{
    private int count = 0;
    ArrayList <Propable> arrProperties = new <Propable> ArrayList();
    
    public void readFromFile()
    {
        try
        {
          Scanner sc = new Scanner(new FileReader("properties.txt"));
         
          while (sc.hasNext()) //Continues reading while there are line to read
          {
              String line = sc.nextLine();
              String [] data = line.split("#");
              
              char type = data[0].charAt(0);
              String name = data[1];
              String contactNum = data[2]; //Assigning data in the text file to variables to be put into the array
              int duration = Integer.parseInt(data[3]);
              
              if (type == 'R') //Case if the input is for residential property
                {
                    char typeRes = data[4].charAt(0); 
                    int bedR = Integer.parseInt(data[5]);
                    int bathR = Integer.parseInt(data[6]);
                    arrProperties.add(new ResProperty(type, name, contactNum, duration, typeRes, bedR, bathR)); //Adding object to arraylist
                }
                else //Case if the input is for business property
                {
                    int size = Integer.parseInt(data[4]);
                    arrProperties.add(new BussProperty(type, name, contactNum, duration, size)); //Adding object to arraylist
                }                          
          }
          sc.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error reading from file"); //Error if the file cannot be opened
        }     
    }
    
    public ArrayList <Propable> getArray() //Method to get array
    {
        return arrProperties;
    }
    
    public void writeTownHToFile()
    {
        try
        {
            PrintWriter file  = new PrintWriter(new FileWriter("townhouses.txt")); //Writing to new file
            
            for (int i = 0; i < arrProperties.size(); i++)
            {
                if (arrProperties.get(i) instanceof ResProperty) //Condition if instance of ResProperty
                {
                    ResProperty Res = (ResProperty)arrProperties.get(i);
                    if (Res.getTypeRes() == 'T') //Condition if type of Residential property is Townhouse
                    {
                        String str = String.format("%-15s%-15s R %-15.2f\n",Res.getName(), Res.getContactNum(), Res.calcMonthRent());
                        file.println(str);                        
                    }
                }  
            }
            file.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error writing to file"); //Error if the file cannot be written to
        }  
    }
}
