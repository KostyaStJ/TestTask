package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Enter in-catalog path");
        StaticVariables.inPathString = sc.nextLine();

        System.out.println("Enter first out-catalog path");
        StaticVariables.firstOutPathString = sc.nextLine();


        System.out.println("Enter second out-catalog path");
        StaticVariables.secondOutPathString = sc.nextLine();


        System.out.println("Enter key");
        StaticVariables.key = sc.nextLine();

        final File folderPath = new File(StaticVariables.inPathString);

        EncryptToFisrtOutFolder.listFilesForFolder(folderPath);

        CompareFiles.getListFromFolderOne(new File(StaticVariables.inPathString));
    }



}