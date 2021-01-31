package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class Controller {

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
    public void calculate_grade_on_mouse_click(ActionEvent event){
        int productGrade = Integer.parseInt(product_grade_textfield.getText());
        int participationGrade = Integer.parseInt(participation_grade_textfield.getText());
        int submissionGrade = Integer.parseInt(submission_grade_textfield.getText());

        double finalAverage = (double) productGrade * .45;
        finalAverage += (double) participationGrade * .45;
        finalAverage += (double) submissionGrade * .1;

        average_label_output.setText(String.format("%.2f",finalAverage));

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

        /*** Confirmation Message ***/
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy [hh:mm]");
        Date date = new Date();
        display_label.setText("Successfully Saved   ------   " + sdf.format(date.getTime()));
    }

}
