package com.example.quranapplication_n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView pText;
    TextView aText;
    Button search;
    TextView display;
    Button git;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pText = findViewById(R.id.parahText);
        aText = findViewById(R.id.ayatText);
        search = findViewById(R.id.buttonSearch);
        display = findViewById(R.id.displayWindow);
        git = findViewById(R.id.buttonGit2);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valP = Integer.parseInt(pText.getText().toString());
                int valA = Integer.parseInt(aText.getText().toString());
                QDH qdh=new QDH();
                int ps=qdh.getParahStart(valP-1);
                ps+=valA;
                QuranArabicText txt=new QuranArabicText();
                String ayat=txt.QuranArabicText[ps];
                display.setText(ayat);

            }
        });
        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "";

                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                startActivity(intent);
            }
        });


    }
}