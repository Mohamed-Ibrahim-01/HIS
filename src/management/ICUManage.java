package src.management;

import java.util.HashMap;
import java.util.List;

import src.fileoperations.Read;
import src.models.ICU;
import src.models.Patient;

public class ICUManage {
    public static HashMap<String,ICU> icus ;
    public static void loadData(){
        icus = new HashMap<String,ICU>();
        List<ICU> icusList = Read.readICUs();
        for(ICU icu : icusList){
            icus.put(icu.getName(), icu);
        }
    }
    public static String[] getEmptyBed(){
        String[] bedData = new String[2]; 
        for(String icuName : icus.keySet()){
            ICU icu = icus.get(icuName);
            if(!icu.isFull()){
                bedData[0] = icu.getName();
                bedData[1] = String.valueOf(icu.nextFreeBed());
                return bedData;
            }
        }
        return bedData;
    }
    public static void addPatient(Patient patient){
        icus.get(patient.getICUname()).addPatient(patient.getId().toString(),patient.getBedNumber());
    }
    public static ICU getICU(String icuName){
        return icus.get(icuName);
    }
}
