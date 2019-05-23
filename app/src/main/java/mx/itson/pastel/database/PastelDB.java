package mx.itson.pastel.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PastelDB extends SQLiteOpenHelper {

    public PastelDB (Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(context, nombre, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL("CREATE TABLE Usuario (id INTEGER PRIMARY KEY AUTOINCREMENT,"+" nombre TEXT, telefono TEXT, correo TEXT)");

        }
        catch (Exception ex){
            Log.e("Database", "error al generar tabla Isiarop");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
