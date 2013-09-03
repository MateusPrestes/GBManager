package com.lp3.gbmanager;

import java.util.List;

import com.lp3.gbmanager.controller.AtividadeListAdapter;
import com.lp3.gbmanager.model.AtividadeBean;
import com.lp3.gbmanager.model.RepositorioAtividadesDB;


import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.Menu;

public class ListaAtividades extends ListActivity {
	RepositorioAtividadesDB repositorio ;
	List<AtividadeBean> atividade;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.lista_atividades);
		 
		    Log.i("Mateus Prestes","OnCreate");
		    repositorio = new RepositorioAtividadesDB(this);
		    // Atualiza a lista com os carros.
		    atualizarLista();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_atividades, menu);
		return true;
	}
	
	private void atualizarLista() {
	    // Exibe uma janela de aguarde
	    final ProgressDialog dialog = ProgressDialog.show(this, "Aguarde",
	        "Buscando atividades, por favor aguarde...", false, true);
	    
	    // Necess�rio utilizar um Handler para atualizar a view dentro de uma thread diferente da principal
	    final Handler handler = new Handler();

	    new Thread() {
	      @Override
	      public void run() {
	        try {
	          // Pega a lista de carros e exibe na tela
	          atividade = repositorio.listarAtividades();
	          Log.i("Mateus Prestes","Atualizando lista de atividades");
	          if (atividade != null) {
	            // Atualiza a view em um Handler
	            handler.post(new Runnable() {
	              @Override
	              public void run() {
	                // Informa para a ListActivity qual o adaptador da lista
	                setListAdapter(new AtividadeListAdapter(ListaAtividades.this, atividade));
	              }
	            });
	          }
	        }
	        finally {
	          // Fecha a janela de aguarde
	          dialog.dismiss();
	        }
	      }
	    }.start();
	  }
	
	

}
