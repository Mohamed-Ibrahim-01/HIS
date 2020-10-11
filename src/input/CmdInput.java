package src.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import src.output.Prompt;

public class CmdInput implements Input {
    private static final InputStreamReader r = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(r);

    @Override
    public String[] getPatientInput() {
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
    public String[] getMsInput() {
        return null;
    }

    @Override
    public String getCRDisMap() {
        return null;
    }

    @Override
    public String getDisMap() {
        return null;
    }

    @Override
    public String getHospMap() {
        return null;
    }

    @Override
    public String getMedMap() {
        return null;
    }

    @Override
    public String[] getDoctorInput() {
        return null;
    }

    @Override
    public String[] getMedInput() {
        return null;
    }

    @Override
    public String[] getPRInput(

    ) {
        return null;
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
    public static boolean getchoose()throws Exception{
            Prompt.wthorNewPR();
            String temp = br.readLine();
            if (temp == "1"){
                Prompt.printDashline();
                return true ; 
            }else {
                Prompt.printDashline();
                return false ; 
            }
    }

    private String getStringDate() {
        return "";
    }

    private String getmed() {
        return "";
    }

    private String getHosp() {
        return "";
    }

    private String getDisease() {
        return "";
    }

    private String getCRDisease() {
        return "";
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

}
