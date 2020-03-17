package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Catalog {
    private String nameOfCatalog;
    private String pathForCatalog;

    //create a list of documents to keep elements in catalog
    ArrayList<Document> documentsInCatalog = new ArrayList<Document>();

    //constructor
    public Catalog(String nameOfCatalog, String pathForCatalog) {
        this.nameOfCatalog = nameOfCatalog;
        this.pathForCatalog = pathForCatalog;
    }

    //function which add documents in catalog
    public void addDocument(Document document) {
        documentsInCatalog.add(document);
    }

    //getters and setters
    public String getNameOfCatalog() {
        return nameOfCatalog;
    }

    public void setNameOfCatalog(String nameOfCatalog) {
        this.nameOfCatalog = nameOfCatalog;
    }

    public String getPathForCatalog() {
        return pathForCatalog;
    }

    public void setPathForCatalog(String pathForCatalog) {
        this.pathForCatalog = pathForCatalog;
    }

    //a method which found a document by id
    public void findByIdClassical(String id){
        for (Document doc: documentsInCatalog)
            if(doc.getIdOfDocument()==id)
                System.out.println("Document with id: " + id +
                        " is named: " + doc.getNameOfDocument() +
                        "and is located in: " + doc.getLocationOfDocument());
            else {
                System.out.println("Catalog with this id doesn't exist");
            }
    }

    //another way to find a document by id
    public Document findByIdFancy(String id){
        return documentsInCatalog.stream().filter(d->d.getIdOfDocument().
                equals(id)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "\nnameOfCatalog='" + nameOfCatalog + '\'' +
                ",\n pathForCatalog='" + pathForCatalog + '\'' +
                ",\n documentsInCatalog=" + documentsInCatalog +
                '}';
    }
}
