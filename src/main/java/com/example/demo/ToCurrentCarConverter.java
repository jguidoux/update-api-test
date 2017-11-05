package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.jonpeterson.jackson.module.versioning.VersionedModelConverter;

public class ToCurrentCarConverter implements VersionedModelConverter{
    @Override
    public ObjectNode convert(ObjectNode modelData, String modelVersion, String targetModelVersion, JsonNodeFactory nodeFactory) {
        int version = Integer.valueOf(modelVersion);

        // version 1 had a single 'model' field that combined 'make' and 'model' with a colon delimiter
        if(version <= 1) {
            modelData.remove("name");
        }

        // version 1-2 had a 'new' text field instead of a boolean 'used' field
        if (version <= 2) {
        }

        modelData.remove("localizedNameOld");


        return modelData;
    }




}
