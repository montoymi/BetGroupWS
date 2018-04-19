package com.amadeus.betgroup.model.polla;

import com.amadeus.betgroup.model.template.TemplateDetail;
import com.amadeus.betgroup.model.tournament.Match;

import java.util.Date;
import java.util.List;

public class PollaMatch {
    private Integer pollaMatchId;
    private Integer pollaHeaderId;
    private PollaHeader pollaHeader;
    private Integer matchId;
    private Match match;

    private List<PollaBet> pollaBetList;
    private Integer pollaEventId;
    private PollaEvent pollaEvent;

    private Integer lastUpdatedBy;
    private Date lastUpdatedDate;

    public Integer getPollaEventId() {
        return pollaEventId;
    }

    public void setPollaEventId(Integer pollaEventId) {
        this.pollaEventId = pollaEventId;
    }

    public PollaEvent getPollaEvent() {
        return pollaEvent;
    }

    public void setPollaEvent(PollaEvent pollaEvent) {
        this.pollaEvent = pollaEvent;
    }

    public PollaHeader getPollaHeader() {
        return pollaHeader;
    }

    public void setPollaHeader(PollaHeader pollaHeader) {
        this.pollaHeader = pollaHeader;
    }

    public List<PollaBet> getPollaBetList() {
        return pollaBetList;
    }

    public void setPollaBetList(List<PollaBet> pollaBetList) {
        this.pollaBetList = pollaBetList;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Integer getPollaMatchId() {
        return pollaMatchId;
    }

    public void setPollaMatchId(Integer pollaMatchId) {
        this.pollaMatchId = pollaMatchId;
    }

    public Integer getPollaHeaderId() {
        return pollaHeaderId;
    }

    public void setPollaHeaderId(Integer pollaHeaderId) {
        this.pollaHeaderId = pollaHeaderId;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }
}
