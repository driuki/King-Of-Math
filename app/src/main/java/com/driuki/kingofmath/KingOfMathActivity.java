package com.driuki.kingofmath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class KingOfMathActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Three lines below makes my program to cover full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Button playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGame();
            }
        });

        // This adds onClickListener on instructionsButton
        // which opens Instructions page
        Button buttonInstructions = (Button) findViewById(R.id.instructionsButton);
        buttonInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstructionsPage();
            }
        });
    }

    // This method is used to open Instructions page from Main page
    public void openInstructionsPage() {
        Intent intent = new Intent(this, Instructions.class);
        startActivity(intent);
    }

    public void openGame() {
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }

}
