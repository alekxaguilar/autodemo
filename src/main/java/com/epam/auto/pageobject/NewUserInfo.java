package com.epam.auto.pageobject;

public class NewUserInfo {

    private final String FIRST_NAME = "Mauro";
    private final String LAST_NAME = "Lara";
    private final String EMAIL = "mauroLara@mail.com";
    private final String TELEPHONE = "1234567890";
    private final String PASSWORD = "test";

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getTELEPHONE() {
        return TELEPHONE;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }
}
