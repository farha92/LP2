package swing;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import swing.action.JAboutMenuAction;
import swing.action.JAgendaMenuAction;
import swing.action.JCadastrarClienteMenuAction;
import swing.action.JConsultarClienteMenuAction;
import swing.action.JSairMenuAction;

public class Salao {
	public static final String PRINCIPAL = "PRINCIPAL";

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("One Beauty ");
		CardLayout cards = new CardLayout();
		// TODO: utilizar card layout para combinar telas.
		// http://docs.oracle.com/javase/tutorial/uiswing/layout/card.html
		JPanel principal = new JPanel(cards);

		// JPanel depositar = new JDepositarPanel(principal, cards);
		JPanel vazio = new JPanel();
		JLabel label = new JLabel("Only Beautiful Women.");
		vazio.add(label);

		JPanel cadastrar = new JCadastrarPanel(principal, cards);
		JPanel consultarCliente = new JConsultarClientePanel(principal, cards);
		JPanel mostrarAgenda = new JAgendaPanel(principal, cards);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setIconImage(new ImageIcon("pindorama.jpg").getImage());

		frame.getContentPane().add(principal);

		principal.add(vazio, PRINCIPAL);
		principal.add(cadastrar, JCadastrarClienteMenuAction.CADASTRAR1);
		principal.add(consultarCliente, JConsultarClienteMenuAction.CONSULTAR1);

		 principal.add(mostrarAgenda,JAgendaMenuAction.ServFunc);

		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("Arquivo");
		menubar.add(file);

		JMenu cliente = new JMenu("Cadastrar cliente");
		menubar.add(cliente);

		JMenu terminal = new JMenu("Agenda");
		menubar.add(terminal);

		JMenu help = new JMenu("Ajuda");
		menubar.add(help);

		Action cadastrarAction = new JCadastrarClienteMenuAction(principal,
				cards);
		cliente.add(cadastrarAction);

		Action consultarAction = new JConsultarClienteMenuAction(principal,
				cards);
		cliente.add(consultarAction);

		Action exitAction = new JSairMenuAction();
		file.add(exitAction);

		Action mostrarAgendaAction = new JAgendaMenuAction(principal, cards);
		terminal.add(mostrarAgendaAction);

		//
		// Action extratoAction = new JConsultarExtratoMenuAction();
		// terminal.add(extratoAction);
		// Action depositarAction = new JDepositarMenuAction(principal,cards);
		// terminal.add(depositarAction);
		Action aboutAction = new JAboutMenuAction(frame);
		help.add(aboutAction);

		frame.setJMenuBar(menubar);

		frame.setMinimumSize(new Dimension(400, 200));

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
