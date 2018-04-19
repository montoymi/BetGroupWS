package com.amadeus.betgroup.model.polla;

import java.util.Date;

public class PollaEvent {
    private Integer pollaEventId;
    private Integer eventNumber;
    private Integer pollaHeaderId;
    private PollaHeader pollaHeader;
    private Date startDate;
    private Date endDate;
    private Integer status;

    public Integer getPollaEventId() {
        return pollaEventId;
    }

    public void setPollaEventId(Integer pollaEventId) {
        this.pollaEventId = pollaEventId;
    }

    public Integer getEventNumber() {
        return eventNumber;
    }

    public void setEventNumber(Integer eventNumber) {
        this.eventNumber = eventNumber;
    }

    public Integer getPollaHeaderId() {
        return pollaHeaderId;
    }

    public void setPollaHeaderId(Integer pollaHeaderId) {
        this.pollaHeaderId = pollaHeaderId;
    }

    public PollaHeader getPollaHeader() {
        return pollaHeader;
    }

    public void setPollaHeader(PollaHeader pollaHeader) {
        this.pollaHeader = pollaHeader;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
