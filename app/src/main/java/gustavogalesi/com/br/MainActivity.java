package gustavogalesi.com.br;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import gustavogalesi.com.br.modelo.cep;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    private EditText etCep;
    private TextView tvCep;
    private TextView tvLogradouro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCep = (EditText)findViewById(R.id.etCep);
        tvCep = (TextView) findViewById(R.id.tvCep);
        tvLogradouro = (TextView) findViewById(R.id.tvLogradouro);

    }

    public interface PAIF{
        @GET("/cep/{cep}")
        Call<cep> buscarCep(@Path(value = "cep") String cep);
    }

    public void pesquisar (View v){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://correiosapi.apphb.com/cep/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PAIF service = retrofit.create(PAIF.class);

        service.buscarCep(etCep.getText().toString())
                .enqueue(new Callback<cep>() {
                    @Override
                    public void onResponse(Call<cep> call, Response<cep> response) {
                        tvLogradouro.setText(response.body().getLogradouro());

                        response.body().getBairro();
                        response.body().getCidade();
                        response.body().getEstado();
                    }

                    @Override
                    public void onFailure(Call<cep> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "CEP Digitado nao encontrado", Toast.LENGTH_SHORT).show();

                    }
                });

    }
}
