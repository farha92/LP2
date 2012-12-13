package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import salao.ClienteDAO;
import swing.Salao;
import salao.Cliente;
	
	@SuppressWarnings("serial")
	public class JCadastrarPanelAction extends AbstractAction {
		private JPanel principal;
		private CardLayout cards;
		
		private JTextField nome;
		private JTextField endereco;
		private JTextField telefone;


		public JCadastrarPanelAction(JPanel principal, CardLayout cards,JTextField nome,JTextField endereco,JTextField telefone) {
			super("Cadastrar");
			this.principal = principal;
			this.cards = cards;
			this.nome = nome;
			this.endereco = endereco;
			this.telefone = telefone;
	
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		
			
			String nom,end;
			String tel;
			
			ClienteDAO cliente = new ClienteDAO();
//      
		
					nom = (nome.getText());
					end = (endereco.getText());
					tel = (telefone.getText());
	
					
					Cliente cli = new Cliente(0,nom ,end,tel);
					
					cliente.inserir(cli);
					
			

					JOptionPane.showMessageDialog(null,
							"Cliente Cadastrado com Sucesso", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
			
		
			if (principal != null) {
				cards.show(principal, Salao.PRINCIPAL);
			}

		

				
}
}