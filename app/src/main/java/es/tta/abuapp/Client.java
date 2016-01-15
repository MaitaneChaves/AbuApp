package es.tta.abuapp;

import android.annotation.TargetApi;
import android.os.Build;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class Client {

    private  String baseURL;
    //private final Map<String,String> properties=new HashMap<>();

    public Client(String baseURL){this.baseURL=baseURL;}
    private HttpURLConnection getConnection(String path) throws IOException {
        URL url=new URL(String.format("%s/%s",baseURL,path));
        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
        /*for(Map.Entry<String,String> property : properties.entrySet())
            conn.setRequestProperty(property.getKey(), property.getValue());
        conn.setUseCaches(false);*/

        return conn;
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    public String getString(String path) throws IOException{
        HttpURLConnection conn=null;
        try{
            conn=getConnection(path);
            try(BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()))){
                String linea=br.readLine();
                return linea;
            }
        }finally{
            if(conn !=null) {
                conn.disconnect();
            }
        }
    }

    public JSONObject getJson(String path) throws IOException, JSONException {
        JSONObject json=new JSONObject(getString(path));
        return json;
    }
}
