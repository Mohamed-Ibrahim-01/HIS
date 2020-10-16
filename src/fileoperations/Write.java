package src.fileoperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import src.input.*;
import src.management.NetworkManage;
import src.management.StoreManage;
import src.models.Doctor;
import src.models.ICU;
import src.models.MedicalHistory;
import src.models.MedicalStatus;
import src.models.Medication;
import src.models.Patient;
import src.models.PersonMH;
import src.models.Prescription;
import src.models.SystemMedication;
import src.models.TreatmentData;
import src.system.System1;
import src.validation.ValidInput;
import src.management.*;

public class Write {
    private static final String slash = File.separator;
    private static Input input = new CmdInput();
    private static String icusDataPath = "." + slash + "data" + slash + "icu";
    private static String patientDataPath = "." + slash + "data" + slash + "patientsdata";
    private static String doctorsDataPath = "." + slash + "data" + slash + "doctorsdata";

    private static UUID genretaUuid() {
        UUID id;
        do {
            id = UUID.randomUUID();
        } while (System1.Ids.contains(id));
        System1.Ids.add(id);
        return id;
    }

    private static String createFolder(String path, String name) {
        File Folder = new File(path + slash + name);
        Folder.mkdir();
        return path + slash + name;
    }

    private static String creatFile(String path, String name, String header) {
        try {
            File file = new File(path + slash + name);
            file.createNewFile();
            overWriteByHeader(file, header);
        } catch (Exception e) {
            System.out.println("Exception has been occured in mehod creat file !!");
        }
        return path + slash + name;
    }

    private static void overWriteByHeader(File file, String header) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));) {
            bw.write(header);
        } catch (Exception e) {
            System.out.println("Exception has occured in method overrite by header ");
        }
    }

    private static boolean writeInFile(String filePath, String strToWrite) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));) {
            strToWrite = System.lineSeparator() + strToWrite;
            bw.write(strToWrite);
            bw.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void updateCSVLine(String path, String keyword, int[] columns, String... newValues) {
        File file = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(file));) {
            String line = br.readLine(), next = br.readLine();
            StringBuffer stream = new StringBuffer();
            for (boolean last = false; (line != null); line = next, next = br.readLine()) {
                last = (next == null);
                if (line.contains(keyword)) {
                    String[] linearray = Read.readCSVLine(line);
                    for (int i = 0; i < columns.length; i++) {
                        linearray[columns[i]] = newValues[i];
                    }
                    stream.append(arrToCSV(linearray) + putSeparator(last));
                } else {
                    stream.append(line + putSeparator(last));
                }
            }
            FileWriter fr = new FileWriter(new File(path), false);
            fr.write(stream.toString());
            fr.close();
        } catch (Exception e) {
            System.out.println("Exception has been occured in updatecsvline");
            e.printStackTrace();
        }
    }

    private static String putSeparator(boolean last) {
        return last ? "" : System.lineSeparator();
    }

    private static String arrToCSV(String[] arr) {
        String CSVLine = "";
        for (String str : arr)
            CSVLine += (str.contains(",")) ? (",\"" + str + "\"") : ("," + str);
        CSVLine = CSVLine.substring(1);
        return CSVLine;
    }

    private static String currentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(new Date());
    }

    private static void addPatientToIcus(Patient patient) {
        ICUManage.addPatient(patient);
        ICU patientIcu = ICUManage.getICU(patient.getICUname());
        int[] columns = { 4 };
        String icusPath = icusDataPath + slash + "ICUs.csv", newBedsNum = String.valueOf(patientIcu.getBusyBeds());
        String patientBed = patient.getId().toString() + "," + patient.getBedNumber();
        updateCSVLine(icusPath, patientIcu.getName(), columns, newBedsNum);
        File icuFolder = new File(icusDataPath + slash + patientIcu.getName());
        String icuPatientsFilePath = icuFolder.getAbsolutePath() + slash + "ps.csv";
        if (!icuFolder.exists())
            creatFile(icuFolder.getAbsolutePath(), "ps.csv", "patientID,BedNumber");
        writeInFile(icuPatientsFilePath, patientBed);
    }

    public static Patient addNewPatient() {
        String[] patientData = input.getPatient(), ICUData = ICUManage.getEmptyBed();
        patientData[0] = genretaUuid().toString();
        patientData[8] = ICUData[0];
        patientData[7] = currentDate();
        patientData[9] = ICUData[1];
        patientData[10]= "0";
        Patient patient = new Patient(patientData);
        String patientFolder = createFolder(patientDataPath, patient.getId().toString());
        writeInFile(patientDataPath + slash + "patients.csv", arrToCSV(patientData));
        addPatientToIcus(patient);
        addMedicalStatus(patient, patientFolder);
        if (input.need("Medical History"))
            addMedicalHistory(patient);
        NetworkManage.addPatient(patient);
        return patient;
    }

    public static void addMedicalHistory(Patient patient) {
        MedicalHistory medicalHistory = new MedicalHistory(patient, null, null);
        String patientFolder = patientDataPath + slash + patient.getId().toString();
        addPersonMH(medicalHistory, patientFolder, "pmh.csv");
        if (input.need("FamilyMH"))
            addFamilyMH(medicalHistory, patientFolder);
    }

    public static void addPersonMH(MedicalHistory medicalHistory, String patientFolder, String fileName) {
        PersonMH patientMH = new PersonMH();
        String pmhFilePath = creatFile(patientFolder, fileName, "Patient Medical History");
        String[] mapNames = { "Chronic Disease", "Hospitalization", "Medication", "Disease" };
        for (String mapName : mapNames)
            addPmhMap(patientMH, mapName, pmhFilePath);
    }

    public static void addFamilyMH(MedicalHistory medicalHistory, String patientFolder) {
        String[] familyMembers = { "fmh.csv", "mmh.csv", "gmmh1.csv", "gfmh1.csv", "gmmh2.csv", "gfmh2.csv" };
        for (String member : familyMembers)
            addPersonMH(medicalHistory, patientFolder, member);
    }

    public static void addPmhMap(PersonMH patientMH, String mapName, String filePath) {
        String map = input.getMap(mapName);
        writeInFile(filePath, map);
        switch (mapName) {
            case "Chronic Disease":
                patientMH.setChronicDiseases(Read.getPmhMap(map.split(",")));
                break;
            case "Hospitalization":
                patientMH.setHospitalizations(Read.getPmhMap(map.split(",")));
                break;
            case "Medication":
                patientMH.setMedications(Read.getPmhMap(map.split(",")));
                break;
            case "Disease":
                patientMH.setDiseases(Read.getPmhMap(map.split(",")));
                break;
        }
    }

    public static void addMedicalStatus(Patient patient, String patientFolder) {
        String[] medicalStatusValues = input.getMedicalStatus();
        MedicalStatus medicalStatus = new MedicalStatus(medicalStatusValues);
        String medicalStatusFilePath = creatFile(patientFolder, "ms.csv", "Temprature,SysBP,DiaBP,HeartRate");
        writeInFile(medicalStatusFilePath, arrToCSV(medicalStatusValues));
        patient.setMedicalStatus(medicalStatus);
    }

    public static Doctor addNewDoctor() {
        String[] doctorData = input.getDoctor();
        doctorData[0] = genretaUuid().toString();
        Doctor doctor = new Doctor(doctorData);
        writeInFile(doctorsDataPath + slash + "Doctors.csv", arrToCSV(doctorData));
        NetworkManage.addDoctor(doctor);
        return doctor;
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
        Patient patient = (Patient) NetworkManage.getPatient(info[0]);
        Doctor doctor = (Doctor) NetworkManage.getDoctor(info[1]);
        String path = "." + slash + "data" + slash + "treatmentdata";
        if (NetworkManage.hasTreatmentData(patient, doctor))
            updateTreatmentData(path, patient, doctor);
        else
            addNewTreatmentData(path, patient, doctor);
    }

    private static void updateTreatmentData(String path, Patient patient, Doctor doctor) {
        // Prompt.hasRelationship(patient, doctor);
        String tdFolderPath = path + slash + patient.getId().toString() + "_" + doctor.getId().toString();
        try {
            if (input.need(" update WTH or add new prescription")) {
                updateWTH(tdFolderPath, patient, doctor);
            } else {
                // Prompt.headerOfPrescription(patient, doctor);
                do {
                    addNewPrescription(tdFolderPath, patient, doctor);
                } while (input.need(" add anther prescription"));
            }
            // Prompt.endOfUpdatingTD();
        } catch (Exception e) {
            System.out.println("Exception has been occured !!");
        }
    }

    private static void addNewTreatmentData(String path, Patient patient, Doctor doctor) {
        // Prompt.hasNotRelationship(patient, doctor);
        String folderName = patient.getId().toString() + "_" + doctor.getId().toString();
        String tdFolderPath = createFolder(path, folderName);
        String tdpath = creatFile(tdFolderPath, "td.csv", "PatientID,DoctorID,WTH");
        creatFile(tdFolderPath, "pr.csv", "PRnum,Date,Duration");
        // Prompt.showTitle(" treatmentdata information ");
        String[] data = new String[3];
        data[0] = patient.getId().toString();
        data[1] = doctor.getId().toString();
        data[2] = input.getWTH();
        writeInFile(tdpath, arrToCSV(data));
        TreatmentData treatmentData = new TreatmentData(data, new ArrayList<Prescription>());
        NetworkManage.addTreatmentData(patient, doctor, treatmentData);
        // Prompt.showTitle("Patient id , Doctor id and WTH have been added");
        // Prompt.headerOfPrescription(patient, doctor);
        do {
            addNewPrescription(tdFolderPath, patient, doctor);
        } while (input.need("add anther prescription"));
        // Prompt.endOfAddingNewTD();
    }

    private static void updateExistedSysMed(String path, String[] medData) {
        // Prompt.addedExistedSysMed();
        int[] columns = { 2 };
        SystemMedication systemMedication = StoreManage.medicationStorage.get(medData[1]);
        systemMedication.addQuantity(medData[2]);
        updateCSVLine(path, medData[1], columns, String.valueOf(systemMedication.getQuantity()));
    }

    private static void addNewSysMed(String path, String[] medData) {
        UUID id = genretaUuid();
        medData[0] = id.toString();
        SystemMedication newmed = new SystemMedication(medData);
        StoreManage.medicationStorage.put(newmed.getName(), newmed);
        StoreManage.storageids.add(id);
        writeInFile(path, arrToCSV(medData));
    }

    private static void updateWTH(String tdfolderpath, Patient patient, Doctor doctor) {
        String tdpath = tdfolderpath + slash + "td.csv";
        int[] columns = { 2 };
        String WTH = input.getWTH();
        updateCSVLine(tdpath, patient.getId().toString() + "," + doctor.getId().toString(), columns, WTH);
        doctor.getTreatmentData(patient).setHoursPerWeekPerPatient(Double.parseDouble(WTH));
    }

    private static void addNewPrescription(String tdfolderpath, Patient patient, Doctor doctor) {
        String[] prInput = input.getPRInput();
        Prescription prescription;
        List<Medication> medications = new ArrayList<Medication>();
        String prpath = tdfolderpath + slash + "pr.csv";
        prInput[0] = String.valueOf(getLinesNumber(prpath) + 1);
        writeInFile(prpath, arrToCSV(prInput));
        String mdpath = creatFile(tdfolderpath, "md" + prInput[0] + ".csv", "Name,DailyDose,DoseValue");
        do {
            medications.add(addNewMed(mdpath, patient));
        } while (input.need(" add another mediction"));
        prescription = new Prescription(medications, prInput);
        prescription.setDoctor(doctor);
        prescription.setPatient(patient);
        doctor.getTreatmentData(patient).getPrescriptions().add(prescription);
    }

    private static Medication addNewMed(String mdpath, Patient patient) {
        String[] data = input.getMedInput();
        Medication medication = new Medication(data);
        patient.getMedications().add(medication);
        writeInFile(mdpath, arrToCSV(data));
        return medication;
    }

    private static int getLinesNumber(String path) {
        int prnum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(new File(path)));) {
            br.readLine();
            while ((br.readLine()) != null)
                prnum++;
        } catch (Exception e) {
            System.out.println("File not found in getLinesNumber");
        }
        return prnum;
    }
}
