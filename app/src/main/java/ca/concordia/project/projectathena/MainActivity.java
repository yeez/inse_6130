package ca.concordia.project.projectathena;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import ca.concordia.project.projectathena.ca.concordia.project.projectathena.dto.AndroidProcess;
import ca.concordia.project.projectathena.ca.concordia.project.projectathena.utils.ParserUtil;
import ca.concordia.project.projectathena.ca.concordia.project.projectathena.utils.AndroidProcessUtil;

public class MainActivity extends AppCompatActivity {

//    private TextView textViewcpuUsage;
    private TextView textViewProcessUsage;
    private Button buttonTurnOnProtection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView
//        textViewcpuUsage = (TextView) findViewById(R.id.textViewcpuUsage);
//        textViewcpuUsage.setMovementMethod(new ScrollingMovementMethod());

        textViewProcessUsage = (TextView) findViewById(R.id.textViewProcessUsage);
        textViewProcessUsage.setMovementMethod(new ScrollingMovementMethod());

        //Buttom
        buttonTurnOnProtection = (Button) findViewById(R.id.buttonTurnOnProtection);
        buttonTurnOnProtection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonTurnOnProtection.setText("IT IS ON!!!!!!!!!");
                AndroidProcess androidProcess = ParserUtil.parseProcess(AndroidProcessUtil.getProcessUsage());
                if(AndroidProcessUtil.isProcessIsMalicious(androidProcess)) {
                    try {
                        AndroidProcessUtil.killSelectedProcess(androidProcess);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //textViewProcessUsage.setText();
            }
        });
    }

}
