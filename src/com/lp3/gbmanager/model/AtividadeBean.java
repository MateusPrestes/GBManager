package com.lp3.gbmanager.model;

public class AtividadeBean {
	
	private String cliente, end, descricao, usuario, prazo, contrato;
	private Long id;
	
	public AtividadeBean(){};
	
	public AtividadeBean(String cliente, String end, String descricao, String usuario,
			String prazo, String contrato, Long id){
		this.cliente = cliente;
		this.end = end;
		this.descricao = descricao;
		this.usuario = usuario;
		this.prazo = prazo;
		this.contrato = contrato;
		this.id = id;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPrazo() {
		return prazo;
	}
	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	
	

}
