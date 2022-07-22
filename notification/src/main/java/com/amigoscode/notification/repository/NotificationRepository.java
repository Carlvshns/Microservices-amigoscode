package com.amigoscode.notification.repository;

import org.springframework.stereotype.Repository;

import com.amigoscode.notification.domain.Notification;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer>{
    
}
