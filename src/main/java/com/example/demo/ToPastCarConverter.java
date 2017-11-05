package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.jonpeterson.jackson.module.versioning.VersionedModelConverter;

public class ToPastCarConverter implements VersionedModelConverter {
    @Override
    public ObjectNode convert(ObjectNode modelData, String modelVersion, String targetModelVersion, JsonNodeFactory nodeFactory) {
        // model version is an int
        int version = Integer.valueOf(modelVersion);
        int targetVersion = Integer.valueOf(targetModelVersion);

        // version 1 had a single 'model' field that combined 'make' and 'model' with a colon delimiter
        if (targetVersion <= 1 && version > 1) {
            JsonNode name = modelData.get("localizedNameOld");
            modelData.remove("localizedName");
            modelData.remove("localizedNameOld");
            modelData.remove("displayName");
            modelData.replace("name", name);
        }

        // version 1-2 had a 'new' text field instead of a boolean 'used' field
        if (targetVersion == 2 && version > 2) {

            JsonNode localizedName = modelData.get("localizedNameOld");
            modelData.remove("localizedNameOld");
            modelData.replace("localizedName", localizedName);

        }

        if (targetVersion == 3 && version > 2) {

            JsonNode localizedName = modelData.get("localizedNameOld");
            modelData.remove("localizedNameOld");
            modelData.replace("localizedName", localizedName);

        }
        return modelData;
    }
}
