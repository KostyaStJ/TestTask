package com.company;

import java.util.Scanner;

public class ConsoleDialog {

    private Scanner scanner = new Scanner(System.in);
    private InputData inputData;

    public void start(){
        System.out.println("Enter in-catalog path");
        String inPathString = scanner.nextLine();

        System.out.println("Enter first out-catalog path");
        String firstOutPathString = scanner.nextLine();

        System.out.println("Enter second out-catalog path");
        String secondOutPathString = scanner.nextLine();

        System.out.println("Enter key");
        String key = scanner.nextLine();

        inputData = new InputData(key,inPathString,firstOutPathString,secondOutPathString);
    }

    public InputData getInputData(){
        return inputData;
    }

    public void firstStepSuccessNotify(){
        System.out.println("Files in folder: " + getInputData().getInPathString() + " are " +
                "successfully encoded to folder: " + getInputData().getFirstOutPathString() );
        System.out.println();
    }

    public void secondStepSuccessNotify(){
        System.out.println("Files in folder: " + getInputData().getFirstOutPathString() + " are " +
                "successfully encoded to folder: " + getInputData().getSecondOutPathString() );
        System.out.println();
    }

    public void compareResultsNotify(boolean compareResult){
        if (compareResult){
            System.out.println("Files in " + getInputData().getInPathString() + " and in" + getInputData()
                    .getSecondOutPathString() + " are EQUALS") ;
        }else {
            System.out.println("Files in " + getInputData().getInPathString() + " and in" + getInputData()
                    .getSecondOutPathString() + " are NOT EQUALS") ;
        }

    }
}
