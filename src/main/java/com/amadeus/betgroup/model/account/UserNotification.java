package com.amadeus.betgroup.model.account;

import com.amadeus.betgroup.model.config.NotificationTemplate;
import com.amadeus.betgroup.model.polla.PollaHeader;

import java.util.Date;

public class UserNotification {
    private Integer userNotificationId;
    private String notificationCode;
    private NotificationTemplate notificationTemplate;
    private User user;
    private Date notificationDate;
    private Integer pollaHeaderId;
    private PollaHeader pollaHeader;
}
