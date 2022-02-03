package com.in.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<int[]>combinationslist=new ArrayList<>() ;
    private  int[] boxpositios={0,0,0,0,0,0,0,0,0} ;
    private int playerturn=1 ;
    private int  checkboxes=1 ;
    private LinearLayout firstplylayout  ,secondplylayout  ;
    private TextView   firstplayer ,secondplayer  ;
    private ImageView  s1,s2,s3,s4,s5,s6,s7,s8,s9 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstplayer = findViewById(R.id.firstplayer);
        secondplayer = findViewById(R.id.secondplayer);

        secondplylayout = findViewById(R.id.secondply_layout);
        firstplylayout = findViewById(R.id.firstply_layout);

        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        s3 = findViewById(R.id.s3);
        s4 = findViewById(R.id.s4);
        s5 = findViewById(R.id.s5);
        s6 = findViewById(R.id.s6);
        s7 = findViewById(R.id.s7);
        s8 = findViewById(R.id.s8);
        s9 = findViewById(R.id.s9);

        combinationslist.add(new int[]{0, 1, 2});
        combinationslist.add(new int[]{3, 4, 5});
        combinationslist.add(new int[]{6, 7, 8});
        combinationslist.add(new int[]{0, 3, 6});
        combinationslist.add(new int[]{0, 4, 8});
        combinationslist.add(new int[]{1, 4, 7});
        combinationslist.add(new int[]{2, 5, 8});
        combinationslist.add(new int[]{2, 4, 6});

        final String getfirstply = getIntent().getStringExtra("first_player_Name");
        final String getsecondply = getIntent().getStringExtra("second_player_Name");

        firstplayer.setText(getfirstply);
        secondplayer.setText(getsecondply);

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxselected(0)){
                    performAction ((ImageView )view,0);

                }
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxselected(1)){
                    performAction ((ImageView )view,1);
                }
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxselected(2)){
                    performAction ((ImageView )view,2);
                }
            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxselected(3)){
                    performAction ((ImageView )view,3);
                }
            }
        });
        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxselected(4)){
                    performAction ((ImageView )view,4);
                }
            }
        });
        s6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxselected(5)){
                    performAction ((ImageView )view,5);
                }
            }
        });
        s7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxselected(6)){
                    performAction ((ImageView ) view,6);
                }

            }
        });
        s8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxselected(7)){
                    performAction ((ImageView) view,7);
                }
            }
        });
        s9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxselected(8)){
                    performAction ((ImageView )view,8);
                }
            }
        });
    }



          private void performAction (ImageView imageView,int selectedbox ) {

              boxpositios[selectedbox] = playerturn;
              if (playerturn == 1) {

                  imageView.setImageResource(R.drawable.x);

              if (checkwinner()) {


                  winDialog winDialog = new winDialog(MainActivity.this, firstplayer.getText().toString() + "has won the match",MainActivity.this);
                 winDialog.setCancelable(false);
                  winDialog.show();
              } else if (selectedbox == 9) {
                  winDialog winDialog = new winDialog(MainActivity.this, "It isa draw", MainActivity.this);
                  winDialog.show();


              } else { chageturn(2);
              selectedbox++ ;

              }
          }
              else  {
                   imageView.setImageResource(R.drawable.o);
                   if (checkwinner()){
                       winDialog winDialog = new winDialog(MainActivity.this, secondplayer.getText().toString() + "has won the match",MainActivity.this);
                       winDialog.setCancelable(false);
                       winDialog.show();

                   } else if (selectedbox ==9) {
                       winDialog winDialog = new winDialog(MainActivity.this, "It isa draw", MainActivity.this);
                       winDialog.show();


                   } else { chageturn(1);
                       selectedbox++ ;

                   }



              }
          }

       private void chageturn (int currentplayer){

        playerturn=currentplayer;
        if(playerturn==1){


            firstplylayout.setBackgroundResource(R.drawable.roundwhite_blue);
            secondplylayout.setBackgroundResource(R.drawable.roundblack_blue);

        }else{

            secondplylayout.setBackgroundResource(R.drawable.roundwhite_blue);
            firstplylayout.setBackgroundResource(R.drawable.roundblack_blue);

        }


       }


          private Boolean checkwinner(){
             boolean response =false ;
             for (int i=0 ; i<combinationslist.size();i++){


                 final int[]combination=combinationslist.get(i);
                 if ((boxpositios[combination[0]]==playerturn)   &&(boxpositios[combination[1]]==playerturn)&&(boxpositios[combination[2]]==playerturn) )
                 { response= true ;}


             }
                   return  response ;
          }

        private Boolean isBoxselected ( int boxposition){

            Boolean response = false;
            if (boxpositios[boxposition] == 0) {

                response = true;

            }
            return response;

        }
          public void restart (){


        boxpositios=new int []{0,0,0,0,0,0,0,0,0};
        playerturn=1 ;
        checkboxes=1  ;
          s1.setImageResource(R.drawable.squar);
              s2.setImageResource(R.drawable.squar);
              s3.setImageResource(R.drawable.squar);
              s4.setImageResource(R.drawable.squar);
              s5.setImageResource(R.drawable.squar);
              s6.setImageResource(R.drawable.squar);
              s7.setImageResource(R.drawable.squar);
              s8.setImageResource(R.drawable.squar);
              s9.setImageResource(R.drawable.squar);







          }




}