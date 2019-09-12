package br.unifil.controler;

import java.io.IOException;
import java.util.Scanner;

import br.unifil.model.Agenda;
import br.unifil.model.Contato;
import br.unifil.util.Files;

public class ExecutarAgenda {

	public ExecutarAgenda() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		Files reader = new Files();
		Agenda agenda = reader.readfile();
		
		boolean flag = true;
		while(flag) {
			Scanner myObj = new Scanner(System.in);
		    System.out.println("\nEntre com a opçao desejada:\n" + 
		    		"1 - Adicionar contato\n" + 
		    		"2 - Remover contato\n" + 
		    		"3 - Verificar se o contato ja esta na agenda\n" + 
		    		"4 - Listar Agenda \n" + 
		    		"5 - Buscar contato por nome\n" +
		    		"6 - Para finalizar a aplicação.\n" +
		    		"Ex. entrada 1,ContatoNome,Numero \n" 
		    		);
		    String userName = myObj.nextLine(); 
		    String[] arr =  userName.split(",");
		    switch (Integer.parseInt(arr[0])) 
			{
				case 1: //  Adicionar contato
					agenda.adicionarContato(new Contato(arr[1],arr[2]));
					reader.savefile(agenda);
					break;
				case 2: // Remover contato
					agenda.removerContato(new Contato(arr[1],arr[2]));
					reader.savefile(agenda);
					break;
				case 3: // Verificar se o contato ja esta na agenda
					if(agenda.existeContato(new Contato(arr[1],arr[2]))) {
						System.out.println("Contato na agenda!");
					}else {
						System.out.println("Contato ainda nao foi adicionado.");
					}
					break;
				case 4: //Listar Agenda
					agenda.listarContatos();
					break;
				case 5: //Buscar contato por nome
					agenda.buscarContato(arr[1]);
					break;
				case 6:
					myObj.close();
					flag = false;
					break;
				default:
					System.out.println("Comando invalido");
					break;
			}
		} 
		

	}

}
