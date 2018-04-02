package com.amadeus.betgroup;

import com.amadeus.betgroup.filters.CORSResponseFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class MyResourceConfig extends ResourceConfig {
    public MyResourceConfig() {
        register(CORSResponseFilter.class);
    }
}

