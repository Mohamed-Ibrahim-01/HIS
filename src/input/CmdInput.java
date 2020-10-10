package src.input;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CmdInput implements Input {
private String dashLine = "----------------------------------------------";
    private static final InputStreamReader r = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(r);
    public String[] getPatientInput() {
        String[] patientData  ;
        System.out.println(dashLine);
    };
    public String[] getMsInput(){};
    public String getCRDisMap(){};
    public String getDisMap(){};
    public String getHospMap(){};
    public String getMedMap(){};
    public String[] getDoctorInput(){};
    public String[] getMedInput(){};
    public String[] getPRInput(){};
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
            System.out.print("Please,Enter the drug name : ");
            medData[1] = br.readLine();
            System.out.print("Please,Enter drug quantity : ");
            medData[2] = br.readLine();
        } catch (Exception e) {
            System.out.println("exception has been occured");
        }
        return medData;
    }
        
    }

