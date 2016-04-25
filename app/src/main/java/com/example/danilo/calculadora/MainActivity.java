package com.example.danilo.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnUm, btnDois, btnTres, btnQuatro, btnCinco, btnSeis, btnSete, btnOito, btnNove, btnZero, btnSoma, btnLimpa, btnMul, btnDiv, btnIgual, btnSub;
    TextView mTextView ;

    private float  result=0;
    private float  numeroSalvo = 0 , numeroAtual = 0;
    private String operacao =  "";
    private boolean novoNumero = false;  // False quando estiver formando o numero True quando tiver formado


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView  = (TextView) findViewById(R.id.numeroTexto);
        mTextView.setText("0");

        btnUm = (Button) findViewById(R.id.buttonOne);
        btnDois = (Button) findViewById(R.id.buttonTwo);
        btnTres = (Button) findViewById(R.id.buttonThree);
        btnQuatro = (Button) findViewById(R.id.buttonFour);
        btnCinco = (Button) findViewById(R.id.buttonFive);
        btnSeis = (Button) findViewById(R.id.buttonSix);
        btnSete = (Button) findViewById(R.id.buttonSeven);
        btnOito = (Button) findViewById(R.id.buttonEight);
        btnNove = (Button) findViewById(R.id.buttonNine);
        btnZero = (Button) findViewById(R.id.buttonZero);
        btnSoma = (Button) findViewById(R.id.buttonPlus);
        btnSub = (Button) findViewById(R.id.buttonMinus);
        btnMul = (Button) findViewById(R.id.buttonMul);
        btnDiv = (Button) findViewById(R.id.buttonDiv);
        btnLimpa = (Button) findViewById(R.id.buttonClear);
        btnIgual = (Button) findViewById(R.id.buttonEqual);

        try{
            btnUm.setOnClickListener(this);
            btnDois.setOnClickListener(this);
            btnTres.setOnClickListener(this);
            btnQuatro.setOnClickListener(this);
            btnCinco.setOnClickListener(this);
            btnSeis.setOnClickListener(this);
            btnSete.setOnClickListener(this);
            btnOito.setOnClickListener(this);
            btnNove.setOnClickListener(this);
            btnZero.setOnClickListener(this);
            btnLimpa.setOnClickListener(this);
            btnSoma.setOnClickListener(this);
            btnSub.setOnClickListener(this);
            btnMul.setOnClickListener(this);
            btnDiv.setOnClickListener(this);
            btnIgual.setOnClickListener(this);
        }
        catch(Exception e){

        }


    }


    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.buttonClear:
                mTextView.setTextSize(50);
                mTextView.setText("Digite o valor");
                operacao = "";
                numeroSalvo = 0;
                numeroAtual = 0;
                result = 0;
                novoNumero = false;
                break;

            case R.id.buttonOne:
                escreveNumero(1);
                break;

            case R.id.buttonTwo:
                escreveNumero(2);
                break;

            case R.id.buttonThree:
                escreveNumero(3);
                break;
                
            case R.id.buttonFour:
                escreveNumero(4);
                break;
                
            case R.id.buttonFive:
                escreveNumero(5);
                break;
                
            case R.id.buttonSix:
                escreveNumero(6);
                break;
                
            case R.id.buttonSeven:
                escreveNumero(7);
                break;
                
            case R.id.buttonEight:
                escreveNumero(8);
                break;
                
            case R.id.buttonNine:
                escreveNumero(9);
                break;
            
            case R.id.buttonZero:
                escreveNumero(0);
                break;

            case R.id.buttonPlus:
                novoNumero = true; 
                operacao = "soma";
                calcula();
                mTextView.setText(Float.toString(numeroAtual));
                break;


            case R.id.buttonMinus:
                novoNumero = true;
                operacao = "subtr";
                calcula();
                mTextView.setText(Float.toString(numeroAtual));
                break;
/*

            case R.id.buttonMul:
                novoNumero = true;
                operacao = "soma";
                mTextView.setText(Float.toString(result));
                break;


            case R.id.buttonDiv:
                novoNumero = true;
                operacao = "soma";
                mTextView.setText(Float.toString(result));
                break;


            case R.id.buttonEqual:
                if(operacao != "") {
                    calcula();
                    mTextView.setText(Float.toString(result));
                    novoNumero = true;
                    break;
                }
        */}
    }

    public void escreveNumero(int num) {
        if (numeroAtual < 99999)
            mTextView.setTextSize(70);
        else {
            mTextView.setTextSize(50);
        }

        if(novoNumero){
            numeroSalvo = numeroAtual;
            numeroAtual = 0;
        }

        numeroAtual = (numeroAtual * 10) + num;
        mTextView.setText(Float.toString(numeroAtual));
        novoNumero = false;
    }
    
    public void calcula(){
        switch(operacao) {
            case "soma":
                result = numeroAtual + numeroSalvo;
                numeroAtual = result;
                break;

            case "subtr":
                result = numeroSalvo - numeroAtual;
                numeroAtual = result;
                break;

            case "multi":
                result = numeroAtual * numeroSalvo;
                numeroAtual = result;
                break;

            case "div":
                if (numeroAtual == 0){
                    mTextView.setText("Erro");
                    numeroAtual = 0;
                    numeroSalvo = 0;
                    result = 0;
                    break;
                }
                result = numeroSalvo / numeroAtual ;

                numeroAtual = result;

                break;

        }

    }

}

