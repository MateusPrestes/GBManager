package com.lp3.gbmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Atividades extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.atividades);
	}


	
	public void ClickMinhasTarefas(View v){
		System.out.println("ENTROU");
		//Intent valor = new Intent(this, MinhasTarefas.class);
		//startActivity(valor);
		
	}
	public void ClickOrdemDeServico(View v){
		System.out.println("ENTROU");
		//Intent valor = new Intent(this, OrdemDeServico.class);
		//startActivity(valor);
		
	}

}
