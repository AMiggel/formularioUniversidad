package unac.com.co.formularios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.spinnerUniversidad)
    Spinner spinnerUniversidad;

    @BindView(R.id.spinnerCarreras)
    Spinner spinnerCarrera;

    @BindView(R.id.spinnerSemestre)
    Spinner spinnerSemestre;



    ArrayAdapter<String> universidad;
    ArrayAdapter carrera;
    ArrayAdapter<String> semestre;
    ArrayAdapter<String> semestre2;

    String [] opcionUniversidad={"Adventista","EAFIT"};
    String[] opcionCarrera={"Ingenieria", "Contaduria"};
    String[] opcionSemestre={"1","2","3","4","5","6","7","8","9","10"};
    String[] opcionSemestre2={"1","2","3","4","5","6","7","8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        spinnerUniversidad.setOnItemSelectedListener(this);
        spinnerCarrera.setOnItemSelectedListener(this);
        spinnerSemestre.setOnItemSelectedListener(this);


        universidad = new ArrayAdapter
                (this, android.R.layout.simple_spinner_dropdown_item, opcionUniversidad);
        spinnerUniversidad.setAdapter(universidad);




    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String universidad = spinnerUniversidad.getSelectedItem().toString();

        switch (view.getId()) {
            case R.id.spinnerUniversidad:
                switch (i) {
                    case 0:
                        carrera = new ArrayAdapter
                                (this, android.R.layout.simple_spinner_dropdown_item, opcionCarrera);
                        spinnerCarrera.setAdapter(carrera);
                        semestre = new ArrayAdapter
                                (this, android.R.layout.simple_spinner_dropdown_item,opcionSemestre);
                        spinnerSemestre.setAdapter(semestre);
                        break;
                    case 1:
                        spinnerCarrera.setAdapter(carrera);
                        break;
                }

            case R.id.spinnerCarreras:
                switch (i){

                    case 0:
                        String carrera = spinnerCarrera.getSelectedItem().toString();

                        if (carrera.equals("Ingenieria") && universidad.equals("EAFIT")){
                            semestre = new ArrayAdapter
                                    (this, android.R.layout.simple_spinner_dropdown_item,opcionSemestre);

                            spinnerSemestre.setAdapter(semestre);
                            break;
                        }
                    case 1:
                        carrera = spinnerCarrera.getSelectedItem().toString();
                        if (carrera.equals("Contaduria")&& universidad.equals("EAFIT")) {
                            semestre2 = new ArrayAdapter
                                    (this, android.R.layout.simple_spinner_dropdown_item,opcionSemestre2);
                            spinnerSemestre.setAdapter(semestre2);
                            break;
                        }
                        break;

                    }

                }

        }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}