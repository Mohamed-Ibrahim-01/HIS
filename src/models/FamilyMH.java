package src.models;
import java.util.HashMap;

class FamilyMH{
HashMap<String,PersonMH>  FamilyMembers ;

public FamilyMH(HashMap<String, PersonMH> familyMembers) { FamilyMembers = familyMembers; }

public HashMap<String, PersonMH> getFamilyMembers() { return FamilyMembers; }
public void setFamilyMembers(HashMap<String, PersonMH> familyMembers) { FamilyMembers = familyMembers; }

}
