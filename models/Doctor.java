package models;
import java.util.UUID;
import java.util.HashMap;
public class Doctor extends Person {
    // SSN : Social Security Number MSA: Major Scientific Area
    private String SSN, MSA , Degree ; 
    private HashMap<Patient,TreatmentData> Patients;

    public Doctor(){
    }

    public Doctor(String name, UUID id, String address, String phone, String birthDate, String sex, String ssn,
            String msa, String degree, HashMap<Patient,TreatmentData> patients) {
        super(name, id, address, phone, birthDate, sex);
        SSN = ssn;
        MSA = msa;
        Degree = degree;
        Patients = patients;
    }

    public String getSSN() { return SSN; }
    public void setSSN(String sSN) { SSN = sSN; }

    public String getMSA() { return MSA; }
    public void setMSA(String mSA) { MSA = mSA; }

    public String getDegree() { return Degree; }
    public void setDegree(String degree) { Degree = degree; }

    public HashMap<Patient, TreatmentData> getPatients() { return Patients; }
    public void setPatients(HashMap<Patient, TreatmentData> patients) { Patients = patients; }

}
