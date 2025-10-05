package com.ui.pojos;

import java.util.Map;

public class Config {
    Map<String,Environments> environments;

    public Map<String, Environments> getEnvironments() {
        return environments;
    }

    public void setEnvironment(Map<String, Environments> environments) {
        this.environments = environments;
    }
}
