package com.marcos.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button numeroZero,numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove,
    ponto, subtracao, soma, divisao, multiplicacao, igual, botao_limpar;

    private TextView txtExpressao, txtResultado;
    private ImageView backspace;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        divisao.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);


        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if(!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;

                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);

                }
                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if(resultado == (double) longResult){
                        txtResultado.setText((CharSequence) String.valueOf(longResult));

                    }else{
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }

                }catch (Exception e){

                }

            }
        });


    }

    private void iniciarComponentes(){
        numeroZero = findViewById(R.id.btn_zero);
        numeroUm = findViewById(R.id.btn_um);
        numeroDois = findViewById(R.id.btn_dois);
        numeroTres = findViewById(R.id.btn_tres);
        numeroQuatro = findViewById(R.id.btn_quatro);
        numeroCinco = findViewById(R.id.btn_cinco);
        numeroSeis = findViewById(R.id.btn_seis);
        numeroSete = findViewById(R.id.btn_sete);
        numeroOito = findViewById(R.id.btn_oito);
        numeroNove = findViewById(R.id.btn_nove);
        ponto = findViewById(R.id.btn_ponto);
        soma = findViewById(R.id.btn_soma);
        subtracao = findViewById(R.id.btn_subtracao);
        multiplicacao = findViewById(R.id.btn_multiplicacao);
        divisao = findViewById(R.id.btn_divisao);
        igual = findViewById(R.id.btn_igual);
        botao_limpar = findViewById(R.id.btn_limpar);
        backspace = findViewById(R.id.backspace);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
    }

    public void addExpressao(String string, boolean limpar_dados){
        if (txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }
        if (limpar_dados){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }else{
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_zero:
                addExpressao("0", true);
                break;

            case R.id.btn_um:
                addExpressao("1", true);
                break;

            case R.id.btn_dois:
                addExpressao("2", true);
                break;

            case R.id.btn_tres:
                addExpressao("3", true);
                break;

            case R.id.btn_quatro:
                addExpressao("4", true);
                break;

            case R.id.btn_cinco:
                addExpressao("5", true);
                break;

            case R.id.btn_seis:
                addExpressao("6", true);
                break;

            case R.id.btn_sete:
                addExpressao("7", true);
                break;

            case R.id.btn_oito:
                addExpressao("8", true);
                break;

            case R.id.btn_nove:
                addExpressao("9", true);
                break;

            case R.id.btn_ponto:
                addExpressao(".", true);
                break;

            case R.id.btn_soma:
                addExpressao("+", false);
                break;

            case R.id.btn_subtracao:
                addExpressao("-", false);
                break;

            case R.id.btn_divisao:
                addExpressao("/", false);
                break;

            case R.id.btn_multiplicacao:
                addExpressao("*", false);
                break;



        }
    }
}