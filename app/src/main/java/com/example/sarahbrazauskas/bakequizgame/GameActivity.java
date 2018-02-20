package com.example.sarahbrazauskas.bakequizgame;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class GameActivity extends AppCompatActivity {

    private static final int BAKES_IN_QUIZ = 10; //Limits game to 10 questions
    private Animation correctAnim; // animation for correct guess, is button shake

    Handler setDelay;       //Handler
    Runnable startDelay;    //Runnable for handler

    Button answer1Button, answer2Button, answer3Button, answer4Button;
    ImageView bakeImageView;
    List<BakeModel> list;
    Random r;
    int turn = 1;
    int correctScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setDelay = new Handler();

        r = new Random();
        correctScore = 0;

        bakeImageView = findViewById(R.id.bakeImageView);

        answer1Button = findViewById(R.id.answer1Button);
        answer2Button = findViewById(R.id.answer2Button);
        answer3Button = findViewById(R.id.answer3Button);
        answer4Button = findViewById(R.id.answer4Button);

        list = new ArrayList<>();

        //declare and initialize media player
        final MediaPlayer mpwrong = MediaPlayer.create(this, R.raw.wrongsound);

        // load the shake animation that's used for correct answers
        correctAnim = AnimationUtils.loadAnimation(this, R.anim.anim_correct);

        //add bakes to the list
        for (int i = 0; i < new Database().answers.length; i++) {
            list.add(new BakeModel(new Database().answers[i], new Database().bakes[i]));
        }

        //shuffle the data
        Collections.shuffle(list);
        newQuestion(turn);

        answer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if the answer is correct play animation, show toast, check for game over
                if (answer1Button.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    view.startAnimation(correctAnim);
                    Toast.makeText(GameActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    correctScore = correctScore + 10;

                    //Use handler to delay Game Activity launch until after sound effect finishes
                    startDelay = new Runnable() {
                        @Override
                        public void run(){
                            if (turn < BAKES_IN_QUIZ) {
                                turn++;
                                newQuestion(turn);
                            } else {
                                gameOver();
                            }
                        }
                    };
                    setDelay.postDelayed(startDelay, 2000);

                    //For wrong answer, play sound, disappear button, show toast, check for game over
                } else {
                    mpwrong.start();
                    answer1Button.setVisibility(View.INVISIBLE);
                    Toast.makeText(GameActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();

                    //Use handler to delay Game Activity launch until after sound effect and toast
                    startDelay = new Runnable() {
                        @Override
                        public void run(){
                            if (turn < BAKES_IN_QUIZ) {
                                turn++;
                                answer1Button.setVisibility(View.VISIBLE);
                                newQuestion(turn);
                            } else {
                                gameOver();
                            }
                        }
                    };
                    setDelay.postDelayed(startDelay, 2500);
                }
            }
        });


        answer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if the answer is correct play animation, show toast, check for game over
                if (answer2Button.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    view.startAnimation(correctAnim);
                    Toast.makeText(GameActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    correctScore = correctScore + 10;

                    //Use handler to delay Game Activity launch until after sound effect finishes
                    startDelay = new Runnable() {
                        @Override
                        public void run(){
                            if (turn < BAKES_IN_QUIZ) {
                                turn++;
                                newQuestion(turn);
                            } else {
                                gameOver();
                            }
                        }
                    };
                    setDelay.postDelayed(startDelay, 2500);

                    //For wrong answer, play sound, disappear button, show toast, check for game over
                } else {
                    mpwrong.start();
                    answer2Button.setVisibility(View.INVISIBLE);
                    Toast.makeText(GameActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    //Use handler to delay Game Activity launch until after sound effect and toast
                    startDelay = new Runnable() {
                        @Override
                        public void run(){
                            if (turn < BAKES_IN_QUIZ) {
                                turn++;
                                answer2Button.setVisibility(View.VISIBLE);
                                newQuestion(turn);
                            } else {
                                gameOver();
                            }
                        }
                    };
                    setDelay.postDelayed(startDelay, 2500);
                }
            }

        });

        answer3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if the answer is correct play animation, show toast, check for game over
                if (answer3Button.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    view.startAnimation(correctAnim);
                    Toast.makeText(GameActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    correctScore = correctScore + 10;

                    //Use handler to delay Game Activity launch until after sound effect finishes
                    startDelay = new Runnable() {
                        @Override
                        public void run(){
                            if (turn < BAKES_IN_QUIZ) {
                                turn++;
                                newQuestion(turn);
                            } else {
                                gameOver();
                            }
                        }
                    };
                    setDelay.postDelayed(startDelay, 2500);

                    //For wrong answer, play sound, disappear button, show toast, check for game over
                } else {
                    mpwrong.start();
                    answer3Button.setVisibility(View.INVISIBLE);
                    Toast.makeText(GameActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    //Use handler to delay Game Activity launch until after sound effect and toast
                    startDelay = new Runnable() {
                        @Override
                        public void run(){
                            if (turn < BAKES_IN_QUIZ) {
                                turn++;
                                answer3Button.setVisibility(View.VISIBLE);
                                newQuestion(turn);
                            } else {
                                gameOver();
                            }
                        }
                    };
                    setDelay.postDelayed(startDelay, 2500);
                }
            }
        });

        answer4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if the answer is correct play animation, show toast, check for game over
                if (answer4Button.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    view.startAnimation(correctAnim);
                    Toast.makeText(GameActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    correctScore = correctScore + 10;

                    //Use handler to delay Game Activity launch until after sound effect finishes
                    startDelay = new Runnable() {
                        @Override
                        public void run(){
                            if (turn < BAKES_IN_QUIZ) {
                                turn++;
                                newQuestion(turn);
                            } else {
                                gameOver();
                            }
                        }
                    };
                    setDelay.postDelayed(startDelay, 2500);

                    //For wrong answer, play sound, disappear button, show toast, check for game over
                } else {
                    mpwrong.start();
                    answer4Button.setVisibility(View.INVISIBLE);
                    Toast.makeText(GameActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    //Use handler to delay Game Activity launch until after sound effect and toast
                    startDelay = new Runnable() {
                        @Override
                        public void run(){
                            if (turn < BAKES_IN_QUIZ) {
                                turn++;
                                answer4Button.setVisibility(View.VISIBLE);
                                newQuestion(turn);
                            } else {
                                gameOver();
                            }
                        }
                    };
                    setDelay.postDelayed(startDelay, 2500);
                }
            }
        });

    }

    private void newQuestion(int number) {

        //set new bake image
        bakeImageView.setImageResource(list.get(number - 1).getImage());

        //decide which button to place the correct answer
        int correct_answer = r.nextInt(4) + 1;

        int firstButton = number - 1;
        int secondButton;
        int thirdButton;
        int fourthButton;

        switch (correct_answer) {
            case 1:
                answer1Button.setText(list.get(firstButton).getName());

                do {
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);
                do {
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);
                do {
                    fourthButton = r.nextInt(list.size());
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                answer2Button.setText(list.get(secondButton).getName());
                answer3Button.setText(list.get(thirdButton).getName());
                answer4Button.setText(list.get(fourthButton).getName());

                break;

            case 2:
                answer2Button.setText(list.get(firstButton).getName());

                do {
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);
                do {
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);
                do {
                    fourthButton = r.nextInt(list.size());
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                answer1Button.setText(list.get(secondButton).getName());
                answer3Button.setText(list.get(thirdButton).getName());
                answer4Button.setText(list.get(fourthButton).getName());

                break;

            case 3:
                answer3Button.setText(list.get(firstButton).getName());

                do {
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);
                do {
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);
                do {
                    fourthButton = r.nextInt(list.size());
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                answer2Button.setText(list.get(secondButton).getName());
                answer1Button.setText(list.get(thirdButton).getName());
                answer4Button.setText(list.get(fourthButton).getName());


                break;

            case 4:
                answer4Button.setText(list.get(firstButton).getName());

                do {
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);
                do {
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);
                do {
                    fourthButton = r.nextInt(list.size());
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                answer2Button.setText(list.get(secondButton).getName());
                answer3Button.setText(list.get(thirdButton).getName());
                answer1Button.setText(list.get(fourthButton).getName());

                break;
        }
    }

    //Create Alert Dialog at end of game to show score and send user back to Main Activity
    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GameActivity.this);
        alertDialogBuilder
                .setMessage("Your score: " + correctScore + "%").setCancelable(false).setPositiveButton("New Game",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
