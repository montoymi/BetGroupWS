package com.amadeus.betgroup.model.template;

import java.util.Date;

public class TemplateEvent {
    private Integer templateEventId;
    private Integer eventNumber;
    private Integer templateId;
    private Date startDate;
    private Date endDate;
    private Integer status;

    public Integer getTemplateEventId() {
        return templateEventId;
    }

    public void setTemplateEventId(Integer templateEventId) {
        this.templateEventId = templateEventId;
    }

    public Integer getEventNumber() {
        return eventNumber;
    }

    public void setEventNumber(Integer eventNumber) {
        this.eventNumber = eventNumber;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
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

