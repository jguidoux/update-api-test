package com.example.demo;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocalizedStrings {

    private List<LocalizedString> localizedString = new ArrayList<>();


    public LocalizedStrings() {
    }

    @JsonValue
    public List<LocalizedString> getLocalizedString() {
        return localizedString;
    }

    public void setLocalizedString(List<LocalizedString> localizedString) {
        this.localizedString = localizedString;
    }

    public void add(Locale locale, String value) {
        localizedString.add(new LocalizedString(locale, value));
    }
}
