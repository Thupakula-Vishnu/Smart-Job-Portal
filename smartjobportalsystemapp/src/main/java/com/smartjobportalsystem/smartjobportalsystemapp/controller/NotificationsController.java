package com.smartjobportalsystem.smartjobportalsystemapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjobportalsystem.smartjobportalsystemapp.model.Notifications;
import com.smartjobportalsystem.smartjobportalsystemapp.service.NotificationsService;

@RestController
@RequestMapping("/notification/api")
public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;

    @PostMapping("/insertNotification")
    public Notifications insertNotification(
            @RequestBody Notifications notification) {

        return notificationsService.insertNotification(notification);
    }

    @GetMapping("/getAllNotifications")
    public List<Notifications> getNotifications() {

        return notificationsService.getNotifications();
    }

    @GetMapping("/getNotificationById/{id}")
    public Notifications getNotificationsById(
            @PathVariable Integer id) {

        return notificationsService.getNotificationsById(id);
    }

    @GetMapping("/getNotificationsByUser/{userId}")
    public List<Notifications> getNotificationsByUser(
            @PathVariable Integer userId) {

        return notificationsService.getNotificationsByUser(userId);
    }

    @GetMapping("/getNotificationsByRead/{isRead}")
    public List<Notifications> findByIsRead(
            @PathVariable Boolean isRead) {

        return notificationsService.findByIsRead(isRead);
    }

    @PutMapping("/updateNotification/{id}")
    public Notifications updateNotification(
            @PathVariable Integer id,
            @RequestBody Notifications notification) {

        return notificationsService.updateNotification(
                id, notification);
    }

    @PatchMapping("/updateNotificationByMessage/{id}")
    public Notifications updateNotificationByMessage(
            @PathVariable Integer id,
            @RequestBody String message) {

        return notificationsService.updateNotificationByMessage(
                id, message);
    }

    @PatchMapping("/updateNotificationByIsRead/{id}/{isRead}")
    public Notifications updateNotificationByIsRead(
            @PathVariable Integer id,
            @PathVariable Boolean isRead) {

        return notificationsService.updateNotificationByIsRead(
                id, isRead);
    }

    @DeleteMapping("/deleteNotification/{id}")
    public String deleteNotification(
            @PathVariable Integer id) {

        return notificationsService.deleteNotification(id);
    }
}