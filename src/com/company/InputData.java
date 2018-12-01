package com.company;

public class InputData {
    private String key ;
    private String inPathString;
    private String firstOutPathString ;
    private String secondOutPathString ;

    public InputData(String key, String inPathString, String firstOutPathString, String secondOutPathString) {
        this.key = key;
        this.inPathString = inPathString;
        this.firstOutPathString = firstOutPathString;
        this.secondOutPathString = secondOutPathString;
    }

    public String getKey() {
        return key;
    }

    public String getInPathString() {
        return inPathString;
    }

    public String getFirstOutPathString() {
        return firstOutPathString;
    }

    public String getSecondOutPathString() {
        return secondOutPathString;
    }
}
