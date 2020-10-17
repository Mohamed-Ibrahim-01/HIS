package src.models;

import java.util.UUID;

public class Person {
    private String Name, Address, Phone, BirthDate, Sex;
    private UUID Id;
    private String[] attributes;
    private String[] attributesNames = {"Id","Name","Address","Phone","BirthDate","Sex"};

    public Person() {
    }

    public Person(final String[] params) {
        Id = UUID.fromString(params[0]);
        Name = params[1];
        Address = params[2];
        Phone = params[3];
        BirthDate = params[4];
        Sex = params[5];
        attributes = params;
    }

    public Person(String name, UUID id, String address, String phone, String birthDate, String sex) {
        Name = name;
        Id = id;
        Address = address;
        Phone = phone;
        BirthDate = birthDate;
        Sex = sex;
    }

    @Override
    public String toString() {
        return Name + "::" + Address + "::" + Phone + "::" + BirthDate + "::" + Sex + "\n";
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
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

    public String[] getAttributes() {
        return attributes;
    }

    public void setAttributes(String[] attributes) {
        this.attributes = attributes;
    }

    public String[] getAttributesNames() {
        return attributesNames;
    }

    public void setAttributesNames(String[] attributesNames) {
        this.attributesNames = attributesNames;
    }
}
