package org.example;

import org.example.tracker.MonitoringVehicleTracker;
import org.example.tracker.MutablePoint;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        var pointHashMap = new HashMap<String, MutablePoint>();
        pointHashMap.put("1", new MutablePoint());
        var monitoringVehicleTracker = new MonitoringVehicleTracker(pointHashMap);

        monitoringVehicleTracker.getLocation("1");
        var locations = monitoringVehicleTracker.getLocations();
    }
}
