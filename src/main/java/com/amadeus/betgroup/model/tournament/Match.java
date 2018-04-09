package com.amadeus.betgroup.model.tournament;

import java.util.Date;

public class Match {
    private Integer groupId;
    private Group group;

    private Integer localId;
    private Team localTeam;
    private Integer visitorId;
    private Team visitorTeam;

    private Integer matchId;

    private String matchCode;
    private Date matchDate;
    private String matchPlace;
    private String resultMatch;
    private Integer scoreLocal;
    private Integer scoreVisitor;
    private String enabled_flag;

    private Date lastUpdatedDate;
    private Integer lastUpdatedBy;

    public String getMatchCode() {
        return matchCode;
    }

    public void setMatchCode(String matchCode) {
        this.matchCode = matchCode;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(int lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getMatch_code() {
        return match_code;
    }

    public void setMatch_code(String match_code) {
        this.match_code = match_code;
    }

    private String match_code;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Integer getLocalId() {
        return localId;
    }

    public void setLocalId(Integer localId) {
        this.localId = localId;
    }

    public Team getLocalTeam() {
        return localTeam;
    }

    public void setLocalTeam(Team localTeam) {
        this.localTeam = localTeam;
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public Team getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(Team visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getMatchPlace() {
        return matchPlace;
    }

    public void setMatchPlace(String matchPlace) {
        this.matchPlace = matchPlace;
    }

    public String getResultMatch() {
        return resultMatch;
    }

    public void setResultMatch(String resultMatch) {
        this.resultMatch = resultMatch;
    }

    public Integer getScoreLocal() {
        return scoreLocal;
    }

    public void setScoreLocal(Integer scoreLocal) {
        this.scoreLocal = scoreLocal;
    }

    public Integer getScoreVisitor() {
        return scoreVisitor;
    }

    public void setScoreVisitor(Integer scoreVisitor) {
        this.scoreVisitor = scoreVisitor;
    }

    public String getEnabled_flag() {
        return enabled_flag;
    }

    public void setEnabled_flag(String enabled_flag) {
        this.enabled_flag = enabled_flag;
    }
}
