package com.amadeus.betgroup.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class PollaScheduler implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Mi job funciona y corre cada 2 segundos");
        System.out.println("Fecha y hora: " + new Date());
    }
}
