package com.lp3.gbmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Menu_Adm extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
	}


	
	public void ClickOS (View v){
		Intent os = new Intent(this,NovaOrdemServico.class);
		startActivity(os);
	}
	
	public void ClickNovaTarefa(View v){
		Intent novaTarefa= new Intent(this,FormularioTarefa.class);
		startActivity(novaTarefa);
		
	}
	
	public void ClickTarefas(View v){
		Intent tarefas = new Intent(this, ListaAtividades.class);
		startActivity(tarefas);
		
	}
	
	public void ClickCadastroUsuario(View v){
		Intent cadastrousuario = new Intent(this, CadastroUsuario.class);
		startActivity(cadastrousuario);
	}
	
}
