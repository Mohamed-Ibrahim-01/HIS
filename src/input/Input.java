package src.input;

public interface Input {
    public String[] getDoctor();
    public String[] getPatient();
    public String[] getMedInput();
    public String[] getPRInput();
    public String[] getSysMedInput();
    public String[] getTdinfo();
    public boolean need(String needed);
    public String[] getMedicalStatus();
    public String getMap(String mapName);
}
