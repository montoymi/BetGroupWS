package com.amadeus.betgroup.model.tournament;

import java.util.Date;
import java.util.List;

public class Tournament {

    private Integer sportId;
    private Sport sport;
    private Integer tournamentId;
    private String tournamentName;
    private Integer enabled_flag;
    private Date startDate;
    private List<Phase> phaseList;

    public List<Phase> getPhaseList() {
        return phaseList;
    }

    public void setPhaseList(List<Phase> phaseList) {
        this.phaseList = phaseList;
    }

    public Integer getSportId() {
        return sportId;
    }

    public void setSportId(Integer sportId) {
        this.sportId = sportId;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public Integer getEnabled_flag() {
        return enabled_flag;
    }

    public void setEnabled_flag(Integer enabled_flag) {
        this.enabled_flag = enabled_flag;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
