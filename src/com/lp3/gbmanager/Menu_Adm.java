package com.lp3.gbmanager;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Menu_Adm extends Activity implements OnSharedPreferenceChangeListener{
	public boolean select = false;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
		pref.registerOnSharedPreferenceChangeListener(this);
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
	
	public void clickConfig(View v){
		Intent configuracao = new Intent(this,EdicaoPreferencias.class);
		startActivity(configuracao);
		
		
	}
	
public void onSharedPreferenceChanged(SharedPreferences pref, String key) {	
    	
		Log.i("DEBUG", "ENTROU EM SHAREDPREFERENCECHANGED");
		Log.i("IDIOMA", key);
		if(key.equals("idioma")){
			Configuration config = new Configuration(getResources().getConfiguration());
			if(pref.getString(key, "portugues").equals("portugues")){
			    config.locale = Locale.ROOT;
			    getResources().updateConfiguration(config,getResources().getDisplayMetrics());  
			    select = true;
			}
			if(pref.getString(key, "portugues").equals("ingles")){
			    config.locale = Locale.ENGLISH ;
			    getResources().updateConfiguration(config,getResources().getDisplayMetrics());
			    select = true;
			}
		}
		if(key.equals("fonte")){
			Log.i("DEBUG", "VAI CHAMAR SETFONTE");
			setFonte();
		}
		if(key.equals("colorf")){
			Log.i("DEBUG", "VAI CHAMAR COLORFONTE");
			setCorFonte();
		}
		
		
    }
public void setFonte(){
	Log.i("DEBUG","CHAMOU SETFONTE");
	if(EdicaoPreferencias.fontePreferencia(this).equals("12")){
		EdicaoPreferencias.setFonte(12, (TextView)findViewById(R.id.textView2));
		EdicaoPreferencias.setFonte(12, (TextView)findViewById(R.id.textView3));
		EdicaoPreferencias.setFonte(12, (TextView)findViewById(R.id.textView4));
		EdicaoPreferencias.setFonte(12, (TextView)findViewById(R.id.textView5));
		EdicaoPreferencias.setFonte(12, (TextView)findViewById(R.id.textView9));
		
		

	}
    if(EdicaoPreferencias.fontePreferencia(this).equals("14")){
    	EdicaoPreferencias.setFonte(14, (TextView)findViewById(R.id.textView2));
		EdicaoPreferencias.setFonte(14, (TextView)findViewById(R.id.textView3));
		EdicaoPreferencias.setFonte(14, (TextView)findViewById(R.id.textView4));
		EdicaoPreferencias.setFonte(14, (TextView)findViewById(R.id.textView5));
		EdicaoPreferencias.setFonte(14, (TextView)findViewById(R.id.textView9));

    }
	if(EdicaoPreferencias.fontePreferencia(this).equals("16")){
		EdicaoPreferencias.setFonte(16, (TextView)findViewById(R.id.textView2));
		EdicaoPreferencias.setFonte(16, (TextView)findViewById(R.id.textView3));
		EdicaoPreferencias.setFonte(16, (TextView)findViewById(R.id.textView4));
		EdicaoPreferencias.setFonte(16, (TextView)findViewById(R.id.textView5));
		EdicaoPreferencias.setFonte(16, (TextView)findViewById(R.id.textView9));

	}
	
	if(EdicaoPreferencias.fontePreferencia(this).equals("18")){
		EdicaoPreferencias.setFonte(18, (TextView)findViewById(R.id.textView2));
		EdicaoPreferencias.setFonte(18, (TextView)findViewById(R.id.textView3));
		EdicaoPreferencias.setFonte(18, (TextView)findViewById(R.id.textView4));
		EdicaoPreferencias.setFonte(18, (TextView)findViewById(R.id.textView5));
		EdicaoPreferencias.setFonte(18, (TextView)findViewById(R.id.textView9));
	}
}

public void setCorFonte(){
	if(EdicaoPreferencias.corFontePreferencia(this).equals("preto")){	
		EdicaoPreferencias.setColorFonte("#000000", (TextView)findViewById(R.id.textView2));
		EdicaoPreferencias.setColorFonte("#000000", (TextView)findViewById(R.id.textView3));
		EdicaoPreferencias.setColorFonte("#000000", (TextView)findViewById(R.id.textView4));
		EdicaoPreferencias.setColorFonte("#000000", (TextView)findViewById(R.id.textView5));
		EdicaoPreferencias.setColorFonte("#000000", (TextView)findViewById(R.id.textView9));
		EdicaoPreferencias.setColorFonte("#000000", (TextView)findViewById(R.id.textView1));
	}
	if(EdicaoPreferencias.corFontePreferencia(this).equals("verde")){	
		EdicaoPreferencias.setColorFonte("#238E23", (TextView)findViewById(R.id.textView2));
		EdicaoPreferencias.setColorFonte("#238E23", (TextView)findViewById(R.id.textView3));
		EdicaoPreferencias.setColorFonte("#238E23", (TextView)findViewById(R.id.textView4));
		EdicaoPreferencias.setColorFonte("#238E23", (TextView)findViewById(R.id.textView5));
		EdicaoPreferencias.setColorFonte("#238E23", (TextView)findViewById(R.id.textView9));
		EdicaoPreferencias.setColorFonte("#238E23", (TextView)findViewById(R.id.textView1));
	}
	if(EdicaoPreferencias.corFontePreferencia(this).equals("vermelho")){	
		EdicaoPreferencias.setColorFonte("#FF0000", (TextView)findViewById(R.id.textView2));
		EdicaoPreferencias.setColorFonte("#FF0000", (TextView)findViewById(R.id.textView3));
		EdicaoPreferencias.setColorFonte("#FF0000", (TextView)findViewById(R.id.textView4));
		EdicaoPreferencias.setColorFonte("#FF0000", (TextView)findViewById(R.id.textView5));
		EdicaoPreferencias.setColorFonte("#FF0000", (TextView)findViewById(R.id.textView9));
		EdicaoPreferencias.setColorFonte("#FF0000", (TextView)findViewById(R.id.textView1));
	}
}


}



	

