package com.example.ej11calculadorasamuel;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class ej11CalculadoraSamuel extends AppCompatActivity implements OnClickListener {

    TextView myTextView, myTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pongo los textView en Blanco
        myTextView=findViewById(R.id.myTextView);
        myTextView.setText("");
        myTextView2=findViewById(R.id.myTextView2);
        myTextView2.setText("");

        //Listener de los botones de la calculadora
        Button botonl=findViewById (R. id.button1);
        botonl.setOnClickListener (this);
        Button boton2=findViewById (R. id.button2);
        boton2.setOnClickListener (this);
        Button boton3=findViewById (R. id.button3);
        boton3.setOnClickListener (this);
        Button boton4=findViewById (R. id.button4);
        boton4.setOnClickListener (this);
        Button boton5=findViewById (R. id.button5);
        boton5.setOnClickListener (this);
        Button boton6=findViewById (R. id.button6);
        boton6.setOnClickListener (this);
        Button boton7=findViewById (R. id.button7);
        boton7.setOnClickListener (this);
        Button boton8=findViewById (R. id.button8);
        boton8.setOnClickListener (this);
        Button boton9=findViewById (R. id.button9);
        boton9.setOnClickListener (this);
        Button boton0=findViewById (R. id.button0);
        boton0.setOnClickListener (this);
        Button botonSuma=findViewById (R. id.buttonSuma);
        botonSuma.setOnClickListener (this);
        Button botonResta=findViewById (R. id.buttonResta);
        botonResta.setOnClickListener (this);
        Button botonMultiplica=findViewById (R. id.buttonMultiplica);
        botonMultiplica.setOnClickListener (this);
        Button botonDivide=findViewById (R. id.buttonDivide);
        botonDivide.setOnClickListener (this);
        Button botonPunto=findViewById (R. id.buttonPunto);
        botonPunto.setOnClickListener (this);
        Button botonBorra=findViewById (R. id.buttonBorra);
        botonBorra.setOnClickListener (this);
        Button botonIgual=findViewById (R. id.buttonIgual);
        botonIgual.setOnClickListener (this);

    }
    //defino los numeros y operacion
    double n1 =0, n2 =0;
    char op1='+';

    @Override
    public void onClick(View v) {

        //En este caso aunque haya un if con más de 2 alternativas, no se puede usar un switch ya
        // que es una constante y no una variable declarada,
        // por lo que Switch no funciona, y hay que usar if-else

        if (v.getId() ==R.id.button1)
            myTextView.append ("1");
        else if (v.getId() ==R.id.button2)
            myTextView.append("2");
        else if (v.getId() ==R.id.button3)
            myTextView.append("3");
        else if (v.getId() ==R.id.button4)
            myTextView.append("4");
        else if (v.getId() ==R.id.button5)
            myTextView.append("5");
        else if (v.getId() ==R.id.button6)
            myTextView.append("6");
        else if (v.getId() ==R.id.button7)
            myTextView.append ("7");
        else if (v.getId() ==R.id.button8)
            myTextView.append("8");
        else if (v.getId() ==R.id.button9)
            myTextView.append("9");
        else if (v.getId() ==R.id.button0)
            myTextView.append ("0");
        else if (v.getId() ==R.id.buttonPunto)
            myTextView.append(".");
        else if (v.getId() ==R.id.buttonBorra){
            myTextView.setText ("");
            myTextView2.setText ("");
            n1 =0;
            op1='+';
        }
        else if (v.getId()==R.id.buttonSuma) calcula ('+');
        else if (v.getId()==R.id.buttonResta) calcula ('-');
        else if (v.getId()==R.id.buttonMultiplica)calcula ('*');
        else if (v.getId()==R.id.buttonDivide) calcula ('/');
        else if (v.getId()==R.id.buttonIgual) calcula ('=');
    }

    //método que realiza los cálculos
    public void calcula(char op) {
        double result = n1;
        String cadena = myTextView.getText().toString();

        try {
            n2 = Double.parseDouble(cadena);
            //el switch realiza las operaciones dependiendo del signo seleccionado
            switch(op1) {
                case '+':
                    result = n1 + n2;
                    break;
                case '-':
                    result = n1 - n2;
                    break;
                case '*':
                    result = n1 * n2;
                    break;
                case '/':
                    result = n1 / n2;
                    break;
            }
            //el numero 1 es el resultado de la operacion anterior
            n1 = result;
            op1 = op;

            if (op == '=') {  //si se pulsa igual muestra el resultado
                myTextView.setText(" "+result);
                myTextView2.setText(" ");
            } else { //si se ha pulsado otro signo pone la siguiente operacion
                myTextView.setText("");
                myTextView2.setText("" + n1 + op1);
            }
        }catch(NumberFormatException nfe){ //toast que hace que aparezca un mensaje en caso de error
            Toast.makeText(this, "Error, tecla incorrecta", Toast.LENGTH_LONG).show();

        }
    }
}
