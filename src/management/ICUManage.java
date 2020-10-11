package src.management;

import java.util.List;

import src.fileoperations.Read;
import src.models.ICU;

public class ICUManage {
    public static List<ICU> icus;

    public static void loadData(){
        icus = Read.readICUs();
    }
    public static String[] getEmptyBed(){
        String[] bedData = new String[2]; 
        for(ICU icu : icus){
            if(!icu.isFull()){
                bedData[0] = icu.getName();
                bedData[1] = String.valueOf(icu.nextFreeBed());
                return bedData;
            }
        }
        return null;
    }
}
