package com.amigoscode.notification.domain;

import java.time.LocalDateTime;

public class NotificationRequest {
    
    private Integer id;

    private String notificationMessage;

    private LocalDateTime notifyTime;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getNotifyTime() {
        return notifyTime;
    }
    public void setNotifyTime(LocalDateTime notifyTime) {
        this.notifyTime = notifyTime;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }
    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }
    
}
