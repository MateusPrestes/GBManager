package com.lp3.gbmanager.model;


import android.content.Context;


public class RepositorioUsuarioFactory {
	private static RepositorioUsuario repositorio;
	
	  public static RepositorioUsuario getRepositorioCarro(Context context) {
	    if (repositorio == null) {
	      //repositorio = new RepositorioCarroDB(context);
	    	repositorio = new RepositorioUsuarioDB(context);
	    }
	    return repositorio;
	  }
}
