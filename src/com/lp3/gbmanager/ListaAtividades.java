package com.lp3.gbmanager;

import java.util.List;




import com.lp3.gbmanager.controller.AtividadeListAdapter;
import com.lp3.gbmanager.model.Atividade;
import com.lp3.gbmanager.model.RepositorioAtividadesDB;


import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ListView;

public class ListaAtividades extends ListActivity implements OnSharedPreferenceChangeListener {
	RepositorioAtividadesDB repositorio ;
	List<Atividade> atividade;
	
	 protected static final int ATUALIZAR = 1;
	 protected static final int FORMULARIO = 2;
	 protected static final int BUSCAR = 3;
	 public boolean select = false;
	
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.lista_atividades);
		 
		    Log.i("Mateus Prestes","OnCreate");
		    repositorio = new RepositorioAtividadesDB(this);
		    // Atualiza a lista com os carros.
		    atualizarLista();
		    //setFonte();
	        //setCorFonte();
	        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
			pref.registerOnSharedPreferenceChangeListener((OnSharedPreferenceChangeListener) this);
	        
		   
	}

	@Override
	public void onResume(){
		  super.onResume();
	      
	      //setFonte();
	      //setCorFonte();
		 
		}
	
	
	 public void setFonte(){
		    if(EdicaoPreferencias.fontePreferencia(this).equals("12")){
				EdicaoPreferencias.setFonte(12, (TextView)findViewById(R.id.id));
				EdicaoPreferencias.setFonte(12, (TextView)findViewById(R.id.cliente));
				EdicaoPreferencias.setFonte(12, (TextView)findViewById(R.id.contrato));
				EdicaoPreferencias.setFonte(12, (TextView)findViewById(R.id.endereco));
				EdicaoPreferencias.setFonte(12, (TextView)findViewById(R.id.prazo));
				EdicaoPreferencias.setFonte(12, (TextView)findViewById(R.id.descricao));
				EdicaoPreferencias.setFonte(12, (TextView)findViewById(R.id.usuario));

			}
		    if(EdicaoPreferencias.fontePreferencia(this).equals("14")){
				EdicaoPreferencias.setFonte(14, (TextView)findViewById(R.id.id));
				EdicaoPreferencias.setFonte(14, (TextView)findViewById(R.id.cliente));
				EdicaoPreferencias.setFonte(14, (TextView)findViewById(R.id.contrato));
				EdicaoPreferencias.setFonte(14, (TextView)findViewById(R.id.endereco));
				EdicaoPreferencias.setFonte(14, (TextView)findViewById(R.id.prazo));
				EdicaoPreferencias.setFonte(14, (TextView)findViewById(R.id.descricao));
				EdicaoPreferencias.setFonte(14, (TextView)findViewById(R.id.usuario));
		   	}
			if(EdicaoPreferencias.fontePreferencia(this).equals("16")){
				EdicaoPreferencias.setFonte(16, (TextView)findViewById(R.id.id));
				EdicaoPreferencias.setFonte(16, (TextView)findViewById(R.id.cliente));
				EdicaoPreferencias.setFonte(16, (TextView)findViewById(R.id.contrato));
				EdicaoPreferencias.setFonte(16, (TextView)findViewById(R.id.endereco));
				EdicaoPreferencias.setFonte(16, (TextView)findViewById(R.id.prazo));
				EdicaoPreferencias.setFonte(16, (TextView)findViewById(R.id.descricao));
				EdicaoPreferencias.setFonte(16, (TextView)findViewById(R.id.usuario));
			}
			
			if(EdicaoPreferencias.fontePreferencia(this).equals("18")){
				EdicaoPreferencias.setFonte(18, (TextView)findViewById(R.id.id));
				EdicaoPreferencias.setFonte(18, (TextView)findViewById(R.id.cliente));
				EdicaoPreferencias.setFonte(18, (TextView)findViewById(R.id.contrato));
				EdicaoPreferencias.setFonte(18, (TextView)findViewById(R.id.endereco));
				EdicaoPreferencias.setFonte(18, (TextView)findViewById(R.id.prazo));
				EdicaoPreferencias.setFonte(18, (TextView)findViewById(R.id.descricao));
				EdicaoPreferencias.setFonte(18, (TextView)findViewById(R.id.usuario));
			}
	 }
	
	private void atualizarLista() {
	    // Exibe uma janela de aguarde
	    final ProgressDialog dialog = ProgressDialog.show(this, "Aguarde",
	        "Buscando atividades, por favor aguarde...", false, true);
	    
	    // Necessario utilizar um Handler para atualizar a view dentro de uma thread diferente da principal
	    final Handler handler = new Handler();

	    new Thread() {
	      @Override
	      public void run() {
	        try {
	          // Pega a lista de atividades e exibe na tela
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
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    super.onCreateOptionsMenu(menu);
	    menu.add(0, ATUALIZAR, 0, "Atualizar").setIcon(R.drawable.atualizar);
	    menu.add(0, FORMULARIO, 0, "Inserir Novo").setIcon(R.drawable.novo);
	    menu.add(0, BUSCAR, 0, "Buscar").setIcon(R.drawable.buscar);
	    return true;
	  }
	
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
	    // Clicou no menu
	    switch (item.getItemId()) {
	      case ATUALIZAR:
	        // Atualiza a lista
	        atualizarLista();
	        break;
	      case FORMULARIO:
	        // Abre a tela com o formulario para inserir um novo carro
	        startActivityForResult(new Intent(this, FormularioTarefa.class),
	            FORMULARIO);
	        break;
	      case BUSCAR:
	        // Abre a tela para buscar a atividade pelo nome
	        startActivity(new Intent(this, ListaAtividades.class));
	        break;
	    }
	    return true;
	  }
	
	  protected void onListItemClick(ListView l, View v, int indice, long id) {
		    super.onListItemClick(l, v, indice, id);
		    // Recupera a atividade selecionado utilizando a posi��o da lista
		    Log.i("LOG_DEBUG","INDICE "+indice);
		    Log.i("LOG_DEBUG", "ATIVIDADE= "+atividade.size());
		    Atividade atividade_bean = atividade.get(indice);
		    
		    // Cria a intent para abrir a tela do formulario
		    Intent it = new Intent(this, FormularioTarefa.class);
		    // Passa o id do carro como parametro
		    it.putExtra("id", atividade_bean.getId());
		    Log.i("LOG_DEBUG","ID= "+atividade_bean.getId());
		    // Abre a tela de edicao
		    startActivityForResult(it, FORMULARIO);
		  }

	@Override
	public void onSharedPreferenceChanged(SharedPreferences arg0, String arg1) {
		setFonte();
		
	}

	
	  
	  

}
