package com.amigoscode.notification.repository;

import com.amigoscode.notification.domain.Notification;
import com.amigoscode.notification.utils.NotificationCreator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Tests for Notification Repository")
public class NotificationRepositoryTest {

    @Autowired
    private NotificationRepository notificationRepository;

    @Test
    @DisplayName("SaveAndFlush persists Notification when Sucessful")
    void save_PersistNotification_WhenSucessful(){
        Notification notificationToBeSaved = NotificationCreator.notificationCreator();

        Notification notificationSaved = this.notificationRepository.saveAndFlush(notificationToBeSaved);

        Assertions.assertNotNull(notificationSaved);

        Assertions.assertNotNull(notificationSaved.getId());

        Assertions.assertEquals(notificationSaved.getNotificationMessage(), notificationToBeSaved.getNotificationMessage());
    }
}
