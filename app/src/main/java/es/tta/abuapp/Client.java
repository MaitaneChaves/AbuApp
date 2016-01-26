package es.tta.abuapp;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class Client {

    public String baseURL;

    public Client(String baseURL){this.baseURL=baseURL;}
    
    private HttpURLConnection getConnection(String path) throws IOException {
        URL url=new URL(String.format("%s/%s",baseURL,path));
        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
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
        System.out.println(json);
        return json;
    }

    public  Bitmap downloadImage(String imagen)
    {
        Bitmap loadedImage=null;
        try {
            HttpURLConnection conn = getConnection(imagen);
            loadedImage = BitmapFactory.decodeStream(conn.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
            return loadedImage;
    }

}
