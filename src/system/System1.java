package src.system;

import java.io.File;
import java.util.HashSet;
import java.util.UUID;

import src.fileoperations.Write;
import src.management.ICUManage;
import src.management.NetworkManage;
import src.management.StoreManage;

public class System1 {
    public static HashSet<UUID> Ids = new HashSet<UUID>();

    public static void loadAllData() {
        NetworkManage.loadData();
        ICUManage.loadData();
        StoreManage.loadData();
    }
    public static void main(String[] args){
      loadAllData();
      Write.addNewPatient();
        //System.out.println( ICUManage.getICU("A1"));
        //System.out.println(ICUManage.getEmptyBed()[1]);
    }
}
