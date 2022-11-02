package com.example.volley;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //kisiEkle();
        //kisiGuncelle();
        //kisiSil();
        //tumKisiler();
        kisiArama();
    }

    public void kisiEkle(){
        String url = "http://kasimadalan.pe.hu/kisiler/insert_kisiler.php";

        StringRequest istek = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Cevap",response);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("kisi_ad","Nida");
                params.put("kisi_tel","0564643846");
                return params;
            }
        };
        Volley.newRequestQueue(this).add(istek);
    }

    public void kisiGuncelle(){
        String url = "http://kasimadalan.pe.hu/kisiler/update_kisiler.php";

        StringRequest istek = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Cevap",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();

                params.put("kisi_id","36");
                params.put("kisi_ad","Nidaxxx");
                params.put("kisi_tel","22222222");
                return params;
            }
        };
        Volley.newRequestQueue(this).add(istek);
    }
    public void kisiSil(){
        String url = "http://kasimadalan.pe.hu/kisiler/delete_kisiler.php";

        StringRequest istek = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Cevap",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("kisi_id","36");
                return params;
            }
        };
        Volley.newRequestQueue(this).add(istek);
    }

    public void tumKisiler(){
        String url = "http://kasimadalan.pe.hu/kisiler/tum_kisiler.php";

        StringRequest istek = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            Log.e("Cevap:",response);
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray kisilerListe = jsonObject.getJSONArray("kisiler");
                    for (int i=0;i<kisilerListe.length();i++){
                        JSONObject k = kisilerListe.getJSONObject(i);
                        int kisi_id=k.getInt("kisi_id");
                        String kisi_ad=k.getString("kisi_ad");
                        String kisi_tel=k.getString("kisi_tel");

                        Log.e("kisi_id",String.valueOf(kisi_id));
                        Log.e("kisi_ad",kisi_ad);
                        Log.e("kisi_tel",kisi_tel);
                        Log.e("********","*******");



                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(istek);
    }
    public void kisiArama(){
        String url = "http://kasimadalan.pe.hu/kisiler/tum_kisiler_arama.php";

        StringRequest istek = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Cevap:",response);
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray kisilerListe = jsonObject.getJSONArray("kisiler");
                    for (int i=0;i<kisilerListe.length();i++){
                        JSONObject k = kisilerListe.getJSONObject(i);
                        int kisi_id=k.getInt("kisi_id");
                        String kisi_ad=k.getString("kisi_ad");
                        String kisi_tel=k.getString("kisi_tel");

                        Log.e("kisi_id",String.valueOf(kisi_id));
                        Log.e("kisi_ad",kisi_ad);
                        Log.e("kisi_tel",kisi_tel);
                        Log.e("********","*******");



                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();
                params.put("kisi_ad","a");
                return super.getParams();
            }
        };

        Volley.newRequestQueue(this).add(istek);
    }
}