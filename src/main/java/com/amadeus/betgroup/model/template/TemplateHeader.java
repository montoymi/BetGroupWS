package com.amadeus.betgroup.model.template;

import com.amadeus.betgroup.model.tournament.Sport;

import java.util.Date;

public class TemplateHeader {

    private Integer templateHeaderId;
    private String templateName;
    private Integer status;
    private Integer sportId;
    private Sport sport;
    private String image;
    private Integer numWildcards;
    private Integer modeWildcardFlag;
    private Integer modePollitaFlag;
    private Integer modePollaFlag;
    private Date startDate;
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getNumWildcards() {
        return numWildcards;
    }

    public void setNumWildcards(Integer numWildcards) {
        this.numWildcards = numWildcards;
    }

    public Integer getModeWildcardFlag() {
        return modeWildcardFlag;
    }

    public void setModeWildcardFlag(Integer modeWildcardFlag) {
        this.modeWildcardFlag = modeWildcardFlag;
    }

    public Integer getModePollitaFlag() {
        return modePollitaFlag;
    }

    public void setModePollitaFlag(Integer modePollitaFlag) {
        this.modePollitaFlag = modePollitaFlag;
    }

    public Integer getModePollaFlag() {
        return modePollaFlag;
    }

    public void setModePollaFlag(Integer modePollaFlag) {
        this.modePollaFlag = modePollaFlag;
    }

    public Integer getTemplateHeaderId() {
        return templateHeaderId;
    }

    public void setTemplateHeaderId(Integer templateHeaderId) {
        this.templateHeaderId = templateHeaderId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSportId() {
        return sportId;
    }

    public void setSportId(Integer sportId) {
        this.sportId = sportId;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
