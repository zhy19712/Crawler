package com.bhidi.crawler.beans;

/**
 * Created by zhy19712 on 01/08/2017.
 */
public class Task {
    public String NAME;
    public String DESCRIPTION;
    public String URL;
    public String CREATED_AT;
    public int ID;


    public Task(int ID, String NAME, String DESCRIPTION, String URL, String CREATED_AT) {
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.URL = URL;
        this.CREATED_AT = CREATED_AT;
        this.ID = ID;
    }

    public String getTITLE() {

        return NAME;
    }
    public int getID() {

        return ID;
    }


    public String getDESCRIPTION() {
        return DESCRIPTION;
    }


    public String getURL() {
        return URL;
    }

    public String getCREATED_AT() {
        return CREATED_AT;
    }
}
