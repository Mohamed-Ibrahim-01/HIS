package src.models;
import java.util.List;
import java.util.UUID;

public class TreatmentData {
    private UUID PatientId ;
    private UUID DoctorId ;
    // Weekly Treatment Hours that Doctor spent with that patient
    private double WTH ; 
    private List<Prescription> prescriptions ;

    public TreatmentData(String[] data,List<Prescription>  prescriptions) {
        PatientId = UUID.fromString(data[0]);
        DoctorId =  UUID.fromString(data[1]);
        WTH = Double.parseDouble(data[2]);
        this.prescriptions = prescriptions;
    }

    public double getHoursPerWeekPerPatient() { return WTH; }
    public void setHoursPerWeekPerPatient(double WTH) { this.WTH = WTH; }
    public UUID getPatientId() { return PatientId; }
    public void setPatientId(UUID patientId) { PatientId = patientId; }
    public UUID getDoctorId() { return DoctorId; }
    public void setDoctorId(UUID doctorId) { DoctorId = doctorId; }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }
private String returnprescriptions(){
    String pr = ""; 
     for (Prescription p : prescriptions){
        pr += p + "\n\n " ;
 }
    return pr ; 
}
@Override 
public String toString(){
return "patient id = "+PatientId +" doctor id =  "+ DoctorId +" WTH =  " + WTH +"\n" +
returnprescriptions();
}
}
