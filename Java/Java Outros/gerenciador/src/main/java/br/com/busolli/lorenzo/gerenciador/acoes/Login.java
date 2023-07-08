package br.com.busolli.lorenzo.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.busolli.lorenzo.gerenciador.entidades.Banco;
import br.com.busolli.lorenzo.gerenciador.entidades.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Banco bd = new Banco();
		Usuario usuario = bd.existeLogin(login, senha);
		
		if(usuario != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", login);
			return "redirect:entrada?acao=ListaEmpresas";
		}
		
		else return "redirect:entrada?acao=LoginForm";
	}

}
