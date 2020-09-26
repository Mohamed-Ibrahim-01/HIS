class MedicalStatus{
   private String BloodPressure;
   private int SystolicBP,DiastolicBP,HeartRate,Temprature;
   public MedicalStatus(int SystolicBP,int DiastolicBP,int Temprature, int HeartRate){
       this.Temprature = Temprature;
       this.SystolicBP = SystolicBP;
       this.DiastolicBP = DiastolicBP;
       this.HeartRate = HeartRate;
       BloodPressure = SystolicBP + "/"+ DiastolicBP;
   }
   public String getBloodPressure() {return BloodPressure;}
   public int getSystolicBP(){ return SystolicBP;}
   public int getDiastolicBP(){ return DiastolicBP;}
   public int getHeartRate(){ return HeartRate;}
   public int getTemprature(){ return Temprature;}
   
   public void setSystolicBP(int systolic){ this.SystolicBP = systolic;}
   public void setDiastolicBP(int diastolic){ this.DiastolicBP = diastolic;}
   public void setTemprature(int temprature){ this.Temprature = temprature;}
   public void setHeartRate(int heartRate){ this.HeartRate = heartRate;}

}
