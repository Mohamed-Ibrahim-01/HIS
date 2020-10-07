package src.models;
public class Medication{
    private String Name;
    private int DailyDose, WeeklyDose, DoseValue ;
    public Medication(String[] data){
        Name = data[0];
        DailyDose = Integer.parseInt(data[1]);
        DoseValue = Integer.parseInt(data[2]);
        WeeklyDose = DailyDose * 7 ;
    }    
    public String getName(){ return Name;}
    public void setName(String name){ Name = name;}

    public int getDailyDose(){ return DailyDose;}
    public void setDailyDose(int dailyDose){ DailyDose = dailyDose;}

    public int getWeeklyDose(){ return WeeklyDose;}
    public void setWeeklyDose(int DailyDose){WeeklyDose = DailyDose * 7 ;}

    public int getDoseValue(){ return DoseValue;}
    public void setDoseValue(int doseValue){ DoseValue = doseValue;}
@Override 
public String toString(){
return "name =  " + Name + " dailydose = "+DailyDose +" Weeklydose  ="+ WeeklyDose +" dosevalue = "+ DoseValue ; 

}
}
