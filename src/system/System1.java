package src.system;
import src.models.*;
import src.fileoperations.*;
import java.util.List;
public class System1 {
    public static void main(String[] args){
       try{
        List<TreatmentData> data = Read.readTreatmentData();
        for(TreatmentData d : data){
            System.out.println(d);
        }
    }
    catch(Exception e){
        System.out.println("Exception occured");
        e.printStackTrace();
    }
    }
}
