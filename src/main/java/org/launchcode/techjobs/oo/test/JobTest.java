package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob1.getId(), testJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());

        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Name", new Employer("Employer"), new Location("Location"), new PositionType("PositionType"), new CoreCompetency("CoreCompetency"));
        Job testJob2 = new Job("Name", new Employer("Employer"), new Location("Location"), new PositionType("PositionType"), new CoreCompetency("CoreCompetency"));

        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob1 = new Job();
        String jobString = testJob1.toString();
        assertEquals('\n', jobString.charAt(0));
        assertEquals('\n', jobString.charAt(jobString.length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Name", new Employer("Employer"), new Location("Location"), new PositionType("PositionType"), new CoreCompetency("CoreCompetency"));
        String testString =
            "\nID: " + testJob.getId() + "\n" +
            "Name: " + testJob.getName() + "\n" +
            "Employer: " + testJob.getEmployer() + "\n" +
            "Location: " + testJob.getLocation() + "\n" +
            "Position Type: " + testJob.getPositionType() + "\n" +
            "Core Competency: " + testJob.getCoreCompetency() + "\n";

        assertEquals(testString, testJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("", new Employer("Employer"), new Location(""), new PositionType("PositionType"), new CoreCompetency("CoreCompetency"));

        String testString =
            "\nID: " + testJob.getId() + "\n" +
            "Name: Data not available\n" +
            "Employer: " + testJob.getEmployer() + "\n" +
            "Location: Data not available\n" +
            "Position Type: " + testJob.getPositionType() + "\n" +
            "Core Competency: " + testJob.getCoreCompetency() + "\n";

        assertEquals(testString, testJob.toString());
    }

    @Test
    public void testToStringHandlesOnlyId() {
        Job testJob = new Job();
        String testString = "\nOOPS! This job does not seem to exist.\n";
        assertEquals(testString, testJob.toString());
    }
}
