public class Person {
    private String Name , Id , Address,Phone , BirthDate , Sex ;
 
    public Person() {
    }
    public Person(String name, String id, String address, String phone, String birthDate, String sex) {
        Name = name;
        Id = id;
        Address = address;
        Phone = phone;
        BirthDate = birthDate;
        Sex = sex;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getBirthDate() {
        return BirthDate;
    }
    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }
    public String getSex() {
        return Sex;
    }
    public void setSex(String sex) {
        Sex = sex;
    }
}