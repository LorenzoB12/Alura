package antigo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private Integer id;
	private String nome;
	private List<Produto> produto = new ArrayList<Produto>();
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Categoria(Integer id, String nome, Produto prod) {
		this.id = id;
		this.nome = nome;
		this.produto.add(prod);
	}
	
	public String getNome() {
		return nome;
	}
	
	public Integer getId() {
		return id;
	}
	
	public List<Produto> getProduto() {
		return produto;
	}
	
}
