package com.company;

import java.io.*;

public class FileReader {


    public byte[] readStringFile(String path) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try (BufferedReader f = new BufferedReader(new
                java.io.FileReader(path))) {
            String str = "";


            for (; (str = f.readLine()) != null; ) {

                byteArrayOutputStream.write(str.getBytes());
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        return byteArrayOutputStream.toByteArray();
    }


    public byte[] readByteFile(String path){
        try (FileInputStream fis = new FileInputStream(path)){
            byte[] bufer = new byte[fis.available()];

            for (; (fis.read(bufer)) > 0;) {

            }

            return bufer;

        } catch ( IOException e ) {
            System.out.println(e);
        }

        return null;

    }
    }

