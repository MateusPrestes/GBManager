package com.lp3.gbmanager.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AtividadesData extends SQLiteOpenHelper {

	
	 private static final String DATABASE_NAME = "atividades";
	 private static final int DATABASE_VERSION = 1;
	 
	 
	public AtividadesData(Context ctx) {
		super(ctx,DATABASE_NAME, null, DATABASE_VERSION );
	}
	
	  @Override
	  public void onCreate(SQLiteDatabase db) {
			
		  db.execSQL("CREATE TABLE atividade (id INTEGER PRIMARY KEY AUTOINCREMENT, cliente TEXT, contrato TEXT, end TEXT, " +
					"descricao TEXT, usuario TEXT, prazo TEXT)");
		  System.out.println("DB CRIADO");
	  }

	  @Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    
	    
	  }

	
	
}
