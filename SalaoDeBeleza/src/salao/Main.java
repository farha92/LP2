package salao;



public class Main {


	
	public static void main(String[] args) {
//seleciona
		ClienteDAO cliente = new ClienteDAO();
		//Cliente cl = cliente.findCliente(1);
		//if (cl == null) {
		//	System.out.println("Conta n�o encontrada!");
		//} else {
		//	System.out.println(cl);}
			
			
			// Realiza a inser��o aqui
	//	Cliente c = new Cliente("eduarda","rua a","33302233", 0);
	//	cliente.inserir(c);
	//	System.out.println(c);
			
			
			// Realiza a deleta�ao
		//Cliente d = new Cliente("gabriel","rua palmeiras","33302233", 7);
		//cliente.deletar(d);
		//System.out.println(d);
		
		//deleta
		ClienteDAO clienteDao = new ClienteDAO();
		Cliente c = clienteDao.findCliente(11);
		System.out.println(c);
		clienteDao.deletar(c);
		
			
			//		FuncionarioDAO funcionario = new FuncionarioDAO();
			//		Funcionario fu = funcionario.findFuncionario("Rogia");
			//		if (fu == null) {
			//			System.out.println("Funcionaria n�o encontrada!");
			//		} else {
			//			System.out.println(fu);}
						
						
						// Realiza a inser��o aqui
				//	Cliente f = new Cliente("gabriel","rua palmeiras","33302233", 0);
				//	cliente.inserir(f);
				//	System.out.println(f);
						
						
						// Realiza a deleta�ao porque ta dando erro? perto de "*" do deletar FuncionarioDAO ?
				//	Cliente del = new Cliente("gabriel","rua palmeiras","33302233", 7);
				//	cliente.deletar(del);
				//	System.out.println(del);
					
			
					
			//		ServicoDAO servico = new ServicoDAO();
			//		Servico se = servico.findServico("massagem");
			//		if (se == null) {
			//			System.out.println("Servi�o n�o encontrado!");
			//		} else {
			//			System.out.println(se);}
						
						
						// Realiza a inser��o aqui
		//			Servico s = new Servico("Teste", 0);
			//		servico.inserir(s);
				//	System.out.println(s);
						
						
						// Realiza a deleta�ao porque ta dando erro? perto de "*" do deletar FuncionarioDAO ?
				//	Cliente del = new Cliente("gabriel","rua palmeiras","33302233", 7);
				//	cliente.deletar(del);
				//	System.out.println(del);
					
							
					}
		
}

