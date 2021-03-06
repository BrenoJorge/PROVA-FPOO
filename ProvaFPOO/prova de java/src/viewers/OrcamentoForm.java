package viewers;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.OrcamentoProcess;
import models.Orcamento;

public class OrcamentoForm extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextField id, fornecedor, produto, preco;
	private JLabel textId, textFornecedor, textProduto, textPreco;
	private JTable tabelaOrcamentos;
	private JScrollPane scroll;
	private static DefaultTableModel tableModel;
	private JButton alterar, excluir, buscar, adicionar;

	OrcamentoForm() {
		setTitle("Tela de usuario");
		setBounds(450, 100, 800, 600);
		painel = new JPanel();
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		painel.setBackground(new Color(57, 57, 67));

		adicionar = new JButton("Adicionar");
		adicionar.setBorderPainted(false);
		adicionar.setFocusPainted(false);
		adicionar.setBackground(new Color(48, 105, 185));
		adicionar.setForeground(new Color(255, 255, 255));
		adicionar.setFont(new Font("Serif", Font.BOLD, 20));
		adicionar.setBounds(550, 20, 150, 50);

		excluir = new JButton("Excluir");
		excluir.setBorderPainted(false);
		excluir.setFocusPainted(false);
		excluir.setBackground(new Color(48, 105, 185));
		excluir.setForeground(new Color(255, 255, 255));
		excluir.setFont(new Font("Serif", Font.BOLD, 20));
		excluir.setBounds(550, 90, 150, 50);

		buscar = new JButton("Buscar");
		buscar.setBorderPainted(false);
		buscar.setFocusPainted(false);
		buscar.setBackground(new Color(48, 105, 185));
		buscar.setForeground(new Color(255, 255, 255));
		buscar.setFont(new Font("Serif", Font.BOLD, 20));
		buscar.setBounds(550, 160, 150, 50);

		alterar = new JButton("Alterar");
		alterar.setBorderPainted(false);
		alterar.setFocusPainted(false);
		alterar.setBackground(new Color(48, 105, 185));
		alterar.setForeground(new Color(255, 255, 255));
		alterar.setFont(new Font("Serif", Font.BOLD, 20));
		alterar.setBounds(550, 230, 150, 50);

		id = new JTextField();
		id.setBounds(100, 25, 50, 20);

		fornecedor = new JTextField();
		fornecedor.setBounds(250, 65, 150, 30);

		produto = new JTextField();
		produto.setBounds(220, 120, 150, 30);

		preco = new JTextField();
		preco.setBounds(180, 175, 50, 20);

		textId = new JLabel("Id :");
		textId.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 30));
		textId.setBounds(20, 5, 200, 50);
		textId.setForeground(new Color(231, 232, 234));
		painel.add(textId);

		textFornecedor = new JLabel("Fornecedor :");
		textFornecedor.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 30));
		textFornecedor.setBounds(20, 50, 300, 50);
		textFornecedor.setForeground(new Color(231, 232, 234));
		painel.add(textFornecedor);

		textProduto = new JLabel("Produto :");
		textProduto.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 30));
		textProduto.setBounds(20, 105, 300, 50);
		textProduto.setForeground(new Color(231, 232, 234));
		painel.add(textProduto);

		textPreco = new JLabel("Valor :");
		textPreco.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 30));
		textPreco.setBounds(20, 155, 300, 50);
		textPreco.setForeground(new Color(231, 232, 234));
		painel.add(textPreco);

		tabela();
		ListarTodos();

		painel.add(adicionar);
		painel.add(excluir);
		painel.add(buscar);
		painel.add(alterar);

		painel.add(id);
		painel.add(fornecedor);
		painel.add(produto);
		painel.add(preco);

		adicionar.addActionListener(this);
		excluir.addActionListener(this);
		buscar.addActionListener(this);
		alterar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == adicionar) {
			String linha = id.getText() + ";" + fornecedor.getText() + ";" + produto.getText() + ";" + preco.getText();
			Orcamento dados = new Orcamento(linha);
			OrcamentoProcess.orcamentos.add(dados);
			OrcamentoProcess.salvar();
			id.setText("");
			fornecedor.setText("");
			produto.setText("");
			preco.setText("");
			ListarTodos();
		} else if (e.getSource() == excluir) {
			boolean rodandoCodigo = true;
			while (rodandoCodigo == true) {
				adicionar.setEnabled(false);
				buscar.setEnabled(false);
				alterar.setEnabled(false);
				excluir.setEnabled(false);
				try {
					String entrada = JOptionPane.showInputDialog(this, "Digite o Id do produto que deseja excluir :");
					Orcamento manTemp = null;
					for (Orcamento o : OrcamentoProcess.orcamentos) {
						if (o.getId() == Integer.parseInt(entrada)) {
							manTemp = o;
						}
					}

					if (JOptionPane.showConfirmDialog(this, "realmente deseja EXCLUIR " + manTemp.getProduto()) == 0) {
						OrcamentoProcess.orcamentos.remove(OrcamentoProcess.orcamentos.indexOf(manTemp));
						rodandoCodigo = false;
						adicionar.setEnabled(true);
						buscar.setEnabled(true);
						alterar.setEnabled(true);
						excluir.setEnabled(true);
					} else if (JOptionPane.showConfirmDialog(this,
							"realmente deseja EXCLUIR " + manTemp.getProduto()) != 0) {
						rodandoCodigo = false;
						adicionar.setEnabled(true);
						buscar.setEnabled(true);
						alterar.setEnabled(true);
						excluir.setEnabled(true);
					}

					ListarTodos();
					OrcamentoProcess.salvar();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(adicionar, "Digite um numero!");
					rodandoCodigo = false;
					adicionar.setEnabled(true);
					buscar.setEnabled(true);
					alterar.setEnabled(true);
					excluir.setEnabled(true);
				}

			}

		} else if (e.getSource() == buscar) {
			String text = JOptionPane.showInputDialog(this, "Digite o ID da manuten??o a ser buscada");

			try {
				int aux = Integer.parseInt(text);
				for (Orcamento o : OrcamentoProcess.orcamentos) {
					if (aux == o.getId()) {
						id.setText(aux + "");
						fornecedor.setText(o.getFornecedor());
						produto.setText(o.getProduto());
						preco.setText(o.getPreco());
					}
				}

			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "ID inv?lido!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == alterar) {
			if (fornecedor.getText().length() != 0 || produto.getText().length() != 0
					|| preco.getText().length() != 0) {

				int indice = -1;

				for (Orcamento m : OrcamentoProcess.orcamentos) {
					if (Integer.parseInt(id.getText()) == m.getId()) {
						indice = OrcamentoProcess.orcamentos.indexOf(m);
					}
				}

				try {
					OrcamentoProcess.orcamentos.get(indice).setPreco(textPreco.getText().replace(",", "."));
				} catch (Exception e1) {
					System.out.println(e1.toString());
				}
				OrcamentoProcess.orcamentos.get(indice).setId(Integer.parseInt(id.getText()));
				OrcamentoProcess.orcamentos.get(indice).setProduto(produto.getText());
				OrcamentoProcess.orcamentos.get(indice).setFornecedor(fornecedor.getText());
				OrcamentoProcess.orcamentos.get(indice).setPreco(preco.getText());
				OrcamentoProcess.salvar();
				ListarTodos();

			}
		}

	}

	private void tabela() {
		tabelaOrcamentos = new JTable();
		tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Fornecedor");
		tableModel.addColumn("Tipo Produto");
		tableModel.addColumn("Preco");
		tableModel.addColumn("Comprar");
		if (OrcamentoProcess.orcamentos.size() != 0) {
			ListarTodos();
		}
		tabelaOrcamentos = new JTable(tableModel);
		tabelaOrcamentos.setEnabled(false);
		scroll = new JScrollPane(tabelaOrcamentos);
		scroll.setBounds(20, 250, 500, 250);
		scroll.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		painel.add(scroll);
	}

	public static void ListarTodos() {
		for (Orcamento orcamento : OrcamentoProcess.orcamentos) {
			OrcamentoProcess.compararProdutos(orcamento.getProduto());
		}
		int totLinhas = tableModel.getRowCount();
		if (tableModel.getRowCount() > 0) {
			for (int i = 0; i < totLinhas; i++) {
				tableModel.removeRow(0);
			}
		}
		for (Orcamento o : OrcamentoProcess.orcamentos) {
			if (o.isMaisBarato()) {
				tableModel.addRow(
						new String[] { o.getId() + "", o.getFornecedor(), o.getProduto(), o.getPreco(), "Comprar!" });
			} else {
				tableModel.addRow(new String[] { o.getId() + "", o.getFornecedor(), o.getProduto(), o.getPreco(), "" });
			}
		}

	}

	public static void main(String[] args) {
		OrcamentoProcess.abrir();
		OrcamentoForm tela = new OrcamentoForm();
		tela.setVisible(true);
	}
}
