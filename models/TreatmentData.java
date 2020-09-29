package models;
import java.util.UUID;

public class TreatmentData {
    private UUID PatientId ;
    private UUID DoctorId ;
    // Weekly Treatment Hours that Doctor spent with that patient
    private double WTH ; 
    private Prescription[] Prescriptions ;

    public TreatmentData(UUID patientId, UUID doctorId, double wTH, Prescription[] prescriptions) {
        PatientId = patientId;
        DoctorId = doctorId;
        WTH = wTH;
        Prescriptions = prescriptions;
    }

    public double getHoursPerWeekPerPatient() { return WTH; }
    public void setHoursPerWeekPerPatient(double WTH) { this.WTH = WTH; }
    public Prescription[] getPrescriptions() { return Prescriptions; }
    public void setPrescriptions(Prescription[] prescriptions) { Prescriptions = prescriptions; }
    public UUID getPatientId() { return PatientId; }
    public void setPatientId(UUID patientId) { PatientId = patientId; }
    public UUID getDoctorId() { return DoctorId; }
    public void setDoctorId(UUID doctorId) { DoctorId = doctorId; }

}
