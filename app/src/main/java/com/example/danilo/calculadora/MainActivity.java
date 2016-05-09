package com.example.danilo.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity  {

    private Button btnUm, btnDois, btnTres, btnQuatro, btnCinco, btnSeis, btnSete, btnOito, btnNove, btnZero, btnSoma, btnLimpa, btnMul, btnDiv, btnIgual, btnSub;
    TextView mTextView ;

    private float  result=0;
    private float  numeroSalvo = 0 , numeroAtual = 0;
    private int num;
    private String operacao =  "";
    private boolean anteriorOperacao = false;  // False quando estiver formando o numero True quando tiver formado
    private boolean emOperacao = false; // False se ainda nao tiver feito operacao True se ja tiver feito
    private boolean temResultado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.numeroTexto);
        mTextView.setTextSize(50);
        mTextView.setText("Digite o valor");

    }
    public void showNumber(float number){
        mTextView.setText(Float.toString(number));

    }

    public void pressNumber(View v){
        Button button = (Button) v;
        num = Integer.parseInt(button.getText().toString());

        if (temResultado){
            numeroAtual = 0;
            temResultado = false;

        }

        numeroAtual = num + numeroAtual * 10;
        showNumber(numeroAtual);
        emOperacao = true;

    }

    public void pressClear(View v){

        numeroAtual =0;
        numeroSalvo = 0;
        operacao = "";
        emOperacao = false;
        temResultado = false;
        mTextView.setText("Digite o valor");
    }

    public void pressPlus(View v) {
        if (emOperacao) {
            numeroSalvo = numeroAtual;
            operacao = "soma";
            numeroAtual = 0;
            anteriorOperacao = true;
        }
    }
    public void pressMinus(View v){
        if(emOperacao) {
            numeroSalvo = numeroAtual;
            operacao = "subtr";
            numeroAtual = 0;
            anteriorOperacao = true;
        }
    }

    public void pressDiv(View v){
        if(emOperacao) {
            numeroSalvo = numeroAtual;
            operacao = "div";
            numeroAtual = 0;
            anteriorOperacao = true;
        }
    }

    public void pressMul(View v){
        if(emOperacao) {
            numeroSalvo = numeroAtual;
            operacao = "multi";
            numeroAtual = 0;
            anteriorOperacao = true;
        }
    }

    public void pressEqual(View v) {
        calcula();
    }
    public void calcula() {
        switch (operacao) {
            case "soma":
                result = numeroAtual + numeroSalvo;
                numeroAtual = result;
                showNumber(result);
                temResultado = true;
                break;

            case "subtr":
                result = numeroSalvo - numeroAtual;
                numeroAtual = result;
                showNumber(result);
                temResultado = true;
                break;

            case "multi":
                result = numeroAtual * numeroSalvo;
                numeroAtual = result;
                showNumber(result);
                temResultado = true;
                break;

            case "div":
                if (numeroAtual == 0) {
                    mTextView.setText("Erro");
                    numeroAtual = 0;
                    numeroSalvo = 0;
                    result = 0;
                    temResultado = true;
                    break;
                }else{
                    result = numeroSalvo / numeroAtual;
                    numeroAtual = result;
                    showNumber(result);
                    temResultado = true;
                }


        }
    }


}

