package com.company;

import java.io.IOException;

import static com.company.CatalogManager.loadCatalogfFromExternFile;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave(){
        Catalog catalog = new Catalog("Java Resources", "d:/java/catalog.ser");
        Document document = new Document("java1" , "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        document.addAdditionalLabels("type", "Slides");
        catalog.addDocument(document);

        try {
            CatalogManager.saveCatalogInExternFile(catalog);
        } catch (IOException e) {
            System.out.println("testCreateSave failed!");
            e.printStackTrace();
        }
    }

    private void testLoadView() throws IOException, ClassNotFoundException {
        Catalog catalog;
        catalog = loadCatalogfFromExternFile("d:/java/catalog.ser");
        assert catalog != null;
        Document document = catalog.findByIdFancy("java1");
        CatalogManager.viewDocument(document);
    }
}
