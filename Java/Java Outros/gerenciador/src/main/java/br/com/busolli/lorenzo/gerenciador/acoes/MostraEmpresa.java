package br.com.busolli.lorenzo.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.busolli.lorenzo.gerenciador.entidades.Banco;
import br.com.busolli.lorenzo.gerenciador.entidades.Empresa;

public class MostraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parId = request.getParameter("id");
		Integer idw = Integer.valueOf(parId);
		
		Banco bancoo = new Banco();
		
		Empresa empresaa = bancoo.buscaEmpresaPelaId(idw);
		
		request.setAttribute("empresa", empresaa);
		
//		RequestDispatcher reed = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
//		reed.forward(request, response);
		
		return "forward:formAlteraEmpresa.jsp";
		
	}

}
