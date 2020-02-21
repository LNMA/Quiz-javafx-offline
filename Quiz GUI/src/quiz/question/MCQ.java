package quiz.question;

public class MCQ extends Question {
    public MCQ(Integer questionID, String question, String answer1, String answer2, String answer3, String answer4, String rightChoice) {
        super(questionID, question, answer1, answer2, answer3, answer4, rightChoice);
        setRightChoice(rightChoice);
    }

    @Override
    public void setRightChoice(String rightChoice) {
        super.rightChoice = rightChoice;
    }

}
