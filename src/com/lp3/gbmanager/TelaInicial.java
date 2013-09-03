package com.lp3.gbmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class TelaInicial extends Activity {


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_inicial);
	}


	public void ClickAtividades(){
		Intent minhastarefas = new Intent(this, ListaAtividades.class);
		startActivity(minhastarefas);
		
	}
	
	public void Click(View v){
		EditText login = (EditText)findViewById(R.id.editText1);
		String texto = login.getText().toString();
		texto=texto.trim();
		System.out.println("TEXTO= "+texto);
		if(texto.equals("adm")){
			
			Intent menu = new Intent(this, Menu_Adm.class);
			startActivity(menu);
			
		}
		else{
			ClickAtividades();
		}
		
	}

}
