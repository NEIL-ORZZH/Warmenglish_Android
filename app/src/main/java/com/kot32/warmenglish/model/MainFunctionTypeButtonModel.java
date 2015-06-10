package com.kot32.warmenglish.model;

/**
 * Created by kot32 on 15/6/1.
 */
public class MainFunctionTypeButtonModel {

    private int image_source;
    private String fuction_name;

    public int getImage_source() {
        return image_source;
    }

    public void setImage_source(int image_source) {
        this.image_source = image_source;
    }

    public String getFuction_name() {
        return fuction_name;
    }

    public void setFuction_name(String fuction_name) {
        this.fuction_name = fuction_name;
    }

    @Override
    public String toString() {
        return "MainFunctionTypeButtonModel{" +
                "image_source=" + image_source +
                ", fuction_name='" + fuction_name + '\'' +
                '}';
    }

    public MainFunctionTypeButtonModel(int image_source, String fuction_name) {
        this.image_source = image_source;
        this.fuction_name = fuction_name;
    }
}
