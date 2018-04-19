package com.amadeus.betgroup.model.polla;

import com.amadeus.betgroup.model.account.User;

import java.util.Date;
import java.util.List;

public class PollaParticipant {
    private Integer pollaParticipantId;
    private Integer pollaHeaderId;
    private Integer userId;
    private User user;
    private Date inscriptionDate;
    private Integer paymentStatus;
    private Integer total;
    private Integer earnings;
    private Integer position;
    private Integer status;

    private Integer numWildCardsLeft;
    private Integer numWildCards;

    public Integer getNumWildCardsLeft() {
        return numWildCardsLeft;
    }

    public void setNumWildCardsLeft(Integer numWildCardsLeft) {
        this.numWildCardsLeft = numWildCardsLeft;
    }

    public Integer getNumWildCards() {
        return numWildCards;
    }

    public void setNumWildCards(Integer numWildCards) {
        this.numWildCards = numWildCards;
    }

    private PollaHeader pollaHeader;

    private List<PollaBet> pollaBetList;

    public List<PollaBet> getPollaBetList() {
        return pollaBetList;
    }

    public void setPollaBetList(List<PollaBet> pollaBetList) {
        this.pollaBetList = pollaBetList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPollaParticipantId() {
        return pollaParticipantId;
    }

    public void setPollaParticipantId(Integer pollaParticipantId) {
        this.pollaParticipantId = pollaParticipantId;
    }

    public Integer getPollaHeaderId() {
        return pollaHeaderId;
    }

    public void setPollaHeaderId(Integer pollaHeaderId) {
        this.pollaHeaderId = pollaHeaderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getInscriptionDate() {
        return inscriptionDate;
    }

    public void setInscriptionDate(Date inscriptionDate) {
        this.inscriptionDate = inscriptionDate;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getEarnings() {
        return earnings;
    }

    public void setEarnings(Integer earnings) {
        this.earnings = earnings;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public PollaHeader getPollaHeader() {
        return pollaHeader;
    }

    public void setPollaHeader(PollaHeader pollaHeader) {
        this.pollaHeader = pollaHeader;
    }
}
