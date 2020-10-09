package src.fileoperations;

import src.models.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.net.SocketImpl;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import src.system.ICU;
import src.system.SystemMedication;

public class Read {
    private static final int CHRONIC_DISEASES = 0, DISEASES = 1, HOSPITALIZATIONS = 2, MEDICATIONS = 3,
            GENETIC_DISEASES = 4;
    private static final String slash = File.separator;

    public static List<Patient> readPatients() {
        String line;
        String patientsDataPath = "." + slash + "data" + slash + "patientsdata";
        List<Patient> patients = new ArrayList<Patient>();
        String[] lineArray;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(patientsDataPath + slash + "patients.csv")));
            br.readLine();
            while ((line = br.readLine()) != null) {
                lineArray = readCSVLine(line);
                patients.add(createPatient(lineArray, patientsDataPath + slash + lineArray[0]));
            }
        } catch (Exception e) {
        }
        return patients;
    }

    public static List<Doctor> readDoctors() {
        String line;
        String doctorsDataPath = "." + slash + "data" + slash + "doctorsdata" + slash + "Doctors.csv";
        List<Doctor> doctors = new ArrayList<Doctor>();
        String[] lineArray;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(doctorsDataPath)));
            br.readLine();
            while ((line = br.readLine()) != null) {
                lineArray = readCSVLine(line);
                doctors.add(new Doctor(lineArray));
            }
        } catch (Exception e) {
            System.out.println("Doctors not found in : " + doctorsDataPath);
            System.out.println("I'm in the folder : " + new File("").getAbsolutePath());
        }
        return doctors;
    }

    public static List<ICU> readICUs() {
        List<ICU> icus = new ArrayList<ICU>();
        String Path = "." + slash + "data" + slash + "icu";
        try (BufferedReader br = new BufferedReader(new FileReader(new File(Path + slash + "ICUs.csv")));) {
            br.readLine();
            String line;
            String[] lineArray = null;
            while ((line = br.readLine()) != null) {
                lineArray = readCSVLine(line);
                icus.add(createIcu(lineArray, Path + slash + lineArray[0]));
            }
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
        return icus;
    }

    public static ICU createIcu(String[] lineArray, String patientsDataPath) {
        ICU icu = new ICU(lineArray);
        try (BufferedReader br = new BufferedReader(new FileReader(new File(patientsDataPath + slash + "ps.csv")))) {
            String[] patientsLineArray = null;
            String line;
            while ((line = br.readLine()) != null) {
                patientsLineArray = readCSVLine(line);
                icu.addPatient(patientsLineArray[0], patientsLineArray[1]);
            }
        } catch (Exception e) {
            System.out.println("There is a problem in createIcu");
        }
        return icu;
    }

    public static List<SystemMedication> readMedicationStorage() {
        String Path = "." + slash + "data" + slash + "storage" + slash + "medcationStorage.csv";
        List<SystemMedication> medicationStorage = new ArrayList<SystemMedication>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(Path)));) {
            br.readLine();
            String line;
            String[] lineArray = null;
            while ((line = br.readLine()) != null) {
                lineArray = readCSVLine(line);
                medicationStorage.add(new SystemMedication(lineArray));
            }
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
        return medicationStorage;
    }

    public static List<TreatmentData> readTreatmentData() {
        List<TreatmentData> treatmentData = new ArrayList<TreatmentData>();
        try {
            String Path = "." + slash + "data" + slash + "TreatmentData";
            File Folder = new File(Path);
            File[] folders = Folder.listFiles();
            for (File folder : folders) {
                treatmentData.add(creatTreatmentData(folder.getAbsolutePath()));
            }
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
        return treatmentData;
    }

    private static Patient createPatient(final String[] personlData, final String patientPath) {
        Patient patient = new Patient(personlData);
        patient.setComplain(personlData[6]);
        patient.setAdmittanceDate(personlData[7]);
        patient.setICUname(personlData[8]);
        patient.setBedNumber(personlData[9]);
        patient.setMedicalStatus(getMs(patientPath + slash + "ms.csv"));
        patient.setMedicalHistory(getMh(patientPath, patient));
        return patient;
    }

    private static MedicalStatus getMs(String patientMsPath) {
        MedicalStatus medicalStatus = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(patientMsPath)));
            br.readLine();
            String[] lineArray = readCSVLine(br.readLine());
            medicalStatus = new MedicalStatus(lineArray);
        } catch (Exception e) {
            System.out.println("******************not comleted****************");

        }
        return medicalStatus;
    }

    private static MedicalHistory getMh(String patientPath, Patient patient) {
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setPatient(patient);
        HashMap<String, PersonMH> familyMembers = new HashMap<String, PersonMH>();
        try {
            File patientFolder = new File(patientPath);
            File[] mhFiles = patientFolder.listFiles(new FileFilter() {
                public boolean accept(File pathName) {
                    return !pathName.getName().equals("ms.csv");
                }
            });
            for (File fmh : mhFiles) {
                switch (fmh.getName()) {
                    case "pmh.csv":
                        medicalHistory.setPatientMH(getPmh(fmh));
                        break;
                    case "fmh.csv":
                        familyMembers.put("FatherMH", getPmh(fmh));
                        break;
                    case "mmh.csv":
                        familyMembers.put("MotherMH", getPmh(fmh));
                        break;
                    case "gmmh1.csv":
                        familyMembers.put("GrandMMH1", getPmh(fmh));
                        break;
                    case "gfmh1.csv":
                        familyMembers.put("GrandFMH1", getPmh(fmh));
                        break;
                    case "gmmh2.csv":
                        familyMembers.put("GrandMMH2", getPmh(fmh));
                        break;
                    case "gfmh2.csv":
                        familyMembers.put("GrandFMH2", getPmh(fmh));
                        break;
                }
            }
            medicalHistory.setPatientFamilyMH(new FamilyMH(familyMembers));
        } catch (Exception e) {
        }
        return medicalHistory;
    }

    private static PersonMH getPmh(File pmh) {
        PersonMH personMH = new PersonMH();
        try {
            BufferedReader br = new BufferedReader(new FileReader(pmh));
            String line;
            for (int i = 0; (line = br.readLine()) != null; i++) {
                String[] lineArray = readCSVLine(line);
                switch (i) {
                    case CHRONIC_DISEASES:
                        personMH.setChronicDiseases(getPmhMap(lineArray));
                        break;
                    case DISEASES:
                        personMH.setDiseases(getPmhMap(lineArray));
                        break;
                    case HOSPITALIZATIONS:
                        personMH.setHospitalizations(getPmhMap(lineArray));
                        break;
                    case MEDICATIONS:
                        personMH.setMedications(getPmhMap(lineArray));
                        break;
                    case GENETIC_DISEASES: {
                        List<String> lineAttributes = new ArrayList<String>();
                        Collections.addAll(lineAttributes, lineArray);
                        break;
                    }
                }
            }
            br.close();
        } catch (Exception e) {
        }
        return personMH;
    }

    private static HashMap<String, Date> getPmhMap(String[] lineArray) {
        if (lineArray.length == 1 && lineArray[0].equals("null"))
            return null;
        else {
            HashMap<String, Date> data = new HashMap<String, Date>();
            for (String S : lineArray) {
                Matcher m = Pattern.compile(
                        "([a-zA-Z\\s]+):(\\s*)(([0-2][0-9]|3[0-1])/(0[0-9]|1[0-2])/(1[8-9]\\d{2}|20[0-2][0-9]))")
                        .matcher(S);
                m.find();
                try {
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(m.group(3));
                    String value = m.group(1);
                    data.put(value, date);
                } catch (Exception e) {
                }
            }
            return data;
        }
    }

    private static String[] getTd(String path) throws Exception {
        BufferedReader br;
        br = new BufferedReader(new FileReader(new File(path + slash + "td.csv")));
        br.readLine();
        String line;
        String[] lineArray = null;
        while ((line = br.readLine()) != null) {
            lineArray = readCSVLine(line);
        }
        br.close();
        return lineArray;
    }

    private static List<Medication> getMd(String mdPath) throws Exception {
        BufferedReader br;
        br = new BufferedReader(new FileReader(new File(mdPath)));
        br.readLine();
        String line;
        String[] lineArray;
        List<Medication> medications = new ArrayList<Medication>();
        while ((line = br.readLine()) != null) {
            lineArray = readCSVLine(line);
            medications.add(new Medication(lineArray));
        }
        br.close();
        return medications;
    }

    private static List<Prescription> getPr(String path) throws Exception {
        BufferedReader br;
        br = new BufferedReader(new FileReader(new File(path + slash + "pr.csv")));
        br.readLine();
        String line;
        String[] lineArray;
        List<Prescription> prescriptions = new ArrayList<Prescription>();
        while ((line = br.readLine()) != null) {
            lineArray = readCSVLine(line);
            List<Medication> medications = getMd(path + slash + "md" + lineArray[0] + ".csv");
            prescriptions.add(new Prescription(medications, lineArray));
        }
        br.close();
        return prescriptions;
    }

    private static TreatmentData creatTreatmentData(String path) throws Exception {
        return new TreatmentData(getTd(path), getPr(path));
    }

    private static String[] readCSVLine(String line) {
        String[] splitedLine = line.split(",");
        List<String> lineAttributes = new LinkedList<String>();
        Collections.addAll(lineAttributes, splitedLine);
        for (int i = 0; i < lineAttributes.size(); i++) {
            String curr = lineAttributes.get(i);
            if (curr.startsWith("\"")) {
                String next = lineAttributes.get(i + 1);
                curr = (curr + "," + next).replace("\"", "");
                lineAttributes.set(i, curr);
                lineAttributes.remove(next);
            }
        }
        return lineAttributes.toArray(new String[lineAttributes.size()]);
    }
}
