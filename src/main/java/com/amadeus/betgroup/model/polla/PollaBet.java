package com.amadeus.betgroup.model.polla;

import java.util.Date;

public class PollaBet {
    private Integer idBet;
    private Integer pollaMatchId;
    private PollaMatch pollaMatch;
    private Integer pollaParticipantId;
    private PollaParticipant pollaParticipant;
    private Integer localBetScore;
    private Integer visitorBetScore;
    private Date updatedDate;;
    private Integer points;
    private Integer status;
    private String resultBet;

    public Integer getIdBet() {
        return idBet;
    }

    public void setIdBet(Integer idBet) {
        this.idBet = idBet;
    }

    public Integer getPollaMatchId() {
        return pollaMatchId;
    }

    public void setPollaMatchId(Integer pollaMatchId) {
        this.pollaMatchId = pollaMatchId;
    }

    public PollaMatch getPollaMatch() {
        return pollaMatch;
    }

    public void setPollaMatch(PollaMatch pollaMatch) {
        this.pollaMatch = pollaMatch;
    }

    public Integer getPollaParticipantId() {
        return pollaParticipantId;
    }

    public void setPollaParticipantId(Integer pollaParticipantId) {
        this.pollaParticipantId = pollaParticipantId;
    }

    public PollaParticipant getPollaParticipant() {
        return pollaParticipant;
    }

    public void setPollaParticipant(PollaParticipant pollaParticipant) {
        this.pollaParticipant = pollaParticipant;
    }

    public Integer getLocalBetScore() {
        return localBetScore;
    }

    public void setLocalBetScore(Integer localBetScore) {
        this.localBetScore = localBetScore;
    }

    public Integer getVisitorBetScore() {
        return visitorBetScore;
    }

    public void setVisitorBetScore(Integer visitorBetScore) {
        this.visitorBetScore = visitorBetScore;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResultBet() {
        return resultBet;
    }

    public void setResultBet(String resultBet) {
        this.resultBet = resultBet;
    }
}
