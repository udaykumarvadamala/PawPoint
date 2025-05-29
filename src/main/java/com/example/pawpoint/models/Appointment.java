package com.example.pawpoint.models;

public class Appointment {
    private String petName;
    private String ownerName;
    private String contact;
    private String date;
    private String serviceType;

    public Appointment(String petName, String ownerName, String contact, String date, String serviceType) {
        this.petName = petName;
        this.ownerName = ownerName;
        this.contact = contact;
        this.date = date;
        this.serviceType = serviceType;
    }

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getContact() {
        return contact;
    }

    public String getDate() {
        return date;
    }

    public String getServiceType() {
        return serviceType;
    }
}
