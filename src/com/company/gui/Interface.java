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
    private static final String RESTAURANT_CARD = "RESTAURANTE";
    private static final String CUSTOMER_CARD = "CLIENTE";
    private static final String LOGIN_CARD = "LOGIN";
    private static final String MENUCUSTOMER_CARD = "MENU CLIENTE";
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
        JPanel registerNewCustomerSuperpanel = new JPanel();
        registerNewCustomerSuperpanel.setLayout(new BorderLayout());
        JPanel registerNewRestaurantSuperpanel = new JPanel();
        registerNewRestaurantSuperpanel.setLayout(new BorderLayout());
        JPanel menuCustomer = new JPanel();
        menuCustomer.setLayout(new BorderLayout());

        construirPanelLogin(this, contentor, loginSuperPanel);

        construirPanelCustomer(this, contentor, loginSuperPanel, registerNewCustomerSuperpanel);

        construirPanelRestaurant(this, contentor, loginSuperPanel, registerNewRestaurantSuperpanel);

        construirPanelMenuCustomer(this, contentor, loginSuperPanel, menuCustomer);


        contentor.add(loginSuperPanel, LOGIN_CARD);
        contentor.add(registerNewCustomerSuperpanel, CUSTOMER_CARD);
        contentor.add(registerNewRestaurantSuperpanel, RESTAURANT_CARD);
        contentor.add(menuCustomer, MENUCUSTOMER_CARD);

        this.setVisible(true);

    }

    private void construirPanelLogin(Interface janela, Container contentor, JPanel loginSuperPanel) {
        ////Criação dos subpaineis north, center e south
        JPanel northLoginSubPanel = new JPanel();
        JPanel centerLoginSubPanel = new JPanel();
        JPanel southLoginSubPanel = new JPanel();

        JButton ptEnLoginButton = new JButton("PT/EN");
        ptEnLoginButton.setSize(15, 5);
        JButton loginButton = new JButton(LOGIN_CARD);
        loginButton.setSize(15, 5);
        JButton customerNewButton = new JLinkButton("Novo Cliente");
        JButton restaurantNewButton = new JLinkButton("Novo Restaurante");

        JLabel titleLoginLabel = new JLabel("LOGIN");
        JLabel usernameLoginLabel = new JLabel("Username:");
        JLabel passwordLoginLabel = new JLabel("Password:");

        JTextField usernameLoginText = new JTextField(20);

        JPasswordField passwordLoginField = new JPasswordField(20);

        ///Layout dos subPaineis north, center e south
        northLoginSubPanel.setLayout(new BorderLayout());
        centerLoginSubPanel.setLayout(new BorderLayout());
        southLoginSubPanel.setLayout(new BorderLayout());

        //Adicionar subPaineis no superpainel Login
        loginSuperPanel.add(northLoginSubPanel, BorderLayout.NORTH);
        loginSuperPanel.add(centerLoginSubPanel, BorderLayout.CENTER);
        loginSuperPanel.add(southLoginSubPanel, BorderLayout.SOUTH);

        /// Criação dos subpaineis nos subpaineis north, center e south
        JPanel northLoginSSPanelTitle = new JPanel();
        JPanel centerLoginSSPanelForm = new JPanel();
        JPanel centerLoginSSPanelButton = new JPanel();
        JPanel southLoginSSPanelLinks = new JPanel();

        //Layout dos subpaineis dos subpaineis north, center e south
        northLoginSubPanel.add(northLoginSSPanelTitle, BorderLayout.CENTER);
        northLoginSubPanel.add(ptEnLoginButton, BorderLayout.EAST);
        northLoginSSPanelTitle.setLayout(new FlowLayout());
        northLoginSSPanelTitle.add(titleLoginLabel);

        centerLoginSubPanel.add(centerLoginSSPanelForm, BorderLayout.NORTH);
        centerLoginSSPanelForm.setLayout(new GridLayout(2, 2));
        centerLoginSSPanelForm.add(usernameLoginLabel);
        centerLoginSSPanelForm.add(usernameLoginText);
        centerLoginSSPanelForm.add(passwordLoginLabel);
        centerLoginSSPanelForm.add(passwordLoginField);
        centerLoginSubPanel.add(centerLoginSSPanelButton, BorderLayout.SOUTH);
        centerLoginSSPanelButton.setLayout(new FlowLayout());
        centerLoginSSPanelButton.add(loginButton);

        southLoginSubPanel.add(southLoginSSPanelLinks);
        southLoginSSPanelLinks.setLayout(new BorderLayout());
        southLoginSSPanelLinks.add(customerNewButton, BorderLayout.EAST);
        southLoginSSPanelLinks.add(restaurantNewButton, BorderLayout.WEST);

        customerNewButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, CUSTOMER_CARD);
            janela.setSize(500, 300);
            // passar por parâmetro no construtor (fica como referência pq qdo precisarmos
            // no actionlistener)
        });
    }

    ////////////////////NOVO CLIENTE/////////////////////////
    private void construirPanelCustomer(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel registerNewCustomerSuperpanel) {


        /////SUBPAINEIS//////
        JPanel northNewCustomerSubPanel = new JPanel();
        northNewCustomerSubPanel.setLayout(new BorderLayout());
        JPanel centerNewCustomerSubPanel = new JPanel();
        JPanel southNewCustomerSubPanel = new JPanel();

        JLabel registerNewCustomerLabel = new JLabel("NOVO CLIENTE");
        JLabel nameClienteLabel = new JLabel("Nome");
        JLabel emailClienteLabel = new JLabel("E-mail");
        JLabel adressClienteLabel = new JLabel("Morada");
        JLabel cellularClienteLabel = new JLabel("Telemóvel");
        JLabel usernameClienteLabel = new JLabel("Username");
        JLabel passwordClienteLabel = new JLabel("Password: ");
        JLabel confirmarPasswordClienteLabel = new JLabel("Confirmar password: ");

        JTextField nameClienteText = new JTextField(20);
        JTextField emailClienteText = new JTextField(20);
        JTextField adressClienteText = new JTextField(20);
        JTextField cellularClienteText = new JTextField(20);
        JTextField usernameClienteText = new JTextField(20);

        JPasswordField passwordClienteField = new JPasswordField(20);
        JPasswordField confirmarPassawordClienteField = new JPasswordField(20);

        JButton ptEnNewCustomerButton = new JButton("PT/EN");
        JButton cancelCustomerButton = new JButton("CANCELAR");
        JButton registerCustomerButton = new JButton("REGISTAR");

        registerNewCustomerSuperpanel.add(northNewCustomerSubPanel, "North");
        registerNewCustomerSuperpanel.add(centerNewCustomerSubPanel, "Center");
        registerNewCustomerSuperpanel.add(southNewCustomerSubPanel, "South");

        JPanel northCustomerSubPanel = new JPanel();
        northCustomerSubPanel.setLayout(new FlowLayout());
        northCustomerSubPanel.add(registerNewCustomerLabel);
        northNewCustomerSubPanel.add(northCustomerSubPanel, BorderLayout.CENTER);
        northNewCustomerSubPanel.add(ptEnNewCustomerButton, BorderLayout.EAST);

        JPanel centerNewCustomerSSPanelForm = new JPanel();
        centerNewCustomerSSPanelForm.setLayout(new GridLayout(7, 2));
        centerNewCustomerSubPanel.add(centerNewCustomerSSPanelForm);
        centerNewCustomerSSPanelForm.add(nameClienteLabel);
        centerNewCustomerSSPanelForm.add(nameClienteText);
        centerNewCustomerSSPanelForm.add(emailClienteLabel);
        centerNewCustomerSSPanelForm.add(emailClienteText);
        centerNewCustomerSSPanelForm.add(adressClienteLabel);
        centerNewCustomerSSPanelForm.add(adressClienteText);
        centerNewCustomerSSPanelForm.add(cellularClienteLabel);
        centerNewCustomerSSPanelForm.add(cellularClienteText);
        centerNewCustomerSSPanelForm.add(usernameClienteLabel);
        centerNewCustomerSSPanelForm.add(usernameClienteText);
        centerNewCustomerSSPanelForm.add(passwordClienteLabel);
        centerNewCustomerSSPanelForm.add(passwordClienteField);
        centerNewCustomerSSPanelForm.add(confirmarPasswordClienteLabel);
        centerNewCustomerSSPanelForm.add(confirmarPassawordClienteField);

        southNewCustomerSubPanel.setLayout(new FlowLayout());
        southNewCustomerSubPanel.add(cancelCustomerButton);
        southNewCustomerSubPanel.add(registerCustomerButton);


        registerCustomerButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, RESTAURANT_CARD);
            this.setSize(500, 300);

        });

        cancelCustomerButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, RESTAURANT_CARD);
            this.setSize(500, 300);

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
    private void construirPanelMenuCustomer(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel menuCustomer) {

        /////SUBPAINEIS//////
        JPanel northMenuCustomerSubPanel = new JPanel();
        northMenuCustomerSubPanel.setLayout(new BorderLayout());
        JPanel centerMenuCustomerSubPanel = new JPanel();
        JPanel southMenuCustomerSubPanel = new JPanel();

        JLabel registerNewCustomerLabel = new JLabel("MENU CUSTOMERE");

        JButton ptEnMenuCustomerButton = new JButton("PT/EN");
        ////
        JButton adicionarPrato = new JButton("ADICIONAR PRATO");
        JButton atualizarPratoDia = new JButton("ATUALIZAR PRATO DO DIA");
        JButton atualizarDados = new JButton("ATUALIZAR DADOS");
        JButton reservas = new JButton("RESERVAS");
        JButton consultarComentarios = new JButton("CONSULTAR COMENTÁRIOS");
        JButton responderComentarios = new JButton("RESPONDER COMENTÁRIOS");
        JButton pontuacaoMedia = new JButton("PONTUAÇÃO MÉDIA");


        ///
        //JButton cancelMenuCustomerButton = new JButton("CANCELAR");
        JButton exitMenuCustomerButton = new JButton("SAIR");

        menuCustomer.add(northMenuCustomerSubPanel, "North");
        menuCustomer.add(centerMenuCustomerSubPanel, "Center");
        menuCustomer.add(southMenuCustomerSubPanel, "South");

        JPanel northCustomerSubPanel = new JPanel();
        northCustomerSubPanel.setLayout(new FlowLayout());
        northCustomerSubPanel.add(registerNewCustomerLabel);
        northMenuCustomerSubPanel.add(northCustomerSubPanel, BorderLayout.CENTER);
        northMenuCustomerSubPanel.add(ptEnMenuCustomerButton, BorderLayout.EAST);

        JPanel centerNewCustomerSSPanelForm = new JPanel();
        centerNewCustomerSSPanelForm.setLayout(new GridLayout(7, 1));
        centerMenuCustomerSubPanel.add(centerNewCustomerSSPanelForm);
        centerNewCustomerSSPanelForm.add(adicionarPrato);
        centerNewCustomerSSPanelForm.add(atualizarPratoDia);
        centerNewCustomerSSPanelForm.add(atualizarDados);
        centerNewCustomerSSPanelForm.add(reservas);
        centerNewCustomerSSPanelForm.add(consultarComentarios);
        centerNewCustomerSSPanelForm.add(responderComentarios);
        centerNewCustomerSSPanelForm.add(pontuacaoMedia);

        southMenuCustomerSubPanel.setLayout(new FlowLayout());
        //southMenuCustomerSubPanel.add(cancelMenuCustomerButton);
        southMenuCustomerSubPanel.add(exitMenuCustomerButton);

//        cancelMenuCustomerButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, CUSTOMER_CARD);
//            this.setSize(500, 300);
//
//        });

        exitMenuCustomerButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENUCUSTOMER_CARD);
            this.setSize(500, 300);

        });
    }


    ////////////////////NOVO RESTAURANTE/////////////////////////
    private void construirPanelRestaurant(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel registerNewRestaurantSuperpanel) {


        /////SUBPAINEIS//////
        JPanel northNewRestaurantSubPanel = new JPanel();
        northNewRestaurantSubPanel.setLayout(new BorderLayout());
        JPanel centerNewRestaurantSubPanel = new JPanel();
        JPanel southNewRestaurantSubPanel = new JPanel();

        JLabel registerNewRestaurantLabel = new JLabel("NOVO RESTAURANTE");
        JLabel nameRestaurantLabel = new JLabel("Nome");
        JLabel emailRestaurantLabel = new JLabel("E-mail");
        JLabel adressRestaurantLabel = new JLabel("Morada");
        JLabel cellularRestaurantLabel = new JLabel("Telemóvel");
///////////////////////
        JLabel lotacaoRestaurantLabel = new JLabel("Lotação");
        JLabel esplanadaRestaurantLabel = new JLabel("Esplanada");
        JLabel zonaInteriorNFumRestaurantLabel = new JLabel("Zona Interior Não Fumadores");
        JLabel zonaInteriorFumRestaurantLabel = new JLabel("Zona Interior Fumadores");
        JLabel horarioAlmocoInicioRestaurantLabel = new JLabel("Horário Almoço Início");
        JLabel horarioAlmocoFimRestauranteLabel = new JLabel("Horário Almoço Fim");
        JLabel horarioJantarInicioRestaurantLabel = new JLabel("Horário Jantar Início");
        JLabel horarioJantarFimRestaurantLabel = new JLabel("Horário Jantar Fim");
//////////////////////////////////


        JLabel usernameRestaurantLabel = new JLabel("Username");
        JLabel passwordRestaurantLabel = new JLabel("Password: ");
        JLabel confirmarPasswordRestaurantLabel = new JLabel("Confirmar password: ");

        JTextField nameRestaurantText = new JTextField(20);
        JTextField emailRestaurantText = new JTextField(20);
        JTextField adressRestaurantText = new JTextField(20);
        JTextField cellularRestaurantText = new JTextField(20);
        ////////
        JTextField lotacaoRestaurantText = new JTextField(5);
        JTextField esplanadaRestaurantText = new JTextField(5);
        JTextField zonaInteriorNFumRestaurantText = new JTextField(5);
        JTextField zonaInteriorFumRestaurantText = new JTextField(5);
        JTextField horarioAlmocoInicioRestaurantText = new JTextField(5);
        JTextField horarioAlmocoFimRestauranteText = new JTextField(5);
        JTextField horarioJantarInicioRestaurantText = new JTextField(5);
        JTextField horarioJantarFimRestaurantText = new JTextField(5);
        ///////
        JTextField usernameRestaurantText = new JTextField(20);

        JPasswordField passwordRestaurantField = new JPasswordField(20);
        JPasswordField confirmarPasswordRestaurantField = new JPasswordField(20);

        JButton ptEnNewRestaurantButton = new JButton("PT/EN");
        JButton cancelRestaurantButton = new JButton("CANCELAR");
        JButton registerRestaurantButton = new JButton("REGISTAR");

        registerNewRestaurantSuperpanel.add(northNewRestaurantSubPanel, "North");
        registerNewRestaurantSuperpanel.add(centerNewRestaurantSubPanel, "Center");
        registerNewRestaurantSuperpanel.add(southNewRestaurantSubPanel, "South");

        JPanel northRestaurantSubPanel = new JPanel();
        northRestaurantSubPanel.setLayout(new FlowLayout());
        northRestaurantSubPanel.add(registerNewRestaurantLabel);
        northNewRestaurantSubPanel.add(northRestaurantSubPanel, BorderLayout.CENTER);
        northNewRestaurantSubPanel.add(ptEnNewRestaurantButton, BorderLayout.EAST);

        JPanel centerNewRestaurantSSPanelForm = new JPanel();
        centerNewRestaurantSSPanelForm.setLayout(new GridLayout(7, 2));
        centerNewRestaurantSubPanel.add(centerNewRestaurantSSPanelForm);
        centerNewRestaurantSSPanelForm.add(nameRestaurantLabel);
        centerNewRestaurantSSPanelForm.add(nameRestaurantText);
        centerNewRestaurantSSPanelForm.add(emailRestaurantLabel);
        centerNewRestaurantSSPanelForm.add(emailRestaurantText);
        centerNewRestaurantSSPanelForm.add(adressRestaurantLabel);
        centerNewRestaurantSSPanelForm.add(adressRestaurantText);
        centerNewRestaurantSSPanelForm.add(cellularRestaurantLabel);
        centerNewRestaurantSSPanelForm.add(cellularRestaurantText);
        /////
        centerNewRestaurantSSPanelForm.add(lotacaoRestaurantLabel);
        centerNewRestaurantSSPanelForm.add(lotacaoRestaurantText);
        centerNewRestaurantSSPanelForm.add(esplanadaRestaurantLabel);
        centerNewRestaurantSSPanelForm.add(esplanadaRestaurantText);
        centerNewRestaurantSSPanelForm.add(zonaInteriorNFumRestaurantLabel);
        centerNewRestaurantSSPanelForm.add(zonaInteriorNFumRestaurantText);
        centerNewRestaurantSSPanelForm.add(zonaInteriorFumRestaurantLabel);
        centerNewRestaurantSSPanelForm.add(zonaInteriorFumRestaurantText);
        centerNewRestaurantSSPanelForm.add(horarioAlmocoInicioRestaurantLabel);
        centerNewRestaurantSSPanelForm.add(horarioAlmocoInicioRestaurantText);
        centerNewRestaurantSSPanelForm.add(horarioAlmocoFimRestauranteLabel);
        centerNewRestaurantSSPanelForm.add(horarioAlmocoFimRestauranteText);
        centerNewRestaurantSSPanelForm.add(horarioJantarInicioRestaurantLabel);
        centerNewRestaurantSSPanelForm.add(horarioJantarInicioRestaurantText);
        centerNewRestaurantSSPanelForm.add(horarioJantarFimRestaurantLabel);
        centerNewRestaurantSSPanelForm.add(horarioJantarFimRestaurantText);


        ////
        centerNewRestaurantSSPanelForm.add(usernameRestaurantLabel);
        centerNewRestaurantSSPanelForm.add(usernameRestaurantText);
        centerNewRestaurantSSPanelForm.add(passwordRestaurantLabel);
        centerNewRestaurantSSPanelForm.add(passwordRestaurantField);
        centerNewRestaurantSSPanelForm.add(confirmarPasswordRestaurantLabel);
        centerNewRestaurantSSPanelForm.add(confirmarPasswordRestaurantField);

        southNewRestaurantSubPanel.setLayout(new FlowLayout());
        southNewRestaurantSubPanel.add(cancelRestaurantButton);
        southNewRestaurantSubPanel.add(registerRestaurantButton);

        registerRestaurantButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, RESTAURANT_CARD);
            this.setSize(500, 300);
            // passar por parâmetro no construtor (fica como referência pq qdo precisarmos
            // no actionlistener)
        });
    }

    //////MENU RESTAURANTE////////
    private void construirPanelMenuCustomer(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel menuRestaurant) {

        /////SUBPAINEIS//////
        JPanel northMenuRestaurantSubPanel = new JPanel();
        northMenuRestaurantSubPanel.setLayout(new BorderLayout());
        JPanel centerMenuRestaurantSubPanel = new JPanel();
        JPanel southMenuRestaurantSubPanel = new JPanel();

        JLabel registerNewRestaurantLabel = new JLabel("MENU RESTAURANTE");

        JButton ptEnMenuRestaurantButton = new JButton("PT/EN");
        ////
        JButton adicionarPrato = new JButton("ADICIONAR PRATO");
        JButton atualizarPratoDia = new JButton("ATUALIZAR PRATO DO DIA");
        JButton atualizarDados = new JButton("ATUALIZAR DADOS");
        JButton reservas = new JButton("RESERVAS");
        JButton consultarComentarios = new JButton("CONSULTAR COMENTÁRIOS");
        JButton responderComentarios = new JButton("RESPONDER COMENTÁRIOS");
        JButton pontuacaoMedia = new JButton("PONTUAÇÃO MÉDIA");


        ///
        //JButton cancelMenuRestaurantButton = new JButton("CANCELAR");
        JButton exitMenuRestaurantButton = new JButton("SAIR");

        menuRestaurant.add(northMenuRestaurantSubPanel, "North");
        menuRestaurant.add(centerMenuRestaurantSubPanel, "Center");
        menuRestaurant.add(southMenuRestaurantSubPanel, "South");

        JPanel northRestaurantSubPanel = new JPanel();
        northRestaurantSubPanel.setLayout(new FlowLayout());
        northRestaurantSubPanel.add(registerNewRestaurantLabel);
        northMenuRestaurantSubPanel.add(northRestaurantSubPanel, BorderLayout.CENTER);
        northMenuRestaurantSubPanel.add(ptEnMenuRestaurantButton, BorderLayout.EAST);

        JPanel centerNewRestaurantSSPanelForm = new JPanel();
        centerNewRestaurantSSPanelForm.setLayout(new GridLayout(7, 1));
        centerMenuRestaurantSubPanel.add(centerNewRestaurantSSPanelForm);
        centerNewRestaurantSSPanelForm.add(adicionarPrato);
        centerNewRestaurantSSPanelForm.add(atualizarPratoDia);
        centerNewRestaurantSSPanelForm.add(atualizarDados);
        centerNewRestaurantSSPanelForm.add(reservas);
        centerNewRestaurantSSPanelForm.add(consultarComentarios);
        centerNewRestaurantSSPanelForm.add(responderComentarios);
        centerNewRestaurantSSPanelForm.add(pontuacaoMedia);

        southMenuRestaurantSubPanel.setLayout(new FlowLayout());
        //southMenuRestaurantSubPanel.add(cancelMenuRestaurantButton);
        southMenuRestaurantSubPanel.add(exitMenuRestaurantButton);

//        cancelMenuRestaurantButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, RESTAURANT_CARD);
//            this.setSize(500, 300);
//
//        });

        exitMenuRestaurantButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, RESTAURANT_CARD);
            this.setSize(500, 300);

        });
    }
}