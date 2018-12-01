package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSaver {

    public boolean saveInByteFile(String fileFullPath, byte [] encodedFileArray){
        FileOutputStream fis = null;
        try {
            fis = new FileOutputStream(fileFullPath);
            fis.write(encodedFileArray);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean saveInStringFile(String fileFullPath, String decodedFile){
        try (PrintWriter pw = new PrintWriter(fileFullPath)) {
            pw.println(decodedFile);
            return true;
        }catch (IOException e){
            e.printStackTrace();

        }

        return false;
    }

}
