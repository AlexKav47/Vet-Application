public class VetApplication
{
    public static void main (String [] args)
    {
     int maxAnimals;
     int choice; 
     
     System.out.print("Enter the maximum number of animals that can be registed in the system: ");   
     maxAnimals = EasyScanner.nextInt();   
        
     Vet myVet = new Vet(maxAnimals);   
     
     do
     {
      System.out.println();
      System.out.println("Vet System");
      System.out.println("1. Add an Animal");
      System.out.println("2. Remove an Animal");
      System.out.println("3. Check if Vet System is empty");
      System.out.println("4. Check if Vet System is full");
      System.out.println("5. Add Additional Pet Details");
      System.out.println("6. Animal Details");
      System.out.println("7. Update Animal Length of Time in System");
      System.out.println("8. Exit System");
      System.out.println();
      System.out.print("Please enter choice [1-8 only]:");
      choice = EasyScanner.nextInt();   
      System.out.println();   
      if(choice == 1)
      {
       addAnimal(myVet);    
      }
      else if(choice == 2)
      {
       removeAnimal(myVet);   
      }
      else if(choice == 3)
      {
       isItEmpty(myVet);   
      }
      else if(choice == 4)
      {
       isItFull(myVet);   
      }
      else if(choice == 5)
      {
       addPetDetails(myVet);
      }
      else if(choice == 6)
      {
       otherOptions(myVet);   
      }
      else if(choice == 7)
      {
      displayLenOfTime(myVet);
      }
      else if(choice == 8)
      {
      System.out.println("Thank you for using the Vet System");  
      }
      else if(choice <= 0 || choice <= 8)
      {
      System.out.println("Invalid entry, please enter 1-8 only");   
      }
     }while(choice != 8); 
    }
    
    private static void otherOptions(Vet myVet)
    {
     char choice2;
     
     System.out.println("Vet System");
     System.out.println("1. Add an Animal");
     System.out.println("2. Remove an Animal");
     System.out.println("3. Check if Vet System is empty");
     System.out.println("4. Check if Vet System is full");
     System.out.println("5. Add Additional Pet Details");
     System.out.println("6. Animal Details");
     System.out.println("\t a. Display Details of an Animal");
     System.out.println("\t b. Display All Animals Details");
     System.out.println("\t c. Display Oldest Animal");
     System.out.println("\t d. Display Youngest Animal");
     System.out.println("7. Update Animal Length of Time in System");
     System.out.println("8. Exit System");
     System.out.println();
     System.out.print("Enter choice [a - d]: ");
     choice2 = EasyScanner.nextChar();
     if(choice2 == 'a')
     {
      displayAnimalDetails(myVet);
     }
     else if(choice2 == 'b')
     {
      listAllAnimals(myVet);   
     }
     else if(choice2 == 'c')
     {
       displayOldestAnimal(myVet); 
     }
     else if(choice2 == 'd')
     {
       displayYoungestAnimal(myVet);
     }
     else
     {
      System.out.println();   
      System.out.println("Invalid entry, please enter a-d only");     
     }
    }
    
    private static void displayLenOfTime(Vet myVet)
    {
      System.out.println(myVet.upDateLenOfTime());  
    } 

    private static void displayYoungestAnimal(Vet myVet)
    {
      Animal youngestAnimal = myVet.findYoungestAnimal();  
     if(youngestAnimal == null)
     {
      System.out.println();
      System.out.println("No Animals are added into the system");
     }
     else
     {
      System.out.println();
      System.out.println(youngestAnimal.getAnimalName()+" with animal id "+youngestAnimal.getAnimalId()+" is the youngest animal ("+youngestAnimal.getAnimalAge()+")");   
     }  
    }
    
    private static void displayOldestAnimal(Vet myVet)
    {
     Animal oldestAnimal = myVet.findOldestAnimal();  
     if(oldestAnimal == null)
     {
      System.out.println();
      System.out.println("No Animals are added into the system");
     }
     else
     {
      System.out.println();
      System.out.println(oldestAnimal.getAnimalName()+" with animal id "+oldestAnimal.getAnimalId()+" is the oldest animal ("+oldestAnimal.getAnimalAge()+")");   
     }
    }
    
    private static void addPetDetails(Vet myVet)
    {
       String animalId;
       
       System.out.print("Enter Animal id: ");  
       animalId = EasyScanner.nextString();
     
       char choice;
       System.out.println();
       System.out.print("Enter if vaccinations have been recieved (y or n): ");
       choice = EasyScanner.nextChar();
       if(choice == 'y')
       {
        if(myVet.addDetails(animalId,true) == false)  
        {
         System.out.println();
         System.out.println("Animal id "+animalId+" does not exsist in the system");
         return; 
        }
       }
       else if(choice == 'n')
       {
        if(myVet.addDetails(animalId,false) == false)
        {
         System.out.println();
         System.out.println("Animal id "+animalId+" does not exsist in the system");
         return; 
        }
       }
       System.out.println();
       System.out.println("Animal details updated");
     }
    

    
    private static void displayAnimalDetails(Vet myVet)
    {
     String animalId;
     Animal newAnimal;
     
     System.out.print("Enter Animal id: ");
     animalId =EasyScanner.nextString();
     newAnimal = myVet.getItem(animalId);
     if(newAnimal == null)
     {
       System.out.println();  
       System.out.println("Animal id "+animalId+" does not exsist in the system");
     }
     else
     {
       System.out.println();
       System.out.println("Animal id: "+newAnimal.getAnimalId());
       System.out.println("Animal name: "+newAnimal.getAnimalName());
       System.out.println("Animal Type: "+newAnimal.getAnimalType());
       System.out.println("Animal Owner Name: "+newAnimal.getOwnerName());
       System.out.println("Animal Age: "+newAnimal.getAnimalAge());
       System.out.println("Year Registered: "+newAnimal.getYearRegistered());
       System.out.println("Lenght of time client: "+newAnimal.getLenTimeClient());
       boolean vaccinationStatus = newAnimal.getVaccinations();
       if(vaccinationStatus == false)
       {
        System.out.println("Animal Vaccinations: No");
       }
       else
       {
        System.out.println("Animal Vaccinations: Yes");  
       }
     }
    }
    
    private static void listAllAnimals(Vet myVet)
    {
     String allDetails;
     allDetails = myVet.list();
     
     if(allDetails.equals("") == true)
     {
      System.out.println(); 
      System.out.println("There are no Animals registered in the Vets");
     }
     else
     {
      System.out.println(allDetails);
     }
    }
    
    private static void isItFull(Vet myVet)
    {
     boolean isItFull = myVet.isFull();
     if(isItFull == true)
     {
      System.out.println("The vet system is Full and cannot accept new animals");   
     }
     else
     {
      System.out.println("The vet system is not full - you can add new animals to the system");   
     }
    }
    
    private static void isItEmpty(Vet myVet)
    {
     boolean isItEmpty = myVet.isEmpty();   
     if(isItEmpty == true)
     {
      System.out.println("This vet system contains no animals");   
     }
     else
     {
      System.out.println("The vet system is not empty");
     }  
    }
    
    private static void removeAnimal(Vet myVet)
    {
     System.out.print("Enter Animal id to remove: ");  
     String number = EasyScanner.nextString();
     
     boolean ok = myVet.delete(number);
     if(ok == false)
     {
       System.out.println();
       System.out.println("Cannot delete animal from system - no such animal with id "+number+" exist in the system");
     }
     else
     {
       System.out.println();
       System.out.println("Animal with id number "+number+" is removed from the system");  
     }        
    }
    
    private static void addAnimal(Vet myVet)
    {
      String animalID;
      String animalType;
      String ownerName;
      String animalName;  
      int animalAge;
      int yearRegistered;
      int choice;

      System.out.print("Enter animal id: ");
      animalID = EasyScanner.nextString();
      System.out.print("Enter animal type: ");
      animalType = EasyScanner.nextString();
      System.out.print("Enter animal name: ");
      ownerName = EasyScanner.nextString();
      System.out.print("Enter owner name: ");
      animalName = EasyScanner.nextString();
      System.out.print("Enter animal age: ");
      animalAge = EasyScanner.nextInt();
      while(animalAge >= 31 || animalAge <= 0)
      {
       System.out.print("Please enter a valid age (0 - 30): ");
       animalAge = EasyScanner.nextInt();
      }
      
      System.out.print("Enter year animal registered: ");
      yearRegistered = EasyScanner.nextInt();
      
      while(yearRegistered >= 2022 || yearRegistered <= 1992)
      {
        System.out.print("Please enter a valid year (before 2022 and after 1992): ");
        yearRegistered = EasyScanner.nextInt();
      }
      Animal animal1 = new Animal(animalID,animalType,ownerName,animalName,animalAge,yearRegistered);
      
      boolean didItAdd = myVet.add(animal1);
      
      if(didItAdd == true)
      {
       System.out.println();
       System.out.println("New Animal Added");
       System.out.println();
      }else
      {
       System.out.println();
       System.out.println("Can not add new animal. This system is full");  
       System.out.println();   
      }
    }   
    }


