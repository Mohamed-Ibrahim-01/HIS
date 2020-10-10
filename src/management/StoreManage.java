package src.management;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import src.fileoperations.Read;
import src.models.SystemMedication;

public class StoreManage {

    public static HashSet<UUID> storageid;
    public static HashMap<String,SystemMedication> medicationStorage ;

    public static void loadData() {
        List<SystemMedication> MedicationStorage = Read.readMedicationStorage();
        for (SystemMedication m : MedicationStorage) {
            storageid.add(m.getId());
            medicationStorage.put(m.getName(), m);
        }
    }
}
