class Medication{
    private String Name;
    private int DailyDose, WeeklyDose, DoseValue, Quantity;
    public Medication(String Name,int DailyDose, int WeeklyDose, int DoseValue, int Quantity){
        this.Name = Name;
        this.DailyDose = DailyDose;
        this.WeeklyDose = WeeklyDose;
        this.DoseValue = DoseValue;
        this.Quantity = Quantity;
    }    
    public String getName(){ return Name;}
    public int getDailyDose(){ return DailyDose;}
    public int getWeeklyDose(){ return WeeklyDose;}
    public int getDoseValue(){ return DoseValue;}
    public int getQuantity(){ return Quantity;}
    
    public void setName(String Name){this.Name = Name;}
    public void setDailyDose(int DailyDose){this.DailyDose = DailyDose;}
    public void setWeeklyDose(int WeeklyDose){this.WeeklyDose = WeeklyDose;}
    public void setDoseValue(int DoseValue){this.DoseValue = DoseValue;}
    public void setQuantity(int Quantity){this.Quantity = Quantity;}
}
