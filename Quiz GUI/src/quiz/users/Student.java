package quiz.users;

import quiz.question.MAQ;
import quiz.question.Question;

import java.util.ArrayList;

public class Student extends User {
    public ArrayList<Question>mcq = new ArrayList<>();

    public Student(String username, String password, String type) {
        super(username, password, type);
    }

}
