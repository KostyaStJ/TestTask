package com.company;

import java.io.*;

public class EncryptToFisrtOutFolder {


    static void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {

                readFile(fileEntry.getName(), StaticVariables.inPathString, false);

                DecryptToSecondOutFolder.listFilesForOutFolder(new File(StaticVariables.firstOutPathString));

            }

        }

    }


    public static byte[] readFile(String filename, String path, boolean varCondition) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();

        try (BufferedReader f = new BufferedReader(new
                FileReader(path + filename))) {
            String str = "";
            int legth = 0;

            for (; (str = f.readLine()) != null; ) {

                b.write(str.getBytes());
            }

           if (!varCondition){
                fileSaver(b, filename);
           }
        } catch (IOException e) {
            System.out.println(e);
        }
        return b.toByteArray();
    }


    public static byte[] encode(byte [] arr, String pKey) {

        byte[] key = pKey.getBytes();
        byte[] res = new byte[arr.length];

        for (int i = 0; i < arr.length; i++) {
            res[i] = (byte) (arr[i] ^ key[i % key.length]);
        }


        return res;
    }

    public static void fileSaver(ByteArrayOutputStream byteArrayOutputStream, String filename) throws IOException {
        FileOutputStream fis = new FileOutputStream(StaticVariables.firstOutPathString + filename);

        fis.write(encode(byteArrayOutputStream.toByteArray(),StaticVariables.key));

    }
}






