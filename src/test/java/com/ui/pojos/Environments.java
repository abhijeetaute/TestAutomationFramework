package com.ui.pojos;

public class Environments {
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

    public int getMaxNumberOfAttempts() {
        return maxNumberOfAttempts;
    }

    public void setMaxNumberOfAttempts(int maxNumberOfAttempts) {
        this.maxNumberOfAttempts = maxNumberOfAttempts;
    }

    private int maxNumberOfAttempts;
}
