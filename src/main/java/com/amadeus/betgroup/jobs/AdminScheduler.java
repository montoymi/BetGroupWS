package com.amadeus.betgroup.jobs;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.List;

public class AdminScheduler {

    public static void main ( String args[] ) throws SchedulerException{


        JobDetail j = JobBuilder.newJob( PollaScheduler.class ).build();
        Trigger t = TriggerBuilder.newTrigger().withIdentity("JobPollaHeaderStatus").
                withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(5).repeatForever()).build();

        Scheduler s = StdSchedulerFactory.getDefaultScheduler();

        s.start();
        s.scheduleJob(j,t);

		//List<JobExecutionContext> jobExecutionContextList = s.getCurrentlyExecutingJobs();

		//Trigger t2 = TriggerBuilder.newTrigger().withIdentity("JobPollaHeaderStatus").
		//	withSchedule(CronScheduleBuilder.cronSchedule("")).build();

    }
}
