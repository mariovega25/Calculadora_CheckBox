package com.example.checboxes

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var et1:EditText;
    lateinit var et2:EditText;
    lateinit var cb1:CheckBox;
    lateinit var cb2:CheckBox;
    lateinit var cb3:CheckBox;
    lateinit var cb4:CheckBox;
    lateinit var tvResuultado: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        et1=findViewById<EditText>(R.id.etValor1);
        et2=findViewById<EditText>(R.id.etValor2);
        cb1=findViewById<CheckBox>(R.id.cbSuma);
        cb2=findViewById<CheckBox>(R.id.cbResta);
        cb3=findViewById<CheckBox>(R.id.cbMultiplicacion);
        cb4=findViewById<CheckBox>(R.id.cbDivision);
        tvResuultado=findViewById<TextView>(R.id.tvRes);

    }
    fun calcular(view: View) {
        var numero1 = et1.text.toString();
        var numero2 = et2.text.toString();
        // validar que los EditText No esten vacios
        if (numero1.isEmpty() || numero2.isEmpty()) {
            tvResuultado.text = "Ingresa ambos numeros";
            return;
        }
        val num1 = numero1.toDouble();
        val num2 = numero2.toDouble();
        var resultado = "";
        //Realizar Operaciones
        if (cb1.isChecked) {
            resultado += "Suma: ${num1 + num2}\n";
        }
        if (cb2.isChecked) {
            resultado += "Resta: ${num1 - num2}\n";
        }
        if (cb3.isChecked) {
            resultado += "Multiplicación: ${num1 * num2}\n";
        }
        if (cb4.isChecked) {
            if (num2 == 0.0 || num1==0.0 ) {
                resultado += "División: Syntax Error (división entre 0)\n";
            } else {
                resultado += "División: ${num1 / num2}\n";
            }
        }

        //Mostrar el resultado en el TextView
        if (resultado.isEmpty()) {
            tvResuultado.text = "Selecciona una operación";
        } else {
            tvResuultado.text = resultado;
        }
    }

    fun Limpiar(view: View){
        et1.text.clear();
        et2.text.clear();
        cb1.isChecked =false;
        cb2.isChecked =false;
        cb3.isChecked =false;
        cb4.isChecked =false;
        tvResuultado.text="0";
    }
}