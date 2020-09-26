import java.util.UUID;
class Medication{
    private UUID uuid;
    private String Name;
    private int DailyDose, WeeklyDose, DoseValue, Quantity;
    public Medication(String Name,int DailyDose, int DoseValue, int Quantity,UUID uuid){
        this.Name = Name;
        this.DailyDose = DailyDose;
        WeeklyDose = (DailyDose*7) ;
        this.DoseValue = DoseValue;
        this.Quantity = Quantity;
        this.uuid = uuid ;
    }    
    public String getName(){ return Name;}
    public int getDailyDose(){ return DailyDose;}
    public int getWeeklyDose(){ return WeeklyDose;}
    public int getDoseValue(){ return DoseValue;}
    public int getQuantity(){ return Quantity;}
    public UUID getUuid() {
        return uuid;
    }
    
    public void setName(String Name){this.Name = Name;}
    public void setDailyDose(int DailyDose){this.DailyDose = DailyDose;}
    public void setWeeklyDose(int WeeklyDose){this.WeeklyDose = WeeklyDose;}
    public void setDoseValue(int DoseValue){this.DoseValue = DoseValue;}
    public void setQuantity(int Quantity){this.Quantity = Quantity;}
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
