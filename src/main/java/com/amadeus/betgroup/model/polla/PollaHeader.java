package com.amadeus.betgroup.model.polla;

import java.util.List;

public class PollaHeader {
    private Integer pollaId;
    private String pollaName;
    private Integer templateHeaderId;
    private Integer adminId;
    private Integer pollaCost;
    private Integer enabled_flag;
    private Integer accessFlag; // 0: publico ; 1: private
    private String password;
    private Integer costFlag;

    private List<PollaMatch> pollaMatchesList;

    public List<PollaMatch> getPollaMatchesList() {
        return pollaMatchesList;
    }

    public void setPollaMatchesList(List<PollaMatch> pollaMatchesList) {
        this.pollaMatchesList = pollaMatchesList;
    }

    public Integer getPollaId() {
        return pollaId;
    }

    public void setPollaId(Integer pollaId) {
        this.pollaId = pollaId;
    }

    public String getPollaName() {
        return pollaName;
    }

    public void setPollaName(String pollaName) {
        this.pollaName = pollaName;
    }

    public Integer getTemplateHeaderId() {
        return templateHeaderId;
    }

    public void setTemplateHeaderId(Integer templateHeaderId) {
        this.templateHeaderId = templateHeaderId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getPollaCost() {
        return pollaCost;
    }

    public void setPollaCost(Integer pollaCost) {
        this.pollaCost = pollaCost;
    }

    public Integer getEnabled_flag() {
        return enabled_flag;
    }

    public void setEnabled_flag(Integer enabled_flag) {
        this.enabled_flag = enabled_flag;
    }

    public Integer getAccessFlag() {
        return accessFlag;
    }

    public void setAccessFlag(Integer accessFlag) {
        this.accessFlag = accessFlag;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCostFlag() {
        return costFlag;
    }

    public void setCostFlag(Integer costFlag) {
        this.costFlag = costFlag;
    }
}
