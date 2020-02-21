package quiz.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import quiz.iofile.IOOut;
import quiz.question.Question;

import javax.swing.*;
import java.util.Collections;

public class ControllerTeacher extends Controller {
    private TextField textField1 = new TextField();
    private TextField textField2 = new TextField();
    private TextField textField3 = new TextField();
    private TextField textField4 = new TextField();
    private TextField textField5 = new TextField();
    private TextField textField6 = new TextField();
    private TextField textField7 = new TextField();
    private TextField textField8 = new TextField();
    private CheckBox checkBox = new CheckBox("Is MAQ");
    private TableView <Question> tableView = new TableView<>();
    private Label label = new Label();
    private Button button = new Button("Add");








    public BorderPane borderPane;


    public void initialize() {
        myData.iOInQuestion();
        SplitPane splitPane = new SplitPane();
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        HBox hBox0 = new HBox();
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        HBox hBox4 = new HBox();
        HBox hBox5 = new HBox();
        HBox hBox6 = new HBox();
        HBox hBox7 = new HBox();
        HBox hBox8 = new HBox();
        HBox hBox9 = new HBox();
        HBox hBoxCheck = new HBox();
        HBox hBoxLabel = new HBox();
        ScrollPane scrollPane = new ScrollPane();

        TableColumn tableColumn1 = new TableColumn("ID");
        tableColumn1.setEditable(true);
        tableColumn1.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tableColumn1.setMinWidth(50);
        tableColumn1.setCellValueFactory(new PropertyValueFactory<Question,Integer>("questionID"));

        TableColumn tableColumn2 = new TableColumn("Question");
        tableColumn2.setEditable(true);
        tableColumn2.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumn2.setMinWidth(370);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<Question,String>("question"));

        TableColumn tableColumn3 = new TableColumn("Answer A");
        tableColumn3.setEditable(true);
        tableColumn3.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumn3.setMinWidth(150);
        tableColumn3.setCellValueFactory(new PropertyValueFactory<Question,String>("answer1"));

        TableColumn tableColumn4 = new TableColumn("Answer B");
        tableColumn4.setEditable(true);
        tableColumn4.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumn4.setMinWidth(150);
        tableColumn4.setCellValueFactory(new PropertyValueFactory<Question,String>("answer2"));

        TableColumn tableColumn5 = new TableColumn("Answer C");
        tableColumn5.setEditable(true);
        tableColumn5.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumn5.setMinWidth(150);
        tableColumn5.setCellValueFactory(new PropertyValueFactory<Question,String>("answer3"));

        TableColumn tableColumn6 = new TableColumn("Answer D");
        tableColumn6.setEditable(true);
        tableColumn6.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumn6.setMinWidth(150);
        tableColumn6.setCellValueFactory(new PropertyValueFactory<Question,String>("answer4"));

        TableColumn tableColumn7 = new TableColumn("Correct Choice");
        tableColumn7.setEditable(true);
        tableColumn7.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumn7.setMinWidth(150);
        tableColumn7.setCellValueFactory(new PropertyValueFactory<Question,String>("rightChoice"));

        TableColumn tableColumn8 = new TableColumn("Num. Of Cor. Choice");
        tableColumn8.setEditable(true);
        tableColumn8.setCellValueFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tableColumn8.setMinWidth(150);
        tableColumn8.setCellValueFactory(new PropertyValueFactory<Question,Integer>("numberOfRightQuestion"));

        tableView.getColumns().addAll(tableColumn1,tableColumn2,tableColumn3,tableColumn4,tableColumn5,tableColumn6,tableColumn7,tableColumn8);

        label.setStyle("-fx-text-fill: red");

        tableView.setTableMenuButtonVisible(true);
        tableView.setEditable(true);


        textField1.setPromptText("Type ID");

        textField1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")){
                    textField1.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        textField2.setPromptText("Type Question");
        textField3.setPromptText("Type Answer A");
        textField4.setPromptText("Type Answer B");
        textField5.setPromptText("Type Answer C");
        textField6.setPromptText("Type Answer D");
        textField7.setPromptText("Type Correct Choice");
        textField7.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("[ABCD]")){
                    textField7.setText(newValue.replaceAll("[^ABCD]",""));
                }
                if (!checkBox.isSelected()) {
                    if (newValue.length() > 1) {
                        textField7.setText(textField7.getText(0, 1));
                    }
                }
                if (checkBox.isSelected()) {
                    if (newValue.length() > 4) {
                        textField7.setText(textField7.getText(0, 4));
                    }
                }
            }
        });
        textField8.setPromptText("Type Num.Of.Cor.Choice");
        textField8.setVisible(false);
        textField8.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")){
                    textField8.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        hBox1.getChildren().add(textField1);
        hBox2.getChildren().add(textField2);
        hBox3.getChildren().add(textField3);
        hBox4.getChildren().add(textField4);
        hBox5.getChildren().add(textField5);
        hBox6.getChildren().add(textField6);
        hBox7.getChildren().add(textField7);
        hBox8.getChildren().add(textField8);
        hBoxCheck.getChildren().add(checkBox);
        hBoxCheck.setPadding(new Insets(3,0,0,0));
        hBox9.getChildren().addAll(hBoxCheck,button);

        hBox0.getChildren().addAll(hBox1,hBox2,hBox3,hBox4,hBox5,hBox6,hBox7,hBox8,hBox9);
        hBox0.setSpacing(2);
        hBox0.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(hBox0);
        hBox.setPadding(new Insets(0,0,0,30));
        hBox.setAlignment(Pos.CENTER);

        hBoxLabel.getChildren().add(label);
        hBoxLabel.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(hBox,hBoxLabel);
        vBox.setSpacing(20);

        scrollPane.setContent(vBox);

        splitPane.getItems().addAll(tableView,scrollPane);
        splitPane.setOrientation(Orientation.VERTICAL);

        borderPane.setCenter(splitPane);

        ObservableList<Question>questionObservableList = FXCollections.observableArrayList(myData.questions);
        tableView.setItems(questionObservableList);

        checkBox.setOnAction(event -> {
            if (checkBox.isSelected()) {
                textField8.clear();
                textField8.setVisible(true);
            }
            if (!checkBox.isSelected()) {
                textField8.setText("1");
                textField8.setVisible(false);
            }

        });
        button.setOnAction(event -> {
            addQuestion();
        });
    }

    public void addQuestion(){
        Integer id;
        String question;
        String answerA;
        String answerB;
        String answerC;
        String answerD;
        String corrChoice;
        Integer numOfCorrChoice;
        if (checkBox.isSelected()){
            if (!textField1.getText().isEmpty()) {
                id = Integer.parseInt(textField1.getText());
                if (!textField2.getText().isEmpty()) {
                    question = textField2.getText();
                    if (!textField3.getText().isEmpty()) {
                        answerA = textField3.getText();
                        if (!textField4.getText().isEmpty()) {
                            answerB = textField4.getText();
                            if (!textField5.getText().isEmpty()) {
                                answerC = textField5.getText();
                                if (!textField6.getText().isEmpty()) {
                                    answerD = textField6.getText();
                                    if (!textField7.getText().isEmpty()) {
                                        corrChoice = textField7.getText();
                                        if (!textField8.getText().isEmpty()) {
                                            numOfCorrChoice = Integer.parseInt(textField8.getText());
                                            myData.addMAQ(id, question, answerA, answerB, answerC, answerD, corrChoice, numOfCorrChoice);
                                                label.setVisible(false);
                                        }else {
                                            label.setVisible(true);
                                            label.setText("Enter Number Of Correct Choice");
                                        }
                                    }else {
                                        label.setVisible(true);
                                        label.setText("Enter Correct Choice");
                                    }
                                }else {
                                    label.setVisible(true);
                                    label.setText("Enter Answer D");
                                }
                            }else {
                                label.setVisible(true);
                                label.setText("Enter Answer C");
                            }
                        }else {
                            label.setVisible(true);
                            label.setText("Enter Answer B");
                        }
                    }else {
                        label.setVisible(true);
                        label.setText("Enter Answer A");
                    }
                }else {
                    label.setVisible(true);
                    label.setText("Enter Question");
                }
            }else {
                label.setVisible(true);
                label.setText("Enter ID");
            }
        }
        else {
            if (!textField1.getText().isEmpty()) {
                id = Integer.parseInt(textField1.getText());
                if (!textField2.getText().isEmpty()) {
                    question = textField2.getText();
                    if (!textField3.getText().isEmpty()) {
                        answerA = textField3.getText();
                        if (!textField4.getText().isEmpty()) {
                            answerB = textField4.getText();
                            if (!textField5.getText().isEmpty()) {
                                answerC = textField5.getText();
                                if (!textField6.getText().isEmpty()) {
                                    answerD = textField6.getText();
                                    if (!textField7.getText().isEmpty()) {
                                        corrChoice = textField7.getText();
                                        myData.addMCQ(id,question,answerA,answerB,answerC,answerD,corrChoice);
                                        label.setVisible(false);
                                    }else {
                                        label.setVisible(true);
                                        label.setText("Enter Correct Choice");
                                    }
                                }else {
                                    label.setVisible(true);
                                    label.setText("Enter Answer D");
                                }
                            }else {
                                label.setVisible(true);
                                label.setText("Enter Answer C");
                            }
                        }else {
                            label.setVisible(true);
                            label.setText("Enter Answer B");
                        }
                    }else {
                        label.setVisible(true);
                        label.setText("Enter Answer A");
                    }
                }else {
                    label.setVisible(true);
                    label.setText("Enter Question");
                }
            }else {
                label.setVisible(true);
                label.setText("Enter ID");
            }
        }

        ObservableList<Question>questionObservableList = FXCollections.observableArrayList(myData.questions);
        tableView.setItems(questionObservableList);

        textField1.setOnMouseClicked(event -> {
            label.setVisible(false);
        });
        textField2.setOnMouseClicked(event -> {
            label.setVisible(false);
        });
        textField3.setOnMouseClicked(event -> {
            label.setVisible(false);
        });
        textField4.setOnMouseClicked(event -> {
            label.setVisible(false);
        });
        textField5.setOnMouseClicked(event -> {
            label.setVisible(false);
        });
        textField6.setOnMouseClicked(event -> {
            label.setVisible(false);
        });
        textField7.setOnMouseClicked(event -> {
            label.setVisible(false);
        });
        textField8.setOnMouseClicked(event -> {
            label.setVisible(false);
        });

    }

    public void closeEvent(ActionEvent actionEvent) {
        stageTeacher.close();
    }

    public void deleteEvent(ActionEvent actionEvent) {
        int i = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(i);
    }

    public void saveEvent(ActionEvent actionEvent) {
            IOOut.checkToSaveAllQuestion();
            for (Question ques: tableView.getItems()) {
                if (ques != null){
                    IOOut.writeQuestion(ques);
                }
            }
    }

    public void loadEvent(ActionEvent actionEvent) {
        myData.iOInQuestion();
        ObservableList<Question>questionObservableList = FXCollections.observableArrayList(myData.questions);
        tableView.setItems(questionObservableList);

    }

    public void duplicate(ActionEvent actionEvent) {
        tableView.getItems().add(tableView.getSelectionModel().getSelectedItem());
    }

    public void aboutTeacher(ActionEvent actionEvent) {
        Stage stage = new Stage();
        StackPane stackPane = new StackPane();
        Label label = new Label("1-ID textfield allow to user to input decimal number only.\n2-correct choice text field allow to user to input capital latter" +
                "\n[ABCD] only, by default you can add one character.\n3-if you select check box \'is MAQ\', you will able to input \nmore than one correct choice and new filed will appear\nalso you can input just decimal number to it." +
                "\n4-You cannot add new question if you didn't fill all textfield." +
                "\n5#Warning : any edit will not save, it will be shallow edit.\n6-if you use delete option or duplicate, the result will appear\nafter reRun the program." +
                "\n7-the reason for last two note is miss understand for the relation\nbetween the table view and observablelist and original array list, obviously the IO system will " +
                "\nbe big player in delete and duplicate process instead of original array list.   " +
                "\n8#warning: if you choose load option from menu, it will duplicate saved \nobject to table list, if you logout and sign in again" +
                "\nthe problem will solved. \n9-save option from menu have no problem with it. \n10-student stage will automatically get now the type of " +
                "\nquestion and give to user proper options.\n11-according to point 10 there is no confuse to set question\nrandom ,not sort by its type." +
                " \n12-at the last question, the student stage automatically \nwill show to user his mark and finish button.\n13-finish button will close stage and generate text file" +
                "\ncontain user name and the result.\n14-sign in and sign out process will follow selection rules. \n15-by default the system will read all account and question file\"mostly\" ");
        label.setStyle("-fx-text-fill: #000634;"+ "-fx-font: Courier New;"+ "-fx-font-family: Courier New;"+ "-fx-font-weight: bold;"+ "-fx-font-size: 14;");
        stackPane.getChildren().add(label);
        stage.setScene(new Scene(stackPane,350,250));
        stage.setTitle("About");
        stage.show();
    }
}
