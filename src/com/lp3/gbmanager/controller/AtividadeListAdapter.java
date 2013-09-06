package com.lp3.gbmanager.controller;

import java.util.List;


import com.lp3.gbmanager.model.Atividade;
import com.lp3.gbmanager.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AtividadeListAdapter extends BaseAdapter{
	private Context context;
	  private List<Atividade> lista;

	  public AtividadeListAdapter(Context context, List<Atividade> lista) {
	    this.context = context;
	    this.lista = lista;
	  }

	  @Override
	  public int getCount() {
	    return lista.size();
	  }

	  @Override
	  public Object getItem(int posicao) {
	    return lista.get(posicao);
	  }

	  @Override
	  public long getItemId(int posicao) {
	    return posicao;
	  }

	  @Override
	  public View getView(int posicao, View convertView, ViewGroup parent) {
	    // Recupera o Carro da posi��o atual
	    Atividade atividade = lista.get(posicao);

	    // LayoutInflater permite instanciar uma View a partir de um arquivo de layout XML
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    // Cria a view a partir do arquivo carro_linha_tabela.xml
	    View view = inflater.inflate(R.layout.detalhes_atividade, null);

	    // Atualiza o valor dos campos da tela
	    TextView id = (TextView) view.findViewById(R.id.id);
	    id.setText("Id: "+atividade.getId().toString());
	    TextView cliente = (TextView) view.findViewById(R.id.cliente);
	    if(atividade.getCliente()!=null){
	    	cliente.setText("Cliente: "+atividade.getCliente());
	    }else{
	    	cliente.setVisibility(View.INVISIBLE);
	    }
	    TextView contrato = (TextView)view.findViewById(R.id.contrato);
	    if(atividade.getContrato()!=null){
	    	contrato.setText("Contrato: "+atividade.getContrato());
	    }else{
	    	contrato.setVisibility(View.INVISIBLE);
	    }
	    TextView descricao = (TextView) view.findViewById(R.id.descricao);
	    if(atividade.getDescricao()!= null){
	    	descricao.setText("Descricao: "+atividade.getDescricao());
	    }else{
	    	descricao.setVisibility(View.INVISIBLE);
	    }
	    TextView endereco = (TextView) view.findViewById(R.id.endereco);
	    if(atividade.getEnd()!= null){
	    	endereco.setText("End: "+atividade.getEnd());
	    }else{
	    	endereco.setVisibility(View.INVISIBLE);
	    }
	    TextView prazo = (TextView) view.findViewById(R.id.prazo);
	    prazo.setText("Prazo: "+String.valueOf(atividade.getPrazo()));

	    
	    
	    

	    return view;
	  }
	

}
