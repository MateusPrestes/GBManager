package com.lp3.gbmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class TelaInicial extends Activity {

	public static final String PREFS_NAME = "Preferences";
    EditText etUsuario;
    EditText etSenha;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_inicial);
		etUsuario = (EditText)findViewById(R.id.editText1);
        etSenha = (EditText)findViewById(R.id.editText2);
         
        //Restaura as preferencias gravadas
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        etUsuario.setText(settings.getString("PrefUsuario", ""));
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
	 /**Chamado quando a Activity é encerrada.*/
    @Override
    protected void onStop(){
       super.onStop();
 
       //Caso o checkbox esteja marcado gravamos o usuário
       CheckBox chkSalvar = (CheckBox)findViewById(R.id.chkSalvar);
       if (chkSalvar.isChecked()){
           SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
           SharedPreferences.Editor editor = settings.edit();
           editor.putString("PrefUsuario", etUsuario.getText().toString());
     
           //Confirma a gravação dos dados
           editor.commit();
       }
       else{
    	   SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
    	   SharedPreferences.Editor editor = settings.edit();
    	   editor.putString("PrefUsuario", "");

    	   //Confirma a gravação dos dados
    	   editor.commit();    	   
       }
    }
    
  //Evento click do botão Fechar prorama
    public void btnFechar_Click(View v){
    	Intent intent = new Intent(Intent.ACTION_MAIN);
    	finish();
    }
     

}
