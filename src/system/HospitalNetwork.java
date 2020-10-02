package src.system;
import java.util.HashMap;
import java.util.UUID;
import src.models.*;

public class HospitalNetwork {

    private HashMap<UUID,Person> Persons;
    private int numPatients, numDoctors;
    public HospitalNetwork(){
        this.Persons = new HashMap<UUID,Person>();
    }
    public boolean addPatient(Patient t){
        boolean added = addPerson(t);
        if(added) numPatients++;
        return added;
    }

    public boolean addDoctor(Doctor d){
        boolean added = addPerson(d);
        if(added) numDoctors++;
        return added;
    }

    private boolean addPerson(Person p){
        UUID Id = p.getId(); 
        if(Persons.containsKey(Id)) return false;
        Persons.put(Id, p);
        return true;
    }
    public void addTreatmentData(Patient patient, Doctor doctor, TreatmentData treatmentData){
        patient.addTreatmentData(doctor,treatmentData);
        doctor.addTreatmentData(patient,treatmentData);
    }

    public int getNumPatients() { return numPatients; }
    public int getNumDoctors() { return numDoctors; }

}

