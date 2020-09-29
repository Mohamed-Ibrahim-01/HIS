package models;

import java.util.UUID;
class Medication{
    private UUID Id;
    private String Name;
    private int DailyDose, WeeklyDose, DoseValue, Quantity;
    public Medication(String name,int dailyDose, int doseValue, int quantity,UUID id){
        Name = name;
        DailyDose = dailyDose;
        DoseValue = doseValue;
        Quantity = quantity;
        Id = id ;
        WeeklyDose = DailyDose * 7 ;
    }    
    public String getName(){ return Name;}
    public void setName(String name){ Name = name;}

    public int getDailyDose(){ return DailyDose;}
    public void setDailyDose(int dailyDose){ DailyDose = dailyDose;}

    public int getWeeklyDose(){ return WeeklyDose;}
    public void setWeeklyDose(int weeklyDose){ WeeklyDose = weeklyDose;}

    public int getDoseValue(){ return DoseValue;}
    public void setDoseValue(int doseValue){ DoseValue = doseValue;}

    public int getQuantity(){ return Quantity;}
    public void setQuantity(int quantity){ Quantity = quantity;}

    public UUID getUuid() { return Id; }
    public void setUuid(UUID id) { Id = id; }
}
