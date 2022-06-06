package controllers;

import java.text.ParseException;
import java.util.ArrayList;

import dao.OrcamentoDAO;
import models.Orcamento;

public class OrcamentoProcess {
	
	public static ArrayList<Orcamento> orcamentos = new ArrayList<>();
	private static OrcamentoDAO od = new OrcamentoDAO();
	
	public static void compararProdutos(String produto) {
		int indexBarato = 0;
		double precoBarato = 9999999;
		for (Orcamento orcamento : orcamentos) {
			if (orcamento.getProduto().equals(produto) && Double.parseDouble(orcamento.getPreco()) < precoBarato) {
				indexBarato = orcamentos.indexOf(orcamento);
				precoBarato = Double.parseDouble(orcamento.getPreco());
			}
		}
		
		for (Orcamento orcamento : orcamentos) {
			if (orcamentos.indexOf(orcamento) == indexBarato) {
				orcamento.setMaisBarato(true);
			} else if(orcamento.getProduto() == produto) {
				orcamento.setMaisBarato(false);
			}
		}
		
	}
	
	public static void salvar() {
		od.escrever(orcamentos);
	}
	
	public static void abrir(){
		try {
			orcamentos = od.ler();
		} catch (ParseException e) {
			System.out.println(e);
		}
	}
}
