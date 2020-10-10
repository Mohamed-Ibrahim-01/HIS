package src.fileoperations;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import src.input.CmdInput;
import src.management.NetworkManage;
import src.management.StoreManage;
import src.models.Doctor;
import src.models.FamilyMH;
import src.models.MedicalHistory;
import src.models.MedicalStatus;
import src.models.Medication;
import src.models.Patient;
import src.models.PersonMH;
import src.models.Prescription;
import src.models.SystemMedication;
import src.models.TreatmentData;
import src.output.Prompt;
import src.validation.ValidInput;

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

    public static void addSystemMedication() {
        String[] medData = input.getSysMedInput();
        if (ValidInput.isExistSysMed(medData[1])) {
            updateExistedSysMed(medData);
        } else {
            addNewSysMed(medData);
        }
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

    private static void updateExistedSysMed(String[] medData) {
        Prompt.addedExistedSysMed();
        StoreManage.medicationStorage.get(medData[1]).addQuantity(medData[2]);
    }

    private static void addNewSysMed(String[] medData) {
        UUID id;
        do {
            id = UUID.randomUUID();
        } while (StoreManage.storageid.contains(id));
        medData[0] = id.toString();
        SystemMedication newmed = new SystemMedication(medData);
        StoreManage.medicationStorage.put(newmed.getName(), newmed);
        StoreManage.storageid.add(id);
    }
}
