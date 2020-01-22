/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Sensors.GarbageSensor;

/**
 *
 * @author arjit
 */
public class GarbageManagementWorkRequest  extends WorkRequest{
    private GarbageSensor garbagesensor;
    private String message;

    public GarbageSensor getGarbagesensor() {
        return garbagesensor;
    }

    public void setGarbagesensor(GarbageSensor garbagesensor) {
        this.garbagesensor = garbagesensor;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
