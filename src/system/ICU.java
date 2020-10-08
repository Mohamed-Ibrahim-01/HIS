package src.system;
import java.util.HashMap;
import java.util.UUID;

import src.enums.Capacity;
import src.models.Patient;
public class ICU {
    private String Name , Code, Manager ;
    private Capacity capacity ;
    private int BedsNumber ,FreeBeds , BusyBeds;
    private HashMap<UUID,Integer> patientsBeds ;
   
    public ICU(){

    }
    
    public ICU(String[] data) {
        Name = data[0];
        Code = data[1];
        Manager = data[2];
        this.BedsNumber = Integer.parseInt(data[3]) ;
        this.BusyBeds = Integer.parseInt(data[4]);
        this.capacity = settingCapacity(BedsNumber);
        FreeBeds = BedsNumber - BusyBeds ; 
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
    @Override
    public String toString(){
        return "code = " +this.Code+"name = "+ this.Name+"manager = "+this.Manager+"beds number = "+this.BedsNumber+"\n"+"capacity = "+this.capacity+"busy = "+this.BusyBeds+"free = "+this.FreeBeds ;

    }  

}