package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import static java.lang.System.currentTimeMillis;


public class Controller {

    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy [hh:mm]");
    Date date = new Date();
    double finalAverage;
    Projects projects = new Projects();
    //FileWriter myWriter;



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
        projectname_textfield.clear();
        classname_textfield.clear();
        section_textfield.clear();
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
    }

    public void save(){

        //Confirmation Message
        display_label.setText("Successfully Saved   ------   " + sdf.format(date.getTime()));

        //Add textfields data to Objects/class - - - print later
        projects.setGroupNumber(group_number_textfield.getText());
        projects.setProductGrade(product_grade_textfield.getText());
        projects.setParticipationGrade(participation_grade_textfield.getText());
        projects.setSubmissionGrade(submission_grade_textfield.getText());
        projects.setFinalGrade(finalAverage);
    }

}

/*
        //Write to File
        try {

                //if (myWriter == null) {
                FileWriter myWriter = new FileWriter("C:/Users/Murrai.Scanlon/Desktop/project_grades/"
                + projectname_textfield.getText() + "_"
                + classname_textfield.getText() + "_"
                + section_textfield.getText() + ".txt");
                myWriter.write("\n" + sdf.format(date.getTime()) + "\n");
                myWriter.write("\n");
                //}

                for (int i = 0; i < listOfGrades.size(); i++){
        myWriter.write(listOfGrades.get(i));
        }
        myWriter.close();
        System.out.println("--------------------");
        System.out.println("\nYour file has been successfully written!\n");
        } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
 */