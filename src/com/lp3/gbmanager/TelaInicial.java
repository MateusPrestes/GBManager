package com.lp3.gbmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class TelaInicial extends Activity {

	Intent menu = new Intent(this, Menu_Adm.class);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_inicial);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_inicial, menu);
		return true;
	}
	
	public void Click(View v){
		
		startActivity(menu);
		
	}

}
