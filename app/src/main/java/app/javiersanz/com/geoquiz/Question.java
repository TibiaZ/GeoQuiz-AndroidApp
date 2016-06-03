package app.javiersanz.com.geoquiz;

/**
 * Created by Usuario on 03/06/2016.
 */
public class Question {

    // Variables

    private int mTextResId;
    private boolean mAnswerTrue;

    // Question constructor

    public Question(int textResId, boolean answerTrue){
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }

    // Getters

    public int getTextResId() {
        return mTextResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    // Setters

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }


}
