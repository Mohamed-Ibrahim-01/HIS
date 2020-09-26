import enums.Capacity;
public class ICU {
    private String Name , ICU_Code, Manager ;
    private Capacity capacity ;
    private int BedsNumber ,Free , Busy;
    
    public ICU(){

    }

    public ICU(String name, String iCU_Code, String manager, int BedsNumber,int Busy) {
        Name = name;
        ICU_Code = iCU_Code;
        Manager = manager;
        this.BedsNumber = BedsNumber ;
        this.Busy = Busy;
        Free = BedsNumber - Busy ; 
        this.capacity = settingCapacity(BedsNumber);
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
        return capacity;
    }

    public void setCapacity(int BedsNumber) {
       this.capacity = settingCapacity(BedsNumber);
    }

    public int getBedsNumber() {
        return BedsNumber;
    }

    public void setBedsNumber(int BedsNumber) {
       this.BedsNumber = BedsNumber ; 
    }

    public int getBusy() {
        return Busy;
    }

    public void setBusy(int busy) {
        Busy = busy;
        Free = BedsNumber - Busy ; 
    }

    public void addBusy(int increament ){
        Busy +=increament;
        Free = BedsNumber - Busy; 
    }

    public void FreeBeds(int beds){
        Busy -= beds;
        Free = BedsNumber - Busy; 
    }

    private static Capacity settingCapacity(int BedsNumber){
         Capacity cap = Capacity.SMALL ;
        switch(BedsNumber){
            case 2 : cap = Capacity.SMALL; break;
            case 4 : cap = Capacity.MEDUIM; break;
            case 6 : cap = Capacity.BIG; break;
        }
        return cap ; 
    }  
}