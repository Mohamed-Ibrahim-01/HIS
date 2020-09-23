class MedicalHistory{
    private PersonMH PatientMH;
    private FamilyMH PatientFamilyMH;
    public MedicalHistory(PersonMH patientMH,FamilyMH patientFamilyMH){
        this.PatientMH = patientMH;
        this.PatientFamilyMH = patientFamilyMH;
    }
    public PersonMH getPatientMH(){ return PatientMH;}
    public FamilyMH getPatientFamilyMH(){ return PatientFamilyMH;}
    public void setPatientMH(PersonMH patientMH){ this.PatientMH = patientMH;}
    public void setPatientFamilyMH(FamilyMH patientFamilyMH){ this.PatientFamilyMH = patientFamilyMH;}
}
