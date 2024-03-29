package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Controller {



    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy [hh:mm]");
    Date date = new Date();
    double finalAverage;
    Projects drivebaseGTE = new Projects();




    /*** TextFields  ***/
    @FXML
    TextField projectname_textfield;
    @FXML
    TextField classname_textfield;
    @FXML
    TextField section_textfield;
    @FXML
    TextField group_number_textfield;
    @FXML
    TextField product_grade_textfield;
    @FXML
    TextField participation_grade_textfield;
    @FXML
    TextField submission_grade_textfield;


    /*** Buttons  ***/
    @FXML
    Button calculate_button;

    /*** Label Displays  ***/
    @FXML
    Label average_label_output;
    @FXML
    Label display_label;




    /* Calculates the project weighted average based on input by user*/
    public double calculate_grade_on_mouse_click(ActionEvent event){
        int productGrade = Integer.parseInt(product_grade_textfield.getText());
        int participationGrade = Integer.parseInt(participation_grade_textfield.getText());
        int submissionGrade = Integer.parseInt(submission_grade_textfield.getText());

        finalAverage = (double) productGrade * .45;
        finalAverage += (double) participationGrade * .45;
        finalAverage += (double) submissionGrade * .1;

        average_label_output.setText(String.format("%.2f",finalAverage));

        return finalAverage;
    }

    public void clear(ActionEvent event){
        group_number_textfield.clear();
        product_grade_textfield.clear();
        participation_grade_textfield.clear();
        submission_grade_textfield.clear();
        average_label_output.setText("");

    }

    public void clear_all(ActionEvent event){
        group_number_textfield.clear();
        projectname_textfield.clear();
        classname_textfield.clear();
        section_textfield.clear();
        product_grade_textfield.clear();
        participation_grade_textfield.clear();
        submission_grade_textfield.clear();
        average_label_output.setText("");
        display_label.setText("");
    }

    public void save() throws InterruptedException {

        //Add textfields data to Objects/class - - - print later
        if (drivebaseGTE.projectName == null){
            drivebaseGTE.setProjectName(projectname_textfield.getText());
            drivebaseGTE.setClassName(classname_textfield.getText());
            drivebaseGTE.setSection(section_textfield.getText());
        }

            drivebaseGTE.groups.put(group_number_textfield.getText(), new ArrayList<String>());
            drivebaseGTE.groups.get(group_number_textfield.getText()).add(product_grade_textfield.getText());
            drivebaseGTE.groups.get(group_number_textfield.getText()).add(participation_grade_textfield.getText());
            drivebaseGTE.groups.get(group_number_textfield.getText()).add(submission_grade_textfield.getText());
            drivebaseGTE.groups.get(group_number_textfield.getText()).add(String.valueOf(finalAverage));

        //Confirmation Message
        display_label.setText("Successfully Saved: Group: " + group_number_textfield.getText() + "   ---   " + sdf.format(date.getTime()));
    }

    public void print() throws InterruptedException {
        //Create a new file

        try {

            FileWriter myWriter = new FileWriter("C:/Users/Murrai.Scanlon/Desktop/project_grades/"
                    + projectname_textfield.getText() + "_"
                    + classname_textfield.getText() + "_"
                    + section_textfield.getText() + ".txt");
            myWriter.write("\n" + sdf.format(date.getTime()) + "\n");
            myWriter.write("\n");

            //Add the header data
            myWriter.write("Project Name: " + drivebaseGTE.projectName+ "\n");
            myWriter.write("Class: " + drivebaseGTE.className + "\n");
            myWriter.write("Section: " + drivebaseGTE.section + "\n");
            myWriter.write("==================================\n");

            //Add group details
            for (String key :  drivebaseGTE.groups.keySet()){
                myWriter.write("\nGroup Number_" + key
                                + "\nAverage: " + drivebaseGTE.groups.get(key).get(3)+ "\n"
                                + "\n\tProduct Grade: " + drivebaseGTE.groups.get(key).get(0)+ "\n"
                                + "\tParticipation Grade: " + drivebaseGTE.groups.get(key).get(1)+ "\n"
                                + "\tSubmission Grade: " + drivebaseGTE.groups.get(key).get(2)+ "\n");
                myWriter.write("--------------------------------\n");
            }
            myWriter.close();
            System.out.println("--------------------");
            System.out.println("\nYour file has been successfully written!\n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        display_label.setText("Successfully Printed: " + projectname_textfield.getText()
                                + "_" + classname_textfield.getText()
                                + "_" + section_textfield.getText() + "   ---   " + sdf.format(date.getTime()));


    }

}

