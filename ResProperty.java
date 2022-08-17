
/**
 * Write a description of class ResProperty here.
 *
 * @author (Ivan Potgieter)
 * @version (16/04/2022)
 */
public class ResProperty extends Property
{
    private char typeRes;
    private int bedR;
    private int bathR;
    private double rentRes;
    
    public ResProperty()//default constructor
    {
        
    }
    
    public ResProperty(char type, String name, String contactNum, int duration, char typeRes, int bedR, int bathR)//parameterized constructor
    {
        super(type, name, contactNum, duration);
        setTypeRes(typeRes);
        setBedR(bedR);
        setBathR(bathR);
    }
    
    public char getTypeRes() //Accessor method 
    {
        return typeRes;
    }
    
    public int getBedR()
    {
        return bedR;
    }
    
    public int getBathR()
    {
        return bathR;
    }
    
    public void setTypeRes(char typeRes) //Mutator method
    {
        this.typeRes = typeRes;
    }
    
    public void setBedR(int bedR) 
    {
        this.bedR = bedR;
    }
    
    public void setBathR(int bathR) 
    {
        this.bathR = bathR;
    }
    
    public double calcMonthRent()
    {
        double rentRes;
        final double FRATE = 500;
        final double TRATE = 1000;
        final double HRATE = 800;
        
        if (getTypeRes() == 'F') //Calculating rent depending on the type of residential property
        {
            rentRes = 8000;
            rentRes = rentRes + (getBedR() * FRATE);
        }
        else if (getTypeRes() == 'T')
        {
            rentRes = 15000;
            rentRes = rentRes + (getBedR() * TRATE);
        }
        else
        {
            rentRes = 12000;
            rentRes = rentRes + (getBedR() * HRATE);
        }
        
        return rentRes;
    }
    
    public String toString()//Residential property toString() method
    {
        String str = String.format("%-20s%-20s%-10d%-10c%-10d%-10d", getName(), getContactNum(), getDuration(), typeRes, bedR, bathR);
        return str;
    }
}
