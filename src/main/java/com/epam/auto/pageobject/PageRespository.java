package com.epam.auto.pageobject;

public class PageRespository {

    public final String HOME_PAGE = "http://127.0.0.1:8080/";
    public final String LOGIN_PAGE = "http://127.0.0.1:8080/index.php?route=account/login";
    public final String REGISTER_PAGE = "http://127.0.0.1:8080/index.php?route=account/register";

    public String getHOME_PAGE() {
        return HOME_PAGE;
    }

    public String getLOGIN_PAGE() {
        return LOGIN_PAGE;
    }

    public String getREGISTER_PAGE() {
        return REGISTER_PAGE;
    }
}
