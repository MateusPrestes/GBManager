package com.lp3.gbmanager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MinhasTarefas extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.minhas_tarefas);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.minhas_tarefas, menu);
		return true;
	}

}
