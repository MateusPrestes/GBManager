package com.lp3.gbmanager;


import java.util.Locale;

import com.lp3.gbmanager.model.RepositorioUsuario;
import com.lp3.gbmanager.model.RepositorioUsuarioFactory;
import com.lp3.gbmanager.model.Usuario;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;

import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.Configuration;

import android.util.Log;

import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class TelaInicial extends Activity {

	public static final String PREFS_NAME = "Preferences";
    	EditText etUsuario;
    	EditText etSenha;

    	RepositorioUsuario repositorio ;

	
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
		final ProgressDialog dialog = ProgressDialog.show(this, "Aguarde",
		        "Autenticando usuário, por favor aguarde...", false, true);
		EditText login = (EditText)findViewById(R.id.editText1);
		EditText senha = (EditText)findViewById(R.id.editText2);
		String texto = login.getText().toString();
		texto=texto.trim();
		System.out.println("TEXTO= "+texto);
		repositorio = new RepositorioUsuarioFactory().getRepositorioCarro(this);
		
		if(repositorio.buscaUsuario(texto)!=null){
			Usuario user_login = repositorio.buscaUsuario(texto);
			Log.i("SENHA DB", user_login.getSenha());
			Log.i("SENHA DIGITADA", senha.getText().toString());
			if(user_login.getSenha().equals(senha.getText().toString())){
				Log.i("SENHAS", "IGUAIS");
				Intent menu = new Intent(this, Menu_Adm.class);
				dialog.dismiss();
				startActivity(menu);
				
			}else{
				dialog.dismiss();
				Toast t = Toast.makeText(this, "Senha inválida", Toast.LENGTH_SHORT);
				t.show();
			}
		}else{
			Toast t = Toast.makeText(this, "Usuário Inexistente", Toast.LENGTH_SHORT);
			dialog.dismiss();
			t.show();
		}
		
		
		
		
	}
	 /**Chamado quando a Activity � encerrada.*/
    @Override
    protected void onStop(){
       super.onStop();
 
       //Caso o checkbox esteja marcado gravamos o usu�rio
       CheckBox chkSalvar = (CheckBox)findViewById(R.id.chkSalvar);
       if (chkSalvar.isChecked()){
           SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
           SharedPreferences.Editor editor = settings.edit();
           editor.putString("PrefUsuario", etUsuario.getText().toString());
     
           //Confirma a grava��o dos dados
           editor.commit();
       }
       else{
    	   SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
    	   SharedPreferences.Editor editor = settings.edit();
    	   editor.putString("PrefUsuario", "");

    	   //Confirma a grava��o dos dados
    	   editor.commit();    	   
       }
    }
    
  //Evento click do bot�o Fechar prorama
    public void btnFechar_Click(View v){
    	Intent intent = new Intent(Intent.ACTION_MAIN);
    	finish();
    }
    
   
     

}
