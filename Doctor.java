import java.util.UUID;
import java.util.HashMap;
public class Doctor extends Person {
    // SSN : Social Security Number MSA: Major Scientific Area
    private String SSN, MSA , Degree ; 
    private HashMap<Patient,PatientData> Patients;

    public Doctor(){
    }

    public Doctor(String name, UUID id, String address, String phone, String birthDate, String sex, String sSN,
            String mSA, String degree, HashMap<Patient,PatientData> Patients) {
        super(name, id, address, phone, birthDate, sex);
        SSN = sSN;
        MSA = mSA;
        Degree = degree;
        this.Patients = Patients;
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

    public HashMap<Patient, PatientData> getPatients() {
        return Patients;
    }

    public void setPatients(HashMap<Patient, PatientData> patients) {
        Patients = patients;
    }

}
