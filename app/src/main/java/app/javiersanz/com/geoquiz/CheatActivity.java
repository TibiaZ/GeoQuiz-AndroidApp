package app.javiersanz.com.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    // Extra for the intent. It'll make know the answer it receives

    private static final String EXTRA_ANSWER_IS_TRUE = "app.javiersanz.com.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "app.javiersanz.com.geoquiz.answer.shown";
    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;

    // Intent method to go back to QuizActivity

    public static Intent newIntent(Context packageContext, boolean answerIsTrue){
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue);
        return i;
    }

    // Method to see if the answer was shown

    public static boolean wasAnswerShown(Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

    // onCreate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        // Matching widgets with their variables

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);
        mShowAnswer = (Button) findViewById(R.id.show_answer_button);

        // Listeners

        mShowAnswer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mAnswerIsTrue){
                    mAnswerTextView.setText(R.string.true_button);
                }else{
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });
    }

    // Method setAnswerShownResult
    // This method will give back information to QuizActivity about whether the user has shown the result or not

    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }
    
}
