package com.Model;

public class Registration {
    private String MSISDN;
    private String SIM_TYPE;
    private String NAME;
    private String DATE_OF_BIRTH;
    private String GENDER;
    private String ADDRESS;
    private String ID_NUMBER;

    public String getMSISDN() {
        return MSISDN;
    }

    public void setMSISDN(String MSISDN) {
        this.MSISDN = MSISDN;
    }

    public String getSIM_TYPE() {
        return SIM_TYPE;
    }

    public void setSIM_TYPE(String SIM_TYPE) {
        this.SIM_TYPE = SIM_TYPE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDATE_OF_BIRTH() {
        return DATE_OF_BIRTH;
    }

    public void setDATE_OF_BIRTH(String DATE_OF_BIRTH) {
        this.DATE_OF_BIRTH = DATE_OF_BIRTH;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getID_NUMBER() {
        return ID_NUMBER;
    }

    public void setID_NUMBER(String ID_NUMBER) {
        this.ID_NUMBER = ID_NUMBER;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "MSISDN='" + MSISDN + '\'' +
                ", SIM_TYPE='" + SIM_TYPE + '\'' +
                ", NAME='" + NAME + '\'' +
                ", DATE_OF_BIRTH='" + DATE_OF_BIRTH + '\'' +
                ", GENDER='" + GENDER + '\'' +
                ", ADDRESS='" + ADDRESS + '\'' +
                ", ID_NUMBER='" + ID_NUMBER + '\'' +
                '}';
    }
}
