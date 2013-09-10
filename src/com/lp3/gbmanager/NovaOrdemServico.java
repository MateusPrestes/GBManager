package com.lp3.gbmanager;

import com.lp3.gbmanager.model.Atividade;
import com.lp3.gbmanager.model.RepositorioAtividadesDB;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NovaOrdemServico extends Activity {

	
	RepositorioAtividadesDB repositorio;
	EditText campoCliente;
	EditText campoContrato;
	EditText campoEndereco;
	EditText campoDescricao;
	Spinner campoUsuario;
	EditText campoPrazo ;
	Long id ;
	Atividade atividadeNova;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nova_ordem_servico);
		
		repositorio = new RepositorioAtividadesDB(this);
		campoCliente = (EditText)findViewById(R.id.editCliente);
		campoContrato = (EditText)findViewById(R.id.editContrato);
		campoDescricao = (EditText)findViewById(R.id.editDescricao);
		campoUsuario = (Spinner)findViewById(R.id.spinner1_OS);
		campoPrazo = (EditText)findViewById(R.id.editPrazo);
		campoEndereco = (EditText)findViewById(R.id.editEndereco);
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
		          campoCliente.setText(atividade.getCliente());
		          campoContrato.setText(atividade.getContrato());
		          campoEndereco.setText(atividade.getEnd());
		        }
		      }
		      else {
		        Toast.makeText(this, "Informe o id da atividade.", Toast.LENGTH_SHORT);
		      }
		    }
		    
		    //aqui comeca
		 // Listener para salvar o carro
		    Button btSalvar = (Button) findViewById(R.id.button_os_salvar);
		    btSalvar.setOnClickListener(new OnClickListener() {
		      public void onClick(View view) {
		        atividadeNova = popularAtividade();
		        Log.i("NOVA ORDEM DE SERVICO", atividadeNova.getCliente()+atividadeNova.getContrato());
		        salvar(atividadeNova);
		      }
		    });
		    
		    Button btExcluir = (Button) findViewById(R.id.button_os_excluir);
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
		        Log.i("ENTROU EM POPULARATIVIDADE", "OK");
		        if(campoDescricao.getText()==null)
		        	campoDescricao.setText("");
		        atividade.setDescricao(campoDescricao.getText().toString());
		        Log.i("DESCRICAO", atividade.getDescricao());
		        if (campoPrazo.getText()==null)
		        	campoPrazo.setText("");
		        atividade.setPrazo(campoPrazo.getText().toString());
		        if (campoCliente.getText()==null)
		        	campoCliente.setText("");
		        atividade.setCliente(campoCliente.getText().toString());
		        Log.i("CLIENTE", atividade.getCliente());
		        if (campoContrato.getText()==null)
		        	campoContrato.setText("");
		        atividade.setContrato(campoContrato.getText().toString());
		        Log.i("Contrato", atividade.getContrato());
		        if (campoEndereco.getText().toString().equals(""));
		        	campoEndereco.setText("");
		        atividade.setEnd(campoEndereco.getText().toString());
		        Log.i("Endereco", atividade.getEnd());
		        
		        
		        

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


