package src.models;

public class MedicalStatus{
   private String BloodPressure;
   private int SystolicBP,DiastolicBP,HeartRate,Temprature;
   public MedicalStatus(final String[] params){
       this.Temprature = Integer.parseInt(params[0]);
       this.SystolicBP = Integer.parseInt(params[1]);
       this.DiastolicBP = Integer.parseInt(params[2]);
       this.HeartRate = Integer.parseInt(params[3]);
       BloodPressure = SystolicBP + "/"+ DiastolicBP;
   }
   public MedicalStatus(int systolicBP,int diastolicBP,int temprature, int heartRate){
       this.Temprature = temprature;
       this.SystolicBP = systolicBP;
       this.DiastolicBP = diastolicBP;
       this.HeartRate = heartRate;
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
