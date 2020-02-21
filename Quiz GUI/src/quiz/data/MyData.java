package quiz.data;

import quiz.iofile.IOOut;
import quiz.question.MAQ;
import quiz.question.MCQ;
import quiz.question.Question;
import quiz.users.Student;
import quiz.users.User;

import java.io.*;
import java.util.ArrayList;

public class MyData implements Serializable {
    public ArrayList<Question> questions = new ArrayList<>();


    public void addMCQ(Integer questionID,String question, String answer1, String answer2,String answer3,String answer4, String rightChoice){
        questions.add(new MCQ(questionID,question, answer1, answer2, answer3,answer4,rightChoice ));
        IOOut.writeQuestion(questions.get(questions.size()-1));
    }

    public void addMAQ(Integer questionID,String question, String answer1, String answer2,String answer3,String answer4, String rightChoice, Integer numberOfRightQuestion){
        questions.add(new MAQ(questionID,question, answer1, answer2, answer3,answer4,rightChoice,numberOfRightQuestion ));
        IOOut.writeQuestion(questions.get(questions.size()-1));
    }

    public void iOInQuestion() {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("question.dat")))) {
            while (true) {
                questions.add((Question) in.readObject());
            }
        }
        catch (EOFException e) {
            System.out.print("\n>>all data was read successfully.\n");
        } catch (IOException | ClassNotFoundException e) {
            System.out.print("\n>>" + e.getMessage() + ".\n");
        }
    }

    public void iOOutQuestion(){
        IOOut.checkToSaveAllQuestion();
        for (Question ques: questions) {
            if (ques != null){
                IOOut.writeQuestion(ques);
            }
        }
    }

    public boolean isMCQ(int index){
        if (questions.get(index) instanceof MCQ){
            return true;
        }else
            return false;
    }

    public Integer getQuestionID(int index){
        Integer ques = questions.get(index).getQuestionID();
        return ques;
    }

    public String getQuestion(int index){
        String ques = questions.get(index).getQuestion();
        return ques;
    }

    public String getQuestionAnswer1(int index){
        String ques = questions.get(index).getAnswer1();
        return ques;
    }

    public String getQuestionAnswer2(int index){
        String ques = questions.get(index).getAnswer2();
        return ques;
    }

    public String getQuestionAnswer3(int index){
        String ques = questions.get(index).getAnswer3();
        return ques;
    }

    public String getQuestionAnswer4(int index){
        String ques = questions.get(index).getAnswer4();
        return ques;
    }

    public String getCorrectChoice(int index){
        String ques = questions.get(index).getRightChoice();
        return ques;
    }

    public Integer getCorrectChoiceNumber(int index){
        Integer ques = ((MAQ)questions.get(index)).getNumberOfRightQuestion();
        return ques;
    }

    public void setQuestion(int questionID,String ques){
        boolean notExist = true;
        for (Question question:questions) {
            if (question != null){
                if (question.getQuestionID() == questionID){
                    question.setQuestion(ques);
                    notExist = false;
                    break;
                }
            }
        }
        if (notExist)
            System.out.print("\n>>There are no question have this ID");
    }

    public void setQuestionAnswer1(int questionID,String answer1){
        boolean notExist = true;
        for (Question question:questions) {
            if (question != null){
                if (question.getQuestionID() == questionID){
                    question.setAnswer1(answer1);
                    notExist = false;
                    break;
                }
            }
        }
        if (notExist)
            System.out.print("\n>>There are no question have this ID");
    }

    public void setQuestionAnswer2(int questionID,String answer2){
        boolean notExist = true;
        for (Question question:questions) {
            if (question != null){
                if (question.getQuestionID() == questionID){
                    question.setAnswer2(answer2);
                    notExist = false;
                    break;
                }
            }
        }
        if (notExist)
            System.out.print("\n>>There are no question have this ID");
    }

    public void setQuestionAnswer3(int questionID,String answer3){
        boolean notExist = true;
        for (Question question:questions) {
            if (question != null){
                if (question.getQuestionID() == questionID){
                    question.setAnswer3(answer3);
                    notExist = false;
                    break;
                }
            }
        }
        if (notExist)
            System.out.print("\n>>There are no question have this ID");
    }

    public void setQuestionAnswer4(int questionID,String answer4){
        boolean notExist = true;
        for (Question question:questions) {
            if (question != null){
                if (question.getQuestionID() == questionID){
                    question.setAnswer4(answer4);
                    notExist = false;
                    break;
                }
            }
        }
        if (notExist)
            System.out.print("\n>>There are no question have this ID");
    }

    public void setRightChoice(int questionID,String rightChoice ){
        boolean notExist = true;
        for (Question question:questions) {
            if (question != null){
                if (question.getQuestionID() == questionID){
                    question.setRightChoice(rightChoice);
                    notExist = false;
                    break;
                }
            }
        }
        if (notExist)
            System.out.print("\n>>There are no question have this ID");
    }







    public ArrayList<User>users = new ArrayList<>();

    public void addStudentUser(String username, String password){
        users.add(new Student(username,password,"student"));
        IOOut.writeAccount(users.get(users.size()-1));
    }

    public void addTeacherUser(){
        users.add(new User("admin","123","teacher"));
        IOOut.writeAccount(users.get(users.size()-1));
    }

    public void iOInAccount() {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("accounts.dat")))) {
            while (true) {
                users.add((User) in.readObject());
            }
        }
        catch (EOFException e) {
            System.out.print("\n>>all data was read successfully.\n");
        } catch (IOException | ClassNotFoundException e) {
            System.out.print("\n>>" + e.getMessage() + ".\n");
        }
    }

    public void iOOutAccount(){
        IOOut.checkToSaveAllAccount();
        for (User user: users) {
            if (user != null){
                IOOut.writeAccount(user);
            }
        }
    }

    public boolean isNewUsernameExist(String newUsername){
        for (User user:users) {
            if (user != null){
                if (user.getUsername().equalsIgnoreCase(newUsername)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean signIn(String username,String password){
        for (User user:users) {
            if (user != null){
                if (user.getUsername().equalsIgnoreCase(username)){
                    if (user.getPassword().equals(password))
                        return true;
                }
            }
        }
        return false;
    }

    public String getType(String username){
        String type = null;
        for (User user:users) {
            if (user != null){
                if (user.getUsername().equalsIgnoreCase(username)){
                    type = user.getType();
                    break;
                }
            }
        }
        return type;
    }

}