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
    public String[] getSysMedInput(){};
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
}