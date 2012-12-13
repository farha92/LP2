package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JCadastrarClienteMenuAction extends AbstractAction {
	public static final String CADASTRAR1 = "CADASTRAR1";

	private JPanel principal;
	private CardLayout cards;

	public JCadastrarClienteMenuAction(JPanel principal, CardLayout cards) {
		super("Inserir Clientes");
		this.principal = principal;
		this.cards = cards;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cards.show(principal, CADASTRAR1);
	}
}
