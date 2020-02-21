package quiz.gui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import quiz.data.MyData;

public class Controller {
    Main main = new Main();
    MyData myData = new MyData();
    public MenuItem closeMenuItem;
    public javafx.scene.control.TabPane tabPane;
    public Tab signInTab;
    public Tab signUpTab;
    public Label signUpLabel;
    public PasswordField signUpPasswordText;
    public TextField signUpUsernameText;
    public Label signInLabel;
    public PasswordField passwordSignInText;
    public TextField signInUsernameText;
    static String staticUsername;
    static Stage stageStudent = new Stage();
    static Stage stageTeacher = new Stage();


    public void showMeSignInTab(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(signInTab))
            tabPane.getTabs().add(signInTab);
    }

    public void showMeSignUpTab(ActionEvent actionEvent) {
        if (!tabPane.getTabs().contains(signUpTab))
            tabPane.getTabs().add(signUpTab);
    }

    public void signUpEvent(ActionEvent actionEvent) {
        String username = signUpUsernameText.getText();
        String password = signUpPasswordText.getText();
        if (username.length() < 3 || password.length() < 3) {
            signUpLabel.setVisible(true);
            signUpLabel.setText("Username and password must by more than 2 character!");
            signUpUsernameText.clear();
            signUpPasswordText.clear();
        }
        if (username.length() >= 3 || password.length() >= 3) {
            if (myData.isNewUsernameExist(username)) {
                signUpLabel.setVisible(true);
                signUpLabel.setText("This username already exist try another one!");
                signUpUsernameText.clear();
                signUpPasswordText.clear();
            } else {
                myData.addStudentUser(username, password);
                signUpLabel.setVisible(true);
                signUpLabel.setText("Sign Up done successfully..");
                signUpUsernameText.clear();
                signUpPasswordText.clear();
            }
        }
    }


    public void SignInEvent(ActionEvent actionEvent) throws Exception {
        String username = signInUsernameText.getText();
        String password = passwordSignInText.getText();
        if (myData.signIn(username, password)) {
            String type = myData.getType(username);
            this.staticUsername = username;
            if (type.equals("student")) {
                signInUsernameText.clear();
                passwordSignInText.clear();
                Parent root = FXMLLoader.load(getClass().getResource("sample1.fxml"));
                stageStudent.setTitle("Student");
                stageStudent.setScene(new Scene(root, 800, 400));
                stageStudent.show();
            } else {
                signInUsernameText.clear();
                passwordSignInText.clear();
                Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
                stageTeacher.setTitle("Teacher");
                stageTeacher.setScene(new Scene(root, 800, 400));
                stageTeacher.show();
            }
        } else {
            signInLabel.setVisible(true);
            signInLabel.setText("Username or password seem wrong!");
            signInUsernameText.clear();
            passwordSignInText.clear();
        }
    }


    public void clearSignUpLabel(MouseEvent mouseEvent) {
        signUpLabel.setVisible(false);
    }

    public void clearSignInLabel(MouseEvent mouseEvent) {
        signInLabel.setVisible(false);
    }


    public void closeEvent(ActionEvent actionEvent) {
        Main.stage.close();
    }

    public void load(ActionEvent actionEvent) {
        if (myData.questions.isEmpty()) {
            if (myData.users.isEmpty()) {
                myData.iOInQuestion();
                myData.iOInAccount();
            }
        }
    }

    public void save(ActionEvent actionEvent) {
        myData.iOOutQuestion();
        myData.iOOutAccount();
    }

    public void about(ActionEvent actionEvent) {
        Stage stage = new Stage();
        StackPane stackPane = new StackPane();
        Label label = new Label("\t   -->Author : Louay Amr<-- \n-->Email : Louay_Amr@outlook.com<--\n  root username: admin, password: 123\n\t -Any registrations process \n\t the account will be student. \n\t -Predefine student account \n\t username:student, password:123.");
        label.setStyle("-fx-text-fill: white;"+ "-fx-background-color: #0b85a6;"+ "-fx-font: Courier New;"+ "-fx-font-family: Courier New;"+ "-fx-font-weight: bold;"+ "-fx-font-size: 16;");
        stackPane.getChildren().add(label);
        stage.setScene(new Scene(stackPane,350,250));
        stage.setTitle("About");
        stage.show();
    }

    public void initialize() {
        myData.iOInAccount();
    }

    }
