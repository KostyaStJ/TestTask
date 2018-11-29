package com.company;

import java.io.File;
import java.util.Arrays;

public class CompareFiles {
    static void getListFromFolderOne(File folderOne) {
        for (final File fileEntry : folderOne.listFiles()) {
            if (fileEntry.isDirectory()) {
                getListFromFolderOne(fileEntry);
            } else {
                byte[] fileByteArr = EncryptToFisrtOutFolder.readFile(fileEntry.getName(), StaticVariables.inPathString,
                        true);
                getListFromFolderTwo(new File(StaticVariables.secondOutPathString), fileEntry, fileByteArr );
            }
        }
    }

    static void getListFromFolderTwo(File folderTwo, File file, byte [] arrayOne) {
        for (final File fileEntry : folderTwo.listFiles()) {
            if (fileEntry.isDirectory()) {
                getListFromFolderOne(fileEntry);
            } else {
                byte[] fileByteArr = EncryptToFisrtOutFolder.readFile(fileEntry.getName(), StaticVariables.secondOutPathString,
                        true);
                if (file.getName().equals(fileEntry.getName())) {

                    startCompare(arrayOne, fileByteArr, file.getName(), fileEntry.getName());
                    }

            }
        }
    }

    static void startCompare(byte[] arrayOne, byte [] arrayTwo, String fileOneName, String fileTwoName){
        boolean compare = Arrays.equals(arrayOne,arrayTwo);
        if (compare){
            System.out.println("Files " +  StaticVariables.inPathString + fileOneName + " and " + StaticVariables
                    .secondOutPathString + fileTwoName + " are EQUALS" );
        }else{
            System.out.println("Files " +  StaticVariables.inPathString + fileOneName + " and " + StaticVariables
                    .secondOutPathString + fileTwoName + " are NOT EQUALS");
        }

    }
}