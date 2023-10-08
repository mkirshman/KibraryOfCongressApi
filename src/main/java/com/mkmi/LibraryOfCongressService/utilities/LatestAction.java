package com.mkmi.LibraryOfCongressService.utilities;
import javax.xml.bind.annotation.XmlElement;

public class LatestAction {
    private String actionDate;
    private String text;

    // Add getters and setters for the above fields

    @XmlElement(name = "actionDate")
    public String getActionDate() {
        return actionDate;
    }

    @XmlElement(name = "text")
    public String getText() {
        return text;
    }
}