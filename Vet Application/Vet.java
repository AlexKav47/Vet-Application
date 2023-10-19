public class Vet
{
    private Animal [] animalList; 
    private int total; 
    
    private static int lenTimeClient;
    public Vet(int sizeIn)
    {
     animalList = new Animal[sizeIn]; 
     total = 0;
    }
    
    public int getTotal()
    {
      return total;
    }
    
    public boolean addDetails(String id ,boolean vaccinations)
    {
     Animal animal = getItem(id); 
     
     if(animal == null)
     {
      return false;   
     }
     else
     {
       animal.setVaccinations(vaccinations); 
       return true;
     }
    }
    
    public String upDateLenOfTime()
    {
     for(int i = 0; i < animalList.length; i++)
     {
      if(animalList[i] == null) 
      {
       return "All Animal Years in System is Updated";        
      }
      else
      {
       animalList[i].setLenTimeClient(1); 
      }
     }   
     return "All Animal Years in System is Updated";   
    }
    
    public Animal findOldestAnimal()
    {
      if(animalList.length == 0)
      {
        return null;  
      }
      else
     {
      Animal tempAnimal = animalList[0];
      for(int i = 0;i < animalList.length;i++)
      {
        if(animalList[i] == null) 
        {
         return tempAnimal;
        }
        else if(tempAnimal.getAnimalAge() < animalList[i].getAnimalAge()) 
        { 
         tempAnimal = animalList[i]; 
        }
      }
      return tempAnimal;
     }
     }
    
    public Animal findYoungestAnimal()
    {
      if(animalList.length == 0)
      {
        return null;  
      }
      else
     {
      Animal tempAnimal = animalList[0];
      for(int i = 0;i < animalList.length;i++)
      {
        if(animalList[i] == null)  
        {
         return tempAnimal;
        }
        else if(tempAnimal.getAnimalAge() > animalList[i].getAnimalAge())
        { 
         tempAnimal = animalList[i]; 
        }
      }
      return tempAnimal;
     }
    }
    
    public boolean add(Animal animalIn) 
    {
       if(isFull() == false)  
       {
         animalList[total] = animalIn; 
         total++;                      
         return true;                  
       }else{
         return false;                 
       }
    }
    
    public boolean delete(String animalIdIn)
    {
      int index = search(animalIdIn);  
      if(index == -999)                
      {
          return false;                
      }
      else
      {  
         for(int i = index; i < total-1; i++)
         {
           animalList[i] = animalList[i+1];  
         }
         total--;  
         return true; 
      }          
    }
    
    public boolean isEmpty()
    {
        if(total == 0)
        {
            return true; 
        }
        else
        {
            return false; 
        }
    }
    
    public boolean isFull()
    {
        if(total == animalList.length)
        {
          return true; 
        }
        else
        {
          return false; 
        }
    }

    public Animal getItem(String animalIdIn)
    {
     int index;
     index = search(animalIdIn);
     if(index == -999)
     {
         return null; 
     }
     else
     {
         return animalList[index];
     }
    }
    
    public int search(String animalIdIn)
    {
        for(int i=0; i < total; i++)
        {
          if(animalList[i].getAnimalId().equals(animalIdIn) == true) 
          {
            return i;  
          }
        }
        return -999; 
    }
    
    public String list()
    {
     String tempString=""; 
     String vaccinationDetails; 
     if(isEmpty() == true)
     {
      return tempString;   
     }
     else
     {
      for(int i=0; i < total; i++)
      {
        boolean checkVaccination= animalList[i].getVaccinations();
        
        if(checkVaccination == false)
        {
         vaccinationDetails ="No";   
        }
        else
        {
         vaccinationDetails ="Yes";   
        }
        tempString = tempString +"Animal id: "+animalList[i].getAnimalId()
        +"\nAnimal Name: "+animalList[i].getAnimalName()
        +"\nAnimal Type: "+animalList[i].getAnimalType()
        +"\nAnimal Age: "+animalList[i].getAnimalAge()
        +"\nOwner Name: "+animalList[i].getOwnerName()
        +"\nLenght of time client: "+animalList[i].getLenTimeClient()
        +"\nYear Registered: "+animalList[i].getYearRegistered()
        +"\nAnimal Vaccinations: "+vaccinationDetails+ "\n\n"; 
      }
      return tempString;
     }
    }
}
