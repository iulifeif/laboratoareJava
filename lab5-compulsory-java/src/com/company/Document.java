package com.company;

import java.util.HashMap;

public class Document {
    private String idOfDocument;
    private String nameOfDocument;
    private String locationOfDocument;

    //a hashMap with Strings and Objects for additional labels of Document
    HashMap<String, Object> additionalLabels = new HashMap<String, Object>();

    //constructor
    public Document(String idOfDocument, String nameOfDocument, String locationOfDocument) {
        this.idOfDocument = idOfDocument;
        this.nameOfDocument = nameOfDocument;
        this.locationOfDocument = locationOfDocument;
    }

    //add other labels in map
    void addAdditionalLabels(String key, Object object){
        additionalLabels.put(key, object);
    }

    //getters and setters
    public String getIdOfDocument() {
        return idOfDocument;
    }

    public void setIdOfDocument(String idOfDocument) {
        this.idOfDocument = idOfDocument;
    }

    public String getNameOfDocument() {
        return nameOfDocument;
    }

    public void setNameOfDocument(String nameOfDocument) {
        this.nameOfDocument = nameOfDocument;
    }

    public HashMap<String, Object> getAdditionalLabels() {
        return additionalLabels;
    }

    public void setAdditionalLabels(HashMap<String, Object> additionalLabels) {
        this.additionalLabels = additionalLabels;
    }

    public String getLocationOfDocument() {
        return locationOfDocument;
    }

    public void setLocationOfDocument(String locationOfDocument) {
        this.locationOfDocument = locationOfDocument;
    }

    @Override
    public String toString() {
        return "Document{" +
                "\nidOfDocument='" + idOfDocument + '\'' +
                ",\n nameOfDocument='" + nameOfDocument + '\'' +
                ",\n locationOfDocument='" + locationOfDocument + '\'' +
                ",\n additionalLabels=" + additionalLabels +
                '}';
    }
}
