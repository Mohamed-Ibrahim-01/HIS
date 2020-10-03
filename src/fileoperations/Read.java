package src.fileoperations;
import src.models.*;
import java.io.BufferedReader;
import java.io.File;
import java.util.Arrays;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import src.system.ICU;
import src.system.SystemMedication;

public class Read {
private static BufferedReader br ;
    public static List<Patient> readPatients(){
       return null;
    }
    public static List<Doctor> readDoctors(){
       return null;
    }
    public static List<ICU> readICUs(){
       return null;
    }
    public static List<SystemMedication> readMedicationStorage(){
        return null;
    }
    public static List<TreatmentData> readTreatmentData(){
        return null;
    }
    private static Patient createPatient(){
       return null;
    }
    private static Doctor createDoctor(){
       return null;
    }
    private static String[] getTrestmentData(String tdPath){
       return null ; 
    }
    private static String[] getMd(String mdPath){  
         br = new BufferedReader(new FileReader(new File(mdPath)));

         return null ; 
    }   
    private static String[] getPr(String prPath){
      return null ; 
    }   
    private static TreatmentData creatTreatmentData(String treatmentDataObjectPath){
      return null ; 
    }   
    private static String[] readCSVLine(String line){
      String[] splitedLine = line.split(",");
      List<String> lineAttributes = new LinkedList<String>();
      Collections.addAll(lineAttributes, splitedLine);
      for(int i = 0; i < lineAttributes.size(); i++){
         String curr = lineAttributes.get(i);
         if(curr.startsWith("\"")){
            String next = lineAttributes.get(i+1);
            curr = (curr +","+ next).replace("\"", "");
            lineAttributes.set(i,curr);
            lineAttributes.remove(next);
         }
      }
      return lineAttributes.toArray(new String[lineAttributes.size()]);
   }
 
}
