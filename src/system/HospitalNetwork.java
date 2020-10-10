package src.system;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import src.fileoperations.Read;
import src.models.Doctor;
import src.models.Medication;
import src.models.Patient;
import src.models.Person;
import src.models.Prescription;
import src.models.TreatmentData;

public class HospitalNetwork {

    private static HashMap<UUID, Person> Persons;
    private static int numPatients, numDoctors;

    public HospitalNetwork() {
         Persons = new HashMap<UUID, Person>();
    }

    public static void loadData() {
        List<Doctor> doctors = Read.readDoctors();
        List<Patient> patients = Read.readPatients();
        List<TreatmentData> data = Read.readTreatmentData();

        for (Doctor d : doctors) {
            if (!addDoctor(d)) {
                System.out.println("doctor" + d.getName() + "has not been added");
            }
        }
        for (Patient d : patients) {
            if (!addPatient(d)) {
                System.out.println("patient" + d.getName() + "has not been added");
            }
        }
        for (TreatmentData t : data) {
            Patient patient = (Patient) Persons.get(t.getPatientId());
            Doctor doctor = (Doctor) Persons.get(t.getDoctorId());
            addTreatmentData(patient, doctor, t);
            List<Prescription> prescriptions = t.getPrescriptions();
            for (Prescription p : prescriptions) {
                p.setDoctor(doctor);
                p.setPatient(patient);
                List<Medication> medications = p.getMedications();
                for (Medication m : medications) {
                    patient.addMedication(m);
                }
            }
        }
    }

    public static boolean addPatient(Patient t) {
        boolean added = addPerson(t);
        if (added)
            numPatients++;
        return added;
    }

    public static boolean addDoctor(Doctor d) {
        boolean added = addPerson(d);
        if (added)
            numDoctors++;
        return added;
    }

    private static boolean addPerson(Person p) {
        UUID Id = p.getId();
        if (Persons.containsKey(Id))
            return false;
        Persons.put(Id, p);
        return true;
    }

    public static void addTreatmentData(Patient patient, Doctor doctor, TreatmentData treatmentData) {
        patient.addTreatmentData(doctor, treatmentData);
        doctor.addTreatmentData(patient, treatmentData);
    }

    public static int getNumPatients() {
        return numPatients;
    }

    public static int getNumDoctors() {
        return numDoctors;
    }
    public static Set<UUID> Ids(){
        return Persons.keySet();
    }
}
