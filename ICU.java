import enums.Capacity;
public class ICU {
    private String Name , ICU_Code, Manager ;
    private Capacity Capacity ;
    private int BedsNumber;

    public ICU(){

    }

    public ICU(String name, String iCU_Code, String manager, enums.Capacity capacity) {
        Name = name;
        ICU_Code = iCU_Code;
        Manager = manager;
        this.Capacity = capacity;
        BedsNumber = settingBedsNumber(capacity);
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getICU_Code() {
        return ICU_Code;
    }

    public void setICU_Code(String iCU_Code) {
        ICU_Code = iCU_Code;
    }

    public String getManager() {
        return Manager;
    }

    public void setManager(String manager) {
        Manager = manager;
    }

    public Capacity getCapacity() {
        return Capacity;
    }

    public void setCapacity(Capacity capacity) {
        Capacity = capacity;
    }

    public int getBedsNumber() {
        return BedsNumber;
    }

    public void setBedsNumber(Capacity capacity) {
        BedsNumber = settingBedsNumber(capacity);
    }

    private static int settingBedsNumber(Capacity capacity){
        int BedsNumber = 0 ;
        switch(capacity){
            case BIG : BedsNumber = 6; break;
            case MEDUIM : BedsNumber = 4; break;
            case SMALL : BedsNumber = 2; break;
        }
        return BedsNumber ; 
    }
}