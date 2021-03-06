package swing;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import swing.action.JCadastrarPanelAction;
import swing.action.JCadastrarPanelCloseAction;

@SuppressWarnings("serial")
public class JCadastrarPanel extends JPanel {

	JTextField nome;
	JTextField telefone;
	JTextField endereco;

	public JCadastrarPanel(JPanel principal, CardLayout cards) {
		add(new JLabel("Nome:"));
		nome = new JTextField(8);
		add(nome);

		add(new JLabel("Endere�o:"));
		endereco = new JTextField(8);
		add(endereco);

		add(new JLabel("Telefone:"));
		telefone = new JTextField(8);
		add(telefone);

		add(new JButton(new JCadastrarPanelAction(principal, cards, nome,
				endereco, telefone)));
		add(new JButton(new JCadastrarPanelCloseAction(principal, cards)));
	}

	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		System.out.printf("JCadastrarPanel::setVisible %b\n", aFlag);
		nome.setText("");
		endereco.setText("");
		telefone.setText("");
	}

	public JCadastrarPanel() {
		this(null, null);
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Only beautyfully woman - teste de cadastro");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JCadastrarPanel();
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
