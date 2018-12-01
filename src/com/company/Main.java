package com.company;

import java.io.File;

public class Main {


    public static void main(String[] args) {

        ConsoleDialog consoleDialog = new ConsoleDialog();
        consoleDialog.start();

        CatalogHandler catalogHandler = new CatalogHandler(consoleDialog.getInputData());

        boolean successOne = catalogHandler.cryptFilesInFolderOne(new File(consoleDialog.getInputData().getInPathString
                ()));

        boolean successTwo = false;
        boolean compareResult = false;

        if (successOne){

            consoleDialog.firstStepSuccessNotify();

            successTwo= catalogHandler.cryptFilesInFolderTwo(new File(consoleDialog.getInputData()
                   .getFirstOutPathString()));
        }

        if (successTwo){
            consoleDialog.secondStepSuccessNotify();

            FilesComparator filesComparator = new FilesComparator(consoleDialog.getInputData(), new FileReader());
            compareResult = filesComparator.start(new File(consoleDialog.getInputData().getInPathString()));

            consoleDialog.compareResultsNotify(compareResult);

        }





    }
}