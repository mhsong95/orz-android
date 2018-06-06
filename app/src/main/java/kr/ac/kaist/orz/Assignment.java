package kr.ac.kaist.orz;

import java.util.Calendar;
import java.util.Comparator;

public class Assignment {
    private int id;
    private String assignmentName;
    private String description;
    private Calendar due;
    private String courseName;
    private float averageTimeEstimate;
    private int significance;

    public Assignment(int id, String assignmentName, String description, String courseName,
                      Calendar due, float averageTimeEstimate, int significance) {
        this.id = id;
        this.assignmentName = assignmentName;
        this.description = description;
        this.due = due;
        this.courseName = courseName;
        this.averageTimeEstimate = averageTimeEstimate;
        this.significance = significance;
    }

    public int getId() {
        return id;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getDue() {
        return due;
    }

    public String getCourseName() {
        return courseName;
    }

    public float getAverageTimeEstimate() {
        return averageTimeEstimate;
    }

    public int getSignificance() {
        return significance;
    }

    public static final DueComparator DUE_COMPARATOR = new DueComparator();
    public static final CourseComparator COURSE_COMPARATOR = new CourseComparator();
    public static final SignificanceComparator SIGNIFICANCE_COMPARATOR = new SignificanceComparator();
    public static final EstimateComparator ESTIMATE_COMPARATOR = new EstimateComparator();

    private static class DueComparator implements Comparator<Assignment> {
        @Override
        public int compare(Assignment a1, Assignment a2) {
            return a1.getDue().compareTo(a2.getDue());
        }
    }

    private static class CourseComparator implements Comparator<Assignment> {
        @Override
        public int compare(Assignment a1, Assignment a2) {
            return a1.getCourseName().compareTo(a2.getCourseName());

        }
    }

    private static class SignificanceComparator implements Comparator<Assignment> {
        @Override
        public int compare(Assignment a1, Assignment a2) {
            return a1.getSignificance() - a2.getSignificance();
        }
    }

    private static class EstimateComparator implements Comparator<Assignment> {
        @Override
        public int compare(Assignment a1, Assignment a2) {
            return (int) (a1.getAverageTimeEstimate() - a2.getAverageTimeEstimate());
        }
    }
}
