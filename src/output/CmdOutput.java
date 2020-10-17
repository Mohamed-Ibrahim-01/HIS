package src.output;

import src.models.*;
import src.management.*;

public class CmdOutput {

    private static void printPerson(Person person) {
        Prompt.printDashline();
        System.out.printf("%-15s %15s %n", "Attributes", "values");
        Prompt.printDashline();
        System.out.println();
        for (int i = 0 ; i< person.getAttributes().length ; i++ ){
            System.out.printf("%-15s %15s " + putNewLine(i,person.getAttributes()),person.getAttributesNames()[i],person.getAttributes()[i]);
        }
    }
    private static String putNewLine(int i , String[] array){
        return (i ==  array.length-1) ? "" : "%n" ;
    }
    public static void printDoctor(String name){
        Doctor doctor = (Doctor) NetworkManage.getDoctor(name);
        Prompt.showTitle("  PRINTING DOCTOR'S INFORMATION  ");
        printPerson(doctor);
        

        
    }

}
