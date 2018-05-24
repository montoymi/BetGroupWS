package com.amadeus.betgroup.model.polla;

import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.template.TemplateHeader;

import java.util.Date;
import java.util.List;

public class PollaHeader {
    private Integer pollaId;
    private String pollaName;
    private Integer templateHeaderId;
	private TemplateHeader templateHeader;
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
    private List<PollaEvent> pollaEventList;
    //Esto es para las modalidades de Juego
    private Integer modeWildcardFlag;
    private Integer numWildcards;
    private Integer modePollitaFlag;
    private Integer modePollaFlag;
    private String rules;

    private Date startDate;
    private Date endDate;
    private Integer total_bet;
    private Integer numParticipants;
    private Integer numEvents;
    private Integer numMatchs;

    private String lang;


	public TemplateHeader getTemplateHeader() {
		return templateHeader;
	}

	public void setTemplateHeader(TemplateHeader templateHeader) {
		this.templateHeader = templateHeader;
	}


	public Integer getNumEvents() {
        return numEvents;
    }

    public void setNumEvents(Integer numEvents) {
        this.numEvents = numEvents;
    }

    public Integer getNumMatchs() {
        return numMatchs;
    }

    public void setNumMatchs(Integer numMatchs) {
        this.numMatchs = numMatchs;
    }

    public Integer getNumParticipants() {
        return numParticipants;
    }

    public void setNumParticipants(Integer numParticipants) {
        this.numParticipants = numParticipants;
    }

    public List<PollaEvent> getPollaEventList() {
        return pollaEventList;
    }

    public void setPollaEventList(List<PollaEvent> pollaEventList) {
        this.pollaEventList = pollaEventList;
    }

    public String getBetgroupCode() {
        return betgroupCode;
    }

    public void setBetgroupCode(String betgroupCode) {
        this.betgroupCode = betgroupCode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getModeWildcardFlag() {
        return modeWildcardFlag;
    }

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

    public Integer getTotal_bet() {
        return total_bet;
    }

    public void setTotal_bet(Integer total_bet) {
        this.total_bet = total_bet;
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

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
