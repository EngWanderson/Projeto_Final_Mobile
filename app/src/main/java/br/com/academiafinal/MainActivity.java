package br.com.academiafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView cardvieMedidas, cardTreinos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardvieMedidas=findViewById(R.id.cardmedida);
        cardTreinos =  findViewById(R.id.cardTreinos);

        cardvieMedidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, TelaMedidas.class);
                startActivity(intent);
            }
        });
        cardTreinos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Treinos.class);
                startActivity(intent);
            }
        });
    }


}