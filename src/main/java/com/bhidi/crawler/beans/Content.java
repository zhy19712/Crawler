package com.bhidi.crawler.beans;

/**
 * Created by zhy19712 on 01/08/2017.
 */
public class Content {
    public String TITLE;
    public String PATH;
    public String TYPE;
    public String CREATED_AT;
    public int ID;


    public Content(int ID, String TITLE, String PATH, String TYPE, String CREATED_AT) {
        this.TITLE = TITLE;
        this.PATH = PATH;
        this.TYPE = TYPE;
        this.CREATED_AT = CREATED_AT;
        this.ID = ID;
    }

    public String getTITLE() {

        return TITLE;
    }
    public int getID() {

        return ID;
    }


    public String getPATH() {
        return PATH;
    }


    public String getTYPE() {
        return TYPE;
    }

    public String getCREATED_AT() {
        return CREATED_AT;
    }

}
