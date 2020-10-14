package src.management;

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

public class NetworkManage {

    private static HashMap<UUID, Person> Persons;
    private static HashMap<String,Person> PersonsNames;
    private static int numPatients, numDoctors;

    public static void loadData() {
        Persons = new HashMap<UUID, Person>();
        PersonsNames = new HashMap<String,Person>();
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
            collectPatientMedications(prescriptions,doctor,patient);
        }
    }
    private static void collectPatientMedications(List<Prescription> prescriptions, Doctor doctor, Patient patient){
            for (Prescription p : prescriptions) {
                p.setDoctor(doctor);
                p.setPatient(patient);
                List<Medication> medications = p.getMedications();
                for (Medication m : medications) {
                    patient.addMedication(m);
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
        Persons.put(Id, p);
        String name = p.getName();
        PersonsNames.put(name,p);
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
    public static boolean hasTreatmentData(Patient patient , Doctor doctor){
        return doctor.hasPatient(patient); 
    }

    public static Patient getPatient(String patientName){
        return (Patient) PersonsNames.get(patientName);
    }
    public static Doctor getDoctor(String doctorName){
        return (Doctor) PersonsNames.get(doctorName);
    }
}
