package com.uninorte.informesestadsticos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityPhotos extends AppCompatActivity {

    ListView lvMainPhotos;
    ArrayList<Photos> datos= new ArrayList <> ();
    MainAdapterPhotos customAdapter;
    TextView tv3,tvSemestre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_photos);

        tv3=(TextView)findViewById(R.id.third_main_textView);
        tvSemestre=(TextView)findViewById(R.id.tvSemestre);

//Fotos de prueba
        datos.add(new Photos(R.drawable.prueba));
        datos.add(new Photos(R.drawable.prueba1));
        datos.add(new Photos(R.drawable.prueba2));
        datos.add(new Photos(R.drawable.mms01));
        datos.add(new Photos(R.drawable.mms02));
        datos.add(new Photos(R.drawable.mms03));
        datos.add(new Photos(R.drawable.mms04));
        datos.add(new Photos(R.drawable.mms05));
        datos.add(new Photos(R.drawable.mms06));
        datos.add(new Photos(R.drawable.mms07));
        datos.add(new Photos(R.drawable.mms08));
        datos.add(new Photos(R.drawable.mms09));

//Obtenemos el nombre del informe y el periodo el cual se selecciono
        Intent intent = getIntent();
        intent.getStringExtra("Informe");
        intent.getStringExtra("Semestre");
        tv3.setText(intent.getStringExtra("Informe"));
        tvSemestre.setText(intent.getStringExtra("Semestre"));

//Cargamos ListView..........
        lvMainPhotos=(ListView)findViewById(R.id.ListView3);
        customAdapter = new MainAdapterPhotos(getApplicationContext(),datos);
        lvMainPhotos.setAdapter(customAdapter);
        lvMainPhotos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(getApplicationContext(),ShowPhoto.class);
                intent.putExtra("photoInteger",datos.get(position).photos+"");
                startActivity(intent);

            }
        });


    }
}
