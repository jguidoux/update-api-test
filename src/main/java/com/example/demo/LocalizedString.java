package com.example.demo;

import java.util.Locale;

public class LocalizedString {

    private Locale locale;
    private String value;

    public LocalizedString(Locale locale, String value) {
        this.locale = locale;
        this.value = value;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
