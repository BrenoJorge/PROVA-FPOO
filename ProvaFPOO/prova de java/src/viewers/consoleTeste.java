package viewers;

import controllers.OrcamentoProcess;
import models.Orcamento;

public class consoleTeste {

	public static void main(String[] args) {
		String linha = "1;microsoft;tela;800;false";
		Orcamento o = new Orcamento(linha);
		OrcamentoProcess.orcamentos.add(o);
		OrcamentoProcess.salvar();
	}

}
