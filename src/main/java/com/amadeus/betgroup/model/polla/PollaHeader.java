package com.amadeus.betgroup.model.polla;

import com.amadeus.betgroup.model.account.User;

import java.util.List;

public class PollaHeader {
    private Integer pollaId;
    private String pollaName;
    private Integer templateHeaderId;

    public String getBetgroupCode() {
        return betgroupCode;
    }

    public void setBetgroupCode(String betgroupCode) {
        this.betgroupCode = betgroupCode;
    }

    private String betgroupCode;
    private Integer adminId;
    private User admin;
    private Integer pollaCost;
    private Integer enabled_flag;
    private Integer accessFlag; // 0: publico ; 1: private
    private String password;
    private Integer costFlag;
    private String image;
    private List<PollaMatch> pollaMatchList;
    private List<PollaParticipant> pollaParticipantList;
    //Esto es para las modalidades de Juego
    private Integer modeWildcardFlag;
    private Integer numWildcards;
    private Integer modePollitaFlag;
    private Integer modePollaFlag;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getModeWildcardFlag() {
        return modeWildcardFlag;
    }

    public void setModeWildcardFlag(Integer wildcardFlag) {
        this.modeWildcardFlag = wildcardFlag;
    }

    public Integer getNumWildcards() {
        return numWildcards;
    }

    public void setNumWildcards(Integer numWildcards) {
        this.numWildcards = numWildcards;
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

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public List<PollaParticipant> getPollaParticipantList() {
        return pollaParticipantList;
    }

    public void setPollaParticipantList(List<PollaParticipant> pollaParticipantList) {
        this.pollaParticipantList = pollaParticipantList;
    }

    public List<PollaMatch> getPollaMatchList() {
        return pollaMatchList;
    }

    public void setPollaMatchList(List<PollaMatch> pollaMatchList) {
        this.pollaMatchList = pollaMatchList;
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
