package com.amadeus.betgroup.model.config;

import java.util.Date;

public class ParamType {
    private String appCode;
    private String paramType;
    private String paramTypeDescription;
    private String enablad_flag;
    private Date enabledFrom;
    private Date enabledTo;
    private Date creationDate;
    private Integer createdBy;
    private Date LastUpdatedDate;
    private Integer LastUpdatedBy;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getParamTypeDescription() {
        return paramTypeDescription;
    }

    public void setParamTypeDescription(String paramTypeDescription) {
        this.paramTypeDescription = paramTypeDescription;
    }

    public String getEnablad_flag() {
        return enablad_flag;
    }

    public void setEnablad_flag(String enablad_flag) {
        this.enablad_flag = enablad_flag;
    }

    public Date getEnabledFrom() {
        return enabledFrom;
    }

    public void setEnabledFrom(Date enabledFrom) {
        this.enabledFrom = enabledFrom;
    }

    public Date getEnabledTo() {
        return enabledTo;
    }

    public void setEnabledTo(Date enabledTo) {
        this.enabledTo = enabledTo;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdatedDate() {
        return LastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        LastUpdatedDate = lastUpdatedDate;
    }

    public Integer getLastUpdatedBy() {
        return LastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        LastUpdatedBy = lastUpdatedBy;
    }
}
