package com.uninorte.informesestadsticos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityInformes extends AppCompatActivity {


    ListView lvMain;
    ArrayList<InformesPeriodos> datos= new ArrayList <> ();
    MainAdapterInformes customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main_informes);
        //  setContentView(R.layout.listview_photos);

        //Datos de Prueba
        datos.add(new InformesPeriodos(getResources().getString(R.string.report1)));
        datos.add(new InformesPeriodos(getResources().getString(R.string.report2)));
        datos.add(new InformesPeriodos(getResources().getString(R.string.report3)));
        datos.add(new InformesPeriodos(getResources().getString(R.string.report4)));
        datos.add(new InformesPeriodos(getResources().getString(R.string.report5)));
        datos.add(new InformesPeriodos(getResources().getString(R.string.report6)));
        datos.add(new InformesPeriodos(getResources().getString(R.string.report7)));

        //Cargamos el ListView con el adaptador.
        lvMain=(ListView)findViewById(R.id.ListView1);
        customAdapter = new MainAdapterInformes(getApplicationContext(),datos);
        lvMain.setAdapter(customAdapter);

        //para saber cual informe fue seleccionado
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(getApplicationContext(),MainActivityPeriodos.class);
                intent.putExtra("Titulo",datos.get(position).infoPeri);
                startActivity(intent);
            }
        });
    }
}
