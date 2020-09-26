import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
class PersonMH{
    private HashMap<String,Date> ChronicDiseases;
    private HashMap<String,Date> Diseases;
    private HashMap<String,Date> Hospitalizations;
    private HashMap<String,Date> Medications;
    private ArrayList<String> GeneticDiseases;
    
    public PersonMH(){
    }
    public PersonMH(HashMap<String,Date> ChronicDiseases,HashMap<String,Date> Diseases
        ,HashMap<String,Date> Hospitalizations ,HashMap<String,Date> Medications,ArrayList<String> GeneticDiseases){

        this.ChronicDiseases = ChronicDiseases;
        this.Hospitalizations = Hospitalizations;
        this.Diseases = Diseases;
        this.Medications = Medications;
        this.GeneticDiseases = GeneticDiseases;
    }

   public HashMap<String,Date> getChronicDiseases(){return this.ChronicDiseases;} 
   public HashMap<String,Date> getDiseases(){return this.Diseases;} 
   public HashMap<String,Date> getHospitalizations(){return this.Hospitalizations;} 
   public HashMap<String,Date> getMedications(){ return this.Medications;}
   public ArrayList<String> getGeneticDiseases(){return this.GeneticDiseases;}
   
   public void setChronicDiseases(HashMap<String,Date> ChronicDiseases){this.ChronicDiseases = ChronicDiseases;} 
   public void setDiseases(HashMap<String,Date> Diseases){this.Diseases = Diseases;} 
   public void setHospitalizations(HashMap<String,Date> Hospitalizations){this.Hospitalizations = Hospitalizations;} 
   public void setMedications(HashMap<String,Date> Medications){this.Medications = Medications;}
   public void setGeneticDiseases(ArrayList<String> GeneticDiseases){ this.GeneticDiseases = GeneticDiseases;}
   
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
