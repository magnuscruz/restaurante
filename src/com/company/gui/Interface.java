package com.company.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Interface extends JFrame {
    private static final String RESTAURANTE_CARD = "RESTAURANTE";
    private static final String CLIENTE_CARD = "CLIENTE";
    private static final String LOGIN_CARD = "LOGIN";
    private static final String MENUCLIENTE_CARD = "MENU CLIENTE";
    private static final String MENURESTAURANTE_CARD = "MENU RESTAURANTE";

//	private List<Utilizador> listaUtilizadores = new ArrayList<>();
//	private List<Comentario> listaComentarios = new ArrayList<>();
//
//	private Utilizador utilizarAtivo;
//	private Utilizador utilizador;

    public Interface() {
        ImageIcon logo = new ImageIcon("logo3.png");
        this.setIconImage(logo.getImage());
        this.setTitle("RESERVAS DE RESTAURANTES");
        this.setSize(400, 180);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contentor = this.getContentPane();
        contentor.setLayout(new CardLayout());

        /////// SUPERPAINEIS////////
        JPanel loginSuperPanel = new JPanel();
        loginSuperPanel.setLayout(new BorderLayout());
        JPanel registarNovoClienteSuperPanel = new JPanel();
        registarNovoClienteSuperPanel.setLayout(new BorderLayout());
        JPanel registarNovoRestauranteSuperPanel = new JPanel();
        registarNovoRestauranteSuperPanel.setLayout(new BorderLayout());
        JPanel menuClienteSuperPanel = new JPanel();
        menuClienteSuperPanel.setLayout(new BorderLayout());
        JPanel menuRestauranteSuperPanel = new JPanel();
        menuRestauranteSuperPanel.setLayout(new BorderLayout());

        construirPanelLogin(this, contentor, loginSuperPanel);

        construirPanelCliente(this, contentor, loginSuperPanel, registarNovoClienteSuperPanel);

        construirPanelRestaurante(this, contentor, loginSuperPanel, registarNovoRestauranteSuperPanel);

        construirPanelMenuCliente(this, contentor, loginSuperPanel, menuClienteSuperPanel);

        construirPanelMenuCliente(this, contentor, loginSuperPanel, menuRestauranteSuperPanel);


        contentor.add(loginSuperPanel, LOGIN_CARD);
        contentor.add(registarNovoClienteSuperPanel, CLIENTE_CARD);
        contentor.add(registarNovoRestauranteSuperPanel, RESTAURANTE_CARD);
        contentor.add(menuClienteSuperPanel, MENUCLIENTE_CARD);
        contentor.add(menuRestauranteSuperPanel, MENURESTAURANTE_CARD);

        this.setVisible(true);

    }

    private void construirPanelLogin(Interface janela, Container contentor, JPanel loginSuperPanel) {
        ////Criação dos subpaineis norte, centro e sul
        JPanel norteLoginSubPanel = new JPanel();
        JPanel centroLoginSubPanel = new JPanel();
        JPanel sulLoginSubPanel = new JPanel();

        JButton ptEnLoginButton = new JButton("PT/EN");
        ptEnLoginButton.setSize(15, 5);
        JButton loginButton = new JButton(LOGIN_CARD);
        loginButton.setSize(15, 5);
        JButton clienteNovoButton = new JLinkButton("Novo Cliente");
        JButton restauranteNovoButton = new JLinkButton("Novo Restaurante");

        JLabel titleLoginLabel = new JLabel("LOGIN");
        JLabel usernameLoginLabel = new JLabel("Username:");
        JLabel passwordLoginLabel = new JLabel("Password:");

        JTextField usernameLoginText = new JTextField(20);

        JPasswordField passwordLoginField = new JPasswordField(20);

///Layout dos subPaineis north, centro e south
        norteLoginSubPanel.setLayout(new BorderLayout());
        centroLoginSubPanel.setLayout(new BorderLayout());
        sulLoginSubPanel.setLayout(new BorderLayout());

//Adicionar subPaineis no superpainel Login
        loginSuperPanel.add(norteLoginSubPanel, BorderLayout.NORTH);
        loginSuperPanel.add(centroLoginSubPanel, BorderLayout.CENTER);
        loginSuperPanel.add(sulLoginSubPanel, BorderLayout.SOUTH);

/// Criação dos subpaineis nos subpaineis norte, centro e sul
        JPanel norteLoginSSPanelTitle = new JPanel();
        JPanel centroLoginSSPanelForm = new JPanel();
        JPanel centroLoginSSPanelButton = new JPanel();
        JPanel sulLoginSSPanelLinks = new JPanel();

//Layout dos subpaineis dos subpaineis norte, centro e sul
        norteLoginSubPanel.add(norteLoginSSPanelTitle, BorderLayout.CENTER);
        norteLoginSubPanel.add(ptEnLoginButton, BorderLayout.EAST);
        norteLoginSSPanelTitle.setLayout(new FlowLayout());
        norteLoginSSPanelTitle.add(titleLoginLabel);

        centroLoginSubPanel.add(centroLoginSSPanelForm, BorderLayout.NORTH);
        centroLoginSSPanelForm.setLayout(new GridLayout(2, 2));
        centroLoginSSPanelForm.add(usernameLoginLabel);
        centroLoginSSPanelForm.add(usernameLoginText);
        centroLoginSSPanelForm.add(passwordLoginLabel);
        centroLoginSSPanelForm.add(passwordLoginField);
        centroLoginSubPanel.add(centroLoginSSPanelButton, BorderLayout.SOUTH);
        centroLoginSSPanelButton.setLayout(new FlowLayout());
        centroLoginSSPanelButton.add(loginButton);

        sulLoginSubPanel.add(sulLoginSSPanelLinks);
        sulLoginSSPanelLinks.setLayout(new BorderLayout());
        sulLoginSSPanelLinks.add(clienteNovoButton, BorderLayout.EAST);
        sulLoginSSPanelLinks.add(restauranteNovoButton, BorderLayout.WEST);



        clienteNovoButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, CLIENTE_CARD);
            janela.setSize(500, 300);
            // passar por parâmetro no construtor (fica como referência pq qdo precisarmos
            // no actionlistener)
        });

        restauranteNovoButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, RESTAURANTE_CARD);
            janela.setSize(500, 300);
            // passar por parâmetro no construtor (fica como referência pq qdo precisarmos
            // no actionlistener)
        });
    }

    ////////////////////NOVO CLIENTE/////////////////////////
    private void construirPanelCliente(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel registarNovoClienteSuperpanel) {


        /////SUBPAINEIS//////
        JPanel norteNovoClienteSubPanel = new JPanel();
        norteNovoClienteSubPanel.setLayout(new BorderLayout());
        JPanel centroNovoClienteSubPanel = new JPanel();
        JPanel sulNovoClienteSubPanel = new JPanel();

        JLabel registarNovoClienteLabel = new JLabel("NOVO CLIENTE");
        JLabel nomeClienteLabel = new JLabel("Nome");
        JLabel emailClienteLabel = new JLabel("E-mail");
        JLabel moradaClienteLabel = new JLabel("Morada");
        JLabel telemovelClienteLabel = new JLabel("Telemóvel");
        JLabel usernameClienteLabel = new JLabel("Username");
        JLabel passwordClienteLabel = new JLabel("Password: ");
        JLabel confirmarPasswordClienteLabel = new JLabel("Confirmar password: ");

        JTextField nomeClienteText = new JTextField(20);
        JTextField emailClienteText = new JTextField(20);
        JTextField moradaClienteText = new JTextField(20);
        JTextField telemovelClienteText = new JTextField(20);
        JTextField usernameClienteText = new JTextField(20);

        JPasswordField passwordClienteField = new JPasswordField(20);
        JPasswordField confirmarPassawordClienteField = new JPasswordField(20);

        JButton ptEnNovoClienteButton = new JButton("PT/EN");
        JButton cancelarClienteButton = new JButton("CANCELAR");
        JButton registarClienteButton = new JButton("REGISTAR");

        registarNovoClienteSuperpanel.add(norteNovoClienteSubPanel, "North");
        registarNovoClienteSuperpanel.add(centroNovoClienteSubPanel, "Center");
        registarNovoClienteSuperpanel.add(sulNovoClienteSubPanel, "South");

        JPanel norteClienteSubPanel = new JPanel();
        norteClienteSubPanel.setLayout(new FlowLayout());
        norteClienteSubPanel.add(registarNovoClienteLabel);
        norteNovoClienteSubPanel.add(norteClienteSubPanel, BorderLayout.CENTER);
        norteNovoClienteSubPanel.add(ptEnNovoClienteButton, BorderLayout.EAST);

        JPanel centroNovoClienteSSPanelForm = new JPanel();
        centroNovoClienteSSPanelForm.setLayout(new GridLayout(7, 2));
        centroNovoClienteSubPanel.add(centroNovoClienteSSPanelForm);
        centroNovoClienteSSPanelForm.add(nomeClienteLabel);
        centroNovoClienteSSPanelForm.add(nomeClienteText);
        centroNovoClienteSSPanelForm.add(emailClienteLabel);
        centroNovoClienteSSPanelForm.add(emailClienteText);
        centroNovoClienteSSPanelForm.add(moradaClienteLabel);
        centroNovoClienteSSPanelForm.add(moradaClienteText);
        centroNovoClienteSSPanelForm.add(telemovelClienteLabel);
        centroNovoClienteSSPanelForm.add(telemovelClienteText);
        centroNovoClienteSSPanelForm.add(usernameClienteLabel);
        centroNovoClienteSSPanelForm.add(usernameClienteText);
        centroNovoClienteSSPanelForm.add(passwordClienteLabel);
        centroNovoClienteSSPanelForm.add(passwordClienteField);
        centroNovoClienteSSPanelForm.add(confirmarPasswordClienteLabel);
        centroNovoClienteSSPanelForm.add(confirmarPassawordClienteField);

        sulNovoClienteSubPanel.setLayout(new FlowLayout());
        sulNovoClienteSubPanel.add(cancelarClienteButton);
        sulNovoClienteSubPanel.add(registarClienteButton);


        registarClienteButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENUCLIENTE_CARD);
            this.setSize(500, 300);

        });

        cancelarClienteButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, LOGIN_CARD);
            this.setSize(500, 180);

        });
    }


    //	public void utilizadorExiste(String username) {
//		boolean a = true;
//		for (int i = 0; i < listaUtilizadores.size(); i++) {
//			if (username.equalsIgnoreCase(listaUtilizadores.get(i).getUsername())) {
//				String nomeClasse = listaUtilizadores.get(i).getClass().getSimpleName();//// Imprime o nome da Classe.
//																						//// Tem é de se associar a uma
//				System.out.println("Utilizador com o username: " + listaUtilizadores.get(i).getUsername()
//						+ " é do tipo: " + nomeClasse);
//				a = false;
//			}
//		}
//		if (a) {
//			System.out.println("Nao existe");
//		}
//	}
    ////// MENU CLIENTE//////////
    private void construirPanelMenuCliente(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel menuClienteSuperPanel) {

        /////SUBPAINEIS//////
        JPanel norteMenuClienteSubPanel = new JPanel();
        norteMenuClienteSubPanel.setLayout(new BorderLayout());
        JPanel centroMenuClienteSubPanel = new JPanel();
        JPanel sulMenuClienteSubPanel = new JPanel();

        JLabel registarNovoClienteLabel = new JLabel("MENU CLIENTE");

        JButton ptEnMenuClienteButton = new JButton("PT/EN");
        ////
        JButton adicionarPrato = new JButton("ADICIONAR PRATO");
        JButton atualizarPratoDia = new JButton("ATUALIZAR PRATO DO DIA");
        JButton atualizarDados = new JButton("ATUALIZAR DADOS");
        JButton reservas = new JButton("RESERVAS");
        JButton consultarComentarios = new JButton("CONSULTAR COMENTÁRIOS");
        JButton responderComentarios = new JButton("RESPONDER COMENTÁRIOS");
        JButton pontuacaoMedia = new JButton("PONTUAÇÃO MÉDIA");


        ///
        //JButton cancelarMenuClienteButton = new JButton("CANCELAR");
        JButton sairMenuClienteButton = new JButton("SAIR");

        menuClienteSuperPanel.add(norteMenuClienteSubPanel, "North");
        menuClienteSuperPanel.add(centroMenuClienteSubPanel, "Center");
        menuClienteSuperPanel.add(sulMenuClienteSubPanel, "South");

        JPanel norteClienteSubPanel = new JPanel();
        norteClienteSubPanel.setLayout(new FlowLayout());
        norteClienteSubPanel.add(registarNovoClienteLabel);
        norteMenuClienteSubPanel.add(norteClienteSubPanel, BorderLayout.CENTER);
        norteMenuClienteSubPanel.add(ptEnMenuClienteButton, BorderLayout.EAST);

        JPanel centroNovoClienteSSPanelForm = new JPanel();
        centroNovoClienteSSPanelForm.setLayout(new GridLayout(7, 1));
        centroMenuClienteSubPanel.add(centroNovoClienteSSPanelForm);
        centroNovoClienteSSPanelForm.add(adicionarPrato);
        centroNovoClienteSSPanelForm.add(atualizarPratoDia);
        centroNovoClienteSSPanelForm.add(atualizarDados);
        centroNovoClienteSSPanelForm.add(reservas);
        centroNovoClienteSSPanelForm.add(consultarComentarios);
        centroNovoClienteSSPanelForm.add(responderComentarios);
        centroNovoClienteSSPanelForm.add(pontuacaoMedia);

        sulMenuClienteSubPanel.setLayout(new FlowLayout());
        //sulMenuClienteSubPanel.add(cancelarMenuClienteButton);
        sulMenuClienteSubPanel.add(sairMenuClienteButton);

//        cancelarMenuClienteButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, CLIENTE_CARD);
//            this.setSize(500, 300);
//
//        });

        sairMenuClienteButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENUCLIENTE_CARD);
            this.setSize(500, 300);

        });

    }


    ////////////////////NOVO RESTAURANTE/////////////////////////
    private void construirPanelRestaurante(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel registarNovoRestauranteSuperpanel) {


        /////SUBPAINEIS//////
        JPanel norteNovoRestauranteSubPanel = new JPanel();
        norteNovoRestauranteSubPanel.setLayout(new BorderLayout());
        JPanel centroNovoRestauranteSubPanel = new JPanel();
        JPanel sulNovoRestauranteSubPanel = new JPanel();

        JLabel registarNovoRestauranteLabel = new JLabel("NOVO RESTAURANTE");
        JLabel nomeRestauranteLabel = new JLabel("Nome");
        JLabel emailRestauranteLabel = new JLabel("E-mail");
        JLabel moradaRestauranteLabel = new JLabel("Morada");
        JLabel telemovelRestauranteLabel = new JLabel("Telemóvel");
///////////////////////
        JLabel lotacaoRestauranteLabel = new JLabel("Lotação");
        JLabel esplanadaRestauranteLabel = new JLabel("Esplanada");
        JLabel zonaInteriorNFumRestauranteLabel = new JLabel("Zona Interior Não Fumadores");
        JLabel zonaInteriorFumRestauranteLabel = new JLabel("Zona Interior Fumadores");
        JLabel horarioAlmocoInicioRestauranteLabel = new JLabel("Horário Almoço Início");
        JLabel horarioAlmocoFimRestauranteLabel = new JLabel("Horário Almoço Fim");
        JLabel horarioJantarInicioRestauranteLabel = new JLabel("Horário Jantar Início");
        JLabel horarioJantarFimRestauranteLabel = new JLabel("Horário Jantar Fim");
//////////////////////////////////


        JLabel usernameRestauranteLabel = new JLabel("Username");
        JLabel passwordRestauranteLabel = new JLabel("Password: ");
        JLabel confirmarPasswordRestauranteLabel = new JLabel("Confirmar password: ");

        JTextField nomeRestauranteText = new JTextField(20);
        JTextField emailRestauranteText = new JTextField(20);
        JTextField moradaRestauranteText = new JTextField(20);
        JTextField telemovelRestauranteText = new JTextField(8);
        ////////
        JTextField lotacaoRestauranteText = new JTextField(5);
        JTextField esplanadaRestauranteText = new JTextField(5);
        JTextField zonaInteriorNFumRestauranteText = new JTextField(5);
        JTextField zonaInteriorFumRestauranteText = new JTextField(5);
        JTextField horarioAlmocoInicioRestauranteText = new JTextField(5);
        JTextField horarioAlmocoFimRestauranteText = new JTextField(5);
        JTextField horarioJantarInicioRestauranteText = new JTextField(5);
        JTextField horarioJantarFimRestauranteText = new JTextField(5);
        ///////
        JTextField usernameRestauranteText = new JTextField(20);

        JPasswordField passwordRestauranteField = new JPasswordField(20);
        JPasswordField confirmarPasswordRestauranteField = new JPasswordField(20);

        JButton ptEnNovoRestauranteButton = new JButton("PT/EN");
        JButton cancelarRestauranteButton = new JButton("CANCELAR");
        JButton registarRestauranteButton = new JButton("REGISTAR");

        registarNovoRestauranteSuperpanel.add(norteNovoRestauranteSubPanel, "North");
        registarNovoRestauranteSuperpanel.add(centroNovoRestauranteSubPanel, "Center");
        registarNovoRestauranteSuperpanel.add(sulNovoRestauranteSubPanel, "South");

        JPanel norteRestauranteSubPanel = new JPanel();
        norteRestauranteSubPanel.setLayout(new FlowLayout());
        norteRestauranteSubPanel.add(registarNovoRestauranteLabel);
        norteNovoRestauranteSubPanel.add(norteRestauranteSubPanel, BorderLayout.CENTER);
        norteNovoRestauranteSubPanel.add(ptEnNovoRestauranteButton, BorderLayout.EAST);

        JPanel centroNovoRestauranteSSPanelForm = new JPanel();
        centroNovoRestauranteSSPanelForm.setLayout(new GridLayout(12, 2));
        centroNovoRestauranteSubPanel.add(centroNovoRestauranteSSPanelForm);
        centroNovoRestauranteSSPanelForm.add(nomeRestauranteLabel);
        centroNovoRestauranteSSPanelForm.add(nomeRestauranteText);
        centroNovoRestauranteSSPanelForm.add(emailRestauranteLabel);
        centroNovoRestauranteSSPanelForm.add(emailRestauranteText);
        centroNovoRestauranteSSPanelForm.add(moradaRestauranteLabel);
        centroNovoRestauranteSSPanelForm.add(moradaRestauranteText);
        centroNovoRestauranteSSPanelForm.add(telemovelRestauranteLabel);
        centroNovoRestauranteSSPanelForm.add(telemovelRestauranteText);
        /////
        centroNovoRestauranteSSPanelForm.add(lotacaoRestauranteLabel);
        centroNovoRestauranteSSPanelForm.add(lotacaoRestauranteText);
        centroNovoRestauranteSSPanelForm.add(esplanadaRestauranteLabel);
        centroNovoRestauranteSSPanelForm.add(esplanadaRestauranteText);
        centroNovoRestauranteSSPanelForm.add(zonaInteriorNFumRestauranteLabel);
        centroNovoRestauranteSSPanelForm.add(zonaInteriorNFumRestauranteText);
        centroNovoRestauranteSSPanelForm.add(zonaInteriorFumRestauranteLabel);
        centroNovoRestauranteSSPanelForm.add(zonaInteriorFumRestauranteText);
        centroNovoRestauranteSSPanelForm.add(horarioAlmocoInicioRestauranteLabel);
        centroNovoRestauranteSSPanelForm.add(horarioAlmocoInicioRestauranteText);
        centroNovoRestauranteSSPanelForm.add(horarioAlmocoFimRestauranteLabel);
        centroNovoRestauranteSSPanelForm.add(horarioAlmocoFimRestauranteText);
        centroNovoRestauranteSSPanelForm.add(horarioJantarInicioRestauranteLabel);
        centroNovoRestauranteSSPanelForm.add(horarioJantarInicioRestauranteText);
        centroNovoRestauranteSSPanelForm.add(horarioJantarFimRestauranteLabel);
        centroNovoRestauranteSSPanelForm.add(horarioJantarFimRestauranteText);


        ////
        centroNovoRestauranteSSPanelForm.add(usernameRestauranteLabel);
        centroNovoRestauranteSSPanelForm.add(usernameRestauranteText);
        centroNovoRestauranteSSPanelForm.add(passwordRestauranteLabel);
        centroNovoRestauranteSSPanelForm.add(passwordRestauranteField);
        centroNovoRestauranteSSPanelForm.add(confirmarPasswordRestauranteLabel);
        centroNovoRestauranteSSPanelForm.add(confirmarPasswordRestauranteField);

        sulNovoRestauranteSubPanel.setLayout(new FlowLayout());
        sulNovoRestauranteSubPanel.add(cancelarRestauranteButton);
        sulNovoRestauranteSubPanel.add(registarRestauranteButton);

        registarRestauranteButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, RESTAURANTE_CARD);
            this.setSize(500, 300);
            // passar por parâmetro no construtor (fica como referência pq qdo precisarmos
            // no actionlistener)
        });
        cancelarRestauranteButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, LOGIN_CARD);
            this.setSize(500, 180);

        });
    }

    //////MENU RESTAURANTE////////
    private void construirPanelMenuCliente(Container contentor, JPanel loginSuperPanel, JPanel menuRestauranteSuperPanel) {

        /////SUBPAINEIS//////
        JPanel norteMenuRestauranteSubPanel = new JPanel();
        norteMenuRestauranteSubPanel.setLayout(new BorderLayout());
        JPanel centroMenuRestauranteSubPanel = new JPanel();
        JPanel sulMenuRestauranteSubPanel = new JPanel();

        JLabel registarNovoRestauranteLabel = new JLabel("MENU RESTAURANTE");

        JButton ptEnMenuRestauranteButton = new JButton("PT/EN");
        ////
        JButton adicionarPrato = new JButton("ADICIONAR PRATO");
        JButton atualizarPratoDia = new JButton("ATUALIZAR PRATO DO DIA");
        JButton atualizarDados = new JButton("ATUALIZAR DADOS");
        JButton reservas = new JButton("RESERVAS");
        JButton consultarComentarios = new JButton("CONSULTAR COMENTÁRIOS");
        JButton responderComentarios = new JButton("RESPONDER COMENTÁRIOS");
        JButton pontuacaoMedia = new JButton("PONTUAÇÃO MÉDIA");


        ///
        //JButton cancelarMenuRestauranteButton = new JButton("CANCELAR");
        JButton sairMenuRestauranteButton = new JButton("SAIR");

        menuRestauranteSuperPanel.add(norteMenuRestauranteSubPanel, "North");
        menuRestauranteSuperPanel.add(centroMenuRestauranteSubPanel, "Center");
        menuRestauranteSuperPanel.add(sulMenuRestauranteSubPanel, "South");

        JPanel norteRestauranteSubPanel = new JPanel();
        norteRestauranteSubPanel.setLayout(new FlowLayout());
        norteRestauranteSubPanel.add(registarNovoRestauranteLabel);
        norteMenuRestauranteSubPanel.add(norteRestauranteSubPanel, BorderLayout.CENTER);
        norteMenuRestauranteSubPanel.add(ptEnMenuRestauranteButton, BorderLayout.EAST);

        JPanel centroNovoRestauranteSSPanelForm = new JPanel();
        centroNovoRestauranteSSPanelForm.setLayout(new GridLayout(7, 1));
        centroMenuRestauranteSubPanel.add(centroNovoRestauranteSSPanelForm);
        centroNovoRestauranteSSPanelForm.add(adicionarPrato);
        centroNovoRestauranteSSPanelForm.add(atualizarPratoDia);
        centroNovoRestauranteSSPanelForm.add(atualizarDados);
        centroNovoRestauranteSSPanelForm.add(reservas);
        centroNovoRestauranteSSPanelForm.add(consultarComentarios);
        centroNovoRestauranteSSPanelForm.add(responderComentarios);
        centroNovoRestauranteSSPanelForm.add(pontuacaoMedia);

        sulMenuRestauranteSubPanel.setLayout(new FlowLayout());
        //sulMenuRestauranteSubPanel.add(cancelarMenuRestauranteButton);
        sulMenuRestauranteSubPanel.add(sairMenuRestauranteButton);

//        cancelarMenuRestauranteButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, RESTAURANTE_CARD);
//            this.setSize(500, 300);
//
//        });

        sairMenuRestauranteButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, RESTAURANTE_CARD);
            this.setSize(500, 300);

        });
    }

}

