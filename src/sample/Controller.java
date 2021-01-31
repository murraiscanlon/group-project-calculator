package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    public Button calculate_button;
    @FXML
    TextField product_grade_textfield;
    @FXML
    TextField participation_grade_textfield;
    @FXML
    TextField submission_grade_textfield;
    @FXML
    Label average_label;

    public void calculate_grade_on_mouse_click(ActionEvent event){

        //average_label.setText(product_grade_textfield.getText());

        int productGrade = Integer.parseInt(product_grade_textfield.getText());
        int participationGrade = Integer.parseInt(participation_grade_textfield.getText());
        int submissionGrade = Integer.parseInt(submission_grade_textfield.getText());

        double finalAverage = (double) productGrade * .45;
        finalAverage += (double) participationGrade * .45;
        finalAverage += (double) submissionGrade * .1;


        average_label.setText(String.format("%.2f",finalAverage));

    }

}
