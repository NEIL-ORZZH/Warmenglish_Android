package com.kot32.warmenglish.model;

/**
 * Created by kot32 on 15/6/5.
 */
public class HttpStatus {

    private String result;

    @Override
    public String toString() {
        return "HttpStatus{" +
                "result='" + result + '\'' +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
