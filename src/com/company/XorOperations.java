package com.company;

public class XorOperations {

    public byte[] encode(byte [] arr, String pKey) {

        byte[] key = pKey.getBytes();
        byte[] res = new byte[arr.length];

        for (int i = 0; i < arr.length; i++) {
            res[i] = (byte) (arr[i] ^ key[i % key.length]);
        }


        return res;
    }

    public  String decode(byte[] pText, String pKey) {
        byte[] res = new byte[pText.length];
        byte[] key = pKey.getBytes();

        for (int i = 0; i < pText.length; i++) {
            res[i] = (byte) (pText[i] ^ key[i % key.length]);
        }


        return new String(res);
    }



}
