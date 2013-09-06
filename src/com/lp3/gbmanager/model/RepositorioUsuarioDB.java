package com.lp3.gbmanager.model;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class RepositorioUsuarioDB implements RepositorioUsuario{

	private Context context;
	private String tabela="usuario";
	private String[] colunas = {"id","login","senha"};
	
	public RepositorioUsuarioDB(Context ctx) {
		this.context = ctx;
	}
	
	
	public boolean salvar(Usuario usuario) {
		// TODO Auto-generated method stub
		SQLiteDatabase sqLite = new UsuarioData(context).getWritableDatabase();
		Log.i("DB ABERTO",String.valueOf(sqLite.isOpen()));
		ContentValues content = new ContentValues();
 
        content.put("login", usuario.getLogin());
		content.put("senha", usuario.getSenha());
				
		sqLite.insert("usuario", null, content);
		sqLite.close();
		return true;
	}
	
	public boolean deletar(Usuario usuario) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = new UsuarioData(context).getWritableDatabase();  
	
		String where = "id = ?";
 
		String[] args = new String[] { ""+usuario.getId() };
 
		int deucerto = db.delete(tabela, where, args);
		db.close();
		if(deucerto>0)
			return true;
		return false;
	}
	
	public Usuario getUsuario(Long id) {
		// TODO Auto-generated method stub
		String where = "id = ?";
		String args[] = {""+id};
		SQLiteDatabase db = new  UsuarioData(context).getReadableDatabase();
		Cursor cursor = db.query(tabela,colunas,where,args,null,null,null);
		if (cursor.getCount() > 0){
			cursor.moveToFirst();
			Usuario user = new Usuario(cursor.getString(cursor.getColumnIndex("login")), cursor.getString(cursor.getColumnIndex("senha")));
			//atividade.setId(Long.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
			//atividade.setImagem(cursor.getBlob(cursor.getColumnIndex("imagem")));
			db.close();
			return user;
		}
		db.close();
		return null;
	}
	
	
	public List<Usuario> listarUsuario(){
		SQLiteDatabase db = new UsuarioData(context).getReadableDatabase();
		List<Usuario> lista = new ArrayList<Usuario>();
		Cursor cursor = db.query(tabela, colunas, null, null, null, null, null);
		
		if(cursor.getCount()<0){
			cursor.moveToFirst();
			do{
				lista.add(new Usuario(cursor.getString(cursor.getColumnIndex("login")), cursor.getString(cursor.getColumnIndex("senha"))));
			}while(cursor.moveToNext());
		}
		return lista;
	}

	
	public Usuario buscaUsuario(String nome){
		String where = "login = ?";
		String args[] = {nome};
		
		SQLiteDatabase db = new UsuarioData(context).getReadableDatabase();
		Cursor cursor = db.query(tabela, colunas, where, args, null, null, null);
		if (cursor.getCount()>0){
			cursor.moveToFirst();
			Usuario user = new Usuario(cursor.getString(cursor.getColumnIndex("login")), cursor.getString(cursor.getColumnIndex("senha")));
			db.close();
			return user;
			
		}db.close();
		return null;
		
	}
	
}
