package quiz.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.*;


public class ControllerStudent extends Controller {

    public Label userNameLabel;

    public Button startBtn;

    public Label questionIDMCQ;
    public Label questionMCQ;
    public RadioButton answerAMCQ;
    public RadioButton answerBMCQ;
    public RadioButton answerCMCQ;
    public RadioButton answerDMCQ;
    private ToggleGroup toggleGroup = new ToggleGroup();
    public Button nextMCQ;
    public Button submitBtnMCQ;
    public Label correctLabelMCQ;
    public Label correctChoiceMCQ;

    public Label questionIDMAQ;
    public Label questionMAQ;
    public CheckBox answerAMAQ;
    public CheckBox answerBMAQ;
    public CheckBox answerCMAQ;
    public CheckBox answerDMAQ;
    public Button submitBtnMAQ;
    public Button nextMAQ;
    public Label correctLabelMAQ;
    public Label correctChoiceMAQ;

    public TabPane tabPaneStudent;
    public Tab mCQTab;
    public Tab mAQTab;
    public Tab startTab;
    public Tab endTab;

    public Label resultLabel;

    private int index;
    private double score;
    private int size;



    public void initialize() {
        myData.iOInQuestion();
        userNameLabel.setText("Welcome "+staticUsername);
        size = myData.questions.size();
    }



        public void logOutEvent(MouseEvent mouseEvent) {
        stageStudent.close();
    }


    public void startQuiz(ActionEvent actionEvent) {
        nextMAQ.setDisable(true);
        nextMCQ.setDisable(true);
        startTab.setDisable(true);
        endTab.setDisable(true);
        if(myData.isMCQ(index)){
            mCQTab.setDisable(false);
            tabPaneStudent.getSelectionModel().select(1);
            mCQ();
            correctChoiceMCQ.setVisible(false);
            correctLabelMCQ.setVisible(false);
        }else{
            mAQTab.setDisable(false);
            tabPaneStudent.getSelectionModel().select(2);
            mAQ();
            correctChoiceMAQ.setVisible(false);
            correctLabelMAQ.setVisible(false);
        }
    }

    public void mCQ(){
        questionIDMCQ.setText(myData.getQuestionID(index).toString()+".");
        questionMCQ.setText(myData.getQuestion(index));
        answerAMCQ.setText(myData.getQuestionAnswer1(index));
        answerBMCQ.setText(myData.getQuestionAnswer2(index));
        answerCMCQ.setText(myData.getQuestionAnswer3(index));
        answerDMCQ.setText(myData.getQuestionAnswer4(index));
        answerAMCQ.setToggleGroup(toggleGroup);
        answerBMCQ.setToggleGroup(toggleGroup);
        answerCMCQ.setToggleGroup(toggleGroup);
        answerDMCQ.setToggleGroup(toggleGroup);
        correctChoiceMCQ.setText(myData.getCorrectChoice(index));
    }

    public void mAQ(){
        questionIDMAQ.setText(myData.getQuestionID(index).toString()+".");
        questionMAQ.setText(myData.getQuestion(index));
        answerAMAQ.setText(myData.getQuestionAnswer1(index));
        answerBMAQ.setText(myData.getQuestionAnswer2(index));
        answerCMAQ.setText(myData.getQuestionAnswer3(index));
        answerDMAQ.setText(myData.getQuestionAnswer4(index));
        correctChoiceMAQ.setText(myData.getCorrectChoice(index));
    }

    public void submitMCQ(ActionEvent actionEvent) {
        submitBtnMCQ.setDisable(true);
        answerAMCQ.setDisable(true);
        answerBMCQ.setDisable(true);
        answerCMCQ.setDisable(true);
        answerDMCQ.setDisable(true);
        correctChoiceMCQ.setVisible(true);
        correctLabelMCQ.setVisible(true);
        nextMCQ.setDisable(false);
        String cor = myData.getCorrectChoice(index);
        if (cor.equalsIgnoreCase("A")){
            if (answerAMCQ.isSelected()){
                score++;
            }
        }
        if (cor.equalsIgnoreCase("B")){
            if (answerBMCQ.isSelected()){
                score++;
            }
        }
        if (cor.equalsIgnoreCase("C")){
            if (answerCMCQ.isSelected()){
                score++;
            }
        }
        if (cor.equalsIgnoreCase("D")){
            if (answerDMCQ.isSelected()){
                score++;
            }
        }
    }

    public void submitBtnMAQ(ActionEvent actionEvent) {
        submitBtnMAQ.setDisable(true);
        answerAMAQ.setDisable(true);
        answerBMAQ.setDisable(true);
        answerCMAQ.setDisable(true);
        answerDMAQ.setDisable(true);
        correctChoiceMAQ.setVisible(true);
        correctLabelMAQ.setVisible(true);
        nextMAQ.setDisable(false);
        String cor = myData.getCorrectChoice(index);
        double num = myData.getCorrectChoiceNumber(index);
        double result = 1/num;
        double total = 0;
        if (cor.contains("A")){
            if (answerAMAQ.isSelected()){
                total+=result;
            }
        }
        if (cor.contains("B")){
            if (answerBMAQ.isSelected()){
                total+=result;
            }
        }
        if (cor.contains("C")){
            if (answerCMAQ.isSelected()){
                total+=result;
            }
        }
        if (cor.contains("D")){
            if (answerDMAQ.isSelected()){
                total+=result;
            }
        }
        if (!cor.contains("A")){
            if (answerAMAQ.isSelected()){
                total=0;
            }
        }
        if (!cor.contains("B")){
            if (answerBMAQ.isSelected()){
                total=0;
            }
        }
        if (!cor.contains("C")){
            if (answerCMAQ.isSelected()){
                total=0;
            }
        }
        if (!cor.contains("D")){
            if (answerDMAQ.isSelected()){
                total=0;
            }
        }
        score+=total;
        total = 0;
    }

    public void nextMCQEvent(ActionEvent actionEvent) {
        startTab.setDisable(true);
        endTab.setDisable(true);
        mCQTab.setDisable(true);
        mAQTab.setDisable(true);
        nextMAQ.setDisable(true);
        nextMCQ.setDisable(true);
        correctChoiceMAQ.setVisible(false);
        correctLabelMAQ.setVisible(false);
        correctChoiceMCQ.setVisible(false);
        correctLabelMCQ.setVisible(false);
        answerAMCQ.setDisable(false);
        answerBMCQ.setDisable(false);
        answerCMCQ.setDisable(false);
        answerDMCQ.setDisable(false);
        answerAMAQ.setDisable(false);
        answerBMAQ.setDisable(false);
        answerCMAQ.setDisable(false);
        answerDMAQ.setDisable(false);
        answerAMCQ.setSelected(false);
        answerBMCQ.setSelected(false);
        answerCMCQ.setSelected(false);
        answerDMCQ.setSelected(false);
        answerAMAQ.setSelected(false);
        answerBMAQ.setSelected(false);
        answerCMAQ.setSelected(false);
        answerDMAQ.setSelected(false);
        index++;
        if (size == index){
            startTab.setDisable(true);
            mCQTab.setDisable(true);
            mAQTab.setDisable(true);
            resultLabel.setText("YOR RESULT IS: "+score+" / "+size);
            endTab.setDisable(false);
            tabPaneStudent.getSelectionModel().select(3);
        }else {
            if (myData.isMCQ(index)) {
                submitBtnMCQ.setDisable(false);
                mCQTab.setDisable(false);
                tabPaneStudent.getSelectionModel().select(1);
                mCQ();
                correctChoiceMCQ.setVisible(false);
                correctLabelMCQ.setVisible(false);
            } else {
                submitBtnMAQ.setDisable(false);
                mAQTab.setDisable(false);
                tabPaneStudent.getSelectionModel().select(2);
                mAQ();
                correctChoiceMAQ.setVisible(false);
                correctLabelMAQ.setVisible(false);
            }
        }
    }

    public void nextMAQEvent(ActionEvent actionEvent) {
        startTab.setDisable(true);
        endTab.setDisable(true);
        mCQTab.setDisable(true);
        mAQTab.setDisable(true);
        nextMAQ.setDisable(true);
        nextMCQ.setDisable(true);
        correctChoiceMAQ.setVisible(false);
        correctLabelMAQ.setVisible(false);
        correctChoiceMCQ.setVisible(false);
        correctLabelMCQ.setVisible(false);
        answerAMCQ.setDisable(false);
        answerBMCQ.setDisable(false);
        answerCMCQ.setDisable(false);
        answerDMCQ.setDisable(false);
        answerAMAQ.setDisable(false);
        answerBMAQ.setDisable(false);
        answerCMAQ.setDisable(false);
        answerDMAQ.setDisable(false);
        answerAMCQ.setSelected(false);
        answerBMCQ.setSelected(false);
        answerCMCQ.setSelected(false);
        answerDMCQ.setSelected(false);
        answerAMAQ.setSelected(false);
        answerBMAQ.setSelected(false);
        answerCMAQ.setSelected(false);
        answerDMAQ.setSelected(false);
        index++;
        if (size == index) {
            startTab.setDisable(true);
            mCQTab.setDisable(true);
            mAQTab.setDisable(true);
            resultLabel.setText("YOR RESULT IS: "+score+" / "+size);
            endTab.setDisable(false);
            tabPaneStudent.getSelectionModel().select(3);
        } else {
            if (myData.isMCQ(index)) {
                submitBtnMCQ.setDisable(false);
                mCQTab.setDisable(false);
                tabPaneStudent.getSelectionModel().select(1);
                mCQ();
                correctChoiceMCQ.setVisible(false);
                correctLabelMCQ.setVisible(false);
            } else {
                submitBtnMAQ.setDisable(false);
                mAQTab.setDisable(false);
                tabPaneStudent.getSelectionModel().select(2);
                mAQ();
                correctChoiceMAQ.setVisible(false);
                correctLabelMAQ.setVisible(false);
            }
        }
    }


    public void finish(ActionEvent actionEvent) throws IOException{
        PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("Result.txt",true)));
        out.append("\n"+staticUsername+", Result is: "+score+" / "+size);
        out.close();
        stageStudent.close();
    }



}
