package com.amigoscode.notification.services;

import java.time.LocalDateTime;
import java.time.ZoneId;

import com.amigoscode.notification.domain.Notification;
import com.amigoscode.notification.domain.NotificationRequest;
import com.amigoscode.notification.repository.NotificationRepository;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    
    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void send(NotificationRequest notificationRequest){
        notificationRequest.setNotificationMessage("Costumer Notification");
        notificationRequest.setNotifyTime(LocalDateTime.now(ZoneId.systemDefault()));

        Notification notification = Notification.Builder
                                                .newBuilder()
                                                .notificationMessage(notificationRequest.getNotificationMessage())
                                                .notifyTime(notificationRequest.getNotifyTime())
                                                .build();
                                                
        notificationRepository.save(notification);
    }
}
