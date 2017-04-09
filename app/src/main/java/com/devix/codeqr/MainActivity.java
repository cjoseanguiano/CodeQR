package com.devix.codeqr;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.devix.codeqr_chat_bsd.R;

public class MainActivity extends AppCompatActivity {

    private Button btnLector;
    private Button btnGenerator;
    private Context context;
    private Button btnAnexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLector = (Button) findViewById(R.id.btnLector);
        btnGenerator = (Button) findViewById(R.id.btnGenerator);
        btnAnexo = (Button)findViewById(R.id.btnAnexo);
        context = getApplicationContext();

        btnLector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = getApplicationContext();
                Toast.makeText(context, "Button Reader", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ReaderMain.class);
                startActivity(intent);

            }
        });


        btnGenerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Button Generator", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, GeneratorMain.class);
                startActivity(intent);

            }
        });

        btnAnexo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Button Anexo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AnexoMain.class);
                startActivity(intent);

            }
        });
    }

}
