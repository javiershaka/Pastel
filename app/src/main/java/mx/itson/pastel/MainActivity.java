package mx.itson.pastel;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Llamar(View view){
        Intent llamar = new Intent(this, DeleteUserActivity.class);
        startActivity(llamar);

    }
    public void Camara(View view){
        Intent cam = new Intent(this, EditUserActivity.class);
        startActivity(cam);

    }
    public void Sms(View view){
        Intent sms = new Intent(this, NewUserActivity.class);
        startActivity(sms);

    }
}
