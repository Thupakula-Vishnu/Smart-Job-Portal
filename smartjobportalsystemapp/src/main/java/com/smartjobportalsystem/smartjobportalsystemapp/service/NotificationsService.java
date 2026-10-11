package com.smartjobportalsystem.smartjobportalsystemapp.service;

import java.util.List;

import com.smartjobportalsystem.smartjobportalsystemapp.model.Notifications;

public interface NotificationsService {

    Notifications insertNotification(Notifications notification);

    List<Notifications> getNotifications();

    Notifications getNotificationsById(Integer id);

    List<Notifications> getNotificationsByUser(Integer userId);

    List<Notifications> findByIsRead(Boolean isRead);

    Notifications updateNotification(
            Integer id,
            Notifications notification);

    Notifications updateNotificationByMessage(
            Integer id,
            String message);

    Notifications updateNotificationByIsRead(
            Integer id,
            Boolean isRead);

    String deleteNotification(Integer id);
}