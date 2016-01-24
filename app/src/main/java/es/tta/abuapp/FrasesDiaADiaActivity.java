package es.tta.abuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import es.tta.abuapp.model.BusinessFrases;
import es.tta.abuapp.model.Frases;

public class FrasesDiaADiaActivity extends AppCompatActivity {

    public static final String URL = "http://vps213926.ovh.net/AbuApp";
    private Client php= new Client(URL);
    private BusinessFrases server;
    private Frases frase;
    private String[] frases;
    //private DataFrases data;

    private String tipo;
    private TextView tituloView;
    private LinearLayout layout;
    private int num_pag=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frases_dia_adia);

        Intent intent = getIntent();
        tipo = intent.getStringExtra(DiaADiaActivity.EXTRA_TIPO);
        tituloView = (TextView)findViewById(R.id.titulo_diaadia);
        tituloView.setText(tipo);
        layout = (LinearLayout)findViewById(R.id.frases_layout);

        php = new Client(URL);
        server = new BusinessFrases(php);

        frases = new String[3]; //CAMBIAR POR MAX_FRASES
        mostrarFrasesTodas();
    }

    public void mostrarFrasesTodas()
    {
        new ProgressTask<String[]>(this)
        {
            @Override
            protected String[] work() throws Exception {
                for(int i=1;i<=3/*server.getMAX_FRASES()*/;i++)
                {
                    frase = server.getFrases(num_pag, tipo);
                    frases[num_pag-1] = frase.getFrase_castellano();
                    num_pag++;
                }
                return frases;
            }

            @Override
            protected void onFinish(String[] frases) {
                for(int i=1;i<=3/*server.getMAX_FRASES()*/;i++)
                {
                    TextView f = new TextView(FrasesDiaADiaActivity.this);
                    f.setText(frases[i-1]);
                    layout.addView(f);
                }
            }
        }.execute();
    }
}
