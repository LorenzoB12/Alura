package br.com.busolli.lorenzo.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.busolli.lorenzo.gerenciador.acoes.Acao;

//@WebFilter("/entrada")
public class ControladorFilter extends HttpFilter implements Filter {
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	public void destroy() {
	}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("ENTRADA CONTROLADOR");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String parametro = "br.com.busolli.lorenzo.gerenciador.acoes." + request.getParameter("acao");
		
		Acao acao = null;
		try {
			Class classe = Class.forName(parametro);
			acao = (Acao) classe.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
		String nome = acao.executa(request, response);
		
		String[] acaoEParametro = nome.split(":");
		if(acaoEParametro[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + acaoEParametro[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(acaoEParametro[1]);
		}
		
		System.out.println("SAÍDA CONTROLADOR");
		
	}

}
