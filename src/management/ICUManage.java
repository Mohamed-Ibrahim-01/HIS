package src.management;

import java.util.List;

import src.fileoperations.Read;
import src.models.ICU;

public class ICUManage {
    public static List<ICU> icus;

    public static void loadData(){
        icus = Read.readICUs();
    }
}
