package com.tsybulnik.gamememory;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Collections;

public class GameMiddleActivity extends AppCompatActivity {
    ImageView iv_11, iv_12, iv_13, iv_14, iv_21, iv_22, iv_23, iv_24, iv_31, iv_32, iv_33, iv_34;
    // array for images
    Integer[] cardArray = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206};
    // actual images
    int image101, image102, image103, image104, image105, image106;
    int image201, image202, image203, image204, image205, image206;
    int firstCard, secondCard;
    int clickedFirstCard, clickedSecondCard;
    int cardNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_middle);
        iv_11 = findViewById(R.id.iv_11);
        iv_12 = findViewById(R.id.iv_12);
        iv_13 = findViewById(R.id.iv_13);
        iv_14 = findViewById(R.id.iv_14);
        iv_21 = findViewById(R.id.iv_21);
        iv_22 = findViewById(R.id.iv_22);
        iv_23 = findViewById(R.id.iv_23);
        iv_24 = findViewById(R.id.iv_24);
        iv_31 = findViewById(R.id.iv_31);
        iv_32 = findViewById(R.id.iv_32);
        iv_33 = findViewById(R.id.iv_33);
        iv_34 = findViewById(R.id.iv_34);


        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");
        iv_21.setTag("4");
        iv_22.setTag("5");
        iv_23.setTag("6");
        iv_24.setTag("7");
        iv_31.setTag("8");
        iv_32.setTag("9");
        iv_33.setTag("10");
        iv_34.setTag("11");

        // load cards images
        frontOfCardsRecources();
        //shuffle images
        Collections.shuffle(Arrays.asList(cardArray));
        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_11, theCard);
            }
        });
        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_12, theCard);

            }
        });
        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_13, theCard);

            }
        });
        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_14, theCard);

            }
        });
        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_21, theCard);

            }
        });
        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_22, theCard);

            }
        });
        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_23, theCard);

            }
        });
        iv_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_24, theCard);

            }
        });
        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_31, theCard);

            }
        });
        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_32, theCard);

            }
        });
        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_33, theCard);

            }
        });
        iv_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_34, theCard);

            }
        });

    }

    private void frontOfCardsRecources() {
        image101 = R.drawable.sample101;
        image102 = R.drawable.sample102;
        image103 = R.drawable.sample103;
        image104 = R.drawable.sample104;
        image105 = R.drawable.sample105;
        image106 = R.drawable.sample106;

        image201 = R.drawable.sample201;
        image202 = R.drawable.sample202;
        image203 = R.drawable.sample203;
        image204 = R.drawable.sample204;
        image205 = R.drawable.sample205;
        image206 = R.drawable.sample206;

        Log.d("MyLog", String.valueOf(image101));
    }

    private void doStuff(ImageView iv, int card) {
        //set corrext image to imageview
        if (cardArray[card] == 101) {
            iv.setImageResource(image101);
        } else if (cardArray[card] == 102) {
            iv.setImageResource(image102);
        } else if (cardArray[card] == 103) {
            iv.setImageResource(image103);
        } else if (cardArray[card] == 104) {
            iv.setImageResource(image104);
        } else if (cardArray[card] == 105) {
            iv.setImageResource(image105);
        } else if (cardArray[card] == 106) {
            iv.setImageResource(image106);

        } else if (cardArray[card] == 201) {
            iv.setImageResource(image201);
        } else if (cardArray[card] == 202) {
            iv.setImageResource(image202);
        } else if (cardArray[card] == 203) {
            iv.setImageResource(image203);
        } else if (cardArray[card] == 204) {
            iv.setImageResource(image204);
        } else if (cardArray[card] == 205) {
            iv.setImageResource(image205);
        } else if (cardArray[card] == 206) {
            iv.setImageResource(image206);
        }
        // check which image is selected and svae it to temporary variaable

        if (cardNumber == 1) {
            firstCard = cardArray[card];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirstCard = card;
            iv.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = cardArray[card];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecondCard = card;
            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_24.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_33.setEnabled(false);
            iv_34.setEnabled(false);


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // check if the selected are equals
                    calculate();
                }
            }, 500);
        }
    }

    private void calculate() {
        if (firstCard == secondCard) {
            if (clickedFirstCard == 0) {
                iv_11.setVisibility(View.INVISIBLE);

            } else if (clickedFirstCard == 1) {
                iv_12.setVisibility(View.INVISIBLE);

            } else if (clickedFirstCard == 2) {
                iv_13.setVisibility(View.INVISIBLE);

            } else if (clickedFirstCard == 3) {
                iv_14.setVisibility(View.INVISIBLE);

            } else if (clickedFirstCard == 4) {
                iv_21.setVisibility(View.INVISIBLE);

            } else if (clickedFirstCard == 5) {
                iv_22.setVisibility(View.INVISIBLE);

            } else if (clickedFirstCard == 6) {
                iv_23.setVisibility(View.INVISIBLE);

            } else if (clickedFirstCard == 7) {
                iv_24.setVisibility(View.INVISIBLE);

            } else if (clickedFirstCard == 8) {
                iv_31.setVisibility(View.INVISIBLE);

            } else if (clickedFirstCard == 9) {
                iv_32.setVisibility(View.INVISIBLE);

            } else if (clickedFirstCard == 10) {
                iv_33.setVisibility(View.INVISIBLE);

            } else if (clickedFirstCard == 11) {
                iv_34.setVisibility(View.INVISIBLE);

            }

            if (clickedSecondCard == 0) {
                iv_11.setVisibility(View.INVISIBLE);

            } else if (clickedSecondCard == 1) {
                iv_12.setVisibility(View.INVISIBLE);

            } else if (clickedSecondCard == 2) {
                iv_13.setVisibility(View.INVISIBLE);

            } else if (clickedSecondCard == 3) {
                iv_14.setVisibility(View.INVISIBLE);

            } else if (clickedSecondCard == 4) {
                iv_21.setVisibility(View.INVISIBLE);

            } else if (clickedSecondCard == 5) {
                iv_22.setVisibility(View.INVISIBLE);

            } else if (clickedSecondCard == 6) {
                iv_23.setVisibility(View.INVISIBLE);

            } else if (clickedSecondCard == 7) {
                iv_24.setVisibility(View.INVISIBLE);

            } else if (clickedSecondCard == 8) {
                iv_31.setVisibility(View.INVISIBLE);

            } else if (clickedSecondCard == 9) {
                iv_32.setVisibility(View.INVISIBLE);

            } else if (clickedSecondCard == 10) {
                iv_33.setVisibility(View.INVISIBLE);

            } else if (clickedSecondCard == 11) {
                iv_34.setVisibility(View.INVISIBLE);

            }
        } else {
            iv_11.setImageResource(R.drawable.question);
            iv_12.setImageResource(R.drawable.question);
            iv_13.setImageResource(R.drawable.question);
            iv_14.setImageResource(R.drawable.question);
            iv_21.setImageResource(R.drawable.question);
            iv_22.setImageResource(R.drawable.question);
            iv_23.setImageResource(R.drawable.question);
            iv_24.setImageResource(R.drawable.question);
            iv_31.setImageResource(R.drawable.question);
            iv_32.setImageResource(R.drawable.question);
            iv_33.setImageResource(R.drawable.question);
            iv_34.setImageResource(R.drawable.question);

        }
        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_24.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_34.setEnabled(true);

        // check gameIsOver
        checkGame();
    }

    private void checkGame() {
        if (iv_11.getVisibility() == View.INVISIBLE &&
                iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE &&
                iv_14.getVisibility() == View.INVISIBLE &&
                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&
                iv_23.getVisibility() == View.INVISIBLE &&
                iv_24.getVisibility() == View.INVISIBLE &&
                iv_31.getVisibility() == View.INVISIBLE &&
                iv_32.getVisibility() == View.INVISIBLE &&
                iv_33.getVisibility() == View.INVISIBLE &&
                iv_34.getVisibility() == View.INVISIBLE
               ) {

            AlertDialog.Builder alertBulder = new AlertDialog.Builder(GameMiddleActivity.this);
            alertBulder.setMessage(R.string.finish_level)
                    .setCancelable(false)
                    .setPositiveButton(R.string.new_game, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            retryGame();
                        }
                    })
                    .setNegativeButton(R.string.back, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(GameMiddleActivity.this, LevelActivity.class);
                            startActivity(intent);
                        }
                    });
            AlertDialog alertDialog = alertBulder.create();
            alertDialog.show();

        }
    }

    private void retryGame() {
        iv_11.setVisibility(View.VISIBLE);
        iv_11.setImageResource(R.drawable.question);

        iv_12.setVisibility(View.VISIBLE);
        iv_12.setImageResource(R.drawable.question);

        iv_13.setVisibility(View.VISIBLE);
        iv_13.setImageResource(R.drawable.question);

        iv_14.setVisibility(View.VISIBLE);
        iv_14.setImageResource(R.drawable.question);

        iv_21.setVisibility(View.VISIBLE);
        iv_21.setImageResource(R.drawable.question);

        iv_22.setVisibility(View.VISIBLE);
        iv_22.setImageResource(R.drawable.question);

        iv_23.setVisibility(View.VISIBLE);
        iv_23.setImageResource(R.drawable.question);

        iv_24.setVisibility(View.VISIBLE);
        iv_24.setImageResource(R.drawable.question);

        iv_31.setVisibility(View.VISIBLE);
        iv_31.setImageResource(R.drawable.question);

        iv_32.setVisibility(View.VISIBLE);
        iv_32.setImageResource(R.drawable.question);

        iv_33.setVisibility(View.VISIBLE);
        iv_33.setImageResource(R.drawable.question);

        iv_34.setVisibility(View.VISIBLE);
        iv_34.setImageResource(R.drawable.question);


    }
}