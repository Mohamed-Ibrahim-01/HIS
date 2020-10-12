package src.fileoperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.UUID;

import src.input.CmdInput;
import src.management.NetworkManage;
import src.management.StoreManage;
import src.models.Doctor;
import src.models.ICU;
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
import src.management.*;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Write {
    private static final String slash = File.separator;
    private static CmdInput input = new CmdInput();

    private static UUID genretaUuid() {
        UUID id;
        do {
            id = UUID.randomUUID();
        } while (System1.Ids.contains(id));
        System1.Ids.add(id);
        return id;
    }

    private static boolean createFolder(String path, String name) {
        File Folder = new File(path + slash + name);
        return Folder.mkdir();
    }

    private static boolean creatFile(String path, String name) {
        boolean result = false;
        try {
            File file = new File(path + slash + name);
            result = file.createNewFile();
        } catch (Exception e) {
            System.out.println("Exception has been occured !!");
        }
        return result;
    }

    private static boolean writeInFile(String filePath, String strToWrite) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
            bw.write(strToWrite);
            bw.flush();
            bw.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void updateStorageFile(String path, String[] medData) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));
            String line = br.readLine();
            String[] linearray;
            String stream = "";
            int q = 0;
            while (line != null) {
                linearray = Read.readCSVLine(line);
                if (line.contains(medData[1])) {
                    q = Integer.parseInt(linearray[2]);
                    q += Integer.parseInt(medData[2]);
                    linearray[2] = String.valueOf(q);
                    stream += (arrToCSV(linearray) + System.lineSeparator());
                } else {
                    stream += (line + System.lineSeparator());
                }
            }
            bw.write(stream);
        } catch (Exception e) {
            System.out.println("Exception has been occured");
        }
    }

    private static void updateCSVLine(String path, String keyword, int[] columns, String... newValues) {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(path)));
                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));) {

            String line = br.readLine();
            String[] linearray;
            String stream = "";
            while (line != null) {
                linearray = Read.readCSVLine(line);
                if (line.contains(keyword)) {
                    for (int i = 0; i < columns.length; i++) {
                        linearray[columns[i]] = newValues[i];
                    }
                    stream += (arrToCSV(linearray) + System.lineSeparator());
                } else
                    stream += (line + System.lineSeparator());
            }
            bw.write(stream);
        } catch (Exception e) {
            System.out.println("Exception has been occured");
        }
    }

    private static String arrToCSV(String[] arr) {
        String CSVLine = "";
        for (String str : arr) {
            if (str.contains(","))
                CSVLine += ",\"" + str + "\"";
            else
                CSVLine += "," + str;
        }
        CSVLine = CSVLine.substring(1);
        return CSVLine;
    }

    private static String currentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");
        return formatter.format(new Date());
    }

    private static void addPatientToIcus(Patient patient) {
        ICUManage.addPatient(patient);
        ICU patientIcu = ICUManage.getICU(patient.getICUname());
        int[] columns = { 4 };
        String icusDataPath = "." + slash + "data" + slash + "icu";
        String icusPath = icusDataPath + slash + "ICUs.csv", newBedsNum = String.valueOf(patientIcu.getBusyBeds());
        String patientBed = patient.getId().toString() + "," + patient.getBedNumber();
        updateCSVLine(icusPath, patientIcu.getName(), columns, newBedsNum);
        File icuFolder = new File(icusDataPath + slash + patientIcu.getName());
        if (icuFolder.exists()) {
            writeInFile(icuFolder.getAbsolutePath() + slash + "ps.csv", patientBed);
        } else {
            try {
                File patientsFile = new File(icuFolder.getAbsolutePath() + slash + "ps.csv");
                patientsFile.createNewFile();
                writeInFile(icuFolder.getAbsolutePath() + slash + "ps.csv", patientBed);
            } catch (Exception e) {
            }
        }

    }

    public static Patient addNewPatient() throws Exception {
        String[] patientData = input.getPatientInput(), ICUData = ICUManage.getEmptyBed();
        String patientDataPath = "." + slash + "data" + slash + "patientsdata";
        patientData[0] = genretaUuid().toString();
        patientData[7] = ICUData[0];
        patientData[8] = currentDate();
        patientData[9] = ICUData[1];
        Patient patient = new Patient(patientData);
        addPatientToIcus(patient);
        addMedicalHistory(patient);
        addMedicalStatus(patient);
        createFolder(patientDataPath, patient.getId().toString());
        writeInFile(patientDataPath, arrToCSV(patientData));
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

    public static void addMedicalStatus(Patient patient) {

    }

    public static Doctor addNewDoctor() throws Exception {
        return null;
    }

    public static void addSystemMedication() {
        String path = "." + slash + "data" + slash + "storage" + slash + "medcationStorage.csv";
        String[] medData = input.getSysMedInput();
        if (ValidInput.isExistSysMed(medData[1])) {
            updateExistedSysMed(path, medData);
        } else {
            addNewSysMed(path, medData);
        }
    }

    public static void addTreatmentData() {
        String[] info = input.getTdinfo();
        Patient patient = (Patient) NetworkManage.PersonsNames.get(info[0]);
        Doctor doctor = (Doctor) NetworkManage.PersonsNames.get(info[1]);
        String path = "." + slash + "data" + slash + "treatmentdata";
        if (NetworkManage.hasTreatmentData(patient, doctor)) {
            updateTreatmentData(path, patient, doctor);
        } else {
            addNewTreatmentData(path, patient, doctor);
        }
    }

    private static void updateTreatmentData(String path, Patient patient, Doctor doctor) {
        Prompt.hasRelationship(patient, doctor);
        String tdFolderPath = path + patient.getId().toString() + "_" + doctor.getId().toString();
        try {
            if (CmdInput.getchoose()) {
                updateWTH(tdFolderPath, patient, doctor);
            } else {
                Prompt.headerOfPrescription(patient, doctor);
                do {
                    addNewPrescription(tdFolderPath, patient, doctor);
                } while (CmdInput.morePR());
            }
            Prompt.endOfUpdatingTD();
        } catch (Exception e) {
            System.out.println("Exception has been occured !!");
        }
    }

    private static void addNewTreatmentData(String path, Patient patient, Doctor doctor) {
        Prompt.hasNotRelationship(patient, doctor);
        String tdFolderPath = path + patient.getId().toString() + "_" + doctor.getId().toString();
        createFolder(tdFolderPath, "");
        creatFile(tdFolderPath, "td.csv");
        creatFile(tdFolderPath, "pr.csv");
        String tdpath = tdFolderPath + slash + "td.csv";
        String prpath = tdFolderPath + slash + "pr.csv";
        TreatmentData treatmentData = new TreatmentData();
        treatmentData.setDoctorId(doctor.getId());
        treatmentData.setPatientId(patient.getId());
        NetworkManage.addTreatmentData(patient, doctor, treatmentData);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(tdpath)));
            Prompt.showTitle(" treatmentdata information ");
            String[] data = new String[3];
            data[0] = patient.getId().toString();
            data[1] = doctor.getId().toString();
            data[2] = CmdInput.addNewWTH();
            bw.write(arrToCSV(data));
            treatmentData.setHoursPerWeekPerPatient(Double.parseDouble(data[2]));
            Prompt.showTitle("Patient id , Doctor id and WTH have been added");
            Prompt.headerOfPrescription(patient, doctor);
            do {
                addNewPrescription(tdFolderPath, patient, doctor);
            } while (CmdInput.morePR());
            Prompt.endOfAddingNewTD();
        } catch (Exception w) {
            System.out.println("Exception occured ! ");
        }
    }

    private static void updateExistedSysMed(String path, String[] medData) {
        Prompt.addedExistedSysMed();
        StoreManage.medicationStorage.get(medData[1]).addQuantity(medData[2]);
        updateStorageFile(path, medData);
    }

    private static void addNewSysMed(String path, String[] medData) {
        UUID id = genretaUuid();
        medData[0] = id.toString();
        SystemMedication newmed = new SystemMedication(medData);
        StoreManage.medicationStorage.put(newmed.getName(), newmed);
        StoreManage.storageid.add(id);
        writeInFile(path, arrToCSV(medData));
    }

    private static void updateWTH(String tdfolderpath, Patient patient, Doctor doctor) throws Exception {
        String tdpath = tdfolderpath + slash + "td.csv";
        int[] columns = { 2 };
        String WTH = CmdInput.updatewth();
        updateCSVLine(tdpath, patient.getId().toString() + "," + doctor.getId().toString(), columns, WTH);
        doctor.getTreatmentData(patient).setHoursPerWeekPerPatient(Double.parseDouble(WTH));
    }

    private static void addNewPrescription(String tdfolderpath, Patient patient, Doctor doctor) {
        String[] prInput = input.getPRInput();
        Prescription prescription;
        List<Medication> medications = new ArrayList<Medication>();
        String prpath = tdfolderpath + slash + "pr.csv";
        String line = "";
        int prnum = 0;
        BufferedReader br;
        BufferedWriter bWriter, bw;
        try {
            br = new BufferedReader(new FileReader(new File(prpath)));
            bWriter = new BufferedWriter(new FileWriter(new File(prpath), true));
            line = br.readLine();
            while (line != null) {
                prnum++;
            }
            prInput[0] = String.valueOf(prnum + 1);
            bWriter.write(arrToCSV(prInput));
            creatFile(tdfolderpath, "md" + prInput[0] + ".csv");
            bw = new BufferedWriter(new FileWriter(new File(tdfolderpath + slash + "md" + prInput[0] + ".csv"), true));
            do {
                medications.add(addNewMed(patient, bw));
            } while (CmdInput.moreMed());
        } catch (Exception e) {
            System.out.println("Excepton occured");
        }
        prescription = new Prescription(medications, prInput);
        prescription.setDoctor(doctor);
        prescription.setPatient(patient);
        doctor.getTreatmentData(patient).getPrescriptions().add(prescription);
    }

    private static Medication addNewMed(Patient patient, BufferedWriter bw) throws Exception {
        String[] data = input.getMedInput();
        Medication medication = new Medication(data);
        patient.getMedications().add(medication);
        bw.write(arrToCSV(data));
        return medication;
    }
}
