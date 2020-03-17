package com.company;

import java.awt.*;
import java.io.*;

import static java.lang.Integer.parseInt;

public class CatalogManager {

//    //save method solved in a way that was easier for me to understand

//    public static void saveCatalogInExternFile(Catalog catalog) {
//        try {
//            //declare the file where to write
//            FileWriter myWriter = new FileWriter("firstFile.txt");
//            //write the catalog
//            myWriter.write(catalog.toString());
//            //close the file
//            myWriter.close();
//            //confirm that instructions have been executed correctly
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            //display if a problem has occurred
//            System.out.println("A problem was found in function 'save'");
//            e.printStackTrace();
//        }
//    }

    //save make with OutPutStream
    public static void saveCatalogInExternFile(Catalog catalog) throws IOException {
        try {
            OutputStream outputStream = new FileOutputStream ("firstFile.txt");
            outputStream.write(parseInt(catalog.getNameOfCatalog()));
            outputStream.write(parseInt(catalog.getPathForCatalog()));
            try {
                outputStream.close();
            } catch (IOException e) {
                System.out.println("File can not be closed!");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File 'firstFile' doesn't exist!");
            e.printStackTrace();
        }
    }

    //load method solved in a way that was easier for me to understand

//    public static Catalog loadCatalogfFromExternFile(String path) {
//        File secondFile = new File("firstFile.txt");
//        if (secondFile.exists()) {
//            //extract the information from the file
//            var nameFromFile = secondFile.getName();
//            var pathFromFile = secondFile.getAbsolutePath();
//            //create a new catalog with information from file
//            Catalog catalog = new Catalog(nameFromFile,pathFromFile);
//            System.out.println("The catalog was added with success!");
//            return catalog;
//        }
//        else{
//            System.out.println("The file 'secondFile' does not exist!");
//        }
//        return null;
//    }

    //load made with ObjectInputStream
    public static Catalog loadCatalogfFromExternFile(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("firstFile.txt"));
        Object catalog = objectInputStream.readObject();
        objectInputStream.close();
        return null;
    }

    //view
    public static void viewDocument(Document document){
        Desktop desktop = Desktop.getDesktop();
        //browse or open, depending of the location type
    }
}
