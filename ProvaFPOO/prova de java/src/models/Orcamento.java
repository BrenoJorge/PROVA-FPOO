package models;

import java.util.Objects;

public class Orcamento {
	
	int id;
	String fornecedor;
	String produto;
	String preco;
	boolean maisBarato;
	
	public Orcamento(String linha){
		this.id = Integer.parseInt(linha.split(";")[0]);
		this.fornecedor = linha.split(";")[1];
		this.produto = linha.split(";")[2];
		this.preco = linha.split(";")[3];
		this.maisBarato = false;
	}
	public Orcamento(int id) {
		this.id = id;
	}
	public Orcamento(int id, String fornecedor, String produto, String preco, boolean maisBarato) {
		this.id = id;
		this.fornecedor = fornecedor;
		this.produto = produto;
		this.preco = preco;
		this.maisBarato = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public boolean isMaisBarato() {
		return maisBarato;
	}

	public void setMaisBarato(boolean maisBarato) {
		this.maisBarato = maisBarato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fornecedor, id, maisBarato, preco, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orcamento other = (Orcamento) obj;
		return Objects.equals(fornecedor, other.fornecedor) && id == other.id && maisBarato == other.maisBarato
				&& Objects.equals(preco, other.preco) && Objects.equals(produto, other.produto);
	}
	
	public Double getSubTotal() {
		return null;
	}

	public String toCSV() {
		return id + ";" + fornecedor + ";" + produto + ";" + preco + "\r\n";
	}

	public String toMaisBarato() {
		return id + "\t" + fornecedor + "\t" + produto + "\t" + preco
				+ "\tComprar\n";
	}
	
	public String toMaisCaro() {
		return id + "\t" + fornecedor + "\t" + produto + "\t" + preco
				+ "\n";
	}
	
}
