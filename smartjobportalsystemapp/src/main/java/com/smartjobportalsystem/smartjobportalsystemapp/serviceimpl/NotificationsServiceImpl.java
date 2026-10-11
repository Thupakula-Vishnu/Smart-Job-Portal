package com.smartjobportalsystem.smartjobportalsystemapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartjobportalsystem.smartjobportalsystemapp.exception.ResourceNotFoundException;
import com.smartjobportalsystem.smartjobportalsystemapp.model.Notifications;
import com.smartjobportalsystem.smartjobportalsystemapp.repository.NotificationsRepository;
import com.smartjobportalsystem.smartjobportalsystemapp.service.NotificationsService;

@Service
public class NotificationsServiceImpl
        implements NotificationsService {

    @Autowired
    private NotificationsRepository notificationsRepository;

    // INSERT NOTIFICATION
    @Override
    public Notifications insertNotification(
            Notifications notification) {

        return notificationsRepository.save(notification);
    }

    // GET ALL NOTIFICATIONS
    @Override
    public List<Notifications> getNotifications() {

        return notificationsRepository.findAll();
    }

    // GET NOTIFICATION BY ID
    @Override
    public Notifications getNotificationsById(
            Integer id) {

        return notificationsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Notification not found with id : " + id
                    )
                );
    }

    // GET NOTIFICATIONS BY USER
    @Override
    public List<Notifications> getNotificationsByUser(
            Integer userId) {

        return notificationsRepository.findByUserId(userId);
    }

    // GET BY READ STATUS
    @Override
    public List<Notifications> findByIsRead(
            Boolean isRead) {

        return notificationsRepository.findByIsRead(isRead);
    }

    // UPDATE COMPLETE NOTIFICATION
    @Override
    public Notifications updateNotification(
            Integer id,
            Notifications notification) {

        Notifications existingNotification =
                notificationsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Notification not found with id : " + id
                    )
                );

        existingNotification.setMessage(
                notification.getMessage()
        );

        existingNotification.setIsRead(
                notification.getIsRead()
        );

        existingNotification.setCreatedDate(
                notification.getCreatedDate()
        );

        existingNotification.setUser(
                notification.getUser()
        );

        return notificationsRepository.save(
                existingNotification
        );
    }

    // UPDATE MESSAGE
    @Override
    public Notifications updateNotificationByMessage(
            Integer id,
            String message) {

        Notifications notification =
                notificationsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Notification not found with id : " + id
                    )
                );

        notification.setMessage(message);

        return notificationsRepository.save(notification);
    }

    // UPDATE READ STATUS
    @Override
    public Notifications updateNotificationByIsRead(
            Integer id,
            Boolean isRead) {

        Notifications notification =
                notificationsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Notification not found with id : " + id
                    )
                );

        notification.setIsRead(isRead);

        return notificationsRepository.save(notification);
    }

    // DELETE NOTIFICATION
    @Override
    public String deleteNotification(Integer id) {

        Notifications notification =
                notificationsRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Notification not found with id : " + id
                    )
                );

        notificationsRepository.delete(notification);

        return "Notification deleted successfully";
    }
}