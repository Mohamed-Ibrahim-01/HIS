package src.output;

import src.models.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Date;
import java.util.Iterator;
import src.management.*;

public class CmdOutput {
    public static void printPatient(String name){
        Patient patient = NetworkManage.getPatient(name);
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
        Prompt.showTitle("  PRINTING PATIENT'S MEDICAL HISTORY");
        String[] mapNames = {"Hospitalizations","ChronicDiseases","Diseases","Medications"};
        for(HashMap<String,Date> map : patient.getMedicalHistory().getPatientMH().getHistory()){
            int i = 0;
            System.out.printf("%60s",mapNames[i]);
            printData(mapToArr(map)); 
        }
    }
    public static void printIcu(String name){
        ICU icu = ICUManage.getICU(name);
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
                System.out.printf("%-15s %15s %n",patient.getName(),String.valueOf(treatmentData.getWTH()));
            }
        } else {
            Prompt.printDashline();
            System.out.println(" Doctor not found, Please check the name and search again !!! ");
            Prompt.printDashline();
        }
    }
}
