package src.system;

import java.util.UUID;

public class SystemMedication {
    private UUID Id;
    private String Name ; 
    private int Quantity;
    
    public MedicationStorage(){


    }   

    public MedicationStorage(UUID id , String name , int quantity){
        this.Id = id;
        this.Name = name ;
        this.Quantity = quantity;
    }
    
    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
    
}
