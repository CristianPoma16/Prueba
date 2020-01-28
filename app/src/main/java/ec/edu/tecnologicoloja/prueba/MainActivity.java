package ec.edu.tecnologicoloja.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button check;
    private EditText mEditTextDate;
    private Spinner spinner;
    private Random generador = new Random();
    private String[] colores = {"Amarillo", "Rojo", "Verde", "Azul"};
    private String[] letras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
    }

    private void setViews() {
        // Button
        check = (Button) findViewById(R.id.button);

        // EditText
        mEditTextDate = (EditText) findViewById(R.id.editText);
        spinner = (Spinner) findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_data, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(escogeColor()==true){
                    Intent check = new Intent (MainActivity.this, Result.class);
                    startActivity(check);
                    escogeColor();
                }
            }
   });
}
    public boolean escogeColor(){
        String res = colores[generador.nextInt(colores.length)];
        String p = String.valueOf(res);
        if (p.equals(mEditTextDate)){
            System.out.println("Correcto");
        }
        return true;
    }



}
