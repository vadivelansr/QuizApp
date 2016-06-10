package com.vadivelansr.android.quizapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.feedback_q1)
    AppCompatTextView feedbackQ1;
    @Bind(R.id.feedback_q2)
    AppCompatTextView feedbackQ2;
    @Bind(R.id.feedback_q3)
    AppCompatTextView feedbackQ3;
    @Bind(R.id.feedback_q4)
    AppCompatTextView feedbackQ4;
    @Bind(R.id.feedback_q5)
    AppCompatTextView feedbackQ5;
    @Bind(R.id.feedback_q6)
    AppCompatTextView feedbackQ6;
    @Bind(R.id.radio_q1_choice_1)
    AppCompatRadioButton radioButtonQ1Choice1;
    @Bind(R.id.radio_q1_choice_2)
    AppCompatRadioButton radioButtonQ1Choice2;
    @Bind(R.id.radio_q1_choice_3)
    AppCompatRadioButton radioButtonQ1Choice3;
    @Bind(R.id.radio_q1_choice_4)
    AppCompatRadioButton radioButtonQ1Choice4;
    @Bind(R.id.radio_q6_choice_1)
    AppCompatRadioButton radioButtonQ6Choice1;
    @Bind(R.id.radio_q6_choice_2)
    AppCompatRadioButton radioButtonQ6Choice2;
    @Bind(R.id.radio_q6_choice_3)
    AppCompatRadioButton radioButtonQ6Choice3;
    @Bind(R.id.radio_q6_choice_4)
    AppCompatRadioButton radioButtonQ6Choice4;
    @Bind(R.id.checkbox_q2_choice_1)
    AppCompatCheckBox checkBoxQ2Choice1;
    @Bind(R.id.checkbox_q2_choice_2)
    AppCompatCheckBox checkBoxQ2Choice2;
    @Bind(R.id.checkbox_q2_choice_3)
    AppCompatCheckBox checkBoxQ2Choice3;
    @Bind(R.id.checkbox_q2_choice_4)
    AppCompatCheckBox checkBoxQ2Choice4;
    @Bind(R.id.checkbox_q5_choice_1)
    AppCompatCheckBox checkBoxQ5Choice1;
    @Bind(R.id.checkbox_q5_choice_2)
    AppCompatCheckBox checkBoxQ5Choice2;
    @Bind(R.id.checkbox_q5_choice_3)
    AppCompatCheckBox checkBoxQ5Choice3;
    @Bind(R.id.checkbox_q5_choice_4)
    AppCompatCheckBox checkBoxQ5Choice4;
    @Bind(R.id.input_answer_3)
    AppCompatEditText q3Answer;
    @Bind(R.id.input_answer_4)
    AppCompatEditText q4Answer;

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    public static void hideSoftKeyboard(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    private boolean checkAnswer1() {
        score = 0;
        if (!radioButtonQ1Choice1.isChecked() && !radioButtonQ1Choice2.isChecked()
                && !radioButtonQ1Choice3.isChecked() && !radioButtonQ1Choice4.isChecked()) {
            feedbackQ1.setVisibility(View.VISIBLE);
            feedbackQ1.setText(getString(R.string.answer_the_question));
            return false;
        } else if (radioButtonQ1Choice1.isChecked()) {
            score = score + 1;
            feedbackQ1.setVisibility(View.INVISIBLE);
        } else {
            feedbackQ1.setVisibility(View.VISIBLE);
            feedbackQ1.setText(getString(R.string.incorrect_answer));
        }
        return true;
    }

    private boolean checkAnswer6() {
        if (!radioButtonQ6Choice1.isChecked() && !radioButtonQ6Choice2.isChecked()
                && !radioButtonQ6Choice3.isChecked() && !radioButtonQ6Choice4.isChecked()) {
            feedbackQ6.setVisibility(View.VISIBLE);
            feedbackQ6.setText(getString(R.string.answer_the_question));
            return false;
        } else if (radioButtonQ6Choice2.isChecked()) {
            score = score + 1;
            feedbackQ6.setVisibility(View.INVISIBLE);
        } else {
            feedbackQ6.setVisibility(View.VISIBLE);
            feedbackQ6.setText(getString(R.string.incorrect_answer));
        }
        return true;
    }

    private boolean checkAnswer2() {
        if (!checkBoxQ2Choice1.isChecked() && !checkBoxQ2Choice2.isChecked()
                && !checkBoxQ2Choice3.isChecked() && !checkBoxQ2Choice4.isChecked()) {
            feedbackQ2.setVisibility(View.VISIBLE);
            feedbackQ2.setText(getString(R.string.answer_the_question));
            return false;
        } else if (checkBoxQ2Choice1.isChecked() && checkBoxQ2Choice4.isChecked()
                && !checkBoxQ2Choice2.isChecked() && !checkBoxQ2Choice3.isChecked()) {
            score = score + 1;
            feedbackQ2.setVisibility(View.INVISIBLE);
        } else {
            feedbackQ2.setVisibility(View.VISIBLE);
            feedbackQ2.setText(getString(R.string.incorrect_answer));
        }
        return true;
    }

    private boolean checkAnswer5() {
        if (!checkBoxQ5Choice1.isChecked() && !checkBoxQ5Choice2.isChecked()
                && !checkBoxQ5Choice3.isChecked() && !checkBoxQ5Choice4.isChecked()) {
            feedbackQ5.setVisibility(View.VISIBLE);
            feedbackQ5.setText(getString(R.string.answer_the_question));
            return false;
        } else if (checkBoxQ5Choice1.isChecked() && checkBoxQ5Choice3.isChecked()
                && !checkBoxQ5Choice2.isChecked() && !checkBoxQ5Choice4.isChecked()) {
            score = score + 1;
            feedbackQ5.setVisibility(View.INVISIBLE);
        } else {
            feedbackQ5.setVisibility(View.VISIBLE);
            feedbackQ5.setText(getString(R.string.incorrect_answer));
        }
        return true;
    }

    private boolean checkAnswer3() {
        if (TextUtils.isEmpty(q3Answer.getText().toString().trim())) {
            feedbackQ3.setVisibility(View.VISIBLE);
            feedbackQ3.setText(getString(R.string.answer_the_question));
            return false;
        } else if (q3Answer.getText().toString().trim().equalsIgnoreCase(getString(R.string.answer_3))) {
            score = score + 1;
            feedbackQ3.setVisibility(View.INVISIBLE);
        } else {
            feedbackQ3.setVisibility(View.VISIBLE);
            feedbackQ3.setText(getString(R.string.incorrect_answer));
        }
        return true;
    }

    private boolean checkAnswer4() {
        if (TextUtils.isEmpty(q4Answer.getText().toString().trim())) {
            feedbackQ4.setVisibility(View.VISIBLE);
            feedbackQ4.setText(getString(R.string.answer_the_question));
            return false;
        } else if (q4Answer.getText().toString().trim().equalsIgnoreCase(getString(R.string.answer_4))) {
            score = score + 1;
            feedbackQ4.setVisibility(View.INVISIBLE);
        } else {
            feedbackQ4.setVisibility(View.VISIBLE);
            feedbackQ4.setText(getString(R.string.incorrect_answer));
        }
        return true;
    }

    @OnClick(R.id.button_submit)
    public void onSubmit(View view) {
        hideSoftKeyboard(this, view);
        String feedback = "";
        if (checkAnswer1() && checkAnswer2() && checkAnswer3() && checkAnswer4() && checkAnswer5() && checkAnswer6()) {
            feedback = getString(R.string.score_feedback) + " " + score + getString(R.string.out_of_six);
        } else {
            feedback = getString(R.string.answer_all_the_questions);
        }
        Toast.makeText(this, feedback, Toast.LENGTH_LONG).show();
    }


}
