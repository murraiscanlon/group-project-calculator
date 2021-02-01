package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Projects {
    String projectName;
    String className;
    String section;
    String groupNumber;
    String productGrade;
    String participationGrade;
    String submissionGrade;
    double finalGrade;
    Map<String, ArrayList<String>> groups = new HashMap<>();



    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getProductGrade() {
        return productGrade;
    }

    public void setProductGrade(String productGrade) {
        this.productGrade = productGrade;
    }

    public String getParticipationGrade() {
        return participationGrade;
    }

    public void setParticipationGrade(String participationGrade) {
        this.participationGrade = participationGrade;
    }

    public String getSubmissionGrade() {
        return submissionGrade;
    }

    public void setSubmissionGrade(String submissionGrade) {
        this.submissionGrade = submissionGrade;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }
}


