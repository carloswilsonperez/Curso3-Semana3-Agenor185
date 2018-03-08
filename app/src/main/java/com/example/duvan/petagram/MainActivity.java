package com.example.duvan.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota>  mascotas;
    RecyclerView rvMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar =  (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);



        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas); //Buscamos el view en el layout
        LinearLayoutManager llm = new LinearLayoutManager(this); //Creamos un manager para el recycler view
        rvMascotas.setLayoutManager(llm); //cambiamos el recyclerview para que se muestre en un LinearLayout
        inicializarMascotas();
        inicializarAdapdator();

    }

    public void inicializarAdapdator(){
         mascotaAdaptador adaptador = new mascotaAdaptador(mascotas, this);
         rvMascotas.setAdapter(adaptador);
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Catyy",R.drawable.m1));
        mascotas.add(new Mascota("Max",R.drawable.img2));
        mascotas.add(new Mascota("Doggy",R.drawable.img3));
        mascotas.add(new Mascota("Catun",R.drawable.img4));
        mascotas.add(new Mascota("Loran",R.drawable.img5));
        mascotas.add(new Mascota("Moran",R.drawable.img6));


    }

    public void activityFavoritos(View view){
        Intent intent = new Intent(this, activityMascotaFavorita.class);
        startActivity(intent);


    }
}
