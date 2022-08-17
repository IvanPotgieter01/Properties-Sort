

/**
 * Write a description of class Property here.
 *
 * @author (Ivan Potgieter)
 * @version (16/04/2022)
 */
public abstract class Property implements Propable
{
    private char type;
    private String name;
    private String contactNum;
    private int duration;
    
    public Property() //default constructor
    {
        
    }
    
    public Property(char type, String name, String contactNum, int duration)  
    {
        setType(type);
        setName(name);
        setContactNum(contactNum);
        setDuration(duration);
    }
    
    public char getType() //Accessor method 
    {
        return type;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getContactNum()
    {
        return contactNum;
    }
    
    public int getDuration()
    {
        return duration;
    }
    
    public void setType(char type) //Mutator method
    {
        this.type = type;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setContactNum(String contactNum)
    {
        this.contactNum = contactNum;
    }
    
    public void setDuration(int duration)
    {
        this.duration = duration;
    }
    
    public abstract double calcMonthRent(); //Abstract method
    
    @Override //default toString() method
    public String toString()
    {
        String str = String.format("%-20s%-20s%-10d", name, contactNum, duration);
        return str;
    }
}
