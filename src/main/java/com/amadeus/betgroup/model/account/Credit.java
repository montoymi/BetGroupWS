package com.amadeus.betgroup.model.account;

import java.util.List;

public class Credit {
    private Integer userId;
    private User user;
    private Integer totalCreditos;

    private List<CreditDetail> creditDetail;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getTotalCreditos() {
        return totalCreditos;
    }

    public void setTotalCreditos(Integer totalCreditos) {
        this.totalCreditos = totalCreditos;
    }

    public List<CreditDetail> getCreditDetail() {
        return creditDetail;
    }

    public void setCreditDetail(List<CreditDetail> creditDetail) {
        this.creditDetail = creditDetail;
    }
}
