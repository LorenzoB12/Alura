package br.com.busolli.lorenzo.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.busolli.lorenzo.gerenciador.acoes.Acao;

//@WebServlet("/entrada")
public class Entrada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		boolean usuarioNaoLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean acaoNaoProtegida = !(request.getParameter("acao").equals("Login") || request.getParameter("acao").equals("LoginForm"));
		
		if(usuarioNaoLogado && acaoNaoProtegida) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		String parametro = "br.com.busolli.lorenzo.gerenciador.acoes." + request.getParameter("acao");
		
		Acao acao = null;
		try {
			Class classe = Class.forName(parametro);
			acao = (Acao) classe.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
		String nome = acao.executa(request, response);
		
//		switch (parametro) {
//		
//		case "ListaEmpresas":
//			ListaEmpresas le = new ListaEmpresas();
//			nome = le.executa(request, response);
//			break;
//		
//		case "NovaEmpresa":
//			NovaEmpresa ne = new NovaEmpresa();
//			nome = ne.executa(request, response);
//			break;
//			
//		case "RemoveEmpresa":
//			RemoveEmpresa re = new RemoveEmpresa();
//			nome = re.executa(request, response);
//			break;
//			
//		case "MostraEmpresa":
//			MostraEmpresa me = new MostraEmpresa();
//			nome = me.executa(request, response);
//			break;
//			
//		case "AlteraEmpresa":
//			AlteraEmpresa ae = new AlteraEmpresa();
//			nome = ae.executa(request, response);
//			break;
//			
//		case "NovaEmpresaForm":
//			NovaEmpresaForm nef = new NovaEmpresaForm();
//			nome = nef.executa(request, response);
//			break;
//		}
		
		String[] acaoEParametro = nome.split(":");
		if(acaoEParametro[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + acaoEParametro[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(acaoEParametro[1]);
		}
		
	}
}