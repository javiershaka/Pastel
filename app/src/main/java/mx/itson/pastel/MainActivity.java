package mx.itson.pastel;
import mx.itson.pastel.entidades.Usuario;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Agregar(View view){
        Usuario u = new Usuario(this);
        u.guardar(((TextView) findViewById(R.id.txtnombre)).getText().toString(), ((TextView) findViewById(R.id.txttelefono)).getText().toString()
                , ((TextView) findViewById(R.id.txtcorreo)).getText().toString());
        String nombres = "";
        for(Usuario usuario:u.obtenerTodos()){
            nombres += u.getNombre()+"\n";
        }
        Toast.makeText(this,nombres,Toast.LENGTH_SHORT).show();
    

    }

    public void mostrar(View v){
        EditText editText = (EditText)findViewById(R.id.txtnewdatos);
        Usuario usr = new Usuario();
        editText.setText("");



    }


    public void NewUser(View view){
        Intent newuser = new Intent(this, NewUserActivity.class);
        startActivity(newuser);

    }
    public void EditUser(View view){
        Intent euser = new Intent(this, EditUserActivity.class);
        startActivity(euser);

    }
    public void DeleteUser(View view){
        Intent duser = new Intent(this, DeleteUserActivity.class);
        startActivity(duser);

    }
}
