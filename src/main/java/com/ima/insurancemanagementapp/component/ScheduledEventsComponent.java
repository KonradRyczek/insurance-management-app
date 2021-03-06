package com.ima.insurancemanagementapp.component;

import com.ima.insurancemanagementapp.service.EmailReminderManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledEventsComponent {

    private EmailReminderManager emailReminderManager;

    public ScheduledEventsComponent(EmailReminderManager emailReminderManager) {
        this.emailReminderManager = emailReminderManager;
    }

    // TODO: add a logger class to the project.
    // private static final Logger LOGGER = Logger.getLogger(EventCreator.class.getName() );

    @Scheduled(cron = "0 0 8 * * ?")
    public void startReminderProcess() {
        // TODO: start this process whith a summary of reminders.
        emailReminderManager.sendReminders();
    }


//    @Scheduled(cron = "30 * * * * *")
//    public void test(){
//        emailReminderManager.sendReminders();
//   }


}
