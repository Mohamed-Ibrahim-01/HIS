package src.output;

import src.models.*;
import src.management.*;

public class CmdOutput {
    public static void printPatient(String name){
        Patient patient = NetworkManage.getPatient(name);
        Prompt.showTitle("  PRINTING PATIENT'S INFORMATION  ");
        printPerson(patient);
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
