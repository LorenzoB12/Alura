package br.com.busolli.lorenzo.gerenciador.acoes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.busolli.lorenzo.gerenciador.entidades.Banco;
import br.com.busolli.lorenzo.gerenciador.entidades.Empresa;

public class NovaEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");

		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);

		Banco bd = new Banco();
		bd.adiciona(empresa);

		request.setAttribute("empresa", empresa.getNome());

//		response.sendRedirect("entrada?acao=listaEmpresas");
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}

}
