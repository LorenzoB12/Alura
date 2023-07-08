package br.com.busolli.lorenzo.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/entrada")
public class AutorizacaoFilter extends HttpFilter implements Filter {
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	public void destroy() {
	}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("ENTRADA AUTORIZACAO");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		HttpSession sessao = request.getSession();
		boolean usuarioNaoLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean acaoProtegida = !(request.getParameter("acao").equals("Login") || request.getParameter("acao").equals("LoginForm"));
		
		if(usuarioNaoLogado && acaoProtegida) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
		
		System.out.println("SAÍDA AUTORIZACAO");
	}

}
