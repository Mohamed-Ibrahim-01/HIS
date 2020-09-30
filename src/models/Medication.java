package src.models;
class Medication{
    private String Name;
    private int DailyDose, WeeklyDose, DoseValue ;
    public Medication(String name,int dailyDose, int doseValue){
        Name = name;
        DailyDose = dailyDose;
        DoseValue = doseValue;
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

}
