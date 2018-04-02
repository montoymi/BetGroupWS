package com.amadeus.betgroup.model.account;

public class Friend {
    private Integer id;
    private Integer idUser;
    private User user;
    private Integer idFriend;
    private User amigo;
    private Integer status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getAmigo() {
        return amigo;
    }

    public void setAmigo(User amigo) {
        this.amigo = amigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdFriend() {
        return idFriend;
    }

    public void setIdFriend(Integer idFriend) {
        this.idFriend = idFriend;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
