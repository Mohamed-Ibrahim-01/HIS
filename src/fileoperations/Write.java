package src.fileoperations;

import java.util.List;
import java.util.UUID;

import src.models.*;
import src.system.HospitalNetwork;
import src.system.SystemMedication;

public class Write {
    public static Patient addNewPatient() throws Exception {
        UUID id;
        do {
            id = UUID.randomUUID();
        } while (HospitalNetwork.Ids().contains(id));
        addMedicalStatus(id);
        return null;
    }

    public static MedicalHistory addMedicalHistory(UUID id) throws Exception {
        addFamilyMH(id);
        addPersonMH(id);
        return null;
    }

    public static PersonMH addPersonMH(UUID id) throws Exception {

        return null;
    }

    public static FamilyMH addFamilyMH(UUID id) throws Exception {

        return null;
    }

    public static MedicalStatus addMedicalStatus(UUID id) throws Exception {

        return null;
    }
    public static Doctor addNewDoctor()throws Exception{
        return null ; 

    }
    public static SystemMedication addNewSystemMedication(){

        return null ; 
    }
    public static TreatmentData addNewTreatmentData(){
        return null ; 
    }
    public static void addTDFile(UUID patientID , UUID doctorID,double WTH){ 
    }
    public static Prescription addNewPrescription(){
        return null ; 
    }
    public static List<Medication> addPrMedications(){
        return null ; 
    }
 

}
