public class Animal
{
    private String animalId; 
    private String animalType;
    private String ownerName;
    private String animalName;
    private int animalAge;
    private boolean vaccinations;
    private int yearRegistered;
    private int lenTimeClient;
    public Animal(String animalIdIn, String animalTypeIn, String ownerNameIn, String animalNameIn, int animalAgeIn, int yearRegisteredIn)
    {
     animalId = animalIdIn;
     animalType = animalTypeIn;
     ownerName = ownerNameIn;
     animalName = animalNameIn;
     animalAge = animalAgeIn;
     vaccinations = false;
     yearRegistered = yearRegisteredIn;
     lenTimeClient = 0;
    }
    
    public void setAnimalId(String animalIdIn)
    {
     animalId = animalIdIn;   
    }
    
    public void setAnimalType(String animalTypeIn)
    {
     animalType = animalTypeIn;   
    }
    
    public void setOwnerName(String ownerNameIn)
    {
     ownerName = ownerNameIn;   
    }
    
    public void setAnimalName(String animalNameIn)
    {
     animalName = animalNameIn;   
    }
    
    public void setAnimalAge(int animalAgeIn)
    {
     animalAge = animalAgeIn;   
    }
    
    public void setVaccinations(boolean vaccinationsIn)
    {
     vaccinations = vaccinationsIn;   
    }
    
    public void setYearRegistered(int yearRegisteredIn)
    {
     yearRegistered = yearRegisteredIn;   
    }
    
    public void setLenTimeClient(int lenTimeClientIn)
    {
     lenTimeClient = lenTimeClient + lenTimeClientIn;   
    }
    
    public String getAnimalId()
    {
     return animalId;   
    }
    
    public String getAnimalType()
    {
     return animalType;
    }
    
    public String getOwnerName()
    {
     return ownerName;
    }
    
    public String getAnimalName()
    {
     return animalName;
    }
    
    public int getAnimalAge()
    {
     return animalAge;
    }
    
    public boolean getVaccinations()
    {
     return vaccinations;
    }
    
    public int getYearRegistered()
    {
     return yearRegistered;
    }
    
    public int getLenTimeClient()
    {
     return lenTimeClient;
    }
}
