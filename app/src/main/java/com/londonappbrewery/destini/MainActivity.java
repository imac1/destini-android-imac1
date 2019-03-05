package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    Button topButton;
    Button bottomButton;
    TextView storyText;
    int mStoryIndex = 1;
    int mStory;
    int mAnswer1;
    int mAnswer2;
    int mEnd;


    private storyAndAnswers [] storyAndAnswBank = new storyAndAnswers[]{
            new storyAndAnswers(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new storyAndAnswers(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new storyAndAnswers(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new storyAndAnswers(R.string.T4_End, R.string.T3_Ans1, R.string.T3_Ans2),
 new storyAndAnswers(R.string.T5_End, R.string.T3_Ans1, R.string.T3_Ans2),
            new storyAndAnswers(R.string.T6_End, R.string.T3_Ans1, R.string.T3_Ans2)
    };

    ArrayList endStory = new ArrayList<endings>();

    int randomEnd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        endStory.add(new endings(getString(R.string.T4_End)));
        endStory.add(new endings(getString(R.string.T5_End)));
        endStory.add(new endings(getString(R.string.T6_End)));

                Random randGenerator = new Random();
         randomEnd = randGenerator.nextInt(endStory.size()-1);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        topButton = findViewById(R.id.buttonTop);
        bottomButton = findViewById(R.id.buttonBottom);
        storyText = findViewById(R.id.storyTextView);




        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStory();
                mStoryIndex ++;
            }
        });




        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStory();
                mStoryIndex ++;
            }
        });


    }
    private void updateStory(){
        mStory = storyAndAnswBank[mStoryIndex].getStoryId();
        storyText.setText(mStory);
        mAnswer1 = storyAndAnswBank[mStoryIndex].getAnswerId1();
        topButton.setText(mAnswer1);
        mAnswer2 = storyAndAnswBank[mStoryIndex].getAnswerId2();
        bottomButton.setText(mAnswer2);

        if (mStoryIndex == 1 ){
            storyText.setText(R.string.T1_Story);
            topButton.setText(R.string.T1_Ans1);
            bottomButton.setText(R.string.T1_Ans2);

        }
        else if (mStoryIndex == 2){
            storyText.setText(R.string.T2_Story);
            topButton.setText(R.string.T2_Ans1);
            bottomButton.setText(R.string.T2_Ans2);
        }
        else if (mStoryIndex == 3){
            storyText.setText(R.string.T3_Story);
            topButton.setText(R.string.T3_Ans1);
            bottomButton.setText(R.string.T3_Ans2);
        }
        else if (mStoryIndex > 4){
            //storyText.setText(R.string.T4_End);
          storyText.setText(((endings)endStory.get(randomEnd)).getEndingId());


           // storyText.setText(getResources().getString(mEnd));
           /* storyText.setText(R.string.T5_End);
            storyText.setText(R.string.T6_End);*/
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();


                }
            });
            alert.show();


        } else if (mStoryIndex > 5){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();


                }
            });
            alert.show();

        }
    }
}
