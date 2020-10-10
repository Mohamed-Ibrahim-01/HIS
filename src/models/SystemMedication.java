package src.models;
import java.util.UUID;
public class SystemMedication {
    private UUID Id;
    private String Name ; 
    private int Quantity;
    
    public SystemMedication(String[] data){
        this.Id = UUID.fromString(data[0]);
        this.Name = data[1] ;
        this.Quantity = Integer.parseInt(data[2]);
    }

    @Override
    public String toString(){
        return Id.toString() + ":" + Name + " : " + Quantity + "\n";
    }
    
    public UUID getId() { return Id; }
    public void setId(UUID id) { Id = id; }

    public String getName() { return Name; }
    public void setName(String name) { Name = name; }

    public int getQuantity() { return Quantity; }
    public void setQuantity(int quantity) { Quantity = quantity; }
    
}
