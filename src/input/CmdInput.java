package src.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdInput implements Input {

    private static final InputStreamReader r = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(r);

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

