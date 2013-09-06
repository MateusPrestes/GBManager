package com.lp3.gbmanager;


import com.lp3.gbmanager.model.Atividade;
import com.lp3.gbmanager.model.RepositorioAtividadesDB;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NovaTarefa extends Activity {
	
	
	  
	  
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nova_tarefa);
		
		
	}

	public void salvarButton(View v){
		RepositorioAtividadesDB repositorio = new RepositorioAtividadesDB(this);
		EditText campoDescricao = (EditText)findViewById(R.id.editText1);
		  Spinner campoUsuario = (Spinner)findViewById(R.id.spinner1);
		  EditText campoPrazo = (EditText)findViewById(R.id.editText2);
		Atividade a = new Atividade();
		a.setDescricao(campoDescricao.getText().toString());
		a.setPrazo(campoPrazo.getText().toString());
		repositorio.salvar(a);
		
		campoDescricao.setText("");
		campoPrazo.setText("");
		
		Toast t = new Toast(this);
		//t.setText("Dados Gravados com sucesso!");
		t = Toast.makeText(this, "Dados Gravados!", Toast.LENGTH_SHORT);
		t.show();
	}
	

}
