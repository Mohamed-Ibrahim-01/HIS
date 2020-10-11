package src.fileoperations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import src.input.CmdInput;
import src.management.ICUManage;
import src.management.NetworkManage;
import src.management.StoreManage;
import src.models.Doctor;
import src.models.MedicalHistory;
import src.models.Medication;
import src.models.Patient;
import src.models.PersonMH;
import src.models.Prescription;
import src.models.SystemMedication;
import src.models.TreatmentData;
import src.output.Prompt;
import src.system.System1;
import src.validation.ValidInput;

public class Write {
    private static final String slash = File.separator;
    private static CmdInput input = new CmdInput();

    private static UUID genretaUuid(){
        UUID id;
        do {
            id = UUID.randomUUID();
        } while (System1.Ids.contains(id));
        System1.Ids.add(id);
        return id;
    }
    private static boolean createFolder(String path,String name){
        File Folder = new File(path + slash + name);
        return Folder.mkdir();
    }
    private static boolean writeInFile(String filePath,String strToWrite){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath,true));
            bw.write(strToWrite);
            bw.flush(); bw.close();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    private static String arrToCSV(String[] arr){
        String CSVLine = "";
        for(String str : arr){
            if(str.contains(",")) CSVLine += ",\"" + str + "\"";
            else CSVLine += "," + str;
        }
        CSVLine = CSVLine.substring(1);
        return CSVLine;
        }
    private static String currentDate(){
        SimpleDateFormat formatter= new SimpleDateFormat("dd/mm/yyyy");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
    private static boolean replaceLineInFile(){
        return false;
    }
    private static void addPatientToIcu(Patient patient){
        String patientData = patient.getId().toString() + ","+ patient.getBedNumber();
        String IcusDataPath = "."+slash+"icu";
        writeInFile(IcusDataPath + slash + "ICUs.csv", patientData);
    }
    public static Patient addNewPatient() throws Exception {
        String[] patientData = input.getPatientInput(), ICUData;
        String patientDataPath = "."+slash+"data"+slash+"patientsdata";
        String ICUDataPath = "."+slash+"data"+slash+"icu";
        //TODO: Check if (ICUData) if null
        ICUData = ICUManage.getEmptyBed();
        patientData[0] = genretaUuid().toString();
        patientData[7] = currentDate();
        patientData[8] = ICUData[0];
        patientData[9] = ICUData[1];
        Patient patient = new Patient(patientData);
        writeInFile(patientDataPath,arrToCSV(patientData));
        addPatientToIcu(patient);
        addMedicalHistory(patient);
        addMedicalStatus(patient);
        createFolder(patientDataPath, patient.getId().toString());
        NetworkManage.addPatient(patient);
        return null;
    }

    public static void addMedicalHistory(Patient patient) throws Exception {

    }

    public static void addPersonMH(MedicalHistory medicalHistory) {

    }

    public static void addFamilyMH(MedicalHistory medicalHistory) {

    }

    public static void addPmhMap(PersonMH personMH) {
    }

    public static void addMedicalStatus(Patient patient){

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
