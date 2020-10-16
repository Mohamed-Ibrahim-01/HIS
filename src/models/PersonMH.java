package src.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
public class PersonMH{
    private HashMap<String,Date> ChronicDiseases;
    private HashMap<String,Date> Diseases;
    private HashMap<String,Date> Hospitalizations;
    private HashMap<String,Date> Medications;
    private List<String> GeneticDiseases;
    
    public PersonMH(){
    }
    public PersonMH(HashMap<String,Date> chronicDiseases,HashMap<String,Date> diseases
        ,HashMap<String,Date> hospitalizations ,HashMap<String,Date> medications,List<String> geneticDiseases){

        this.ChronicDiseases = chronicDiseases;
        this.Hospitalizations = hospitalizations;
        this.Diseases = diseases;
        this.Medications = medications;
        this.GeneticDiseases = geneticDiseases;
    }

   public HashMap<String,Date> getChronicDiseases(){return this.ChronicDiseases;} 
   public HashMap<String,Date> getDiseases(){return this.Diseases;} 
   public HashMap<String,Date> getHospitalizations(){return this.Hospitalizations;} 
   public HashMap<String,Date> getMedications(){ return this.Medications;}
   public List<String> getGeneticDiseases(){return this.GeneticDiseases;}
   
   public void setChronicDiseases(HashMap<String,Date> chronicDiseases){ChronicDiseases = chronicDiseases;} 
   public void setDiseases(HashMap<String,Date> diseases){Diseases = diseases;} 
   public void setHospitalizations(HashMap<String,Date> hospitalizations){Hospitalizations = hospitalizations;} 
   public void setMedications(HashMap<String,Date> medications){Medications = medications;}
   public void setGeneticDiseases(List<String> geneticDiseases){ GeneticDiseases = geneticDiseases;}
   
   public boolean addDisease(String name, Date date){
       if(this.Diseases == null) Diseases = new HashMap<String,Date>();
       if(Diseases.containsKey(name)) return false;
       Diseases.put(name,date);
       return true;
   }
   
   public boolean addChronicDisease(String name, Date date){
       if(this.ChronicDiseases == null) ChronicDiseases = new HashMap<String,Date>();
       if(ChronicDiseases.containsKey(name)) return false;
       ChronicDiseases.put(name,date);
       return true;
   }

   public boolean addGeneticDisease(String name){
       if(this.GeneticDiseases == null) GeneticDiseases = new ArrayList<String>();
       if(GeneticDiseases.contains(name)) return false;
       GeneticDiseases.add(name);
       return true;
   }
}
