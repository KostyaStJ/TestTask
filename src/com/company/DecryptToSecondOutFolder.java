package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class DecryptToSecondOutFolder {


    static void listFilesForOutFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForOutFolder(fileEntry);
            } else {


                saveToSecondOutFolder(fileEntry.getName());
            }
        }
    }


    public static String decode(byte[] pText, String pKey) {
        byte[] res = new byte[pText.length];
        byte[] key = pKey.getBytes();

        for (int i = 0; i < pText.length; i++) {
            res[i] = (byte) (pText[i] ^ key[i % key.length]);
        }


        return new String(res);
    }


    public static void saveToSecondOutFolder(String filename) {
        try (FileInputStream fis = new FileInputStream(StaticVariables.firstOutPathString + filename);

            PrintWriter pw = new PrintWriter(StaticVariables.secondOutPathString + filename)){
            byte[] bufer = new byte[fis.available()];
            int byteread = 0;

            for (; (byteread = fis.read(bufer)) > 0;) {

            }

            pw.println(decode(bufer, StaticVariables.key));
        } catch ( IOException e ) {
            System.out.println(e);
        }


    }

}
