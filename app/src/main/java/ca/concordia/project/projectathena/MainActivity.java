package ca.concordia.project.projectathena;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private TextView textViewcpuUsage;
    private Button buttonTurnOnProtection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView
        textViewcpuUsage = (TextView)findViewById(R.id.textViewcpuUsage);
        textViewcpuUsage.setMovementMethod(new ScrollingMovementMethod());

        //Buttom
        buttonTurnOnProtection = (Button)findViewById(R.id.buttonTurnOnProtection);
        buttonTurnOnProtection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonTurnOnProtection.setText("IT IS ON!!!!!!!!!");
                textViewcpuUsage.setText(checkCpuUsage());
            }
        });
    }

    private static String checkCpuUsage(){
        ProcessBuilder processBuilder;
        String holder = "";
        String[] DATA = {"/system/bin/cat", "/proc/cpuinfo"};
        InputStream inputStream;
        Process process ;
        byte[] byteArry ;
        byteArry = new byte[1024];
        try{
            processBuilder = new ProcessBuilder(DATA);
            process = processBuilder.start();
            inputStream = process.getInputStream();
            while(inputStream.read(byteArry) != -1){
                holder = holder + new String(byteArry);
            }
            inputStream.close();

        } catch(IOException ex){
            ex.printStackTrace();
        }
        return holder;
    }
    }
