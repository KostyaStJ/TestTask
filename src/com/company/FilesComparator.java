package com.company;

import java.io.File;
import java.util.Arrays;

public class FilesComparator {

    private InputData inputData;
    private FileReader fileReader = new FileReader();
    private byte[] fileByteArray;

    public FilesComparator(InputData inputData, FileReader fileReader) {
        this.inputData = inputData;
        this.fileReader = fileReader;
    }

    public boolean start(File folderOne) {
        boolean result = false;

        for (final File fileEntry : folderOne.listFiles()) {
            if (fileEntry.isDirectory()) {
                start(fileEntry);
            } else {
                fileByteArray = fileReader.readStringFile(inputData.getInPathString()+fileEntry.getName());
                result = getFileFromSecondFolder(new File(inputData.getSecondOutPathString()), fileEntry.getName());


            }
        }
        return result;
    }


    private final boolean getFileFromSecondFolder(File folder, String fileName){
        File folderTwo = new File(inputData.getSecondOutPathString());
        boolean result= false;

        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                start(fileEntry);
            } else {
                byte[] fileByteArrayTwo = fileReader.readStringFile(inputData.getSecondOutPathString() + fileEntry
                        .getName());

                if (fileEntry.getName().equals(fileName)) {
                  result = compare(fileByteArray, fileByteArrayTwo);
                }
            }
        }

        return result;
    }

    private boolean compare(byte[] arrayOne, byte [] arrayTwo){
        boolean compareResult = Arrays.equals(arrayOne,arrayTwo);
        return compareResult;
    }

}