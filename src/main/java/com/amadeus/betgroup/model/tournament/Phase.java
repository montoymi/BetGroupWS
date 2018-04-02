package com.amadeus.betgroup.model.tournament;

import java.util.List;

public class Phase {
    private Integer tournamentId;
    private Tournament tournament;
    private Integer phaseId;
    private String phaseName;
    private Integer phaseNumber;
    private String enabled_flag;
    private List<Group> groupList;

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Integer getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Integer phaseId) {
        this.phaseId = phaseId;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    public Integer getPhaseNumber() {
        return phaseNumber;
    }

    public void setPhaseNumber(Integer phaseNumber) {
        this.phaseNumber = phaseNumber;
    }

    public String getEnabled_flag() {
        return enabled_flag;
    }

    public void setEnabled_flag(String enabled_flag) {
        this.enabled_flag = enabled_flag;
    }
}
