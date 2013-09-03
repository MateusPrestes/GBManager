package com.lp3.gbmanager.model;





import java.util.ArrayList;
import java.util.List;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RepositorioAtividadesDB {
	
	private Context context;
	private String tabela="atividade";
	private String[] colunas = {"id","cliente","contrato","end","descricao", "usuario", "prazo"};
	
	public RepositorioAtividadesDB(Context context){
		this.context=context;
	}
	
	
	
	public boolean salvar(AtividadeBean atividade) {
		// TODO Auto-generated method stub
		SQLiteDatabase sqLite = new AtividadesData(context).getWritableDatabase();
		 
		ContentValues content = new ContentValues();
 
        content.put("cliente", atividade.getCliente());
		content.put("contrato", atividade.getContrato());
		content.put("end", atividade.getEnd());
		content.put("descricao", atividade.getDescricao());
		content.put("usuario", atividade.getUsuario());
		content.put("prazo", atividade.getPrazo());
		
		sqLite.insert("atividade", null, content);
		sqLite.close();
		return true;
	}
	
	public boolean deletar(AtividadeBean atividade) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = new AtividadesData(context).getWritableDatabase();  
	
		String where = "id = ?";
 
		String[] args = new String[] { ""+atividade.getId() };
 
		int deucerto = db.delete(tabela, where, args);
		db.close();
		if(deucerto>0)
			return true;
		return false;
	}
	
	public AtividadeBean getAtividade(Long id) {
		// TODO Auto-generated method stub
		String where = "id = ?";
		String args[] = {""+id};
		SQLiteDatabase db = new  AtividadesData(context).getReadableDatabase();
		Cursor cursor = db.query(tabela,colunas,where,args,null,null,null);
		if (cursor.getCount() > 0){
			cursor.moveToFirst();
			AtividadeBean atividade = new AtividadeBean(cursor.getString(cursor.getColumnIndex("cliente")),
					cursor.getString(cursor.getColumnIndex("end")),
					cursor.getString(cursor.getColumnIndex("descricao")), cursor.getString(cursor.getColumnIndex("usuario")), cursor.getString(cursor.getColumnIndex("prazo")), cursor.getString(cursor.getColumnIndex("contrato")));
			//atividade.setId(Long.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
			//atividade.setImagem(cursor.getBlob(cursor.getColumnIndex("imagem")));
			db.close();
			return atividade;
		}
		db.close();
		return null;
	}
	
	public List<AtividadeBean> listarAtividades() {
		// TODO Auto-generated method stub
		SQLiteDatabase db = new  AtividadesData(context).getReadableDatabase();
		Cursor cursor = db.query(tabela,colunas,null,null,null,null,null);
		List<AtividadeBean> lista = new ArrayList<AtividadeBean>();
		if (cursor.getCount() > 0){
			    cursor.moveToFirst();
			
			do{
				lista.add(new AtividadeBean(cursor.getString(cursor.getColumnIndex("cliente")),
						cursor.getString(cursor.getColumnIndex("end")),
						cursor.getString(cursor.getColumnIndex("descricao")), cursor.getString(cursor.getColumnIndex("usuario")), cursor.getString(cursor.getColumnIndex("prazo")), cursor.getString(cursor.getColumnIndex("contrato"))));
				//lista.get(lista.size()-1).setId(Long.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
				//lista.get(lista.size()-1).setImagem(cursor.getBlob(cursor.getColumnIndex("imagem")));
			}while(cursor.moveToNext());
		}
		db.close();
		return lista;
	}
	
	public AtividadeBean buscaAtividades(String nome) {
		// TODO Auto-generated method stub
		String where = "nome = ? ";
		
		String args[] = {nome};
		SQLiteDatabase db = new  AtividadesData(context).getReadableDatabase();
		Cursor cursor = db.query(tabela,colunas,where,args,null,null,null);
		if (cursor.getCount() > 0)
		{
			cursor.moveToFirst();
			AtividadeBean atividade = new AtividadeBean(cursor.getString(cursor.getColumnIndex("cliente")),
					cursor.getString(cursor.getColumnIndex("end")),
					cursor.getString(cursor.getColumnIndex("descricao")), cursor.getString(cursor.getColumnIndex("usuario")), cursor.getString(cursor.getColumnIndex("prazo")), cursor.getString(cursor.getColumnIndex("contrato")));
			//carro.setId(Long.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
			//carro.setImagem(cursor.getBlob(cursor.getColumnIndex("imagem")));
			db.close();
			return atividade;
		}
		db.close();
		return null;
	}
	
	
	
	
	

}
