package com.lp3.gbmanager;

import com.lp3.gbmanager.model.RepositorioUsuario;
import com.lp3.gbmanager.model.RepositorioUsuarioFactory;
import com.lp3.gbmanager.model.Usuario;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroUsuario extends Activity {
	EditText campoUsuario;
	EditText campoMatricula;
	EditText campoEmail;
	EditText campoFuncionario;
	EditText campoSenha;
	RepositorioUsuario repositorio;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro_usuario);
		
	}

	public void salvarUsuario(View v){
		try{
		repositorio = new RepositorioUsuarioFactory().getRepositorioCarro(this);
		campoUsuario = (EditText)findViewById(R.id.editNome);
		campoSenha = (EditText)findViewById(R.id.editSenha);
		
		Usuario novoUsuario = new Usuario(campoUsuario.getText().toString(), campoSenha.getText().toString());
		
		if(repositorio.salvar(novoUsuario)){
			Toast t = Toast.makeText(this, "Usuario cadastrado!", Toast.LENGTH_SHORT);
			t.show();
			Intent menu = new Intent(this, Menu_Adm.class);
			startActivity(menu);
		}
		}catch(SQLiteException e){
			Toast t = Toast.makeText(this, "Nao foi possivel gravar dados", Toast.LENGTH_SHORT);
			t.show();
		}
	}

}
