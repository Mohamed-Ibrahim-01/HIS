package src.system;
import src.models.*;
import src.fileoperations.*;
import java.util.List;
public class System1 {
    public static void main(String[] args){
        List<Patient> patients = Read.readPatients();
        for(Patient d : patients){
            System.out.println(d);
        }
    }
}
