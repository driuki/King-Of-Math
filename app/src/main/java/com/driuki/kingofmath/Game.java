package com.driuki.kingofmath;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Game extends Activity {

    private TextView textFirstNumRandom, operatorText, textSecondNumRandom, answer, textAnswer,
        timer;
    private Button checkAnswer;
    private EditText answerEdit;
    private String answerStringEdit;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 11 * 1000;

    GameEngine engine = new GameEngine();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Three lines below makes my program to cover full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

        engine.operatorNumber();
        engine.setNumbersRandom();
        startTimer();

        textFirstNumRandom = (TextView) findViewById(R.id.firstNumber);
        textFirstNumRandom.setText(String.valueOf(engine.getNum1()));

        operatorText = (TextView) findViewById(R.id.mathOperator);
        operatorText.setText(String.valueOf(engine.operatorStringBuilder()));

        textSecondNumRandom = (TextView) findViewById(R.id.secondNumber);
        textSecondNumRandom.setText(String.valueOf(engine.getNum2()));

//        textAnswer = (TextView) findViewById(R.id.answer);
//        textAnswer.setText(String.valueOf(engine.count()));

        answerEdit = (EditText) findViewById(R.id.writeAnswer);

        checkAnswer = (Button) findViewById(R.id.buttonCheckAnswer);
        checkAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerStringEdit = answerEdit.getText().toString();
                String intNumber = answerStringEdit;
                int number = Integer.parseInt(intNumber);
                engine.setPersonAnswer(number);
                engine.checkResult();
                answer.setText(String.valueOf(engine.ansIfTrue()));
            }
        });

        answer = (TextView) findViewById(R.id.textViewAnswer);

        timer = (TextView) findViewById(R.id.timer);


    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                String resultText = "Time: " + l / 1000;
                timer.setText(resultText);
            }

            @Override
            public void onFinish() {
                String resultText = "Time: 0";
                timer.setText(resultText);
            }
        }.start();
    }

}
