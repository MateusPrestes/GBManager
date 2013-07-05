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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu__adm, menu);
		return true;
	}
	
	public void ClickOS (View v){
		Intent os = new Intent(this,NovaOrdemServico.class);
		startActivity(os);
	}
	
	public void ClickNovaTarefa(View v){
		Intent novaTarefa= new Intent(this,NovaTarefa.class);
		startActivity(novaTarefa);
		
	}
}
