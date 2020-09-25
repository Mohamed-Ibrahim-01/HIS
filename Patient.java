import java.util.UUID;

public class Patient extends Person {
        private String PatientId , AdmittanceDate ;
        private MedicalStatus MedicalStatus ;
        private String Complain ;
        private MedicalHistory MedicalHistory ;  
        private Doctor[] Doctors ; 
        private Prescription[][] Prescriptions ; 
        private double[] HoursPerWeekPerDoctor ;  
        private Medication[] Medications ; 
    public Patient() {
    }

    public Patient(String name, UUID id, String address, String phone, String birthDate, String sex, String patientId,
            String admittanceDate, MedicalStatus medicalStatus, MedicalHistory medicalHistory, Doctor[] doctors,
            Prescription[][] prescriptions, double[] hoursPerWeekPerDoctor, Medication[] medications) {
        super(name, id, address, phone, birthDate, sex);
        PatientId = patientId;
        AdmittanceDate = admittanceDate;
        MedicalStatus = medicalStatus;
        MedicalHistory = medicalHistory;
        Doctors = doctors;
        Prescriptions = prescriptions;
        HoursPerWeekPerDoctor = hoursPerWeekPerDoctor;
        Medications = medications;
    }

    public String getPatientId() {
        return PatientId;
    }

    public void setPatientId(String patientId) {
        PatientId = patientId;
    }

    public String getAdmittanceDate() {
        return AdmittanceDate;
    }

    public void setAdmittanceDate(String admittanceDate) {
        AdmittanceDate = admittanceDate;
    }

    public MedicalStatus getMedicalStatus() {
        return MedicalStatus;
    }

    public void setMedicalStatus(MedicalStatus medicalStatus) {
        MedicalStatus = medicalStatus;
    }

    public MedicalHistory getMedicalHistory() {
        return MedicalHistory;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        MedicalHistory = medicalHistory;
    }

    public Doctor[] getDoctors() {
        return Doctors;
    }

    public void setDoctors(Doctor[] doctors) {
        Doctors = doctors;
    }

    public Prescription[][] getPrescriptions() {
        return Prescriptions;
    }

    public void setPrescriptions(Prescription[][] prescriptions) {
        Prescriptions = prescriptions;
    }

    public double[] getHoursPerWeekPerDoctor() {
        return HoursPerWeekPerDoctor;
    }

    public void setHoursPerWeekPerDoctor(double[] hoursPerWeekPerDoctor) {
        HoursPerWeekPerDoctor = hoursPerWeekPerDoctor;
    }

    public Medication[] getMedications() {
        return Medications;
    }

    public void setMedications(Medication[] medications) {
        Medications = medications;
    }
    public void setComplain(String complain){
        this.Complain = complain;
    }
    public String getComplain(){return this.Complain;}
    

}
