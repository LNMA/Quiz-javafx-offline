package quiz.question;

public class MAQ extends Question{
    private Integer numberOfRightQuestion;

    public MAQ(Integer questionID, String question, String answer1, String answer2, String answer3, String answer4, String rightChoice, Integer numberOfRightQuestion) {
        super(questionID, question, answer1, answer2, answer3, answer4, rightChoice);
        this.numberOfRightQuestion = numberOfRightQuestion;
        setRightChoice(rightChoice);
    }

    public String getRightChoice() {
        return rightChoice;
    }

    public void setRightChoice(String rightChoice) {
        super.rightChoice = rightChoice;
    }

    public Integer getNumberOfRightQuestion() {
        return numberOfRightQuestion;
    }

    public void setNumberOfRightQuestion(Integer numberOfRightQuestion) {
        this.numberOfRightQuestion = numberOfRightQuestion;
    }

    @Override
    public String toString() {
        return "MAQ{" +
                "numberOfRightQuestion=" + numberOfRightQuestion +
                '}';
    }
}
