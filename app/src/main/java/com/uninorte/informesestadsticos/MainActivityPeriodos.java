package com.uninorte.informesestadsticos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityPeriodos extends AppCompatActivity {


    ListView lvMainPeriodos;
    ArrayList<InformesPeriodos> datos= new ArrayList <> ();
    MainAdapterPeriodos customAdapter;
    String NombreInforme;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_periodos);

        tv2=(TextView)findViewById(R.id.second_main_textView);

//Datos de prueba para los periodos
        datos.add(new InformesPeriodos(getResources().getString(R.string.periodo1)));
        datos.add(new InformesPeriodos(getResources().getString(R.string.periodo2)));
        datos.add(new InformesPeriodos(getResources().getString(R.string.periodo3)));
        datos.add(new InformesPeriodos(getResources().getString(R.string.periodo4)));
        datos.add(new InformesPeriodos(getResources().getString(R.string.periodo5)));
        datos.add(new InformesPeriodos(getResources().getString(R.string.periodo6)));
        datos.add(new InformesPeriodos(getResources().getString(R.string.periodo7)));

//Traemos el nombre del Informe de la actividad anterior
        Intent intent = getIntent();
        NombreInforme=intent.getStringExtra("Titulo");
        tv2.setText(NombreInforme);

//Cargamos ListView..........
        lvMainPeriodos=(ListView)findViewById(R.id.ListView2);
        customAdapter = new MainAdapterPeriodos(getApplicationContext(),datos);
        lvMainPeriodos.setAdapter(customAdapter);
        lvMainPeriodos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(getApplicationContext(),MainActivityPhotos.class);
                intent.putExtra("Informe",NombreInforme);
                intent.putExtra("Semestre",datos.get(position).getInfoPeri());
                startActivity(intent);

            }
        });


    }
}
