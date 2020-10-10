package src.fileoperations;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.Date;
import src.input.CmdInput;
import src.management.*;
import src.system.System1;
import src.models.*;

public class Write {
    private static final String slash = File.separator;
    private static CmdInput input = new CmdInput();
    public static Patient addNewPatient() throws Exception {
        UUID id;
        do {
            id = UUID.randomUUID();
        } while (NetworkManage.Ids().contains(id));
        addMedicalStatus(id);
        return null;
    }

    public static MedicalHistory addMedicalHistory(UUID id) throws Exception {
        addFamilyMH(id);
        addPersonMH(id);
        return null;
    }

    public static PersonMH addPersonMH(UUID id) throws Exception {

        return null;
    }

    public static FamilyMH addFamilyMH(UUID id) throws Exception {

        return null;
    }

    public static HashMap<String, Date> addPmhMap() {
        return null;
    }

    public static MedicalStatus addMedicalStatus(UUID id) throws Exception {

        return null;
    }

    public static Doctor addNewDoctor() throws Exception {
        return null;
    }

    public static void addNewSystemMedication() {
     String [] medData = input.getSysMedInput();
        
     
     
     UUID id;
        do {
            id = UUID.randomUUID();
        } while (StoreManage.storageid.contains(id));
        medData[0] = id.toString();
        SystemMedication newmed = new SystemMedication(medData);
        StoreManage.MedicationStorage.add(newmed);
        StoreManage.storageid.add(id);
       
    }

    public static TreatmentData addNewTreatmentData() {
        return null;
    }

    public static void addTDFile(UUID patientID, UUID doctorID, double WTH) {
    }

    public static Prescription addNewPrescription() {
        return null;
    }

    public static List<Medication> addPrMedications() {
        return null;
    }
}
