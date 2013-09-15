package com.lp3.gbmanager.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UsuarioData extends SQLiteOpenHelper{

	 private static final String DATABASE_NAME = "usuario";
	 private static final int DATABASE_VERSION = 1;
	 
	 
	public UsuarioData(Context ctx) {
		super(ctx,DATABASE_NAME, null, DATABASE_VERSION );
	}
	
	  @Override
	  public void onCreate(SQLiteDatabase db) {
		  Log.i("CRIANDO DB", "");
		  db.execSQL("CREATE TABLE usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, login TEXT, senha TEXT)");
		  db.execSQL("INSERT INTO usuario (login, senha) VALUES ('admin', 'senha')");
		  System.out.println("DB CRIADO");
		  Log.i("DB CRIADO", "");
	  }

	  @Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    
	    
	  }
}
