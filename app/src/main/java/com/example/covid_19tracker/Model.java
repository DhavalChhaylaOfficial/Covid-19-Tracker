package com.example.covid_19tracker;

public class Model {
    private String districtName;
    private int confirmedCases;
    private int activeCases;
    private int recoveredCases;
    private int deceasedCases;

    public Model(String districtName, int confirmedCases, int activeCases, int recoveredCases, int deceasedCases) {
        this.districtName = districtName;
        this.confirmedCases = confirmedCases;
        this.activeCases = activeCases;
        this.recoveredCases = recoveredCases;
        this.deceasedCases = deceasedCases;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public int getConfirmedCases() {
        return confirmedCases;
    }

    public void setConfirmedCases(int confirmedCases) {
        this.confirmedCases = confirmedCases;
    }

    public int getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(int activeCases) {
        this.activeCases = activeCases;
    }

    public int getRecoveredCases() {
        return recoveredCases;
    }

    public void setRecoveredCases(int recoveredCases) {
        this.recoveredCases = recoveredCases;
    }

    public int getDeceasedCases() {
        return deceasedCases;
    }

    public void setDeceasedCases(int deceasedCases) {
        this.deceasedCases = deceasedCases;
    }
}


