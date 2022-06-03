package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controle.ProcessaManutencao;
import modelo.Manutencao;

public class FormManutencao extends JDialog{



		private static final long serialVersionUID = 1L;
		private JPanel painel;
		private JLabel id, Data, Equipamento, CustoHora, TempoGasto;
		private JTextField tfId, tfData, tfEquipamento, tfCustoHora, tfTempoGasto;
		private JButton create, read, update, delete;
		private final Locale BRASIL = new Locale("pt", "BR");
		private DecimalFormat df = new DecimalFormat("#.00");
		private JTextArea verResultados;
		private JScrollPane rolagem;
		private String texto = "";
		
		public FormManutencao() {
			setTitle("Cadastro de Manutencao de Equipamento");
			setBounds(150, 170, 800, 600);
			painel = new JPanel();
			painel.setBackground(new Color(144, 0, 49));
			setContentPane(painel);
			setLayout(null);

			id = new JLabel("Id : ");
			id.setForeground(new Color(255,255,255));
			id.setBounds(20, 20, 120, 30);
			id.setFont( new Font("Serif", Font.BOLD, 25) );
			painel.add(id);
			Data = new JLabel("Data : ");
			Data.setBounds(20, 55, 120, 30);
			Data.setFont( new Font("Serif", Font.BOLD, 25) );
			Data.setForeground(new Color(255,255,255));
			painel.add(Data);
			Equipamento = new JLabel("Equipamento : ");
			Equipamento.setBounds(20, 90, 180, 30);
			Equipamento.setForeground(new Color(255,255,255));
			Equipamento.setFont( new Font("Serif", Font.BOLD, 25) );
			painel.add(Equipamento);
			CustoHora = new JLabel("Custo horas : ");
			CustoHora.setBounds(20, 125, 180, 30);
			CustoHora.setForeground(new Color(255,255,255));
			CustoHora.setFont( new Font("Serif", Font.BOLD, 25) );
			painel.add(CustoHora);
			TempoGasto = new JLabel("Tempo gasto : ");
			TempoGasto.setBounds(20, 165, 180, 30);
			TempoGasto.setForeground(new Color(255,255,255));
			TempoGasto.setFont( new Font("Serif", Font.BOLD, 25) );
			painel.add(TempoGasto);
			tfId = new JTextField();
			tfId.setBounds(200, 25, 55, 30);
			painel.add(tfId);
			tfData = new JTextField();
			tfData.setBounds(200, 60, 100, 30);
			painel.add(tfData);
			tfEquipamento = new JTextField();
			tfEquipamento.setBounds(200, 95, 255, 30);
			painel.add(tfEquipamento);
			tfCustoHora = new JTextField();
			tfCustoHora.setBounds(200, 130, 255, 30);
			painel.add(tfCustoHora);
			tfTempoGasto = new JTextField();
			tfTempoGasto.setBounds(200, 165, 255, 30);
			painel.add(tfTempoGasto);
			
			create = new JButton("Cadastrar");
			read = new JButton("Buscar");
			update = new JButton("Atualizar");
			delete = new JButton("Excluir");
			create.setBounds(525, 25, 110, 30);
			create.setBackground(new Color(191,221,255));
			read.setBounds(525, 70, 110, 30);
			read.setBackground(new Color(191,221,255));
			update.setBounds(525, 115, 110, 30);
			delete.setBounds(525, 160, 110, 30);
			update.setEnabled(false);
			delete.setEnabled(false);
			painel.add(create);
			painel.add(read);
			painel.add(update);
			painel.add(delete);
			
			verResultados = new JTextArea();
			verResultados.setEditable(false);
			verResultados.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			preencherAreaDeTexto();
			rolagem = new JScrollPane(verResultados);
			rolagem.setBounds(20, 340, 740, 200);
			painel.add(rolagem);
			
		}
		
		private void preencherAreaDeTexto() {
			texto = ""; // Limpar a área de texto antes de preenher
			for (Manutencao p : ProcessaManutencao.manutencoes) {
				texto += p.toString();
			}
			verResultados.setText(texto);
		}
		
		public static void main(String[] agrs){
			ProcessaManutencao.abrir();
			new FormManutencao().setVisible(true);
		}


}
