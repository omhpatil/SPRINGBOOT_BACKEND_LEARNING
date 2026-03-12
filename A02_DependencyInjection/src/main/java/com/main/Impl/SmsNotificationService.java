package com.main.Impl;

import com.main.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary                      // use @Primary or @Qualifier
@Component
//@Qualifier("smsNotify")
//@ConditionalOnProperty(name="notificationService.type", havingValue = "sms")
public class SmsNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("SMS Sending : "+  message);
    }
}
