
package models;
import enums.Capacity;
public class ICU {
    private String Name , Code, Manager ;
    private Capacity capacity ;
    private int BedsNumber ,FreeBeds , BusyBeds;
    
    public ICU(){

    }

    public ICU(String name, String iCU_Code, String manager, int BedsNumber,int Busy) {
        Name = name;
        Code = iCU_Code;
        Manager = manager;
        this.BedsNumber = BedsNumber ;
        this.BusyBeds = Busy;
        this.capacity = settingCapacity(BedsNumber);
        FreeBeds = BedsNumber - Busy ; 
    }
    
    public String getName() { return Name; }
    public void setName(String name) { Name = name; }

    public String getCode() { return Code; }
    public void setCode(String code) { Code = code; }

    public String getManager() { return Manager; }
    public void setManager(String manager) { Manager = manager; }

    public Capacity getCapacity() { return capacity; }
    public void setCapacity(int bedsNumber) { this.capacity = settingCapacity(bedsNumber); }

    public int getBedsNumber() { return BedsNumber; }
    public void setBedsNumber(int bedsNumber) { this.BedsNumber = bedsNumber ; }

    public int getBusyBeds() { return BusyBeds; }
    public int getFreeBeds() { return FreeBeds; }

    public void setBusyBeds(int busy) {
        BusyBeds = busy;
        FreeBeds = BedsNumber - BusyBeds ; 
    }

    public void busyBeds(int increament ){
        BusyBeds += increament;
        FreeBeds = BedsNumber - BusyBeds; 
    }

    public void freeBeds(int freedBeds){
        BusyBeds -= freedBeds;
        FreeBeds = BedsNumber - BusyBeds; 
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