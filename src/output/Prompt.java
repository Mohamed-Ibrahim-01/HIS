package src.output;

import src.models.Doctor;
import src.models.Patient;

public class Prompt {
    public static void addedExistedSysMed() {
        System.out.println("Ooops!! this drug is already in the store \nadditional quantity will be added.");
    }

    public static void printDashline() {
        String dashLine = "--------------------------------------------------------------------";
        System.out.println(dashLine);
    }

    public static void showTitle(String title) {
        System.out.println("====================================================================");
        System.out.println("                           " + title + "                            ");
        System.out.println("====================================================================");
    }

    public static void askToInput(String toInput) {
        System.out.print("Please,Enter " + toInput + " : ");
    }
    public static void askToInputInForm(String toInput,String form) {
        System.out.print("Please,Enter " + toInput + "in form " + "[ " + form + " ]" + " : ");
    }

    public static void askToNeed(String toNeed){
        System.out.print("Do you want to " + toNeed + "?" +" [1 -> YES, 0 -> NO] : ");
    }

    public static void hasRelationship(Patient patient, Doctor doctor) {
        System.out.println(
                "there is a treatment Data between patient " + patient.getName() + " and doctor " + doctor.getName());
    }

    public static void wthorNewPR() {
        System.out.println(
                "Do you want to update WTH or add new prescription ? \n to update WTH press 1 \n to add new prescription press 2 ");
    }

    public static void headerOfPrescription(Patient patient, Doctor doctor) {
        System.out.println(
                " priscriptions will be added by doctor / " + doctor.getName() + " to patient / " + patient.getName());
    }

    public static void takeChoose() {
        System.out.println("Do you want to add anther medication ? \" press 1 to add or press 2 to exit \" ");
    }

    public static void AnotherPR() {
        System.out.println("Do you want to add anther prescription ? \" press 1 to add or press 2 to exit \" ");
    }

    public static void hasNotRelationship(Patient patient, Doctor doctor) {
        System.out.println("new treatment data between " + patient.getName() + " and doctor " + doctor.getName()
                + " will be created");
    }

    public static void endOfAddingNewTD() {
        System.out.println("new treatmnt data has been addded successfuly");
    }

    public static void endOfUpdatingTD() {
        System.out.println("treatmnt data has been updated successfuly");
    }
}
