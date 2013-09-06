package com.lp3.gbmanager;






import com.lp3.gbmanager.model.Atividade;
import com.lp3.gbmanager.model.RepositorioAtividadesDB;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class FormularioTarefa extends Activity {
	RepositorioAtividadesDB repositorio;
	EditText campoDescricao;
	Spinner campoUsuario;
	EditText campoPrazo ;
	Long id ;
	  
	  
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nova_tarefa);
		repositorio = new RepositorioAtividadesDB(this);
		campoDescricao = (EditText)findViewById(R.id.editText1);
		campoUsuario = (Spinner)findViewById(R.id.spinner1);
		campoPrazo = (EditText)findViewById(R.id.editText2);
		
		id = null;

	    Bundle extras = getIntent().getExtras();
	    
	    if (extras != null) {
	      id = extras.getLong("id");

	      if (id != null) {
	        
	        Atividade atividade = repositorio.getAtividade(id);

	        if (atividade == null) {
	          Toast.makeText(this, "Atividade n�o encontrada: " + id,
	              Toast.LENGTH_SHORT);
	        }
	        else {
	          campoDescricao.setText(atividade.getDescricao());
	          campoPrazo.setText(atividade.getPrazo());
	        
	        }
	      }
	      else {
	        Toast.makeText(this, "Informe o id da atividade.", Toast.LENGTH_SHORT);
	      }
	    }
	    
	    //aqui comeca
	 // Listener para salvar o carro
	    Button btSalvar = (Button) findViewById(R.id.button_form_tarefa_salvar);
	    btSalvar.setOnClickListener(new OnClickListener() {
	      public void onClick(View view) {
	        Atividade atividade = popularAtividade();
	        salvar(atividade);
	      }
	    });
	    
	    Button btExcluir = (Button) findViewById(R.id.button_form_tarefa_excluir);
	    if (id == null) {
	      // Se id est� nulo, n�o pode excluir
	      btExcluir.setVisibility(View.INVISIBLE);
	    }
	    else {
	      // Listener para excluir o carro
	      btExcluir.setOnClickListener(new OnClickListener() {
	        public void onClick(View view) {
	          Atividade atividade2 = repositorio.getAtividade(id);
	          excluir(atividade2);
	        }
	      });
	    }
	}
	    private Atividade popularAtividade() {
	        Atividade atividade = id != null ? repositorio.getAtividade(id) : new Atividade();
	        atividade.setDescricao(campoDescricao.getText().toString());
	        atividade.setPrazo(campoPrazo.getText().toString());
	        //carro.setAno(Integer.parseInt(campoAno.getText().toString()));
	        

	        return atividade;
	      }
	    
	    public void salvar(final Atividade atividade) {
	        final ProgressDialog dialog = ProgressDialog.show(this, "Aguarde",
	            "Salvando atividade, por aguarde...", false, true);
	        new Thread() {
	          @Override
	          public void run() {
	            // Salvar
	            boolean ok = repositorio.salvar(atividade);        

	            // OK
	            setResult(ok ? Activity.RESULT_OK : RESULT_CANCELED, new Intent());

	            // Fecha a tela
	            finish();

	            dialog.dismiss();
	          }
	        }.start();
	      }
	    
	    public void excluir(final Atividade atividade) {
	        final ProgressDialog dialog = ProgressDialog.show(this, "Aguarde",
	            "Excluindo atividade, por aguarde...", false, true);
	        new Thread() {
	          @Override
	          public void run() {
	            // Excluir
	            boolean ok = repositorio.deletar(atividade);

	            // OK
	            setResult(ok ? Activity.RESULT_OK : RESULT_CANCELED, new Intent());

	            // Fecha a tela
	            finish();

	            dialog.dismiss();
	          }
	        }.start();
	      }
	    
		
	}

	
	


