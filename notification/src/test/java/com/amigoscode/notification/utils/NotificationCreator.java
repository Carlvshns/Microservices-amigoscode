package com.amigoscode.notification.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;

import com.amigoscode.notification.domain.Notification;

public class NotificationCreator {

    public static Notification notificationCreator(){
        Notification notification = new  Notification();
        notification.setId(1);
        notification.setNotificationMessage("Customer Notification");
        notification.setNotifyTime(LocalDateTime.now(ZoneId.systemDefault()));
        return notification;
    }
}
