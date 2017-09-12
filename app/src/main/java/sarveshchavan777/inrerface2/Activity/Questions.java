package sarveshchavan777.inrerface2.Activity;

import android.app.Activity;

public class Questions extends Activity {
    private int ID;
    private String Question;

    private String Answer;
    private String Answer2;
    private String RANDOMANS1;
    private String RANDOMANS2;
    private String USELESSSTRING;

    public Questions() {
        ID = 0;
        Question = "";

        Answer = "";
        Answer2 = "";

        RANDOMANS1 = "";
        RANDOMANS2 = "";
        USELESSSTRING = "";
    }

    public Questions(String qUESTION, String aNSWER, String aNSWER2, String rANDOMANS1, String rANDOMANS2, String uSLESSSTRING) {
        Question = qUESTION;

        Answer = aNSWER;
        Answer2 = aNSWER2;

        RANDOMANS1 = rANDOMANS1;
        RANDOMANS2 = rANDOMANS2;
        USELESSSTRING = uSLESSSTRING;
    }

    public int getID() {
        return ID;
    }

    public String getQUESTION() {
        return Question;
    }


    public String getANSWER() {
        return Answer;
    }

    public String getANSWER2() {
        return Answer2;
    }

    public String getRANDOMANS1() {
        return RANDOMANS1;
    }

    public String getRANDOMANS2() {
        return RANDOMANS2;
    }

    public String getUSELESSSTRING() {
        return USELESSSTRING;
    }

    public void setID(int id) {
        ID = id;
    }

    public void setQuestion(String question) {
        Question = question;
    }


    public void setAnswer(String answer) {
        Answer = answer;
    }

    public void setAnswer2(String answer2) {
        Answer2 = answer2;
    }

    public void setRANDOMANS1(String randomans1) {
        RANDOMANS1 = randomans1;
    }

    public void setRANDOMANS2(String randomans2) {
        RANDOMANS2 = randomans2;
    }

    public void setUSELESSSTRING(String uselessstring) {
        USELESSSTRING = uselessstring;
    }

}
