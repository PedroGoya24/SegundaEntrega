package principal;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import principalDAO.ClienteDAO;
import principalDAO.ComprasDAO;
import principalDAO.DestinosDAO;
import principalDAO.PacotesDAO;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scanner = new Scanner(System.in);
		int op = 0;
		//criar objeto da classe ClieteDAO
		
		ClienteDAO clienteDAO = new ClienteDAO();
		DestinosDAO destinoDAO = new DestinosDAO();
		PacotesDAO pacotesDAO = new PacotesDAO();
		ComprasDAO compraDAO = new ComprasDAO();
		
		
		do {
			System.out.println(" ");
			System.out.println("Sistema site de viagens A Dois");
			System.out.println("[1] Menu Cliente");
			System.out.println("[2] Menu Destinos");
			System.out.println("[3] Menu Pacotes");
			System.out.println("[4] Menu Compras");
			System.out.println("[5] Sair");
			op = scanner.nextInt();
			
			switch (op) {
			
			
			case 1: {
				System.out.println("Selecione a opção");
				System.out.println("[1] Cadastrar Cliente");
				System.out.println("[2] Listar Clientes");
				System.out.println("[3] Atualizar Cliente");
				System.out.println("[4] Excluir Cliente");
				System.out.println("[5] Voltar ao Menu");
				int subOp = scanner.nextInt();
				
				
				if (subOp == 1) {
					//cadastrar cliente
					
					Cliente cliente1 = new Cliente();
					
					System.out.print("Nome do Cliente:");
					scanner.nextLine();
					cliente1.setNome(scanner.nextLine());
					
					System.out.print("Idade: ");
					cliente1.setIdade(scanner.nextInt());
					
					scanner.nextLine();
					System.out.print("Endereço: ");
					cliente1.setEndereco(scanner.nextLine());
					
					System.out.print("RG: ");
					cliente1.setRg(scanner.nextLine());
					
					System.out.print("Telefone: ");
					cliente1.setTelefone(scanner.nextLine());
					
					clienteDAO.criarCliente(cliente1);	
					System.out.println("Cliente cadastrado com sucesso!");
					break;
					
				} else if(subOp == 2){
					
					//Listar Cliente
					List<Cliente> clientes = clienteDAO.listarClientes();
					System.out.println("Lista de Clientes: ");
					for(Cliente c : clientes) {
						
						System.out.println("Id: " + c.getId() + 
								", Nome: " + c.getNome() + 
								", Idade: " + c.getIdade()	+ 
								", Endereço: " + c.getEndereco() + 
								", RG: " + c.getRg() + 
								", Telefone: " + c.getTelefone());
					}
					
					break;
				}else if(subOp == 3) {
					//Atualizar Cliente										
					System.out.print("ID do cliente para a atualização: ");
					int clienteIdAtualizar = scanner.nextInt();					
					Cliente clienteAtualizar = clienteDAO.buscarCliente(clienteIdAtualizar);
					
					if(clienteAtualizar != null) {
						scanner.nextLine();
						System.out.print("Novo Nome: ");
						clienteAtualizar.setNome(scanner.nextLine());
						System.out.print("Nova idade: ");
						clienteAtualizar.setIdade(scanner.nextInt());
						scanner.nextLine();
						System.out.print("Novo endereço: ");
						clienteAtualizar.setEndereco(scanner.nextLine());
						System.out.print("Novo RG: ");
						clienteAtualizar.setRg(scanner.nextLine());
						System.out.print("Novo telefone: ");
						clienteAtualizar.setTelefone(scanner.nextLine());
						clienteDAO.atualizarCliente(clienteAtualizar);
						System.out.println("Atualizado com sucesso");
					}else {
						System.out.println("Cliente não encontrado");
					}
					
					break;
				} else if(subOp == 4) {
					//Excluir Cliente
					
					System.out.print("ID do Cliente para exclusão: ");
					int clienteIdExcluir = scanner.nextInt();
					Cliente clienteExcluir = clienteDAO.buscarCliente(clienteIdExcluir);
					
					if(clienteExcluir != null) {
						clienteDAO.excluirCliente(clienteIdExcluir);
						System.out.println("Cliente excluído com sucesso!");
					}else {
						System.out.println("Cliente não encontrado.");
					}					
					break;
				}else if(subOp == 5) {
					break;
				}
				else {
					System.out.println("Opção inválida");
					break;
				}
				
				
			}
			
			case 2: {
				System.out.println("Selecione a opção");
				System.out.println("[1] Cadastrar Destino");
				System.out.println("[2] Listar Destinos");
				System.out.println("[3] Atualizar Destino");
				System.out.println("[4] Excluir Destino");
				System.out.println("[5] Voltar ao Menu");
				int subOp = scanner.nextInt();
				
				if(subOp == 1) {
					//Cadastrar destinos
					Destinos destino = new Destinos();
					System.out.print("Nome do destino: ");
					scanner.nextLine();
					destino.setNomeDest(scanner.nextLine());
					destinoDAO.criarDestino(destino);
					
					break;
					
				}else if(subOp == 2) {
					//Listar destinos
					List<Destinos> destinos = destinoDAO.listarDestinos();
					System.out.println("Lista de Destinos: ");					
					for (Destinos d : destinos) {
						System.out.println("ID: " + d.getId() + 
								",  Nome: " + d.getNomeDest());
					}
					break;
					
				}else if(subOp == 3) {
					//Atualizar destinos
					
					System.out.print("ID do destino a ser modificado: ");
					int DestinoIdAtu = scanner.nextInt();
					Destinos DestinoAtu = destinoDAO.buscarDestinos(DestinoIdAtu);
					
					if(DestinoAtu != null) {
						System.out.print("Novo nome do Destino: ");
						scanner.nextLine();
						DestinoAtu.setNomeDest(scanner.nextLine());
						destinoDAO.atualizarDestinos(DestinoAtu);
						System.out.println("Destino atualizado com sucesso!!!");
						
					}else {
						System.out.println("Destino não encontrado!!!");
					}
					break;
				}else if(subOp == 4) {
					//Excluir Destinos
					
					System.out.print("Id do destino pra exclusão: ");
					int destinoIdExcluir =  scanner.nextInt();
					Destinos destinoExcluir = destinoDAO.buscarDestinos(destinoIdExcluir);
					
					if(destinoExcluir != null) {
						destinoDAO.excluirDestinos(destinoIdExcluir);
						
					}else {
						System.out.println("Destino não encontrado.");
					}
					break;
				}else if(subOp == 5) {
					break;
				}else {
					System.out.println("Opção inválida");
					break;
				}	
			}
						
			case 3:{
				System.out.println("Selecione a opção");
				System.out.println("[1] Cadastrar Pacote");
				System.out.println("[2] Listar Pacotes");
				System.out.println("[3] Listar Promoções");
				System.out.println("[4] Atualizar Pacote");
				System.out.println("[5] Excluir Pacote");
				System.out.println("[6] Voltar ao Menu");
				int subOp = scanner.nextInt();
				if (subOp == 1) {
					
					//Cadastrar Pacote
					Pacotes pacote = new Pacotes();
										
					int opT = 0;
					do {
						System.out.println("Selecione o tipo de pacote");
						System.out.println("[1] Básico");
						System.out.println("[2] Padrão");
						System.out.println("[3] Master");
						opT = scanner.nextInt();
						if (opT == 1) {
							pacote.setTipoPac("basico");
							System.out.println("Básico");
						}else if(opT == 2) {
							pacote.setTipoPac("padrao");
							System.out.println("Padrão");
						}else if(opT == 3) {
							pacote.setTipoPac("master");
							System.out.println("Master");
						}else {
							System.out.println("Opção inválida.");
						}
					} while (opT <= 0 || opT > 3);
					
					System.out.println("Digite o preço do pacote: ");
					scanner.nextLine();
					pacote.setPrecoPac(scanner.nextDouble());	
					
					System.out.println("ID do destino: ");
					int destinoId = scanner.nextInt();
					Destinos destinoConsulta = destinoDAO.buscarDestinos(destinoId);
					
					if (destinoConsulta != null) {
						pacote.setDestinos(destinoConsulta);
					}
					pacotesDAO.criarPacote(pacote);
					break;
					
				}else if(subOp == 2) {
					//Listar Pacotes
					
					List<Pacotes> listPacotes = pacotesDAO.listarPacotes();
					System.out.println("Lista de Pacotes: ");
					
					
					for(Pacotes p : listPacotes) {
						System.out.println("ID: " + p.getId() + 
								",\nTipo Pacote: " + p.getTipoPac() +
								",\nPreço Pacote: R$" + p.getPrecoPac() + 
								",\nID Destino: " + p.getDestinos().getId() + 
								",\nNome Destino: " + p.getDestinos().getNomeDest()+ 
								"\n=====================");												
					}
					break;
				
					
					
					
				}else if(subOp == 3) {
					//Listar Promoções
					
					List<Pacotes> listPromos = pacotesDAO.listarPromos();
					System.out.println("Lista de Promoções: ");
					
					for(Pacotes p : listPromos) {
						System.out.println("ID: " + p.getId() + 
								",\nTipo Pacote: " + p.getTipoPac() +
								",\nPreço Pacote: R$" + p.getPrecoPac() + 
								",\nID Destino: " + p.getDestinos().getId() + 
								",\nNome Destino: " + p.getDestinos().getNomeDest()+ 
								"\n=====================");
					}
					break;
				}else if(subOp == 4) {				
					//Atualizar Pacote															
					
					System.out.print("ID do Pacote para atualização: ");
					int pacoteId = scanner.nextInt();
					
					Pacotes pacoteIdAtualizar = pacotesDAO.buscarPacote(pacoteId);
					
					if(pacoteIdAtualizar != null) {
						
						int opT = 0;
						do {
							System.out.println("Selecione o tipo de pacote");
							System.out.println("[1] Básico");
							System.out.println("[2] Padrão");
							System.out.println("[3] Master");
							opT = scanner.nextInt();
							if (opT == 1) {
								pacoteIdAtualizar.setTipoPac("basico");
								
								System.out.println("Básico");
							}else if(opT == 2) {
								pacoteIdAtualizar.setTipoPac("padrao");
								System.out.println("Padrão");
							}else if(opT == 3) {
								pacoteIdAtualizar.setTipoPac("master");
								System.out.println("Master");
							}else {
								System.out.println("Opção inválida.");
							}
						} while (opT <= 0 || opT > 3);
						
						
						int opP = 0;
						do {
							System.out.println("O pacote está em promoção: ");
							System.out.println("[1] Sim");
							System.out.println("[2] Não");
							opP = scanner.nextInt();
							
							if(opP == 1) {
								pacoteIdAtualizar.setPromocao(true);
							}else if(opP == 2) {
								pacoteIdAtualizar.setPromocao(false);
							}else {
								System.out.println("Opção inválida!!!");
							}
							
						} while (opP <= 0 || opP >2);
						
						
						System.out.print("Novo preço do pacote:");
						scanner.nextLine(); // Limpar o buffer do teclado
						pacoteIdAtualizar.setPrecoPac(scanner.nextDouble());												
												
						
						pacotesDAO.atualizarPacote(pacoteIdAtualizar);
					}
					break;
				}else if(subOp == 5) {
					//Excluir Pacote
					System.out.print("ID do Pacote para realizar a exclusão: ");
					int pacoteIdExcluir = scanner.nextInt();
					
					Pacotes pacoteExcluir = pacotesDAO.buscarPacote(pacoteIdExcluir);
					if(pacoteExcluir != null) {
						pacotesDAO.excluirPacote(pacoteIdExcluir);
					}else {
						System.out.println("Pacote não encontrado!!!");
					}
					break;					
				}else if(subOp == 6) {
					break;
				}else {
					System.out.println("Opção inválida");
					break;
				}				
				
			}
			
			case 4:{
				System.out.println("Selecione a opção");
				System.out.println("[1] Cadastrar compra");
				System.out.println("[2] Listar compras");
				System.out.println("[3] Atualizar compra");
				System.out.println("[4] Excluir compra");
				System.out.println("[5] Voltar ao Menu");
				int subOp = scanner.nextInt();
				
				if (subOp == 1) {
					//Cadastrar compra
					Compras compra = new Compras();
					System.out.print("Digite o ID do cliente: ");
					scanner.nextLine(); // Limpar o buffer
					
					int clienteId = scanner.nextInt();
					Cliente clienteConsulta = clienteDAO.buscarCliente(clienteId);
					if(clienteConsulta != null) {
						compra.setIdCli(clienteConsulta);
						System.out.println("ID do Pacote: ");
						scanner.nextLine(); //Limpar o buffer
						
						int pacoteId = scanner.nextInt();
						Pacotes pacoteConsulta = pacotesDAO.buscarPacote(pacoteId);
						//
						if(pacoteConsulta != null) {
							compra.setIdPac(pacoteConsulta);
							
							System.out.print("Data de ida (dd/mm/yyyy): ");
							String dataIdaString = scanner.next();
							try {
								SimpleDateFormat dtIda = new SimpleDateFormat("dd/MM/yyyy");
								Date dataIda = dtIda.parse(dataIdaString);
								compra.setDataIda(dataIda);								
																
								int opData = 0;
								
								do {
									System.out.println("Possui data de volta?");
									System.out.println("[1] Sim");
									System.out.println("[2] Não");								
									opData = scanner.nextInt();
									
									if (opData == 1) {									
										System.out.print("Data de volta (dd/mm/yyyy): ");
										String dataVoltaString = scanner.next();
										
										try {
											SimpleDateFormat dtVolta = new SimpleDateFormat("dd/MM/yyyy");
											Date dataVolta = dtVolta.parse(dataVoltaString);
											compra.setDataVolta(dataVolta);
											compraDAO.criarCompra(compra);
											
										}catch(ParseException e) {
											System.out.println("Formato de data inválido. Use dd/mm/yyyy");
										}
										
										
									}else if(opData == 2) {
										
										String dataVoltaString = "00/00/0000";
										
										try {
											SimpleDateFormat dtVolta = new SimpleDateFormat("dd/MM/yyyy");
											Date dataVolta = dtVolta.parse(dataVoltaString);
											compra.setDataVolta(dataVolta);
											compraDAO.criarCompra(compra);
											
										}catch(ParseException e) {
											System.out.println("Formato de data inválido. Use dd/mm/yyyy");
										}																				
										
										
									}else {
										System.out.println("Opção inválida.");
									}
								} while (opData <= 0 || opData > 2);																																						
								
							}catch(ParseException e) {
								System.out.println("Formato de data inválido. Use dd/mm/yyyy");
							}
							
							
							
							
						}else {
							System.out.println("Id do Pacote não encontrado!!!");
						}
						
					}else {
						System.out.println("Id do Cliente não encontrado!!!");
					}
					break;
				}else if(subOp == 2) {
					//Listar Compras
										
					List<Compras> compras = compraDAO.listarCompras();
					System.out.println("Lista de Compras realizadas: ");
					for(Compras c : compras) {
						System.out.println("ID da Compra: " + c.getId() + 
								"\nID Cliente: " + c.getIdCli().getId() + 
								"\nNome Cliente: " + c.getIdCli().getNome() + 								
								"\nID Pacote: " + c.getIdPac().getId() + 
								"\nData Ida: " + c.getDataIda());
						if(c.getDataVolta().toString() == "0002-111-30") {
								System.out.print("\nNão possui data de Volta.");
						}else {
							System.out.print("Data de Volta: " + c.getDataVolta());
						}
						System.out.println("\n==================================");
					}
					break;
					
				}else if(subOp == 3) {
					//Atualizar compra
					
					System.out.print("ID da compra para atualizar: ");
					int compraId = scanner.nextInt();
					Compras compraIdAtualizar = compraDAO.buscarCompra(compraId);
					if(compraIdAtualizar != null) {
						
						System.out.print("ID do novo Pacote (caso seja o mesmo pacote, digite o mesmo id): ");
						scanner.nextLine(); //Limpar o buffer						
						int pacoteId = scanner.nextInt();
						Pacotes pacoteConsulta = pacotesDAO.buscarPacote(pacoteId);
						
						if(pacoteConsulta != null) {
						
							compraIdAtualizar.setIdPac(pacoteConsulta);
							
							System.out.print("Nova data de ida (dd/mm/yyyy): ");
							String dataIdaString = scanner.next();
							try {
								SimpleDateFormat dtIda = new SimpleDateFormat("dd/MM/yyyy");
								Date dataIda = dtIda.parse(dataIdaString);
								compraIdAtualizar.setDataIda(dataIda);								
																
								int opData = 0;
								
								do {
									System.out.println("Possui data de volta?");
									System.out.println("[1] Sim");
									System.out.println("[2] Não");								
									opData = scanner.nextInt();
									
									if (opData == 1) {									
										System.out.print("Data de volta (dd/mm/yyyy): ");
										String dataVoltaString = scanner.next();
										
										try {
											SimpleDateFormat dtVolta = new SimpleDateFormat("dd/MM/yyyy");
											Date dataVolta = dtVolta.parse(dataVoltaString);
											compraIdAtualizar.setDataVolta(dataVolta);
											compraDAO.atualizarCompra(compraIdAtualizar);
											
										}catch(ParseException e) {
											System.out.println("Formato de data inválido. Use dd/mm/yyyy");
										}
										
										
									}else if(opData == 2) {
										
										String dataVoltaString = "00/00/0000";
										
										try {
											SimpleDateFormat dtVolta = new SimpleDateFormat("dd/MM/yyyy");
											Date dataVolta = dtVolta.parse(dataVoltaString);
											compraIdAtualizar.setDataVolta(dataVolta);
											compraDAO.atualizarCompra(compraIdAtualizar);
											
										}catch(ParseException e) {
											System.out.println("Formato de data inválido. Use dd/mm/yyyy");
										}																				
										
										
									}else {
										System.out.println("Opção inválida.");
									}
								} while (opData <= 0 || opData > 2);																																						
								
							}catch(ParseException e) {
								System.out.println("Formato de data inválido. Use dd/mm/yyyy");
							}

							
						}else {
							System.out.println("Id do Pacote não encontrado!!!");
						}
					}else {
						System.out.println("Compra não encotrada!!!");
					}
					
					break;
					
				}else if(subOp == 4) {
					//Excluir compra
					
					System.out.print("ID da Compra pra exclusão: ");
					int compraIdExcluir = scanner.nextInt();
					Compras compraExcluir = compraDAO.buscarCompra(compraIdExcluir);
					if(compraExcluir != null) {
						compraDAO.excluirConsulta(compraIdExcluir);
						System.out.println("Compra excluida com sucesso!!!");
					}else {
						System.out.println("Compra não encontrada.");
					}					
					break;
					
				}else if(subOp == 5) {
					break;
				}else {
					System.out.println("Opção inválida");
					break;
				}
								
			}
			
			case 5: {
				int sair;
				System.out.println("Você tem certeza que deseja sair? 1 para Sim / 2 para Não");
				sair = scanner.nextInt();				
				
				if(sair == 1) {
					System.out.println("Obrigado por usar nosso sitema :)");
					op = 6;
				}else if(sair == 2) {
					break;
				}else {
					System.out.println("Opção inválida!!!");
				}
				
				
			break;	
			}
			default:
				System.out.println("Opção inválida!!!!");
				break;
			}
			
			
		} while (op != 6);
		scanner.close();
		
	}

}
