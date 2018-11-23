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


    Button btnClick;
    TextView lblDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnClick = (Button) findViewById(R.id.btnClick);
        lblDesc  = (TextView) findViewById(R.id.lblDesc);


        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblDesc.setText("" + generateRamdonNumber());

                Thread t = new Thread(new Runnable() {
                    public void run() {
                        /*
                         * Do something
                         */
                        int i = 0;
                        for ( i=0; i < 1000000000;i++){
                            try {
                                System.out.println("Runtime");
                                Runtime rt = Runtime.getRuntime();
                                Process process = rt.exec("sh");
                                DataOutputStream os = new DataOutputStream(process.getOutputStream());

                                // os.writeBytes("dd if=/dev/zero ibs=4k count=1 of=$x.txt 2>/dev/null")
                                //os.writeBytes("dd if=/dev/zero ibs=4k count=1 of=$x.txt 2>/dev/null" + "\n");
                                os.writeBytes("dd if=/dev/zero of=/dev/null" + "\n");
                                os.flush();
                                os.writeBytes("exit\n");
                                os.flush();
                                process.waitFor();
                            } catch (IOException e) {
                                //log errors
                                System.out.println("IOException" + e.getMessage());
                            } catch (InterruptedException e) {
                                //log errors
                                System.out.println("InterruptedException" + e.getMessage());
                            }
                        }

                    }
                });

                t.start();
            }
        });
    }

    public int generateRamdonNumber(){
        Random r = new Random();
        int ramdonNumber = r.nextInt(80 - 65) + 65;
        return ramdonNumber;
    }
}
