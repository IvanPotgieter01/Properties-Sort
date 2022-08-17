
/**
 * Write a description of class BussProperty here.
 *
 * @author (Ivan Potgieter)
 * @version (16/04/2022)
 */
public class BussProperty extends Property
{
    private int size;
    private double insurance;
    private double rentBus;
    
    public BussProperty()//default constructor
    {
        
    }
    
    public BussProperty(char type, String name, String contactNum, int duration, int size)//parameterized constructor
    {
        super(type, name, contactNum, duration);
        setSize(size);
    }
    
    public int getSize() //Accessor method 
    {
        return size;
    }
    
    public double getInsurace()
    {
        return insurance;
    }
    
    public void setSize(int size) //Mutator method
    {
        this.size = size;
    }
    
    public double calcMonthRent()
    {
        double rentBus;
        final double RATE = 250;
        rentBus = getSize() * RATE; //Calculating rent from property size
        return rentBus;
    }
    
    public double calcMonthInsurance()
    {
        double insurance;
        final double percentage = 0.1;
        insurance = calcMonthRent() * percentage; //Calculating insurance from monthly rent
        return insurance;
    }
    
    
    public String toString()//Business property toString() method
    {
        String str = String.format("%-20s%-20s%-10d%-10d", getName(), getContactNum(), getDuration(), size);
        return str;
    }
}
