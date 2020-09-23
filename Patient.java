
public class Patient extends Person {
        private String PatientId , AdmittanceDate ;
        private MedicalStatus MedicalStatus ;
        private MedicalHistory MedicalHistory ;  
    public Patient() {
    }
    public Patient(String name, String id, String address, String phone, String birthDate, String sex, String patientId,
			String admittanceDate, MedicalStatus medicalStatus, MedicalHistory medicalHistory) {
		super(name, id, address, phone, birthDate, sex);
		PatientId = patientId;
		AdmittanceDate = admittanceDate;
		MedicalStatus = medicalStatus;
		MedicalHistory = medicalHistory;
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
}