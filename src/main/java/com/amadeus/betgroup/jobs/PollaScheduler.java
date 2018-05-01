package com.amadeus.betgroup.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class PollaScheduler implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Mi job funciona y corre cada 2 segundos");
        System.out.println("Llamar a una funcion que ");
        // Llamar a una funcion que pueda cambiar el estado de las pollas de 1 a 0 una vez la fecha fin sea menor que la fecha actual.
        //cuando cambia de estado una template
        //cuando cambia de estado una betgroup: una betgroup tiene un start y un date.....inicialmente estara en etado 2 (Abierto)
        //como tiene una fecha y hora de inicio

        //cuando cambia de estado un betevent
        //cuando cambia de estado un betparticipant
        //cuando cambia de estado un betmatch
        //cuando cambia de estado un bet
        //cuando cambia de estado un match  //match siempre nace con estado 1, cuando se actualiza resultado real del match, ahi se actualiza estado a 0.
        //cuando cambia de estado un torneo
        //cuando cambia de estado una fase group

        System.out.println("Fecha y hora: " + new Date());



        //darle otro nombre al war, DEV prod....deplegar, mas de un war en el mismo servidor.

    }


}
