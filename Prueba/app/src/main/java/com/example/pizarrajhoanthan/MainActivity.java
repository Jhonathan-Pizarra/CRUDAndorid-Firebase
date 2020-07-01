package com.example.pizarrajhoanthan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pizarrajhoanthan.model.Persona;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    EditText nombre, apellido, correo, password;
    ListView listaPersonas;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private List<Persona> listPerson = new ArrayList<Persona>();
    ArrayAdapter<Persona> arraryAdapterPersona;

    Persona personaSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.txt_Nombre);
        apellido = findViewById(R.id.txt_apellido);
        correo = findViewById(R.id.txt_correo);
        password = findViewById(R.id.txt_password);

        listaPersonas = findViewById(R.id.list_datos);
        inicializarFirebase();

        listarDatos();
        listaPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                personaSelected = (Persona) parent.getItemAtPosition(position);
                nombre.setText(personaSelected.getNombre());
                apellido.setText(personaSelected.getApellido());
                correo.setText(personaSelected.getCorreo());
                password.setText(personaSelected.getPassword());
            }
        });

    }

    private void listarDatos() {
        databaseReference.child("Persona").addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        listPerson.clear();
                        for (DataSnapshot objSnapshot : datasnapshot.getChildren()){
                            Persona p = objSnapshot.getValue(Persona.class);
                            listPerson.add(p);
                        }

                        arraryAdapterPersona = new ArrayAdapter<Persona>(MainActivity.this, android.R.layout.simple_list_item_1, listPerson);
                        listaPersonas.setAdapter(arraryAdapterPersona);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase= firebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String name = nombre.getText().toString();
        String lastname = apellido.getText().toString();
        String mail = correo.getText().toString();
        String pass = password.getText().toString();

        switch (item.getItemId()){
            case R.id.icon_add:
                if(name.equals("") || lastname.equals("") || mail.equals("") || pass.equals("")){
                    validacion();
                }else{
                    Persona p = new Persona();
                    p.setUid(UUID.randomUUID().toString());
                    p.setNombre(name);
                    p.setApellido(lastname);
                    p.setCorreo(mail);
                    p.setPassword(pass);

                    databaseReference.child("Persona").child(p.getUid()).setValue(p);
                    Toast.makeText(this, "Agregado", Toast.LENGTH_SHORT).show();
                    limiarCajas();
                }
                break;

            case R.id.icon_save:
                Persona p = new Persona();
                p.setUid(personaSelected.getUid());
                p.setNombre(nombre.getText().toString().trim());
                p.setApellido(apellido.getText().toString().trim());
                p.setCorreo(correo.getText().toString().trim());
                p.setPassword(password.getText().toString().trim());
                databaseReference.child("Persona").child(p.getUid()).setValue(p);
                Toast.makeText(this, "Actualizado", Toast.LENGTH_SHORT).show();
                limiarCajas();
                break;

            case R.id.icon_delete:
                Persona per = new Persona();
                per.setUid(personaSelected.getUid());
                databaseReference.child("Persona").child(per.getUid()).removeValue();
                Toast.makeText(this, "Eliminado", Toast.LENGTH_SHORT).show();
                limiarCajas();
                break;

            default:
                break;
        }

        return true;
    }

    private void limiarCajas() {
        nombre.setText("");
        apellido.setText("");
        correo.setText("");
        password.setText("");

    }

    private void validacion() {
        String name = nombre.getText().toString();
        String lastname = apellido.getText().toString();
        String mail = correo.getText().toString();
        String pass = password.getText().toString();

        if (name.equals("")){
            nombre.setError("Required");
        }else if(lastname.equals("")){
            apellido.setError("Required");
        }else if(mail.equals("")){
            correo.setError("Required");
        }else if(pass.equals("")){
            password.setError("Required");
        }
    }
}