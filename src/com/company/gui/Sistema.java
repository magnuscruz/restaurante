package com.company.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.company.Comentario;
import com.company.Utilizador;

public class Sistema extends JFrame {
	private List<Utilizador> listaUtilizadores = new ArrayList<>();
	private List<Comentario> listaComentarios = new ArrayList<>();

	private Utilizador utilizarAtivo;
	private Utilizador utilizador;

	public Sistema() {
		JFrame janela = new JFrame();	
		janela.setTitle("APP");
		janela.setSize(400, 150);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentor = janela.getContentPane();
		contentor.setLayout(new CardLayout());

		/////// SUPERPAINEIS////////
		JPanel login = new JPanel();
		login.setLayout(new BorderLayout());
		// contentor.add(login);
		JPanel registoCliente = new JPanel();
		registoCliente.setLayout(new BorderLayout());
		// contentor.add(registoCliente);
		JPanel registoRestaurante = new JPanel();
		registoRestaurante.setLayout(new BorderLayout());
		// contentor.add(registoRestaurante);

		JPanel norte = new JPanel();
		JPanel centro = new JPanel();
		JPanel sul = new JPanel();

		JButton linguaBotao = new JButton("PT - EN");
		JButton loginBotao = new JButton("LOGIN");
		loginBotao.setSize(15, 5);
		JButton clienteBotao = new JLinkButton("Novo Cliente");
		JButton restauranteBotao = new JLinkButton("Novo Restaurante");

		JLabel usernameLabel = new JLabel("Username:");
		JTextField usernameText = new JTextField(20);
		JLabel passwordLabel = new JLabel("Password:");
		JPasswordField passwordText = new JPasswordField(20);
		centro.setLayout(new BorderLayout());
		login.add(centro, BorderLayout.CENTER);
		sul.setLayout(new BorderLayout());
		login.add(sul, BorderLayout.SOUTH);


		norte.setLayout(new GridLayout());
		norte.add(linguaBotao);
		JPanel c1 = new JPanel();
		c1.setLayout(new GridLayout(3,2));
		JPanel c2 = new JPanel();
		c2.setLayout(new FlowLayout());
		JPanel s1 = new JPanel();
		s1.setLayout(new BorderLayout());
		
		centro.add(norte, BorderLayout.NORTH);
		centro.add(c1, BorderLayout.CENTER);
		centro.add(c2, BorderLayout.SOUTH);
		
		sul.add(s1);
		
		c1.add(usernameLabel);
		c1.add(usernameText);
		c1.add(passwordLabel);
		c1.add(passwordText);
		c2.add(loginBotao);
		s1.add(clienteBotao, BorderLayout.EAST);
		s1.add(restauranteBotao, BorderLayout.WEST);


		contentor.add(login);
		contentor.add(registoCliente);
		contentor.add(registoRestaurante);

		clienteBotao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentor.getLayout();
				cl.next(contentor);// passar por parâmetro no construtor (fica como referência pq qdo precisarmos
									// no actionlistener)
			}
		});

		// cl.next(c); // controlar por meio de um botão

		////////////////////REGISTO CLIENTE/////////////////////////
		JPanel norte1 = new JPanel();
		JPanel centro1 = new JPanel();
		JPanel sul1 = new JPanel();

		JButton lingua_botao1 = new JButton("PT/EN");

		JLabel registarCliente_label = new JLabel("Registar Cliente");

		JLabel nome_label = new JLabel("Nome");
		JTextField nome_text1 = new JTextField(20);
		JLabel email_label = new JLabel("E-mail");
		JTextField email_text1 = new JTextField(20);
		JLabel morada_label = new JLabel("Morada");
		JTextField morada_text1 = new JTextField(20);
		JLabel telemovel_label = new JLabel("Telemóvel");
		JTextField telemovel_text1 = new JTextField(20);
		JLabel username_label1 = new JLabel("Username");
		JTextField username_text1 = new JTextField(20);
		JLabel password_label1 = new JLabel("Password: ");
		JPasswordField passaword_text1 = new JPasswordField(20);
		JLabel confirmarPassword_label = new JLabel("Confirmar password: ");
		JPasswordField confirmarPassaword_text = new JPasswordField(20);

		JButton cancelar_botao = new JButton("CANCELAR");
		JButton registar_botao1 = new JButton("REGISTAR");

		registoCliente.add(norte1, "North");
		registoCliente.add(centro1, "Center");
		registoCliente.add(sul1, "South");

		norte1.add(registarCliente_label);
		norte1.add(linguaBotao);

		JPanel c11 = new JPanel();
		c11.setLayout(new GridLayout(7, 2));

		centro1.add(c11);

		c11.add(nome_label);
		c11.add(nome_text1);
		c11.add(email_label);
		c11.add(email_text1);
		c11.add(morada_label);
		c11.add(morada_text1);
		c11.add(telemovel_label);
		c11.add(telemovel_text1);
		c11.add(username_label1);
		c11.add(username_text1);
		c11.add(password_label1);
		c11.add(passaword_text1);
		c11.add(confirmarPassword_label);
		c11.add(confirmarPassaword_text);

		sul1.setLayout(new FlowLayout());
		sul1.add(cancelar_botao);
		sul1.add(registar_botao1);
		////// MENU CLIENTE//////////

		janela.setVisible(true);

	}

	public void utilizadorExiste(String username) {
		boolean a = true;
		for (int i = 0; i < listaUtilizadores.size(); i++) {
			if (username.equalsIgnoreCase(listaUtilizadores.get(i).getUsername())) {
				String nomeClasse = listaUtilizadores.get(i).getClass().getSimpleName();//// Imprime o nome da Classe.
																						//// Tem é de se associar a uma
																						//// variavel
				System.out.println("Utilizador com o username: " + listaUtilizadores.get(i).getUsername()
						+ " é do tipo: " + nomeClasse);
				a = false;
			}
		}
		if (a) {
			System.out.println("Nao existe");
		}
	}

}
