package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean gameActive=true;
    //Player representation
    // 0-x
    //1-0
    int activePlayer=0;
    int [] gameState={2,2,2,2,2,2,2,2,2};

    //    State meanings
    //    0 - X
    //    1 - o
    //    2 - Null

    int [][] winPositions={{0,1,2},{3,4,5},{6,7,8},
                          {0,3,6},{1,4,7},{2,5,8},
                          {0,4,8},{2,4,6}};
    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if (gameState[tappedImage] == 2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.cross);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O turn - Tap to play");
            }
            else {
                img.setImageResource(R.drawable.round1);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X turn - Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        //check any player has won
        for(int[] winPosition: winPositions){
            if(gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]]!=2){
                gameActive=false;
                String winnerStr;
                if(gameState[winPosition[0]]== 0){
                    winnerStr= "X has won\nTap to play ";
                }
                else {
                    winnerStr= "O has won";
                }
                //Announcement of winner
                TextView status= findViewById(R.id.status);
                status.setText(winnerStr);
            }
            if(gameState[0]!=2 && gameState[1]!=2 && gameState[2]!=2 && gameState[3]!=2 && gameState[4]!=2 && gameState[5]!=2 && gameState[6]!=2 &&
                    gameState[7]!=2 && gameState[8]!=2 ){
                Toast.makeText(this,"Match Draw",Toast.LENGTH_SHORT).show();
                String match= "X turn - Tap to play ";;
                TextView status= findViewById(R.id.status);
                status.setText(match);
                gameReset(view);

            }
        }
    }
    public void gameReset(View view){
        gameActive=true;
        activePlayer=0;
        for (int i=0;i< gameState.length; i++){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}