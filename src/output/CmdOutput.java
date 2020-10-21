package src.output;

import src.models.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Date;
import java.util.Iterator;
import src.management.*;
import java.util.List;
public class CmdOutput {
    public static void printPatient(String name){
        Patient patient = NetworkManage.getPatient(name);
        if(patient == null) {
            Prompt.showTitle("PATIENT NOT FOUND");
            return ;
        }
        Prompt.showTitle("  PRINTING PATIENT'S INFORMATION  ");
        printData(patient.getPatientData());
    }
    public static void printAllPatients(){
        Prompt.showTitle("  PRINTING ALL PATIENT'S INFORMATION  ");
        for(Patient patient : NetworkManage.getPatients())
            printData(patient.getPatientData());
    }

    public static void printMedicalHistory(String name){
        Patient patient = NetworkManage.getPatient(name);
        if(patient == null) {
            Prompt.showTitle("PATIENT NOT FOUND");
            return ;
        }
        Prompt.showTitle("  PRINTING PATIENT'S MEDICAL HISTORY");
        String[] mapNames = {"Hospitalizations","ChronicDiseases","Diseases","Medications"};
        for(HashMap<String,Date> map : patient.getMedicalHistory().getPatientMH().getHistory()){
            int i = 0;
            System.out.printf("%60s",mapNames[i]);
            printData(mapToArr(map)); 
        }
    }
    public static void prnitPatientMedications(String name){
        Patient patient = NetworkManage.getPatient(name);
        if(patient == null) {
            Prompt.showTitle("PATIENT NOT FOUND");
            return ;
        }
        Prompt.showTitle("  PRINTING PATIENT'S MEDICATIONS");
        for(Medication medication : patient.getMedications()){
            System.out.println(medication);
        }
    }
    public static void printIcu(String name){
        ICU icu = ICUManage.getICU(name);
        if(icu == null) {
            Prompt.showTitle("ICU NOT FOUND");
            return ;
        }
        Prompt.showTitle("PRINTING ICU DATA");
        System.out.println(icu);
    }
    public static void printAllIcus(){
        Prompt.showTitle("PRINTING ALL ICUS");
        for(ICU icu : ICUManage.getIcus())
            System.out.println(icu);
    }
    private static <T,V> String[][] mapToArr(HashMap<T,V> map){
        String[][] arr = new String[map.size()][2];
        Set<Map.Entry<T,V>> entries = map.entrySet();
        Iterator<Map.Entry<T,V>> entriesIterator = entries.iterator();
        for(int i = 0; entriesIterator.hasNext();i++){
            Map.Entry<T,V> mapping = (Map.Entry<T,V>) entriesIterator.next();
            arr[i][0] = mapping.getKey().toString();
            arr[i][1] = mapping.getValue().toString();
        }
        return arr;
    }
    private static void printData (String[][] toPrint){
        for (int i = 0; i < toPrint.length; i++) {
            System.out.printf("%-40s %40s %n ",toPrint[i][0],toPrint[i][1]);
        }
    }

    private static void printPerson(Person person) {
        Prompt.printDashline();
        System.out.printf("%-15s %15s %n", "Attributes", "values");
        Prompt.printDashline();
        System.out.println();
        for (int i = 0; i < person.getAttributes().length; i++) {
            System.out.printf("%-15s %15s %n ", person.getAttributesNames()[i], person.getAttributes()[i]);
        }
    }

    // private static String putNewLine(int i , String[] array){
    // return (i == array.length-1) ? "" : "%n" ;
    // }
    public static void printDoctor(String name) {
        Doctor doctor = (Doctor) NetworkManage.getDoctor(name);
        if (doctor != null) {
            Prompt.showTitle("  PRINTING DOCTOR'S INFORMATION  ");
            System.out.printf("%-15s %15s %n", "Attributes", "values");
            Prompt.printDashline();
            for (int i = 0; i < doctor.getAttributes().length; i++) {
                System.out.printf("%-15s %15s %n ", doctor.getAttributesNames()[i], doctor.getAttributes()[i]);
            }
            Prompt.printDashline();
            Prompt.showTitle("TREATMENT INFORMATION ");
            System.out.printf("%-15s %15s %n", "Patient Name", "WTH");
            for (Patient patient : doctor.getPatientList()) {
                TreatmentData treatmentData = doctor.getPatientsData().get(patient);
                System.out.printf("%-15s %15s %n", patient.getName(), String.valueOf(treatmentData.getWTH()));
            }
        } else {
            Prompt.printDashline();
            System.out.println(" Doctor not found, Please check the name and try again !!! ");
            Prompt.printDashline();
        }
    }

    public static void printAllDoctors() {
        List<Doctor> doctors = NetworkManage.getDoctors();
        Prompt.showTitle("PRINTING ALL DOCTORS");
        for (Doctor doctor : doctors) {
            System.out.printf("%-15s %15s %n", doctor.getName(), doctor.getMSA());
        }
        Prompt.printDashline();
    }

    public static void printTheStorage() {
        List<SystemMedication> medications = StoreManage.getMedicationStorage();
        Prompt.showTitle("PRINTING ALL STORAGE MEDICATIN'S INFORMATION ");
        for (SystemMedication s : medications) {
            System.out.printf("%-15s %15s %n", s.getName(), String.valueOf(s.getQuantity()));
        }
        Prompt.printDashline();
    }

    public static void printTreatmentData(String pname, String dname) {
        Doctor doctor = (Doctor) NetworkManage.getDoctor(dname);
        Patient patient = (Patient) NetworkManage.getPatient(pname);
        if ((doctor != null) && (patient != null)) {
            if (NetworkManage.hasTreatmentData(patient, doctor)) {
                Prompt.showTitle("PRINTING TREATMENT INFORMATION ");
                TreatmentData treatmentData = doctor.getTreatmentData(patient);
                System.out.println(
                        "treatment data between patient " + patient.getName() + " and doctor " + doctor.getName());
                System.out.println("the weekly treatment hours = " + treatmentData.getWTH());
                Prompt.printDashline();
                System.out.println("PRINTING ALL PRESCRIPTIONS");
                printAllPrescriptions(treatmentData);
                Prompt.printDashline();
            } else {
                System.out.println("there aren't treatment date between patient " + patient.getName() + " and doctor "
                        + doctor.getName());
            }
        } else {
            System.out.println(" Patient or/and Doctor are not found ,please check names and try again !!!");
        }

    }

    private static void printAllPrescriptions(TreatmentData treatmentData) {
        List<Prescription> prescriptions = treatmentData.getPrescriptions();
        int i = 1;
        for (Prescription prescription : prescriptions) {
            System.out.println("PRINT PRESCRIPTION NUMBER " + i);
            printPrescription(prescription);
            i++;
        }
    }

    private static void printPrescription(Prescription prescription) {
        System.out.printf("%-15s %15s %n", "Date", "Duration");
        System.out.printf("%-15s %15s %n", prescription.getDate(), prescription.getDuration());
        List<Medication> medications = prescription.getMedications();
        printPRMedications(medications);
    }

    private static void printmedication(Medication medication) {
        System.out.printf("%-20s %13s %13s %13s %n", medication.getName(), String.valueOf(medication.getDailyDose()),
                String.valueOf(medication.getWeeklyDose()), String.valueOf(medication.getDoseValue()));
    }

    private static void printPRMedications(List<Medication> medications) {
        System.out.println("LIST OF MEDICATIONS");
        System.out.printf("%-20s %13s %13s %13s %n", "name", "Daily dose", "Weekly dose", "Dose value");
        for (Medication medication : medications) {
            printmedication(medication);
        }
    }
}
