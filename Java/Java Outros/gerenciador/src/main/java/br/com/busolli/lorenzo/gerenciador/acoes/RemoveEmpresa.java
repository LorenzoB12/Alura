package br.com.busolli.lorenzo.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.busolli.lorenzo.gerenciador.entidades.Banco;

public class RemoveEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
					
		Banco bank = new Banco();
		bank.removeEmpresa(id);
		
//		response.sendRedirect("entrada?acao=listaEmpresas");
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}

}
