package com.example.bytepoetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RequestQueue queue;
    ArrayList<menuPrincipal> listMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show();


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

                        String titulo=(jsonObject.getString("titulo "));
                        int imagen = Integer.parseInt(jsonObject.getString("imagen"));



                        // String data4 = (data1+ data2+data3);


                        //String url="http://khushiconfecciones.com//app_khushi/imagenes/carpeta_imagenes/Intel_logo_(2006-2020).jpg";
                        listMenu.add(new menuPrincipal(titulo,imagen));



                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }


            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        queue.add(jsonArrayRequest);

    }

}