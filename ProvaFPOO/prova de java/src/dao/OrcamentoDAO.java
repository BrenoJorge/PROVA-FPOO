package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import models.Orcamento;

public class OrcamentoDAO {
	
	BufferedReader br;
	BufferedWriter bw;
	String path = "C:\\Users\\des\\Desktop\\ProvaFPOO\\prova de java\\dados\\dados.csv";
	
	public ArrayList<Orcamento> ler() throws ParseException {
		ArrayList<Orcamento> linhas = new ArrayList<>();
		Orcamento dado;
		try {
			br = new BufferedReader(new FileReader(path));
			String linha = br.readLine();
			while(linha != null) {
				dado = new Orcamento(linha);
				linhas.add(dado);
				linha = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		return linhas;
	}
	
	public void escrever(ArrayList<Orcamento> linhas) {
		try {
			bw = new BufferedWriter(new FileWriter(path));
			for (Orcamento p : linhas) {
				bw.write(p.toCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("sucesso");
	}
}
