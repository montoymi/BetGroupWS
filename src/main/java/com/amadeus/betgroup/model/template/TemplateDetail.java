package com.amadeus.betgroup.model.template;


import com.amadeus.betgroup.model.tournament.Match;

public class TemplateDetail {
    private Integer templateDetailId;
    private Integer templateHeaderId;
    private Integer matchId;
    private Match match;

    public Integer getTemplateDetailId() {
        return templateDetailId;
    }

    public void setTemplateDetailId(Integer templateDetailId) {
        this.templateDetailId = templateDetailId;
    }

    public Integer getTemplateHeaderId() {
        return templateHeaderId;
    }

    public void setTemplateHeaderId(Integer templateHeaderId) {
        this.templateHeaderId = templateHeaderId;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
