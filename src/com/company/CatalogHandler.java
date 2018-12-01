package com.company;

import java.io.File;

public class CatalogHandler {

    private InputData inputData;
    private FileReader fileReader = new FileReader();
    private XorOperations xorOperations = new XorOperations();
    private FileSaver fileSaver = new FileSaver();

    public CatalogHandler(InputData inputData) {
        this.inputData = inputData;
    }

    public boolean cryptFilesInFolderOne(File folder) {

        boolean successfulSave = false;
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                cryptFilesInFolderOne(fileEntry);
            } else {

             byte [] fileByteArray = fileReader.readStringFile(inputData.getInPathString() + fileEntry.getName());

             byte [] encodedByteArray = xorOperations.encode(fileByteArray, inputData.getKey());

             successfulSave = fileSaver.saveInByteFile(inputData.getFirstOutPathString() + fileEntry.getName(),
                     encodedByteArray);

            }
        }
        return successfulSave;
    }

    public boolean cryptFilesInFolderTwo(File folder) {
        boolean successfulSave = false;
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                cryptFilesInFolderOne(fileEntry);
            } else {
                byte [] fileByteArray = fileReader.readByteFile(inputData.getFirstOutPathString() + fileEntry.getName
                        ());

                String decodedFile = xorOperations.decode(fileByteArray, inputData.getKey());

                successfulSave = fileSaver.saveInStringFile(inputData.getSecondOutPathString() + fileEntry.getName(),
                        decodedFile);

            }
        }

        return successfulSave;
    }

}
