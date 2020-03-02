package br.edu.ifsp.arq.dmo_2020s1.conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConversorTemperatura extends AppCompatActivity implements View.OnClickListener {

    private EditText entradaEditText;
    private Button fahrenheit2celsius;
    private TextView saidaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_temperatura);

        entradaEditText = findViewById(R.id.edittext_valor);
        fahrenheit2celsius = findViewById(R.id.coverte_celsius);
        saidaTextView = findViewById(R.id.textview_valor_saida);

        fahrenheit2celsius.setOnClickListener(this);
    }

        @Override
        public void onClick (View v){
            if (v == fahrenheit2celsius) {
                converterParaCelsius();
            }
        }

        private double getEntrada () throws NumberFormatException {
            double entrada;
            try {
                entrada = Double.valueOf(entradaEditText.getText().toString());
            } catch (NumberFormatException e) {
                entrada = 0;
                throw e;
            }

            return entrada;
        }

        private void converterParaCelsius () {
            double valor;
            try {
                valor = getEntrada();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Valor Digitado e invalido", Toast.LENGTH_SHORT).show();
                valor = 0;
            }

            saidaTextView.setText(String.format("%.2f °C", (valor-32)/1.8));
        }
    }
