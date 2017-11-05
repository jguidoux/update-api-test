package com.example.demo;


import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.github.jonpeterson.jackson.module.versioning.JsonSerializeToVersion;
import com.github.jonpeterson.jackson.module.versioning.JsonVersionedModel;

@JsonVersionedModel(currentVersion = "3", toCurrentConverterClass = ToCurrentCarConverter.class,
        toPastConverterClass = ToPastCarConverter.class)
class Car {

    private String make;
    private String model;
    private int year;
    private boolean used;

    private LocalizedStrings localizedNameOld = new LocalizedStrings();

    @JsonUnwrapped
    private LocalizedName localizedName = new LocalizedName();


    @JsonSerializeToVersion
    private String serializeToVersion;

    public Car() {
    }


    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", used=" + used +
                ", serializeToVersion='" + serializeToVersion + '\'' +
                '}';
    }

    private Car(String make, String model, int year, boolean used, String serializeToVersion) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.used = used;
        this.serializeToVersion = serializeToVersion;
    }

    public String getMake() {
        return make;
    }

    public Car setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Car setYear(int year) {
        this.year = year;
        return this;
    }

    public boolean isUsed() {
        return used;
    }

    public Car setUsed(boolean used) {
        this.used = used;
        return this;
    }

    public LocalizedStrings getLocalizedNameOld() {
        return localizedNameOld;
    }

    public void setLocalizedNameOld(LocalizedStrings localizedNameOld) {
        this.localizedNameOld = localizedNameOld;
    }

    public String getSerializeToVersion() {
        return serializeToVersion;
    }

    public void setSerializeToVersion(String serializeToVersion) {
        this.serializeToVersion = serializeToVersion;
    }


    public LocalizedName getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(LocalizedName localizedName) {
        this.localizedName = localizedName;
    }

    public static class CarBuilder {
        private String make;
        private String model;
        private int year;
        private boolean used;
        private String version = "3";


        public Car createCar() {
            return new Car(make, model, year, used, version);
        }


        public CarBuilder setMake(String make) {
            this.make = make;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public CarBuilder setVersion(String version) {
            this.version = version;
            return this;
        }

        public CarBuilder setUsed(boolean used) {
            this.used = used;
            return this;
        }
    }
}
