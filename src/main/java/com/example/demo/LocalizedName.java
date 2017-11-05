package com.example.demo;

import com.github.jonpeterson.jackson.module.versioning.JsonVersionedModel;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class LocalizedName {

    private Map<Locale, String> localizedName = new HashMap<>();
    private String name;
    private String displayName;


    public Map<Locale, String> getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(Map<Locale, String> localizedName) {
        this.localizedName = localizedName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}

