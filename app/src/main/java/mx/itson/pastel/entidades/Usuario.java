package mx.itson.pastel.entidades;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mx.itson.pastel.database.PastelDB;

public class Usuario {

    Context context;
    private int id;
    private String nombre;
    private String telefono;
    private String correo;

    public Usuario(Context context){
        this.context = context;
    }

    public Usuario(){
    }

    public void guardar(String nombre, String telefono, String correo){
        try{
            PastelDB db = new PastelDB(context, "PastelDB", null, 1);
            SQLiteDatabase baseDatos = db.getWritableDatabase();
            baseDatos.execSQL("INSERT INTO Usuario (nombre, telefono, correo) VALUES ('"+nombre+"', '"+telefono+"', '"+correo+"')");
            baseDatos.close();
        }catch(Exception ex){
            Log.e("Database", "Error al agregar usuario.");
        }
    }

    public List<Usuario> obtenerTodos(){
        List<Usuario> usuarios = new ArrayList<>();
        PastelDB db = new PastelDB(context, "PastelDB", null, 1);
        SQLiteDatabase baseDatos = db.getReadableDatabase();
        Cursor cursor = baseDatos.rawQuery("SELECT * FROM Usuario", null);
        while(cursor.moveToNext()){
            Usuario u = new Usuario();
            u.setId(cursor.getInt(0));
            u.setNombre(cursor.getString(1));
            u.setTelefono(cursor.getString(2));
            u.setCorreo(cursor.getString(3));
            usuarios.add(u);
        }
        return usuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}