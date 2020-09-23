import java.util.Date;

class Medication{
    private String Name;
    private Date StartDate,EndDate;
    private int DailyDose,WeeklyDose,DoseValue;
    public Medication(String Name, Date StartDate, Date EndDate ,int DailyDose, int WeeklyDose, int DoseValue){
        this.Name = Name;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.DailyDose = DailyDose;
        this.WeeklyDose =WeeklyDose;
        this.DoseValue = DoseValue;
    }    
    public String getName(){ return Name;}
    public Date getStartDate(){ return StartDate;}
    public Date getEndDate(){ return EndDate;}
    public int getDailyDose(){ return DailyDose;}
    public int getWeeklyDose(){ return WeeklyDose;}
    public int getDoseValue(){ return DoseValue;}
    
    public void setName(String Name){this.Name = Name;}
    public void setStartDate(Date StartDate){this.StartDate = StartDate;}
    public void setEndDate(Date EndDate){this.EndDate = EndDate;}
    public void setDailyDose(int DailyDose){this.DailyDose = DailyDose;}
    public void setWeeklyDose(int WeeklyDose){this.WeeklyDose = WeeklyDose;}
    public void setDoseValue(int DoseValue){this.DoseValue = DoseValue;}
}
