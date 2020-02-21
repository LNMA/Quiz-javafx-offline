package quiz.question;


import java.io.Serializable;

 abstract public class Question implements Serializable {
    private Integer questionID;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    String rightChoice;

     public Question(Integer questionID, String question, String answer1, String answer2, String answer3, String answer4, String rightChoice) {
         this.questionID = questionID;
         this.question = question;
         this.answer1 = answer1;
         this.answer2 = answer2;
         this.answer3 = answer3;
         this.answer4 = answer4;
         this.rightChoice = rightChoice;
     }

     public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    abstract public void setRightChoice(String rightChoice);

     public String getRightChoice() {
         return rightChoice;
     }

     @Override
     public String toString() {
         return "Question{" +
                 "questionID=" + questionID +
                 ", question='" + question + '\'' +
                 ", answer1='" + answer1 + '\'' +
                 ", answer2='" + answer2 + '\'' +
                 ", answer3='" + answer3 + '\'' +
                 ", answer4='" + answer4 + '\'' +
                 ", rightChoice='" + rightChoice + '\'' +
                 '}';
     }
 }

