package com.test.lesson18;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by USER on 06.01.2016.
 */
public class OttoProvider {
    private static final Bus bus = new Bus(ThreadEnforcer.ANY);

    public static Bus getBus(){
        return bus;
    }

    private OttoProvider(){

    }

}
