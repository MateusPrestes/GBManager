package com.gbmanager.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Servlet implementation class GBManagerServlet
 */
@WebServlet("/GBManagerServlet")
public class GBManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<Long, Usuario>  usuarios;
	
	public static final int LISTAR = 1;
	public static final int GET = 2;
	public static final int SEARCH = 3;
	public static final int  ADD = 4;
	public static final int DEL = 5;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GBManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			usuarios =RepositorioUsuario.getInstance().getRepositorioUsuario();
		
 	    String operationString = request.getParameter("operation");
		 int operation = Integer.parseInt(operationString);
		 switch(operation){
		 	case LISTAR : {
		 		PrintWriter out = response.getWriter();
		        out.println(new JSONObject(usuarios));
		 	}
		 		break;
		 	
		 	case GET : {
		 		String idString = request.getParameter("id");
		 		Long id = Long.parseLong(idString);
		 		Usuario user = null;
		 	    if (usuarios.containsKey(id)) 
		 	      user = usuarios.get(id);
		 	     else 
		 	      user = new Usuario("", "");
		 	    Map<String,Usuario> result = new HashMap<String,Usuario>();  
		 	    result.put("usuario",user);
		 	    PrintWriter out = response.getWriter();
		        out.println(new JSONObject(result));
		 	}
		 		break;
		 	
		 	case SEARCH : {
		 		String nome = request.getParameter("login");
		 		Usuario usuario = null;
		 		for(Usuario c: usuarios.values()){
		 			  if (c.getLogin().equals(nome))
		 				 usuario= c;
		 	      }
		 		if (usuario==null){
		 			usuario=new Usuario("",""); //carro não encontrado
		 		}
		 		Map<String,Usuario> result = new HashMap<String,Usuario>();  
		 	    result.put("usuario",usuario);
		 	    PrintWriter out = response.getWriter();
		        out.println(new JSONObject(result));
		 	}
		 		break;
		 	
		 	case ADD : {
		 		String usuarioString = request.getParameter("usuario");
		 		System.out.println(usuarioString);
		 		boolean sucess=false;
		 		try {
					JSONObject carroJson = new JSONObject(usuarioString);
					Usuario c = new Usuario(carroJson.getString("login"),carroJson.getString("senha"));
					c.setId(carroJson.getLong("id"));
					usuarios.put(c.getId(), c);
					sucess=true;
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 		
		 		PrintWriter out = response.getWriter();
		        out.print(sucess);
		 	}
		 		break;
		 		
		 	case DEL:{
		 		String idString = request.getParameter("id");
		 		Long id = Long.parseLong(idString);
		 		
		 		usuarios.remove(id);
		 		
		 		PrintWriter out = response.getWriter();
		        out.print(true);
		        break;
		 	}
		 	default:{ PrintWriter out = response.getWriter();
		 			out.print("Comando desconhecido!");}
		 	
		 }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
