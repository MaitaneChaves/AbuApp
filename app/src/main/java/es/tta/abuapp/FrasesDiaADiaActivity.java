package es.tta.abuapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Size;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import es.tta.abuapp.model.BusinessFrases;
import es.tta.abuapp.model.Frases;

public class FrasesDiaADiaActivity extends AppCompatActivity {

    public final static String EXTRA_CASTELLANO = "es.tta.abuapp.castellano";
    public final static String EXTRA_EUSKERA = "es.tta.abuapp.euskera";
    public final static String EXTRA_AUDIO = "es.tta.abuapp.audio";

    private String cast;
    private String eus;
    private String aud;

    public static final String URL = "http://vps213926.ovh.net/AbuApp";
    private Client php= new Client(URL);
    private BusinessFrases server;
    private Frases frase;
    private String[] frasesCastellano;
    private String[] frasesEuskera;
    private String[] frasesAudio;

    private String tipo;
    private TextView tituloView;
    private LinearLayout layout;
    private int num_pag=1;
    private TextView f;
    private int max_frases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frases_dia_adia);

        Intent intent = getIntent();
        tipo = intent.getStringExtra(DiaADiaActivity.EXTRA_TIPO);
        tituloView = (TextView)findViewById(R.id.titulo_diaadia);
        tituloView.setText(tipo.substring(0,1).toUpperCase() + tipo.substring(1));
        layout = (LinearLayout)findViewById(R.id.frases_layout);

        php = new Client(URL);
        server = new BusinessFrases(php);

        max_frases = server.devolverMaximoFrases(tipo);
        frasesCastellano = new String[max_frases];
        frasesEuskera = new String[max_frases];
        frasesAudio = new String[max_frases];
        for(int i=1;i<=max_frases;i++)
        {
            mostrarFrasesTodas();
        }
    }

    public void mostrarFrasesTodas()
    {
        new ProgressTask<String>(this)
        {
            @Override
            protected String work() throws Exception {
                frase = server.getFrases(num_pag, tipo);
                frasesCastellano[num_pag-1] = frase.getFrase_castellano();
                frasesEuskera[num_pag-1] = frase.getFrase_euskera();
                frasesAudio[num_pag-1] = frase.getAudio();
                num_pag++;
                String fraseConNumero = frase.getFrase_castellano() + "--" + (num_pag-1);
                return fraseConNumero;
            }

            @Override
            protected void onFinish(String fraseConNumero) {
                f = new TextView(FrasesDiaADiaActivity.this);
                String[] frase = fraseConNumero.split("--");
                f.setText(frase[0] + "\n");
                f.setId(Integer.valueOf(frase[1]));
                f.setTextColor(Color.WHITE);
                f.setGravity(Gravity.CENTER);
                f.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                layout.addView(f);

                f.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pulsado = v.getId();
                        cast = frasesCastellano[pulsado-1];
                        eus = frasesEuskera[pulsado-1];
                        aud = frasesAudio[pulsado-1];

                        Intent intent = new Intent(FrasesDiaADiaActivity.this,FraseSeleccionadaActivity.class);
                        intent.putExtra(EXTRA_CASTELLANO, cast);
                        intent.putExtra(EXTRA_EUSKERA, eus);
                        intent.putExtra(EXTRA_AUDIO, aud);
                        startActivity(intent);
                    }
                });
            }
        }.execute();
    }
}