public class Doctor extends Person {
    private String SSN, MSA , Degree ; 
    private Patient[] patients;
    private double[] HoursPerWeekPerPatient ; 
    private Prescription[][] Prescriptions ; 
    public Doctor(){
    }

    public Doctor(String name, String id, String address, String phone, String birthDate, String sex, String sSN,
            String mSA, String degree, Patient[] patients, double[] hoursPerWeekPerPatient,
            Prescription[][] prescriptions) {
        super(name, id, address, phone, birthDate, sex);
        SSN = sSN;
        MSA = mSA;
        Degree = degree;
        this.patients = patients;
        HoursPerWeekPerPatient = hoursPerWeekPerPatient;
        Prescriptions = prescriptions;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String sSN) {
        SSN = sSN;
    }

    public String getMSA() {
        return MSA;
    }

    public void setMSA(String mSA) {
        MSA = mSA;
    }

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String degree) {
        Degree = degree;
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    public double[] getHoursPerWeekPerPatient() {
        return HoursPerWeekPerPatient;
    }

    public void setHoursPerWeekPerPatient(double[] hoursPerWeekPerPatient) {
        HoursPerWeekPerPatient = hoursPerWeekPerPatient;
    }

    public Prescription[][] getPrescriptions() {
        return Prescriptions;
    }

    public void setPrescriptions(Prescription[][] prescriptions) {
        Prescriptions = prescriptions;
    }
    
}