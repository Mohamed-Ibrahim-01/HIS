package src.management;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import src.fileoperations.Read;
import src.models.SystemMedication;

public class StoreManage {

    public static HashSet<UUID> storageids;
    public static HashMap<String,SystemMedication> medicationStorage ;
    private static List<SystemMedication> MedicationStorage ;
    public static void loadData() {
        storageids = new HashSet<UUID>();
        medicationStorage = new HashMap<String,SystemMedication>();
        MedicationStorage = Read.readMedicationStorage();
        for (SystemMedication m : MedicationStorage) {
            storageids.add(m.getId());
            medicationStorage.put(m.getName(), m);
        }
    }

    public static List<SystemMedication> getMedicationStorage() {
        return MedicationStorage;
    }

    public static void setMedicationStorage(List<SystemMedication> medicationStorage) {
        MedicationStorage = medicationStorage;
    }
}
