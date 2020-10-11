package src.output;

import src.models.Doctor;
import src.models.Patient;

public class Prompt {
    public static void addedExistedSysMed() {
        System.out.println("Ooops!! this drug is already in the store \nadditional quantity will be added.");
    }

    public static void printDashline() {
        String dashLine =  "--------------------------------------------------------------------";
        System.out.println(dashLine);
    }
    public static void showTitle(String title){
        System.out.println("====================================================================");
        System.out.println("                           "+title+"                                ");
        System.out.println("====================================================================");
    }
    public static void askToInput(String toInput){
        System.out.println("Please,Enter "+toInput+" : ");
    }
    public static void hasRelationship(Patient patient ,Doctor doctor){
        System.out.println("there is a treatment Data between patient "+patient.getName()+" and doctor "+doctor.getName());
    }
    public static void wthorNewPR(){
        System.out.println("Do you want to update WTH or add new prescription ? \n to update WTH press 1 \n to add new prescription press 2 ");
    }
}
