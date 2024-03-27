package com.example.bytepoetic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ArrayList<personaje>listaPersonajes;
    RecyclerView recyclerPersonajes;
    RequestQueue queue;
    ArrayList<menuPrincipal> listMenu;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);


        /*queue = Volley.newRequestQueue(this);



        listMenu = new ArrayList<menuPrincipal>();
        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        agregarlistaMenu("http://khushiconfecciones.com//app_khushi/recycler.php");
        Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show();*/

        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        agregarlistaMenu("http://khushiconfecciones.com//bytepoetic/menu.php");




        listaPersonajes=new ArrayList<>();
        recyclerPersonajes=findViewById(R.id.recycler);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));

        llenarPersonajes();
        AdaptadorPersonajes adapter=new AdaptadorPersonajes(listaPersonajes);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "selección: "+
                                listaPersonajes.get(recyclerPersonajes.getChildAdapterPosition(v)).getNombre(),Toast.LENGTH_SHORT).show();
            }
        });
        recyclerPersonajes.setAdapter(adapter);


    }

    private void llenarPersonajes() {

        listaPersonajes.add(new personaje("krusty_lala","dekkfnlfke",R.drawable.krusti));
        listaPersonajes.add(new personaje("bart","dekkfnlfke",R.drawable.bart));
        listaPersonajes.add(new personaje("burns","dekkfnlfke",R.drawable.burns));
        listaPersonajes.add(new personaje("flanders","dekkfnlfke",R.drawable.flanders));
        listaPersonajes.add(new personaje("homero","dekkfnlfke",R.drawable.homero));
        listaPersonajes.add(new personaje("lisa","dekkfnlfke",R.drawable.lisa));
        listaPersonajes.add(new personaje("magie","dekkfnlfke",R.drawable.magie));
    }


    private void agregarlistaMenu(String URL) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject=null;
                listMenu.clear(); //limpia las lista existente
                for (int i = 0; i < response.length(); i++) {


                    try {
                        jsonObject = response.getJSONObject(i);

                        //String titulo=(jsonObject.getString("titulo "));


                        int id = Integer.parseInt(jsonObject.getString("id"));
                        String titulo =(jsonObject.getString("titulo"));
                        String url =(jsonObject.getString("url"));



                        // String data4 = (data1+ data2+data3);


                        //String url="https://www.google.com/url?sa=i&url=https%3A%2F%2Ftwitter.com%2FGoogleColombia&psig=AOvVaw0h9bhLtziT6XAaWIJZzoIH&ust=1711592672679000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCNiN79uxk4UDFQAAAAAdAAAAABAJ";
                        listaPersonajes.add(new personaje(titulo,titulo,url));



                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                Adapter_menu_principal adapter123 = new Adapter_menu_principal(listMenu);
                recycler.setAdapter(adapter123);

            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error de conexión", Toast.LENGTH_SHORT).show();



            }
        });


        queue.add(jsonArrayRequest);

    }

}