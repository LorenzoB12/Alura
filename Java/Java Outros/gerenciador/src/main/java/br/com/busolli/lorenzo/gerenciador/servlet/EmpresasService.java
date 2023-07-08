package br.com.busolli.lorenzo.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.busolli.lorenzo.gerenciador.entidades.Banco;
import br.com.busolli.lorenzo.gerenciador.entidades.Empresa;

@WebServlet(urlPatterns = "/empresas")
public class EmpresasService extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		List<Empresa> empresas = new Banco().getEmpresas();
		String tipo = request.getHeader("accept");
		
		if(tipo.toUpperCase().contains("XML")) {
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			String xml = xstream.toXML(empresas);
			
			response.setContentType("application/xml");
			response.getWriter().print(xml);
		} 
		
		if(tipo.toUpperCase().contains("JSON")) {
			Gson gson = new Gson();
			String json = gson.toJson(empresas);
			
			response.setContentType("application/json");
			response.getWriter().print(json);
		}
		
		else {
			response.setContentType("application/json");
			response.getWriter().print("{'message' : 'no content'}");
		}
		
	}
}
