package com.smartjobportalsystem.smartjobportalsystemapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartjobportalsystem.smartjobportalsystemapp.model.Notifications;

public interface NotificationsRepository
        extends JpaRepository<Notifications, Integer> {

    List<Notifications> findByUserId(Integer userId);

    List<Notifications> findByIsRead(Boolean isRead);
}