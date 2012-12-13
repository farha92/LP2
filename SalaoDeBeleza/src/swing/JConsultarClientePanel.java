package swing;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import swing.action.JCadastrarPanelCloseAction;
import salao.ClienteDAO;
import salao.Cliente;


@SuppressWarnings("serial")
public class JConsultarClientePanel extends JPanel{

	private JTextArea dados;
	public JConsultarClientePanel(JPanel principal, CardLayout cards) {
		dados = new JTextArea(20,60); 
		dados.setEditable(false);
		add(dados);
		add(new JButton(new JCadastrarPanelCloseAction(principal, cards)));
	}

	public JConsultarClientePanel() {
		this(null, null);
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		if (aFlag == false) {
			return;
		}
		System.out.printf("JDepositarPanel::setVisible %b\n", aFlag);
		ClienteDAO cliente = new ClienteDAO();
		
		List<Cliente> cl = cliente.consultarCliente();

	
			String s = "Nome \t Endere�o \t\t Telefone \n\n";
		
			for (Cliente consultar : cl) {
			
				s += String.format("%s \t %s \t %s \n",	consultar.getNome(),consultar.getEndereco(),consultar.getTelefone());
			}
			
			dados.setText(s);
			
	}
	
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("One Beauty - Teste do Painel Consultar cliente");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JConsultarClientePanel();
		frame.getContentPane().add(painel);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}

