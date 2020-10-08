package src.system;

import src.models.*;
import src.fileoperations.*;
import java.util.List;

public class System1 {
    private static List<ICU> icus;
    private static List<SystemMedication> MedicationStorage;

    public static void loadAllData() {
        HospitalNetwork.loadData();
        icus = Read.readICUs();
        MedicationStorage = Read.readMedicationStorage();
    }
}
