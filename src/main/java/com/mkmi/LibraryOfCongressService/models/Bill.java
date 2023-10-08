package com.mkmi.LibraryOfCongressService.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mkmi.LibraryOfCongressService.utilities.LatestAction;

@XmlRootElement(name = "bill")
public class Bill {
    private String congress;
    private String type;
    private String originChamber;
    private String originChamberCode;
    private String number;
    private String url;
    private String title;
    private String updateDateIncludingText;
    private LatestAction latestAction;
    private String updateDate;

    @XmlElement(name = "congress")
    public String getCongress() {
        return congress;
    }

    public void setCongress(String congress) {
        this.congress = congress;
    }

    @XmlElement(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name = "originChamber")
    public String getOriginChamber() {
        return originChamber;
    }

    public void setOriginChamber(String originChamber) {
        this.originChamber = originChamber;
    }

    @XmlElement(name = "originChamberCode")
    public String getOriginChamberCode() {
        return originChamberCode;
    }

    public void setOriginChamberCode(String originChamberCode) {
        this.originChamberCode = originChamberCode;
    }

    @XmlElement(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @XmlElement(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "updateDateIncludingText")
    public String getUpdateDateIncludingText() {
        return updateDateIncludingText;
    }
    public void setUpdateDateIncludingText(String updateDateIncludingText) {
        this.updateDateIncludingText = updateDateIncludingText;
    }

    @XmlElement(name = "latestAction")
    public LatestAction getLatestAction() {
        return latestAction;
    }

    public void setLatestAction(LatestAction latestAction) {
        this.latestAction = latestAction;
    }

    @XmlElement(name = "updateDate")
    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}

