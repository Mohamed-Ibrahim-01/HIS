package src.system;

import java.util.HashSet;
import java.util.UUID;
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
}
