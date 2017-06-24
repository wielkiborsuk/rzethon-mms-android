package com.example.user.newmms.model;

import java.util.List;

public class Simulation {
    private String id;
    private List<SimulationNode> path;
    private LastReport lastReport;
    private double deliveryTime;
    private double speedFactor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SimulationNode> getPath() {
        return path;
    }

    public void setPath(List<SimulationNode> path) {
        this.path = path;
    }

    public LastReport getLastReport() {
        return lastReport;
    }

    public void setLastReport(LastReport lastReport) {
        this.lastReport = lastReport;
    }

    public double getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(double deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public double getSpeedFactor() {
        return speedFactor;
    }

    public void setSpeedFactor(double speedFactor) {
        this.speedFactor = speedFactor;
    }


    public static class LastReport {
        private String name;
        private double time;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getTime() {
            return time;
        }

        public void setTime(double time) {
            this.time = time;
        }
    }

    public static class SimulationNode {
        private String name;
        private String host;
        private Location location;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }
    }

    public static class Location {
        private double x;
        private double y;
        private double z;

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getZ() {
            return z;
        }

        public void setZ(double z) {
            this.z = z;
        }
    }
}
