package br.com.busolli.lorenzo.gerenciador.acoes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.busolli.lorenzo.gerenciador.entidades.Banco;
import br.com.busolli.lorenzo.gerenciador.entidades.Empresa;

public class AlteraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeEmpresaa = request.getParameter("nome");
		String paramDataEmpresaa = request.getParameter("data");
		String paramIdd = request.getParameter("id");
		Integer idd = Integer.valueOf(paramIdd);
		
		Date dataaAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataaAbertura = sdf.parse(paramDataEmpresaa);
		} catch (Exception e) {
			throw new ServletException(e);
		}
					
		Banco banc = new Banco();
		Empresa empr = banc.buscaEmpresaPelaId(idd);
		empr.setNome(nomeEmpresaa);
		empr.setDataAbertura(dataaAbertura);
		
//		response.sendRedirect("entrada?acao=listaEmpresas");
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}

}
