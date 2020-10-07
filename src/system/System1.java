package src.system;
import src.models.*;
import src.fileoperations.*;
import java.util.List;
public class System1 {
    public static void main(String[] args){
        List<Doctor> doctors = Read.readDoctors();
        for(Doctor d : doctors){
            System.out.println(d);
        }
    }
}
