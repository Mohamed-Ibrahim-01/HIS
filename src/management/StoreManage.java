package src.management;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import src.fileoperations.Read;
import src.models.SystemMedication;

public class StoreManage {

    public static List<SystemMedication> MedicationStorage;
    public static HashSet<UUID> storageid;
    public static HashSet<String> storageName;

    public static void loadData() {
        MedicationStorage = Read.readMedicationStorage();
        for (SystemMedication m : MedicationStorage) {
            storageid.add(m.getId());
            storageName.add(m.getName());
        }
    }
}
