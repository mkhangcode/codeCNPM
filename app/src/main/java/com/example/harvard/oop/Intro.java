package com.example.harvard.oop;

public class Intro {
    private int resourceID;
    private String txtTittle;
    private String txtDescription;

    public Intro(int resourceID, String txtTittle, String txtDescription) {
        this.resourceID = resourceID;
        this.txtTittle = txtTittle;
        this.txtDescription = txtDescription;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String gettxtTittle() {
        return txtTittle;
    }

    public void settxtTittle(String txtTittle) {
        this.txtTittle = txtTittle;
    }

    public String gettxtDescription() {
        return txtDescription;
    }

    public void settxtDescription(String txtDescription) {
        this.txtDescription = txtDescription;
    }
}
