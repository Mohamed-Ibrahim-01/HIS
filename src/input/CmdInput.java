package src.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import src.output.Prompt;

public class CmdInput implements Input {
    private static final InputStreamReader r = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(r);

    @Override
    public String[] getPatient() {
        Prompt.showTitle("Patient Data");
        String[] patientData = new String[10];
        String[] patientDataStrs = { "Name", "Address", "Phone", "Birth Date", "Sex", "Complain" };
        try {
            for (int i = 0; i < 6; i++) {
                Prompt.askToInput("Patient " + patientDataStrs[i]);
                patientData[i + 1] = br.readLine();
            }
        } catch (Exception e) {
        }
        Prompt.printDashline();
        return patientData;
    }

    @Override
    public String getMap(String mapName) {
        String map = "";
        if (mapName.equals("Chronic Disease"))
            Prompt.showTitle("Medical History");
        try {
            do {
                Prompt.askToInputInForm(mapName, "{Name}:{Date}");
                map += br.readLine() + ",";
            } while (need("more " + mapName + "s"));
        } catch (Exception e) {
        }
        return map;
    }

    @Override
    public String[] getMedicalStatus() {
        Prompt.showTitle("Medical Status");
        String[] medicalStatusAttributes = { "Temprature", "systolicBP", "DiastolicBP", "Heart Rate" },
                medicalStatus = new String[4];
        int i = 0;
        for (String attribute : medicalStatusAttributes) {
            Prompt.askToInput(attribute);
            medicalStatus[i++] = getInput();
        }
        return medicalStatus;
    }

    private static String getInput() {
        String input = "";
        try {
            input += br.readLine();
        } catch (Exception e) {
            System.out.println("Exception has been occured");
        }
        return input;
    }

    @Override
    public String[] getDoctor() {
        Prompt.showTitle("Doctor Data");
        String[] DoctorData = new String[9];
        String[] DoctorDataStrs = { "Name", "Address", "Phone", "Birth Date", "Sex", "SSN", "MSA", "Degree" };
        for (int i = 0; i < 8; i++) {
            Prompt.askToInput("Doctor " + DoctorDataStrs[i]);
            DoctorData[i + 1] = getInput();
        }
        Prompt.printDashline();
        return DoctorData;
    }

    @Override
    public String[] getMedInput() {
        String[] data = new String[3];
        try {
            Prompt.printDashline();
            Prompt.askToInput(" the name of the medication");
            data[0] = br.readLine();
            Prompt.askToInput(" the daily dose ");
            data[1] = br.readLine();
            Prompt.askToInput(" the dose value ");
            data[2] = br.readLine();
            Prompt.printDashline();
        } catch (Exception e) {
            System.out.println("Exception has been occured");
        }
        return data;
    }

    @Override
    public String[] getPRInput() {
        String[] data = new String[3];
        try {
            Prompt.askToInput(" the date of prescription \" in the form of \"dd/mm/yyyy\",pleas\"");
            data[1] = br.readLine();
            Prompt.askToInput("the duration of the prescription ");
            data[2] = br.readLine();
            Prompt.printDashline();
        } catch (Exception e) {
            System.out.println("Exception has been occured");
        }
        return data;
    }

    @Override
    public String[] getTdinfo() {
        String[] info = new String[2];
        try {
            Prompt.showTitle("TREATMENT DATA INFORMATION");
            Prompt.askToInput("patient name");
            info[0] = br.readLine().toLowerCase();
            Prompt.askToInput("doctor's name");
            info[1] = br.readLine().toLowerCase();
            Prompt.printDashline();
        } catch (Exception e) {
            System.out.println("Exception has been occured");
        }
        return info;
    }

    @Override
    public String getWTH() {
        Prompt.printDashline();
        Prompt.askToInput("the weekly treatment hours ");
        String WTH = getInput();
        Prompt.printDashline();
        return WTH;
    }
    
    public String[] getSysMedInput() {
        String[] medData = new String[3];
        try {
            Prompt.showTitle("new System medication");
            Prompt.askToInput("the drug name");
            medData[1] = br.readLine().toLowerCase();
            Prompt.askToInput("drug quantity");
            medData[2] = br.readLine();
            Prompt.printDashline();
        } catch (Exception e) {
            System.out.println("exception has been occured");
        }
        return medData;
    }


    @Override
    public boolean need(String needed) {
        Prompt.askToNeed(needed);
        try {
            String response = br.readLine();
            return (response.equals("1") ? true : false);
        } catch (Exception e) {
            System.out.println("exception has been occured");
        }
        return false;
    }
}
