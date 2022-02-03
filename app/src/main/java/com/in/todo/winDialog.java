package com.in.todo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class winDialog extends Dialog {
    private final  String message;
    private final MainActivity  mainActivity   ;
    public winDialog(@NonNull Context context,String message,MainActivity  mainActivity) {
        super(context);
        this.message=message;
        this.mainActivity=mainActivity ;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.windialog_layout);

        final TextView messages=findViewById(R.id.messages) ;
        final Button   startagain=findViewById(R.id.startagain) ;
        messages.setText(message);
        startagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.restart();
                dismiss();
            }
        });


    }
}
