package br.com.busolli.lorenzo.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

//@WebFilter("/entrada")
public class MonitoramentoFilter extends HttpFilter implements Filter {

	@Override
	public void init() throws ServletException {
	}
	
	@Override
	public void destroy() {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("ENTRADA MONITORAMENTO");
		long antes = System.currentTimeMillis();
		String classe = request.getParameter("acao");
		
		chain.doFilter(request, response);
		
		System.out.println("SAÍDA MONITORAMENTO");
		
		long depois = System.currentTimeMillis();
		
		System.out.println("Tempo de execucao do " + classe + " -> " + (depois - antes)); 
	}
	
	
}
