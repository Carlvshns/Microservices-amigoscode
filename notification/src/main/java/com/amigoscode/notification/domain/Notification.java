package com.amigoscode.notification.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Notification {
    
    @Id
    @SequenceGenerator(name = "notification_id_generator", sequenceName = "notification_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_sequence")
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

    public static final class Builder{
        
        private Integer id;
        private String notificationMessage;
        private LocalDateTime notifyTime;

        private Builder (){
        }

        public static Builder newBuilder(){
            return new Builder();
        }

        public Builder id(Integer id){
            this.id = id;
            return this;
        }


        public Builder notificationMessage(String notificationMessage){
            this.notificationMessage = notificationMessage;
            return this;
        }

        public Builder notifyTime(LocalDateTime notifyTime){
            this.notifyTime = notifyTime;
            return this;
        }

        public Notification build(){
            Notification notification = new Notification();
            notification.setId(id);
            notification.setNotificationMessage(notificationMessage);
            notification.setNotifyTime(notifyTime);
            return notification;
        }
    } 
}
