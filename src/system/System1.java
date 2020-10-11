package src.system;

import src.fileoperations.*;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import src.fileoperations.Read;
import src.management.ICUManage;
import src.management.NetworkManage;
import src.management.StoreManage;
import src.models.ICU;

public class System1 {
    public static HashSet<UUID> Ids = new HashSet<UUID>();

    public static void loadAllData() {
        NetworkManage.loadData();
        ICUManage.loadData();
        StoreManage.loadData();
    }
}
