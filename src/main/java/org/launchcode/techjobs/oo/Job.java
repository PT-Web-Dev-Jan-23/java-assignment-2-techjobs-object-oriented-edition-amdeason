package org.launchcode.techjobs.oo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Job {
    private int id;
    private static int nextId = 1;
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positiontype, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positiontype;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String jobString = "";

        if (isEmpty()) {
            jobString += "\nOOPS! This job does not seem to exist.\n";
        }

        else {
            ArrayList<String> fields = new ArrayList<>(Arrays.asList(String.valueOf(id), name, employer.toString(), location.toString(), positionType.toString(), coreCompetency.toString()));

            for (int i = 0; i < fields.size(); i++) {
                String field = fields.get(i);
                if (field.isEmpty()) {
                    fields.set(i, "Data not available");
                }
            }

            jobString = String.format(
            "\nID: %s\n" +
            "Name: %s\n" +
            "Employer: %s\n" +
            "Location: %s\n" +
            "Position Type: %s\n" +
            "Core Competency: %s\n", fields.get(0), fields.get(1), fields.get(2), fields.get(3), fields.get(4), fields.get(5));
        }

        return jobString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public boolean isEmpty() {
        return (name == null || name.isEmpty()) && (employer == null || employer.toString().isEmpty()) && (location == null || location.toString().isEmpty()) && (positionType == null || positionType.toString().isEmpty()) && (coreCompetency == null || coreCompetency.toString().isEmpty());
    }

    /*
    Getters
     */
    public int getId() {
        return id;
    }
    public String getName() {
        if (name.isEmpty())
            return "Data not available";
        else
            return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    /*
     Setters
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
