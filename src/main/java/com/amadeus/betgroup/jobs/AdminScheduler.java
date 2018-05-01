package com.amadeus.betgroup.jobs;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class AdminScheduler {

    public static void main ( String args[] ) throws SchedulerException{
        JobDetail j = JobBuilder.newJob( PollaScheduler.class ).build();
        Trigger t = TriggerBuilder.newTrigger().withIdentity("CronePolla").
                withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(02).repeatForever()).build();

        Scheduler s = StdSchedulerFactory.getDefaultScheduler();

        s.start();
        s.scheduleJob(j,t);


    }
}
