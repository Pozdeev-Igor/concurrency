package org.example.tracker.mutable;

import net.jcip.annotations.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public class MonitoringVehicleTracker {

    private final Map<String, MutablePoint> locations;

    public MonitoringVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        var mutablePoint = locations.get(id);
        return mutablePoint == null ? null : new MutablePoint(mutablePoint);
    }

    public synchronized void setLocation(String id, int x, int y) {
        var mutablePoint = locations.get(id);
        if (mutablePoint == null) {
            throw new IllegalArgumentException("No such ID: " + id);
        }
        mutablePoint.x = x;
        mutablePoint.y = y;
    }

    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> locations) {
        var result = new HashMap<String, MutablePoint>();
        locations.keySet().forEach(id -> result.put(id, new MutablePoint(locations.get(id))));

        return Collections.unmodifiableMap(result);
    }
}
