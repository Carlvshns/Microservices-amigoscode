package com.amigoscode.notification.endpoint;

import com.amigoscode.notification.domain.NotificationRequest;
import com.amigoscode.notification.services.NotificationService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {
    
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        System.out.println("New notification... "+notificationRequest);
        notificationService.send(notificationRequest);
    }

}
