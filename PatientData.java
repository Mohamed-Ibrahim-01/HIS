import java.util.UUID;
public class PatientData {
    private UUID Patientid ;
    private double HoursPerWeekPerPatient ; 
    private Prescription[] Prescriptions ;

    public PatientData(UUID patientid, double hoursPerWeekPerPatient, Prescription[] prescriptions) {
        Patientid = patientid;
        HoursPerWeekPerPatient = hoursPerWeekPerPatient;
        Prescriptions = prescriptions;
    }

    public UUID getPatientid() {
        return Patientid;
    }

    public void setPatientid(UUID patientid) {
        Patientid = patientid;
    }

    public double getHoursPerWeekPerPatient() {
        return HoursPerWeekPerPatient;
    }

    public void setHoursPerWeekPerPatient(double hoursPerWeekPerPatient) {
        HoursPerWeekPerPatient = hoursPerWeekPerPatient;
    }

    public Prescription[] getPrescriptions() {
        return Prescriptions;
    }

    public void setPrescriptions(Prescription[] prescriptions) {
        Prescriptions = prescriptions;
    }
    
    
}
