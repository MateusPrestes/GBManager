package com.lp3.gbmanager.controller;

import java.util.List;

import com.lp3.gbmanager.R;
import com.lp3.gbmanager.R.id;
import com.lp3.gbmanager.R.layout;
import com.lp3.gbmanager.model.AtividadeBean;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AtividadeListAdapter extends BaseAdapter{
	private Context context;
	  private List<AtividadeBean> lista;

	  public AtividadeListAdapter(Context context, List<AtividadeBean> lista) {
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
	    AtividadeBean atividade = lista.get(posicao);

	    // LayoutInflater permite instanciar uma View a partir de um arquivo de layout XML
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    // Cria a view a partir do arquivo carro_linha_tabela.xml
	    View view = inflater.inflate(R.layout.detalhes_atividade, null);

	    // Atualiza o valor dos campos da tela
	    TextView cliente = (TextView) view.findViewById(R.id.cliente);
	    cliente.setText(atividade.getCliente());

	    TextView descricao = (TextView) view.findViewById(R.id.descricao);
	    descricao.setText(atividade.getDescricao());

	    TextView prazo = (TextView) view.findViewById(R.id.prazo);
	    prazo.setText(String.valueOf(atividade.getPrazo()));

	    
	    
	    

	    return view;
	  }
	

}
