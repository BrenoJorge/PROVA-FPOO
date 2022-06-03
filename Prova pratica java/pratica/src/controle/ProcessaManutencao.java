package controle;

import java.util.ArrayList;

import DAO.ManutencaoDAO;
import modelo.Manutencao;

public class ProcessaManutencao {

	public static ArrayList<Manutencao> manutencoes = new ArrayList<>();
	private static ManutencaoDAO md = new ManutencaoDAO();
	
	public static void abrir() {
		manutencoes = md.ler();
	}
	
	public static void salvar() {
		md.escrever(manutencoes);
	}
	
	public static void testes() {
		manutencoes.add(new Manutencao(1,"Injetora 1","100,0","3,0"));
		manutencoes.add(new Manutencao(1,"Esteira","100,0","3,0"));
		manutencoes.add(new Manutencao(1,"Bra�o Hidraulico","200,0","3,0"));
		manutencoes.add(new Manutencao(1,"Injetora 2","100,0","1,5"));
		manutencoes.add(new Manutencao(1,"Injetora 3","100,0","1,0"));
		manutencoes.add(new Manutencao(1,"Esteira","50,0","3,0"));
		manutencoes.add(new Manutencao(1,"Bra�o Hidraulico","70,0","2,0"));
	}
}
