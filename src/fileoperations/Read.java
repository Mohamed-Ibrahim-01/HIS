package src.fileoperations;
import src.models.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import src.system.ICU;
import src.system.SystemMedication;

public class Read {
   private static String slash = File.pathSeparator;
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
    public static List<TreatmentData> readTreatmentData()throws Exception{
       String Path = ".."+slash+".."+slash+"data"+slash+"TreatmentData";
       File Folder = new File(Path);
       File[] folders = Folder.listFiles();
       List<TreatmentData> treatmentData = new ArrayList<TreatmentData>();
       for(File folder : folders){
          treatmentData.add(creatTreatmentData(folder.getCanonicalPath()));
       }
      return treatmentData;
    }
    private static Patient createPatient(){
       return null;
    }
    private static Doctor createDoctor(){
       return null;
    }
    private static String[] getTd(String path)throws Exception{
      br = new BufferedReader(new FileReader(new File(path+File.pathSeparator+"td.csv")));
      br.readLine();
      String line ;
      String[] lineArray = null;
         while ( (line = br.readLine()) != null){
            lineArray = readCSVLine(line);
         }
       return lineArray ; 
    }
    private static List<Medication> getMd(String mdPath) throws Exception{  
         br = new BufferedReader(new FileReader(new File(mdPath)));
         br.readLine();
         String line ;
         String[] lineArray ;
         List<Medication> medications = new ArrayList<Medication>();
            while( (line = br.readLine()) != null){
               lineArray = readCSVLine(line);
               medications.add(new Medication(lineArray));
         }         
         return medications ; 
    }   
    private static List<Prescription> getPr(String path) throws Exception{
         br = new BufferedReader(new FileReader(new File(path+File.pathSeparator+"pr.csv")));
         br.readLine();
         String line ;
         String[] lineArray ;
         List<Prescription> prescriptions = new ArrayList<Prescription>();
               while ( (line = br.readLine()) != null){
                  lineArray = readCSVLine(line);
                 List<Medication> medications =  getMd(path+File.pathSeparator+"md"+lineArray[0]+".csv");
                 prescriptions.add(new Prescription(medications,lineArray));
               }     
      return prescriptions ; 
    }   
    private static TreatmentData creatTreatmentData(String path)throws Exception{
      TreatmentData treatmentData =  new TreatmentData(getTd(path),getPr(path)); 
      return treatmentData ; 
   }   
   private static String[] readCSVLine(String line){
      String[] arr = line.split(",");      
      return arr; 
   }
 
}
