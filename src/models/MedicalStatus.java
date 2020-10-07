package src.models;

public class MedicalStatus{
   private String BloodPressure;
   private double SystolicBP,DiastolicBP,HeartRate,Temprature;
   public MedicalStatus(final String[] params){
       this.Temprature = Double.parseDouble(params[0]);
       this.SystolicBP = Double.parseDouble(params[1]);
       this.DiastolicBP =Double.parseDouble(params[2]);
       this.HeartRate = Double.parseDouble(params[3]);
       BloodPressure = SystolicBP + "/"+ DiastolicBP;
   }
//    public MedicalStatus(int systolicBP,int diastolicBP,int temprature, int heartRate){
//        this.Temprature = temprature;
//        this.SystolicBP = systolicBP;
//        this.DiastolicBP = diastolicBP;
//        this.HeartRate = heartRate;
//        BloodPressure = SystolicBP + "/"+ DiastolicBP;
  // }
   public String getBloodPressure() {return BloodPressure;}
   public double getSystolicBP(){ return SystolicBP;}
   public double getDiastolicBP(){ return DiastolicBP;}
   public double getHeartRate(){ return HeartRate;}
   public double getTemprature(){ return Temprature;}
   
   public void setSystolicBP(double systolic){ this.SystolicBP = systolic;}
   public void setDiastolicBP(double diastolic){ this.DiastolicBP = diastolic;}
   public void setTemprature(double temprature){ this.Temprature = temprature;}
   public void setHeartRate(double heartRate){ this.HeartRate = heartRate;}

}
