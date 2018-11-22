package ca.concordia.project.projectathena;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import ca.concordia.project.projectathena.ca.concordia.project.projectathena.dto.AndroidProcess;
import ca.concordia.project.projectathena.ca.concordia.project.projectathena.utils.ParserUtil;
import ca.concordia.project.projectathena.ca.concordia.project.projectathena.utils.AndroidProcessUtil;

public class MainActivity extends AppCompatActivity {

    private boolean loop;

    private Button buttonTurnOnProtection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTurnOnProtection = (Button) findViewById(R.id.buttonTurnOnProtection);
        buttonTurnOnProtection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loop = true;
               startDefense();
            }
        });
    }

    public void startDefense(){
        while(loop){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AndroidProcess androidProcess = ParserUtil.parseProcess(AndroidProcessUtil.getProcessUsage());
            if(AndroidProcessUtil.isProcessIsMalicious(androidProcess)) {
                loop = false; //Stop the loop
                try {
                    AndroidProcessUtil.killSelectedProcess(androidProcess);
                    Toast.makeText(getApplicationContext(), "Treat detected, high CPU Usage, killing CPU Process...",
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                   startDefense();
                }
            }

        }

    }

}
