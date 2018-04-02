package com.amadeus.betgroup.model.polla;

import com.amadeus.betgroup.model.tournament.Match;

public class PollaMatch {
    private Integer pollaMatchId;
    private Integer pollaHeaderId;
    private Integer matchId;
    private Match match;

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
