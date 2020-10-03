package src.fileoperations;
import src.models.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import src.system.ICU;
import src.system.SystemMedication;

public class Read {
   private static String slash = File.pathSeparator;
    public static List<Patient> readPatients(){
       return null;
    }
    public static List<Doctor> readDoctors(){
       String slash = File.pathSeparator;
       String doctorsDataPath = ".."+slash+".."+slash+"data"+slash+"d";
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
      BufferedReader br ; 
      br = new BufferedReader(new FileReader(new File(path+File.pathSeparator+"td.csv")));
      br.readLine();
      String line ;
      String[] lineArray = null;
         while ( (line = br.readLine()) != null){
            lineArray = readCSVLine(line);
         }
         br.close();
       return lineArray ; 
    }

    private static List<Medication> getMd(String mdPath) throws Exception{  
         BufferedReader br ;
         br = new BufferedReader(new FileReader(new File(mdPath)));
         br.readLine();
         String line ;
         String[] lineArray ;
         List<Medication> medications = new ArrayList<Medication>();
            while( (line = br.readLine()) != null){
               lineArray = readCSVLine(line);
               medications.add(new Medication(lineArray));
         }         
         br.close();
         return medications ; 
    }   

    private static List<Prescription> getPr(String path) throws Exception{
      BufferedReader br ;
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
      br.close();
      return prescriptions ; 
    }

    private static TreatmentData creatTreatmentData(String path)throws Exception{
     return  new TreatmentData(getTd(path),getPr(path)); 
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
