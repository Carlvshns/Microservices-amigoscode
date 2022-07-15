package com.amigoscode.notification.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class NotificationRequest {
    
    @Id
    @SequenceGenerator(name = "notification_id_generator", sequenceName = "notification_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_sequence")
    private Integer id;

    private String notification;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotification() {
        return notification;
    }
    public void setNotification(String notification) {
        this.notification = notification;
    }
    
}
