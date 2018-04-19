package com.amadeus.betgroup.model.polla;

public class PollaEventParticipant {
    private Integer pollaParticipantId;
    private PollaParticipant pollaParticipant;
    private Integer pollaEventId;
    private PollaEvent pollaEvent;
    private Integer total_points;
    private Integer position;

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

    public Integer getTotal_points() {
        return total_points;
    }

    public void setTotal_points(Integer total_points) {
        this.total_points = total_points;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
