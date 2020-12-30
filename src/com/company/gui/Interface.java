package com.company.gui;

import com.company.gui.util.DateLabelFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class Interface extends JFrame {
    private static final String LOGIN_CARD = "LOGIN";
    private static final String RESTAURANTE_CARD = "RESTAURANTE";
    private static final String CLIENTE_CARD = "CLIENTE";
    private static final String MENUCLIENTE_CARD = "MENU CLIENTE";
    private static final String MCLIREST_CARD = "MENU CLIENTE - CONSULTAR RESTAURANTES";
    private static final String MCLICOMENTARIOS_CARD = "MENU CLIENTE - COMENTÁRIOS";
    private static final String MCLIATDADOS_CARD = "MENU CLIENTE - ATUALIZAR DADOS";
    private static final String MCLIHISRES_CARD = "MENU CLIENTE - HISTÓRICO DE RESERVAS";
    private static final String MCLIRESACT_CARD = "MENU CLIENTE - RESERVAS ACTIVAS";
    private static final String MCLIFAZERRES_CARD = "MENU CLIENTE - FAZER RESERVAS";
    private static final String MCLIFAZERRESP_CARD = "MENU CLIENTE - FAZER RESERVAS PRESENCIAL";
    private static final String MCLIFAZERRESTA_CARD = "MENU CLIENTE - FAZER RESERVAS TAKE-AWAY";


    private static final String MENURESTAURANTE_CARD = "MENU RESTAURANTE";
    private static final String MRESTADICIONARPRATO_CARD = "ADICIONAR PRATO";
    private static final String MRESTATUALIZARPRATO_CARD = "ATUALIZAR PRATO DO DIA";
    private static final String MRESTATUALIZARDADOS_CARD = "MENU RESTAURANTE - ATUALIZAR DADOS";
    private static final String MRESTRESERV_CARD = "MENU RESTAURANTE - HISTÓRICO DE RESERVAS";
    private static final String MRESTCOMENTARIOS_CARD = "MENU RESTAURANTE - COMENTÁRIOS";
    private static final int LARGURA_LOGIN = 400;
    private static final int ALTURA_LOGIN = 180;
    private static final int LARGURA_PADRAO = 500;
    private static final int ALTURA_PADRAO = 300;


    public Interface() {
        ImageIcon logo = new ImageIcon("logo3.png");
        this.setIconImage(logo.getImage());
        this.setTitle("RESERVAS DE RESTAURANTES");
        this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contentor = this.getContentPane();
        contentor.setLayout(new CardLayout());

        /////// SUPERPAINEIS////////
        JPanel loginSuperPanel = new JPanel();
        loginSuperPanel.setLayout(new BorderLayout());
        JPanel registarNovoClienteSuperPanel = new JPanel();
        registarNovoClienteSuperPanel.setLayout(new BorderLayout());
        JPanel registarNovoRestSuperPanel = new JPanel();
        registarNovoRestSuperPanel.setLayout(new BorderLayout());
        JPanel menuClienteSuperPanel = new JPanel();
        menuClienteSuperPanel.setLayout(new BorderLayout());
        JPanel mCliRestSuperPanel = new JPanel();
        mCliRestSuperPanel.setLayout(new BorderLayout());
        JPanel mCliComentariosSuperPanel = new JPanel();
        mCliComentariosSuperPanel.setLayout(new BorderLayout());
        JPanel mCliAtDadosSuperPanel = new JPanel();
        mCliAtDadosSuperPanel.setLayout(new BorderLayout());
        JPanel mCliHistResSuperPanel = new JPanel();
        mCliHistResSuperPanel.setLayout(new BorderLayout());
        JPanel mCliResActSuperPanel = new JPanel();
        mCliResActSuperPanel.setLayout(new BorderLayout());
        JPanel mCliFazerResSuperPanel = new JPanel();
        mCliFazerResSuperPanel.setLayout(new BorderLayout());
        JPanel mCliFazerResPSuperPanel = new JPanel();
        mCliFazerResPSuperPanel.setLayout(new BorderLayout());
        JPanel mCliFazerResTASuperPanel = new JPanel();
        mCliFazerResTASuperPanel.setLayout(new BorderLayout());


        JPanel mRestSuperPanel = new JPanel();
        mRestSuperPanel.setLayout(new BorderLayout());
        JPanel mRestAdPratoSuperPanel = new JPanel();
        mRestAdPratoSuperPanel.setLayout(new BorderLayout());
        JPanel mRestAtPratoDiaSuperPanel = new JPanel();
        mRestAtPratoDiaSuperPanel.setLayout(new BorderLayout());
        JPanel mRestAtDadosSuperPanel = new JPanel();
        mRestAtDadosSuperPanel.setLayout(new BorderLayout());
        JPanel mRestReservasSuperPanel = new JPanel();
        mRestReservasSuperPanel.setLayout(new BorderLayout());
        JPanel mRestComentariosSuperPanel = new JPanel();
        mRestComentariosSuperPanel.setLayout(new BorderLayout());


        construirPanelLogin(this, contentor, loginSuperPanel);

        construirPanelCliente(this, contentor, loginSuperPanel, registarNovoClienteSuperPanel);

        construirPanelRestaurante(this, contentor, loginSuperPanel, registarNovoRestSuperPanel);

        construirPanelMenuCliente(this, contentor, loginSuperPanel, menuClienteSuperPanel);

        ////PROBLEMA - não aceita this
        construirPanelMRest(contentor, loginSuperPanel, mRestSuperPanel);

        construirPanelMRestAdPrato(this, contentor, loginSuperPanel, mRestAdPratoSuperPanel);

        construirPanelMRestAtPratoDia(this, contentor, loginSuperPanel, mRestAtPratoDiaSuperPanel);

        construirPanelMRestAtDados(this, contentor, loginSuperPanel, mRestAtDadosSuperPanel);

        construirPanelMRestReservas(this, contentor, loginSuperPanel, mRestReservasSuperPanel);

        construirPanelMRestComentarios(this, contentor, loginSuperPanel, mRestComentariosSuperPanel);

        construirPanelMCliRestaurantes(this, contentor, loginSuperPanel, mCliRestSuperPanel);

        construirPanelMCliComentarios(this, contentor, loginSuperPanel, mCliComentariosSuperPanel);

        construirPanelMCliAtDados(this, contentor, loginSuperPanel, mCliAtDadosSuperPanel);

        construirPanelMCliHistRes(this, contentor, loginSuperPanel, mCliHistResSuperPanel);

        construirPanelMCliResAct(this, contentor, loginSuperPanel, mCliResActSuperPanel);

        construirPanelMCliFazerRes(this, contentor, loginSuperPanel, mCliFazerResSuperPanel);

        //construirPanelMCliFazerResP(this, contentor, loginSuperPanel, mCliFazerResPSuperPanel);

        construirPanelMCliFazerResTA(this, contentor, loginSuperPanel, mCliFazerResTASuperPanel);


        contentor.add(loginSuperPanel, LOGIN_CARD);
        contentor.add(registarNovoClienteSuperPanel, CLIENTE_CARD);
        contentor.add(registarNovoRestSuperPanel, RESTAURANTE_CARD);
        contentor.add(menuClienteSuperPanel, MENUCLIENTE_CARD);
        contentor.add(mRestSuperPanel, MENURESTAURANTE_CARD);
        contentor.add(mRestAdPratoSuperPanel, MRESTADICIONARPRATO_CARD);
        contentor.add(mRestAtPratoDiaSuperPanel, MRESTATUALIZARPRATO_CARD);
        contentor.add(mRestAtDadosSuperPanel, MRESTATUALIZARDADOS_CARD);
        contentor.add(mRestReservasSuperPanel, MRESTRESERV_CARD);
        contentor.add(mRestComentariosSuperPanel, MRESTCOMENTARIOS_CARD);
        contentor.add(mCliRestSuperPanel, MCLIREST_CARD);
        contentor.add(mCliComentariosSuperPanel, MCLICOMENTARIOS_CARD);
        contentor.add(mCliAtDadosSuperPanel, MCLIATDADOS_CARD);
        contentor.add(mCliHistResSuperPanel, MCLIHISRES_CARD);
        contentor.add(mCliResActSuperPanel, MCLIRESACT_CARD);
        contentor.add(mCliFazerResSuperPanel, MCLIFAZERRES_CARD);
        contentor.add(mCliFazerResPSuperPanel, MCLIFAZERRESP_CARD);
        contentor.add(mCliFazerResTASuperPanel, MCLIFAZERRESTA_CARD);

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
        JLabel usernameLoginLabel = new JLabel("Username");
        JLabel passwordLoginLabel = new JLabel("Password");

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
            janela.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
            // passar por parâmetro no construtor (fica como referência pq qdo precisarmos
            // no actionlistener)
        });

        restauranteNovoButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, RESTAURANTE_CARD);
            janela.setSize(LARGURA_PADRAO, 350);
            // passar por parâmetro no construtor (fica como referência pq qdo precisarmos
            // no actionlistener)
        });
    }

    ////////////////////NOVO CLIENTE/////////////////////////
    private void construirPanelCliente(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel registarNovoClienteSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteNovoClienteSubPanel = new JPanel();
        norteNovoClienteSubPanel.setLayout(new BorderLayout());
        JPanel centroNovoClienteSubPanel = new JPanel();
        JPanel sulNovoClienteSubPanel = new JPanel();

        JLabel registarNovoClienteLabel = new JLabel("NOVO CLIENTE");
        registarNovoClienteLabel.setForeground(Color.BLUE);
        JLabel nomeClienteLabel = new JLabel("Nome");
        //nomeClienteLabel.setBounds(50,80,100,20);
        JLabel emailClienteLabel = new JLabel("E-mail");
        JLabel moradaClienteLabel = new JLabel("Morada");
        JLabel telemovelClienteLabel = new JLabel("Telemóvel");
        JLabel usernameClienteLabel = new JLabel("Username");
        JLabel passwordClienteLabel = new JLabel("Password ");
        JLabel confirmarPasswordClienteLabel = new JLabel("Confirmar password ");

        JTextField nomeClienteText = new JTextField(20);
        nomeClienteText.setMargin(new Insets(3, 3, 3, 3));
        //nomeClienteText.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        JTextField emailClienteText = new JTextField(20);
        //emailClienteText.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        JTextField moradaClienteText = new JTextField(20);
        JTextField telemovelClienteText = new JTextField(20);
        JTextField usernameClienteText = new JTextField(20);

        JPasswordField passwordClienteField = new JPasswordField(20);
        JPasswordField confirmarPassawordClienteField = new JPasswordField(20);

        JButton ptEnNovoClienteButton = new JButton("PT/EN");
        JButton cancelarClienteButton = new JButton("CANCELAR");
        JButton registarClienteButton = new JButton("REGISTAR");

        //todo não deu certo
        //Define as máscaras
        MaskFormatter mascaraTelCliente = null;

        try {
            mascaraTelCliente = new MaskFormatter("(##)####-####");

        } catch (ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }

        //Seta as máscaras nos objetos JFormattedTextField
        JFormattedTextField telClienteT = new JFormattedTextField(mascaraTelCliente);
        //telClienteT.setBounds(150,80,100,20);


        registarNovoClienteSuperPanel.add(norteNovoClienteSubPanel, "North");
        registarNovoClienteSuperPanel.add(centroNovoClienteSubPanel, "Center");
        registarNovoClienteSuperPanel.add(sulNovoClienteSubPanel, "South");

        JPanel norteNovoClienteSSPanel = new JPanel();
        norteNovoClienteSSPanel.setLayout(new FlowLayout());
        norteNovoClienteSSPanel.add(registarNovoClienteLabel);
        norteNovoClienteSubPanel.add(norteNovoClienteSSPanel, BorderLayout.CENTER);
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
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });

        cancelarClienteButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, LOGIN_CARD);
            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);

        });
    }


    ////// MENU CLIENTE//////////
    private void construirPanelMenuCliente(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel menuClienteSuperPanel) {

        /////SUBPAINEIS//////
        JPanel norteMenuClienteSubPanel = new JPanel();
        norteMenuClienteSubPanel.setLayout(new BorderLayout());
        JPanel centroMenuClienteSubPanel = new JPanel();
        JPanel sulMenuClienteSubPanel = new JPanel();

        JLabel registarNovoClienteLabel = new JLabel("MENU CLIENTE");
        registarNovoClienteLabel.setForeground(Color.BLUE);

        JButton ptEnMenuClienteButton = new JButton("PT/EN");
        ////
        JButton consultarRestMCliButton = new JButton("RESTAURANTES");
        JButton comentariosMCliButton = new JButton("COMENTÁRIOS");
        JButton histResComPonMCliButton = new JButton("RESERVAS/COMENTAR");
        JButton reservasActMCliButton = new JButton("RESERVAS ACTIVAS");
        JButton fazerReservasMCliButton = new JButton("FAZER RESERVAS");
        JButton atualDadosMCliButton = new JButton("ATUALIZAR DADOS");

        ///
        //JButton cancelarMenuClienteButton = new JButton("CANCELAR");
        JButton logoutMenuClienteButton = new JButton("LOGOUT");

        menuClienteSuperPanel.add(norteMenuClienteSubPanel, "North");
        menuClienteSuperPanel.add(centroMenuClienteSubPanel, "Center");
        menuClienteSuperPanel.add(sulMenuClienteSubPanel, "South");

        JPanel norteClienteSubPanel = new JPanel();
        norteClienteSubPanel.setLayout(new FlowLayout());
        norteClienteSubPanel.add(registarNovoClienteLabel);
        norteMenuClienteSubPanel.add(norteClienteSubPanel, BorderLayout.CENTER);
        norteMenuClienteSubPanel.add(ptEnMenuClienteButton, BorderLayout.EAST);

        JPanel centroNovoClienteSSPanelForm = new JPanel();
        centroNovoClienteSSPanelForm.setLayout(new GridLayout(7, 2));
        centroMenuClienteSubPanel.add(centroNovoClienteSSPanelForm);
        centroNovoClienteSSPanelForm.add(consultarRestMCliButton);
        centroNovoClienteSSPanelForm.add(comentariosMCliButton);
        centroNovoClienteSSPanelForm.add(histResComPonMCliButton);
        centroNovoClienteSSPanelForm.add(reservasActMCliButton);
        centroNovoClienteSSPanelForm.add(fazerReservasMCliButton);
        centroNovoClienteSSPanelForm.add(atualDadosMCliButton);

        sulMenuClienteSubPanel.setLayout(new FlowLayout());
        sulMenuClienteSubPanel.add(logoutMenuClienteButton);

        consultarRestMCliButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MCLIREST_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
        });

        comentariosMCliButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MCLICOMENTARIOS_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
        });

        histResComPonMCliButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MCLIHISRES_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
        });

        reservasActMCliButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MCLIRESACT_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
        });

        fazerReservasMCliButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MCLIFAZERRES_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
        });

        atualDadosMCliButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MCLIATDADOS_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
        });

        logoutMenuClienteButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, LOGIN_CARD);
            this.setSize(400, 180);
        });

    }


    ////////////////////NOVO RESTAURANTE/////////////////////////
    private void construirPanelRestaurante(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel registarNovoRestauranteSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteNovoRestauranteSubPanel = new JPanel();
        norteNovoRestauranteSubPanel.setLayout(new BorderLayout());
        JPanel centroNovoRestauranteSubPanel = new JPanel();
        centroNovoRestauranteSubPanel.setLayout(new FlowLayout());
        JPanel sulNovoRestauranteSubPanel = new JPanel();

        JLabel registarNovoRestauranteLabel = new JLabel("NOVO RESTAURANTE");
        registarNovoRestauranteLabel.setForeground(Color.RED);
        JLabel nomeRestauranteLabel = new JLabel("Nome");
        JLabel emailRestauranteLabel = new JLabel("E-mail");
        JLabel moradaRestauranteLabel = new JLabel("Morada");
        JLabel cidadeRestauranteLabel = new JLabel("Cidade");
        JLabel telemovelRestauranteLabel = new JLabel("Telemóvel");
///////////////////////
        JLabel lotacaoRestauranteLabel = new JLabel("Lotação:");
        JLabel esplanadaRestauranteLabel = new JLabel("Esplanada");
        JLabel zonaInteriorLabel = new JLabel("Zona Interior:");
        JLabel zonaInteriorNFumRestauranteLabel = new JLabel("Ñ Fumadores");
        JLabel zonaInteriorFumRestauranteLabel = new JLabel("Fumadores");
        JLabel horariosRestauranteLabel = new JLabel("Horários:");
        JLabel horariosAlmocoRestauranteLabel = new JLabel("Almoço:");
        JLabel horarioAlmocoInicioRestauranteLabel = new JLabel("Início");
        JLabel horarioAlmocoFimRestauranteLabel = new JLabel("Fim");
        JLabel horariosJantarRestauranteLabel = new JLabel("Jantar:");
        JLabel horarioJantarInicioRestauranteLabel = new JLabel("Início");
        JLabel horarioJantarFimRestauranteLabel = new JLabel("Fim");
//////////////////////////////////


        JLabel usernameRestauranteLabel = new JLabel("Username");
        JLabel passwordRestauranteLabel = new JLabel("Password ");
        JLabel confirmarPasswordRestauranteLabel = new JLabel("Confirmar password ");

        JTextField nomeRestauranteText = new JTextField(18);
        nomeRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField emailRestauranteText = new JTextField(18);
        emailRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField moradaRestauranteText = new JTextField(20);
        moradaRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField cidadeRestauranteText = new JTextField(15);
        cidadeRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField telemovelRestauranteText = new JTextField(8);
        telemovelRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        ////////
        JTextField esplanadaRestauranteText = new JTextField(3);
        esplanadaRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField zonaInteriorNFumRestauranteText = new JTextField(3);
        zonaInteriorNFumRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField zonaInteriorFumRestauranteText = new JTextField(3);
        zonaInteriorFumRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField horarioAlmocoInicioRestauranteText = new JTextField(3);
        horarioAlmocoInicioRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField horarioAlmocoFimRestauranteText = new JTextField(3);
        horarioAlmocoFimRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField horarioJantarInicioRestauranteText = new JTextField(3);
        horarioJantarInicioRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField horarioJantarFimRestauranteText = new JTextField(3);
        horarioJantarFimRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        ///////
        JTextField usernameRestauranteText = new JTextField(20);
        usernameRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        JPasswordField passwordRestauranteField = new JPasswordField(15);
        passwordRestauranteField.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JPasswordField confirmarPasswordRestauranteField = new JPasswordField(15);
        confirmarPasswordRestauranteField.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        JButton ptEnNovoRestauranteButton = new JButton("PT/EN");
        JButton cancelarRestauranteButton = new JButton("CANCELAR");
        JButton registarRestauranteButton = new JButton("REGISTAR");

        registarNovoRestauranteSuperPanel.add(norteNovoRestauranteSubPanel, "North");
        registarNovoRestauranteSuperPanel.add(centroNovoRestauranteSubPanel, "Center");
        registarNovoRestauranteSuperPanel.add(sulNovoRestauranteSubPanel, "South");

//        JPanel norteSupMRestSubPanel = new JPanel();
//        norteSupMRestSubPanel.setLayout(new FlowLayout());
//        norteNovoRestauranteSubPanel.add(norteSupMRestSubPanel, BorderLayout.CENTER);
//        norteSupMRestSubPanel.add(registarNovoRestauranteLabel);
//        norteNovoRestauranteSubPanel.add(ptEnNovoRestauranteButton, BorderLayout.EAST);

        JPanel norteNovoRestSSPanel = new JPanel();
        norteNovoRestSSPanel.setLayout(new FlowLayout());
        norteNovoRestSSPanel.add(registarNovoRestauranteLabel);
        norteNovoRestauranteSubPanel.add(norteNovoRestSSPanel, BorderLayout.CENTER);
        norteNovoRestauranteSubPanel.add(ptEnNovoRestauranteButton, BorderLayout.EAST);

        JPanel centroNovoRestSSPanelForm1 = new JPanel();
        centroNovoRestSSPanelForm1.setLayout(new FlowLayout());
        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm1);
        JPanel centroNovoRestSSPanelForm2 = new JPanel();
        centroNovoRestSSPanelForm2.setLayout(new FlowLayout());
        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm2, BorderLayout.CENTER);
        JPanel centroNovoRestSSPanelForm2A = new JPanel();
        centroNovoRestSSPanelForm2A.setLayout(new FlowLayout());
        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm2A, BorderLayout.CENTER);
        JPanel centroNovoRestSSPanelForm3 = new JPanel();
        //centroNovoRestSSPanelForm3.setLayout(new FlowLayout());
        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm3, BorderLayout.CENTER);

        JPanel centroNovoRestSSPanelForm4 = new JPanel();
        centroNovoRestSSPanelForm4.setLayout(new FlowLayout());
        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm4, BorderLayout.CENTER);

        JPanel centroNovoRestSSPanelForm5 = new JPanel();
        centroNovoRestSSPanelForm5.setLayout(new FlowLayout());
        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm5, BorderLayout.CENTER);

        JPanel centroNovoRestSSPanelForm6 = new JPanel();
        centroNovoRestSSPanelForm6.setLayout(new FlowLayout());
        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm6, BorderLayout.CENTER);

        centroNovoRestSSPanelForm1.add(nomeRestauranteLabel);
        centroNovoRestSSPanelForm1.add(nomeRestauranteText);
        centroNovoRestSSPanelForm1.add(emailRestauranteLabel);
        centroNovoRestSSPanelForm1.add(emailRestauranteText);
        centroNovoRestSSPanelForm2.add(moradaRestauranteLabel);
        centroNovoRestSSPanelForm2.add(moradaRestauranteText);
        centroNovoRestSSPanelForm2A.add(cidadeRestauranteLabel);
        centroNovoRestSSPanelForm2A.add(cidadeRestauranteText);
        centroNovoRestSSPanelForm2A.add(telemovelRestauranteLabel);
        centroNovoRestSSPanelForm2A.add(telemovelRestauranteText);
        /////
        centroNovoRestSSPanelForm3.add(lotacaoRestauranteLabel);
        centroNovoRestSSPanelForm3.add(esplanadaRestauranteLabel);
        centroNovoRestSSPanelForm3.add(esplanadaRestauranteText);
        centroNovoRestSSPanelForm3.add(zonaInteriorLabel);
        centroNovoRestSSPanelForm3.add(zonaInteriorNFumRestauranteLabel);
        centroNovoRestSSPanelForm3.add(zonaInteriorNFumRestauranteText);
        centroNovoRestSSPanelForm3.add(zonaInteriorFumRestauranteLabel);
        centroNovoRestSSPanelForm3.add(zonaInteriorFumRestauranteText);

        centroNovoRestSSPanelForm4.add(horariosRestauranteLabel);
        centroNovoRestSSPanelForm4.add(horariosAlmocoRestauranteLabel);
        centroNovoRestSSPanelForm4.add(horarioAlmocoInicioRestauranteLabel);
        centroNovoRestSSPanelForm4.add(horarioAlmocoInicioRestauranteText);
        centroNovoRestSSPanelForm4.add(horarioAlmocoFimRestauranteLabel);
        centroNovoRestSSPanelForm4.add(horarioAlmocoFimRestauranteText);
        centroNovoRestSSPanelForm4.add(horariosJantarRestauranteLabel);
        centroNovoRestSSPanelForm4.add(horarioJantarInicioRestauranteLabel);
        centroNovoRestSSPanelForm4.add(horarioJantarInicioRestauranteText);
        centroNovoRestSSPanelForm4.add(horarioJantarFimRestauranteLabel);
        centroNovoRestSSPanelForm4.add(horarioJantarFimRestauranteText);

        //
        centroNovoRestSSPanelForm5.add(usernameRestauranteLabel);
        centroNovoRestSSPanelForm5.add(usernameRestauranteText);

        centroNovoRestSSPanelForm6.add(passwordRestauranteLabel);
        centroNovoRestSSPanelForm6.add(passwordRestauranteField);
        centroNovoRestSSPanelForm6.add(confirmarPasswordRestauranteLabel);
        centroNovoRestSSPanelForm6.add(confirmarPasswordRestauranteField);


        sulNovoRestauranteSubPanel.setLayout(new FlowLayout());
        sulNovoRestauranteSubPanel.add(cancelarRestauranteButton);
        sulNovoRestauranteSubPanel.add(registarRestauranteButton);

        cancelarRestauranteButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, LOGIN_CARD);
            this.setSize(500, 180);
        });

        registarRestauranteButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENURESTAURANTE_CARD);
            this.setSize(500, 300);

        });
    }

    //////MENU RESTAURANTE////////
    private void construirPanelMRest(Container contentor, JPanel loginSuperPanel, JPanel menuRestauranteSuperPanel) {

        /////SUBPAINEIS//////
        JPanel norteMenuRestauranteSubPanel = new JPanel();
        norteMenuRestauranteSubPanel.setLayout(new BorderLayout());
        JPanel centroMenuRestauranteSubPanel = new JPanel();
        JPanel sulMenuRestauranteSubPanel = new JPanel();

        JLabel registarNovoRestauranteLabel = new JLabel("MENU RESTAURANTE");
        registarNovoRestauranteLabel.setForeground(Color.RED);

        JButton ptEnMenuRestauranteButton = new JButton("PT/EN");
        ////
        JButton mRestAdicionarPratoButton = new JButton("ADICIONAR PRATO");
        JButton mRestAtualizarPratoDiaButton = new JButton("ATUALIZAR PRATO DO DIA");
        JButton mRestAtualizarDadosButton = new JButton("ATUALIZAR DADOS");
        JButton mRestReservasButton = new JButton("RESERVAS");
        JButton mRestConsultarComentariosButton = new JButton("COMENTÁRIOS");
        JButton pontuacaoMedia = new JButton("PONTUAÇÃO MÉDIA");


        ///
        //JButton cancelarMenuRestauranteButton = new JButton("CANCELAR");
        JButton logoutMenuRestauranteButton = new JButton("LOGOUT");

        menuRestauranteSuperPanel.add(norteMenuRestauranteSubPanel, "North");
        menuRestauranteSuperPanel.add(centroMenuRestauranteSubPanel, "Center");
        menuRestauranteSuperPanel.add(sulMenuRestauranteSubPanel, "South");

        JPanel norteMenuRestauranteSSPanel = new JPanel();
        norteMenuRestauranteSSPanel.setLayout(new FlowLayout());
        norteMenuRestauranteSSPanel.add(registarNovoRestauranteLabel);
        norteMenuRestauranteSubPanel.add(norteMenuRestauranteSSPanel, BorderLayout.CENTER);
        norteMenuRestauranteSubPanel.add(ptEnMenuRestauranteButton, BorderLayout.EAST);

        JPanel centroNovoRestauranteSSPanelForm = new JPanel();
        centroNovoRestauranteSSPanelForm.setLayout(new GridLayout(7, 1));
        centroMenuRestauranteSubPanel.add(centroNovoRestauranteSSPanelForm);
        centroNovoRestauranteSSPanelForm.add(mRestAdicionarPratoButton);
        centroNovoRestauranteSSPanelForm.add(mRestAtualizarPratoDiaButton);
        centroNovoRestauranteSSPanelForm.add(mRestAtualizarDadosButton);
        centroNovoRestauranteSSPanelForm.add(mRestReservasButton);
        centroNovoRestauranteSSPanelForm.add(mRestConsultarComentariosButton);
        centroNovoRestauranteSSPanelForm.add(pontuacaoMedia);

        sulMenuRestauranteSubPanel.setLayout(new FlowLayout());
        //sulMenuRestauranteSubPanel.add(cancelarMenuRestauranteButton);
        sulMenuRestauranteSubPanel.add(logoutMenuRestauranteButton);

//        cancelarMenuRestauranteButton.addActionListener(a -> {
//           CardLayout cl = (CardLayout) contentor.getLayout();
//           cl.show(contentor, LOGIN_CARD);
//            this.setSize(500, 300);
//
//       });
        mRestAdicionarPratoButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MRESTADICIONARPRATO_CARD);
            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
        });

        mRestAtualizarPratoDiaButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MRESTATUALIZARPRATO_CARD);
            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
        });

        mRestReservasButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MRESTRESERV_CARD);
            this.setSize(LARGURA_PADRAO, 350);
        });

        mRestAtualizarDadosButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MRESTATUALIZARDADOS_CARD);
            this.setSize(LARGURA_PADRAO, 350);
        });

//        mRestReservasButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MRESTCOMENTARIOS_CARD);
//            this.setSize(LARGURA_PADRAO, 350);
//      });

        mRestConsultarComentariosButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MRESTCOMENTARIOS_CARD);
            this.setSize(LARGURA_PADRAO, 350);
        });

        logoutMenuRestauranteButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, LOGIN_CARD);
            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
        });
    }

    ///////////MENU RESTAURANTE - ADICIONAR PRATO//////////////////////
    private void construirPanelMRestAdPrato(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mRestAdPratoSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteAdPratoSubPanel = new JPanel();
        norteAdPratoSubPanel.setLayout(new BorderLayout());
        JPanel centroAdPratoSubPanel = new JPanel();
        JPanel sulAdPratoSubPanel = new JPanel();

        JLabel adPratoLabel = new JLabel("ADICIONAR PRATO");
        JLabel nomePratoLabel = new JLabel("Nome Prato");
        JLabel descricaoPratoLabel = new JLabel("Descrição");
        JLabel precoPratoLabel = new JLabel("Preço");

        JTextField nomePratoText = new JTextField(20);
        JTextField descricaoPratoText = new JTextField(20);
        JTextField precoPratoText = new JTextField(10);


        JButton ptEnAdPratoButton = new JButton("PT/EN");
        JButton voltarMenuRestAdPratoButton = new JButton("MENU RESTAURANTE");
        JButton confirmarAdPratoButton = new JButton("CONFIRMAR");


        JComboBox tipoPratoAd = new JComboBox();
        tipoPratoAd.addItem("Carta");
        tipoPratoAd.addItem("Prato do dia");


        mRestAdPratoSuperPanel.add(norteAdPratoSubPanel, "North");
        mRestAdPratoSuperPanel.add(centroAdPratoSubPanel, "Center");
        mRestAdPratoSuperPanel.add(sulAdPratoSubPanel, "South");

        JPanel norteAdPratoSSPanel = new JPanel();
        norteAdPratoSSPanel.setLayout(new FlowLayout());
        norteAdPratoSSPanel.add(adPratoLabel);
        norteAdPratoSubPanel.add(norteAdPratoSSPanel, BorderLayout.CENTER);
        norteAdPratoSubPanel.add(ptEnAdPratoButton, BorderLayout.EAST);

        JPanel centroAdPratoSSPanelForm = new JPanel();
        centroAdPratoSSPanelForm.setLayout(new GridLayout(5, 2));
        centroAdPratoSubPanel.add(centroAdPratoSSPanelForm);
        centroAdPratoSubPanel.add(tipoPratoAd);
        centroAdPratoSSPanelForm.add(nomePratoLabel);
        centroAdPratoSSPanelForm.add(nomePratoText);
        centroAdPratoSSPanelForm.add(descricaoPratoLabel);
        centroAdPratoSSPanelForm.add(descricaoPratoText);
        centroAdPratoSSPanelForm.add(precoPratoLabel);
        centroAdPratoSSPanelForm.add(precoPratoText);

        sulAdPratoSubPanel.setLayout(new FlowLayout());
        sulAdPratoSubPanel.add(voltarMenuRestAdPratoButton);
        sulAdPratoSubPanel.add(confirmarAdPratoButton);


        voltarMenuRestAdPratoButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENURESTAURANTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });

        confirmarAdPratoButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENURESTAURANTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });

    }

    /////////MENU RESTAURANTE – ATUALIZAR PRATO//////////////////////
    private void construirPanelMRestAtPratoDia(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mRestAtPratoSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteAtPratoSubPanel = new JPanel();
        norteAtPratoSubPanel.setLayout(new BorderLayout());
        JPanel centroAtPratoSubPanel = new JPanel();
        JPanel sulAtPratoSubPanel = new JPanel();

        JLabel atPratoLabel = new JLabel("ATUALIZAR PRATO DO DIA");
        JLabel atNomePratoLabel = new JLabel("Nome Prato");
        JLabel atDescricaoPratoLabel = new JLabel("Descrição");
        JLabel atPrecoPratoLabel = new JLabel("Preço");

        JTextField atNomePratoText = new JTextField(20);
        JTextField atDescricaoPratoText = new JTextField(20);
        JTextField atPrecoPratoText = new JTextField(10);

        JButton ptEnAtPratoButton = new JButton("PT/EN");
        JButton voltarMenuRestAtPratoButton = new JButton("MENU RESTAURANTE");
        JButton confirmarAtPratoButton = new JButton("CONFIRMAR");

        mRestAtPratoSuperPanel.add(norteAtPratoSubPanel, "North");
        mRestAtPratoSuperPanel.add(centroAtPratoSubPanel, "Center");
        mRestAtPratoSuperPanel.add(sulAtPratoSubPanel, "South");

        JPanel norteAtPratoSSPanel = new JPanel();
        norteAtPratoSSPanel.setLayout(new FlowLayout());
        norteAtPratoSSPanel.add(atPratoLabel);
        norteAtPratoSubPanel.add(norteAtPratoSSPanel, BorderLayout.CENTER);
        norteAtPratoSubPanel.add(ptEnAtPratoButton, BorderLayout.EAST);

        JPanel centroAtPratoSSPanelForm = new JPanel();
        centroAtPratoSSPanelForm.setLayout(new GridLayout(3, 2));
        centroAtPratoSubPanel.add(centroAtPratoSSPanelForm);
        //centroAtPratoSSPanelForm.add(atPratoLabel);
        centroAtPratoSSPanelForm.add(atNomePratoLabel);
        centroAtPratoSSPanelForm.add(atNomePratoText);
        centroAtPratoSSPanelForm.add(atDescricaoPratoLabel);
        centroAtPratoSSPanelForm.add(atDescricaoPratoText);
        centroAtPratoSSPanelForm.add(atPrecoPratoLabel);
        centroAtPratoSSPanelForm.add(atPrecoPratoText);

        sulAtPratoSubPanel.setLayout(new FlowLayout());
        sulAtPratoSubPanel.add(voltarMenuRestAtPratoButton);
        sulAtPratoSubPanel.add(confirmarAtPratoButton);


        voltarMenuRestAtPratoButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENURESTAURANTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });
        confirmarAtPratoButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENURESTAURANTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });
    }

    ///////////////////MENU RESTAURANTE - ATUALIZAR DADOS /////////////////////////
    private void construirPanelMRestAtDados(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mRestAtDadosSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteMRestAtDadosSubPanel = new JPanel();
        norteMRestAtDadosSubPanel.setLayout(new BorderLayout());
        JPanel centroMRestAtDadosSubPanel = new JPanel();
        JPanel sulMRestAtDadosSubPanel = new JPanel();

        JLabel atDadosRestLabel = new JLabel("ATUALIZAR DADOS");
        JLabel nomeAtDadosRestLabel = new JLabel("Nome");
        JLabel emailAtDadosRestLabel = new JLabel("E-mail");
        JLabel moradaAtDadosRestLabel = new JLabel("Morada");
        JLabel cidadeAtDadosRestLabel = new JLabel("Cidade");
        JLabel telemovelAtDadosRestLabel = new JLabel("Telemóvel");
///////////////////////
        JLabel lotacaoAtDadosRestLabel = new JLabel("Lotação:");
        JLabel esplanadaAtDadosRestLabel = new JLabel("Esplanada");
        JLabel zonaInteriorAtDadosRestLabel = new JLabel("Zona Interior:");
        JLabel zonaInteriorNFumAtDadosRestLabel = new JLabel("Ñ Fumadores");
        JLabel zonaInteriorFumAtDadosRestLabel = new JLabel("Fumadores");
        JLabel horariosAtDadosRestLabel = new JLabel("Horários:");
        JLabel horariosAlmocoAtDadosRestLabel = new JLabel("Almoço:");
        JLabel horarioAlmocoInicioAtDadosRestLabel = new JLabel("Início");
        JLabel horarioAlmocoFimAtDadosRestLabel = new JLabel("Fim");
        JLabel horariosJantarAtDadosRestLabel = new JLabel("Jantar:");
        JLabel horarioJantarInicioAtDadosRestLabel = new JLabel("Início");
        JLabel horarioJantarFimAtDadosRestLabel = new JLabel("Fim");
        JLabel usernameAtDadosRestLabel = new JLabel("Username");
        JLabel passwordAtDadosRestLabel = new JLabel("Password");
        JLabel confirmarPasswordAtDadosRestLabel = new JLabel("Confirmar password ");

        JTextField nomeAtDadosRestText = new JTextField(18);
        nomeAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField emailAtDadosRestText = new JTextField(18);
        emailAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField moradaAtDadosRestText = new JTextField(20);
        moradaAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField cidadeAtDadosRestText = new JTextField(15);
        cidadeAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField telemovelAtDadosRestText = new JTextField(8);
        telemovelAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        //JTextField lotacaoAtDadosRestText = new JTextField(5);
        JTextField esplanadaAtDadosRestText = new JTextField(3);
        esplanadaAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField zonaInteriorNFumAtDadosRestText = new JTextField(3);
        zonaInteriorNFumAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField zonaInteriorFumAtDadosRestText = new JTextField(3);
        zonaInteriorFumAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField horarioAlmocoInicioAtDadosRestText = new JTextField(3);
        horarioAlmocoInicioAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField horarioAlmocoFimAtDadosRestText = new JTextField(3);
        horarioAlmocoFimAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField horarioJantarInicioAtDadosRestText = new JTextField(3);
        horarioJantarInicioAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField horarioJantarFimAtDadosRestText = new JTextField(3);
        horarioJantarFimAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        ///////
        JTextField usernameAtDadosRestText = new JTextField(20);
        usernameAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        JPasswordField passwordAtDadosRestField = new JPasswordField(15);
        passwordAtDadosRestField.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JPasswordField confirmarPasswordAtDadosRestField = new JPasswordField(15);
        confirmarPasswordAtDadosRestField.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        JButton ptEnAtDadosRestButton = new JButton("PT/EN");
        JButton voltarMenuRestAtDadosRestButton = new JButton("MENU RESTAURANTE");
        JButton atDadosRestButton = new JButton("ATUALIZAR");

        mRestAtDadosSuperPanel.add(norteMRestAtDadosSubPanel, "North");
        mRestAtDadosSuperPanel.add(centroMRestAtDadosSubPanel, "Center");
        mRestAtDadosSuperPanel.add(sulMRestAtDadosSubPanel, "South");

        JPanel norteAtDadosRestSSPanel = new JPanel();
        norteAtDadosRestSSPanel.setLayout(new FlowLayout());
        norteAtDadosRestSSPanel.add(atDadosRestLabel);
        norteMRestAtDadosSubPanel.add(norteAtDadosRestSSPanel, BorderLayout.CENTER);
        norteMRestAtDadosSubPanel.add(ptEnAtDadosRestButton, BorderLayout.EAST);

        JPanel centroAtDadosRestSSPanelForm1 = new JPanel();
        centroAtDadosRestSSPanelForm1.setLayout(new FlowLayout());
        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm1, BorderLayout.WEST);

        JPanel centroAtDadosRestSSPanelForm2 = new JPanel();
        centroAtDadosRestSSPanelForm2.setLayout(new FlowLayout());
        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm2, BorderLayout.WEST);

        JPanel centroAtDadosRestSSPanelForm2A = new JPanel();
        centroAtDadosRestSSPanelForm2A.setLayout(new FlowLayout());
        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm2A, BorderLayout.WEST);

        JPanel centroAtDadosRestSSPanelForm3 = new JPanel();
        //centroAtDadosRestSSPanelForm3.setLayout(new FlowLayout());
        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm3, BorderLayout.WEST);

        JPanel centroAtDadosRestSSPanelForm4 = new JPanel();
        centroAtDadosRestSSPanelForm4.setLayout(new FlowLayout());
        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm4, BorderLayout.WEST);

        JPanel centroAtDadosRestSSPanelForm5 = new JPanel();
        centroAtDadosRestSSPanelForm5.setLayout(new FlowLayout());
        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm5, BorderLayout.WEST);

        JPanel centroAtDadosRestSSPanelForm6 = new JPanel();
        centroAtDadosRestSSPanelForm6.setLayout(new FlowLayout());
        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm6, BorderLayout.WEST);

        centroAtDadosRestSSPanelForm1.add(nomeAtDadosRestLabel);
        centroAtDadosRestSSPanelForm1.add(nomeAtDadosRestText);
        centroAtDadosRestSSPanelForm1.add(emailAtDadosRestLabel);
        centroAtDadosRestSSPanelForm1.add(emailAtDadosRestText);

        centroAtDadosRestSSPanelForm2.add(moradaAtDadosRestLabel);
        centroAtDadosRestSSPanelForm2.add(moradaAtDadosRestText);
        centroAtDadosRestSSPanelForm2A.add(cidadeAtDadosRestLabel);
        centroAtDadosRestSSPanelForm2A.add(cidadeAtDadosRestText);
        centroAtDadosRestSSPanelForm2A.add(telemovelAtDadosRestLabel);
        centroAtDadosRestSSPanelForm2A.add(telemovelAtDadosRestText);

        centroAtDadosRestSSPanelForm3.add(lotacaoAtDadosRestLabel);
        centroAtDadosRestSSPanelForm3.add(esplanadaAtDadosRestLabel);
        centroAtDadosRestSSPanelForm3.add(esplanadaAtDadosRestText);
        centroAtDadosRestSSPanelForm3.add(zonaInteriorAtDadosRestLabel);
        centroAtDadosRestSSPanelForm3.add(zonaInteriorNFumAtDadosRestLabel);
        centroAtDadosRestSSPanelForm3.add(zonaInteriorNFumAtDadosRestText);
        centroAtDadosRestSSPanelForm3.add(zonaInteriorFumAtDadosRestLabel);
        centroAtDadosRestSSPanelForm3.add(zonaInteriorFumAtDadosRestText);


        centroAtDadosRestSSPanelForm4.add(horariosAtDadosRestLabel);
        centroAtDadosRestSSPanelForm4.add(horariosAlmocoAtDadosRestLabel);
        centroAtDadosRestSSPanelForm4.add(horarioAlmocoInicioAtDadosRestLabel);
        centroAtDadosRestSSPanelForm4.add(horarioAlmocoInicioAtDadosRestText);
        centroAtDadosRestSSPanelForm4.add(horarioAlmocoFimAtDadosRestLabel);
        centroAtDadosRestSSPanelForm4.add(horarioAlmocoFimAtDadosRestText);
        centroAtDadosRestSSPanelForm4.add(horariosJantarAtDadosRestLabel);
        centroAtDadosRestSSPanelForm4.add(horarioJantarInicioAtDadosRestLabel);
        centroAtDadosRestSSPanelForm4.add(horarioJantarInicioAtDadosRestText);
        centroAtDadosRestSSPanelForm4.add(horarioJantarFimAtDadosRestLabel);
        centroAtDadosRestSSPanelForm4.add(horarioJantarFimAtDadosRestText);

        centroAtDadosRestSSPanelForm5.add(usernameAtDadosRestLabel);
        centroAtDadosRestSSPanelForm5.add(usernameAtDadosRestText);

        centroAtDadosRestSSPanelForm6.add(passwordAtDadosRestLabel);
        centroAtDadosRestSSPanelForm6.add(passwordAtDadosRestField);
        centroAtDadosRestSSPanelForm6.add(confirmarPasswordAtDadosRestLabel);
        centroAtDadosRestSSPanelForm6.add(confirmarPasswordAtDadosRestField);

        sulMRestAtDadosSubPanel.setLayout(new FlowLayout());
        sulMRestAtDadosSubPanel.add(voltarMenuRestAtDadosRestButton);
        sulMRestAtDadosSubPanel.add(atDadosRestButton);

        voltarMenuRestAtDadosRestButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENURESTAURANTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
        });

        atDadosRestButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENURESTAURANTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });

    }

    //////MENU RESTAURANTE – HISTÓRICO DE RESERVAS//////////
    private void construirPanelMRestReservas(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mRestReservasSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteMRestReservasSubPanel = new JPanel();
        norteMRestReservasSubPanel.setLayout(new BorderLayout());
        JPanel centroMRestReservasSubPanel = new JPanel();
        JPanel sulMRestReservasSubPanel = new JPanel();

        JLabel mRestReservasLabel = new JLabel("HISTÓRICO DE RESERVAS");
        JLabel usernameMRestReservasLabel = new JLabel("Username");
        //JLabel filtrarTipomRestResLabel = new JLabel("Escolha a opção em que a lista será mostrada:");
        JLabel filtrarDataInicioMRestReservasLabel = new JLabel("De");
        JLabel filtrarDataFimMRestReservasLabel = new JLabel("Até");


        JTextField usernameMRestReservasText = new JTextField(20);

        JCheckBox cem = new JCheckBox("Até 100");
        cem.setMnemonic(KeyEvent.VK_C);
        JCheckBox duzentos = new JCheckBox("100-200");
        duzentos.setMnemonic(KeyEvent.VK_C);
        JCheckBox trezentos = new JCheckBox("200-300");
        trezentos.setMnemonic(KeyEvent.VK_C);
        JCheckBox quatrocentos = new JCheckBox("+ de 300");
        quatrocentos.setMnemonic(KeyEvent.VK_C);


        JRadioButton filtrarIntervDatasMRestResRButton = new JRadioButton("DATAS");
        //todo verificar a questão do calendário
        JRadioButton filtrarTipomRestResRButton = new JRadioButton("TIPO");
        JRadioButton filtrarIntervValmRestResRButton = new JRadioButton("VALORES");
        JRadioButton filtrarClientemRestResRButton = new JRadioButton("CLIENTE");

        ButtonGroup group = new ButtonGroup();
        group.add(filtrarIntervDatasMRestResRButton);
        group.add(filtrarTipomRestResRButton);
        group.add(filtrarIntervValmRestResRButton);
        group.add(filtrarClientemRestResRButton);

        JComboBox<String> filtrosTipoMRestReservasJCBox = new JComboBox<>();
        filtrosTipoMRestReservasJCBox.addItem("");
        filtrosTipoMRestReservasJCBox.addItem("Presencial");
        filtrosTipoMRestReservasJCBox.addItem("Take-Away");

        JButton ptEnMRestReservasButton = new JButton("PT/EN");
        JButton voltarMRestReservasButton = new JButton("MENU RESTAURANTE");
        JButton okMRestReservasButton = new JButton("OK");

        //Adição do calendário
        UtilDateModel model1 = new UtilDateModel();
        UtilDateModel model2 = new UtilDateModel();

        ResourceBundle b = ResourceBundle.getBundle("Text");

        Properties p = convertResourceBundleToProperties(b);
        JDatePanelImpl datePanel = new JDatePanelImpl(model1, p);
        JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        JDatePanelImpl datePanel1 = new JDatePanelImpl(model2, p);
        JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());

        mRestReservasSuperPanel.add(norteMRestReservasSubPanel, "North");
        mRestReservasSuperPanel.add(centroMRestReservasSubPanel, "Center");
        mRestReservasSuperPanel.add(sulMRestReservasSubPanel, "South");

        JPanel norteMRestReservasSSPanel = new JPanel();
        norteMRestReservasSSPanel.setLayout(new FlowLayout());
        norteMRestReservasSSPanel.add(mRestReservasLabel);
        norteMRestReservasSubPanel.add(norteMRestReservasSSPanel, BorderLayout.CENTER);
        norteMRestReservasSubPanel.add(ptEnMRestReservasButton, BorderLayout.EAST);

        JPanel centroMRestReservasSSPanel = new JPanel();
        centroMRestReservasSSPanel.setLayout(new FlowLayout());
        centroMRestReservasSubPanel.add(centroMRestReservasSSPanel, BorderLayout.WEST);

        JPanel centroMRestReservasSSPanel1 = new JPanel();
        centroMRestReservasSSPanel1.setLayout(new FlowLayout());
        centroMRestReservasSubPanel.add(centroMRestReservasSSPanel1, BorderLayout.WEST);

        JPanel centroMRestReservasSSPanel2 = new JPanel();
        centroMRestReservasSSPanel2.setLayout(new FlowLayout());
        centroMRestReservasSubPanel.add(centroMRestReservasSSPanel2, BorderLayout.WEST);

        JPanel centroMRestReservasSSPanel2A = new JPanel();
        centroMRestReservasSSPanel2A.setLayout(new GridLayout(1, 1));
        centroMRestReservasSubPanel.add(centroMRestReservasSSPanel2A, BorderLayout.WEST);

        JPanel centroMRestReservasSSPanel3 = new JPanel();
        centroMRestReservasSSPanel3.setLayout(new FlowLayout());
        centroMRestReservasSubPanel.add(centroMRestReservasSSPanel3, BorderLayout.WEST);

        JPanel centroMRestReservasSSPanel4 = new JPanel();
        centroMRestReservasSSPanel4.setLayout(new FlowLayout());
        centroMRestReservasSubPanel.add(centroMRestReservasSSPanel4, BorderLayout.WEST);

        centroMRestReservasSSPanel.add(filtrarIntervDatasMRestResRButton);
        centroMRestReservasSSPanel1.add(filtrarDataInicioMRestReservasLabel);
        centroMRestReservasSSPanel1.add(datePicker1);
        centroMRestReservasSSPanel1.add(filtrarDataFimMRestReservasLabel);
        centroMRestReservasSSPanel1.add(datePicker2);

        centroMRestReservasSSPanel2.add(filtrarTipomRestResRButton);
        centroMRestReservasSSPanel2A.add(filtrosTipoMRestReservasJCBox);

        centroMRestReservasSSPanel3.add(filtrarIntervValmRestResRButton);
        centroMRestReservasSSPanel3.add(cem);
        centroMRestReservasSSPanel3.add(duzentos);
        centroMRestReservasSSPanel3.add(trezentos);
        centroMRestReservasSSPanel3.add(quatrocentos);

        centroMRestReservasSSPanel4.add(filtrarClientemRestResRButton);
        centroMRestReservasSSPanel4.add(usernameMRestReservasLabel);
        centroMRestReservasSSPanel4.add(usernameMRestReservasText);

        sulMRestReservasSubPanel.setLayout(new FlowLayout());
        sulMRestReservasSubPanel.add(voltarMRestReservasButton);
        sulMRestReservasSubPanel.add(okMRestReservasButton);


        voltarMRestReservasButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENURESTAURANTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });

        //todo ver os encaminhamentos
        okMRestReservasButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, LOGIN_CARD);
            this.setSize(500, 180);
        });
    }

    /**
     * Convert ResourceBundle into a Properties object.
     *
     * @param resource a resource bundle to convert.
     * @return Properties a properties version of the resource bundle.
     */
    private static Properties convertResourceBundleToProperties(ResourceBundle resource) {
        Properties properties = new Properties();
        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            properties.put(key, resource.getString(key));
        }
        return properties;
    }


    //////MENU RESTAURANTE – COMENTÁRIOS//////////
    private void construirPanelMRestComentarios(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mRestComentariosSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteMRestComentariosSubPanel = new JPanel();
        norteMRestComentariosSubPanel.setLayout(new BorderLayout());
        JPanel centroMRestComentariosSubPanel = new JPanel();
        JPanel sulMRestComentariosSubPanel = new JPanel();

        JLabel mRestComentariosLabel = new JLabel("COMENTÁRIOS RECEBIDOS");


        String[] nomeColunasMRestComentarios = new String[]{
                "USERNAME", "COMENTÁRIO", "PONTUAÇÃO"
        };

        //todo exemplo a verificar
        Object[][] dados = new Object[][]{
                {"USERNAME", "COMENTÁRIO", "PONTUAÇÃO"},
                {"Nuno", "Muito bom", 4.0},
                {"Manuel", "Excelente", 5.0},
                {"André", "Pouco espaço interno", 3.0},
        };
        //criação da tabela
        JTable tabela = new JTable(dados, nomeColunasMRestComentarios);

        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuItemAdd = new JMenuItem("Responder");

        JButton ptEnMRestReservasButton = new JButton("PT/EN");
        JButton voltarMRestComentariosButton = new JButton("MENU RESTAURANTE");
        JButton responderMRestComentariosButton = new JButton("OK");

        mRestComentariosSuperPanel.add(norteMRestComentariosSubPanel, "North");
        mRestComentariosSuperPanel.add(centroMRestComentariosSubPanel, "Center");
        mRestComentariosSuperPanel.add(sulMRestComentariosSubPanel, "South");

        JPanel norteMRestComentariosSSPanel = new JPanel();
        norteMRestComentariosSSPanel.setLayout(new FlowLayout());
        norteMRestComentariosSSPanel.add(mRestComentariosLabel);
        norteMRestComentariosSubPanel.add(norteMRestComentariosSSPanel, BorderLayout.CENTER);
        norteMRestComentariosSubPanel.add(ptEnMRestReservasButton, BorderLayout.EAST);

        JPanel centroMRestReservasSSPanel1 = new JPanel();
        centroMRestReservasSSPanel1.setLayout(new FlowLayout());
        centroMRestComentariosSubPanel.add(tabela, BorderLayout.WEST);

        sulMRestComentariosSubPanel.setLayout(new FlowLayout());
        sulMRestComentariosSubPanel.add(voltarMRestComentariosButton);
        sulMRestComentariosSubPanel.add(responderMRestComentariosButton);


        voltarMRestComentariosButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENURESTAURANTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });

        //todo ver os encaminhamentos para responder comentário
        responderMRestComentariosButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, LOGIN_CARD);
            this.setSize(500, 180);
        });

    }

    //todo mudar linha pontuação e aparecer nome das colunas na tabela, permitir de possa comentar/pontuar uma reserva(Comentar um restaurante e atribuir pontuação)
    //////MENU RESTAURANTE – LISTAR RESTAURANTES//////////
    private void construirPanelMCliRestaurantes(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliRestSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteMCliRestSubPanel = new JPanel();
        norteMCliRestSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliRestSubPanel = new JPanel();
        JPanel sulMCliRestSubPanel = new JPanel();


        //JLabel fTipomRestResLabel = new JLabel("Escolha a opção em que a lista será mostrada:");


        JCheckBox um = new JCheckBox("1");
        um.setMnemonic(KeyEvent.VK_C);
        JCheckBox dois = new JCheckBox("2");
        dois.setMnemonic(KeyEvent.VK_C);
        JCheckBox tres = new JCheckBox("3");
        tres.setMnemonic(KeyEvent.VK_C);
        JCheckBox quatro = new JCheckBox("4");
        quatro.setMnemonic(KeyEvent.VK_C);
        JCheckBox cinco = new JCheckBox("5");
        cinco.setMnemonic(KeyEvent.VK_C);

        JCheckBox dez = new JCheckBox(">10€");
        um.setMnemonic(KeyEvent.VK_C);
        JCheckBox dezVinte = new JCheckBox("10€-20€");
        dois.setMnemonic(KeyEvent.VK_C);
        JCheckBox vinteTrinta = new JCheckBox("20€-30€");
        tres.setMnemonic(KeyEvent.VK_C);
        JCheckBox trintaQuarenta = new JCheckBox("30€-40€");
        quatro.setMnemonic(KeyEvent.VK_C);
        JCheckBox quarenta = new JCheckBox("<40€");
        cinco.setMnemonic(KeyEvent.VK_C);


        JLabel mCliRestLabel = new JLabel("PESQUISAR RESTAURANTES");
        JLabel fDataMCliRestLabel = new JLabel("DATA");
        JLabel fhoraFMCliRestLabel = new JLabel("HORA DE FUNCIONAMENTO:");
        JLabel fvaloresMedCPMCliRestLabel = new JLabel("VALORES MÉDIOS DOS PRATOS:");
        JLabel fPontMCliRestLabel = new JLabel("PONTUAÇÃO:");
        JLabel fLotMCliRestLabel = new JLabel("LOTAÇÃO:");
        JLabel fCidMCliRestLabel = new JLabel("CIDADE:");

        JRadioButton fvaloresMCMCliRestRButton = new JRadioButton("CARTA");
        JRadioButton fvaloresMPMCliRestRButton = new JRadioButton("PRATOS DO DIA");

        ButtonGroup group = new ButtonGroup();
        group.add(fvaloresMCMCliRestRButton);
        group.add(fvaloresMPMCliRestRButton);

        JComboBox<String> fHoraFMCliRestJCBox = new JComboBox<>();
        fHoraFMCliRestJCBox.addItem("");
        fHoraFMCliRestJCBox.addItem("Almoço");
        fHoraFMCliRestJCBox.addItem("Jantar");
        fHoraFMCliRestJCBox.addItem("Ambos");


        //todo verificar porque não deu certo
        JComboBox fLotCliRestJCBox = new JComboBox();
        for (int i = 1; i <= 50; i++) {
            fLotCliRestJCBox.addItem(i);
        }

        JComboBox fCidMCliRestJCBox = new JComboBox();
        fCidMCliRestJCBox.addItem("");
        fCidMCliRestJCBox.addItem("Coimbra");
        fCidMCliRestJCBox.addItem("Porto");
        fCidMCliRestJCBox.addItem("Lisboa");

        JButton ptEnMCliRestButton = new JButton("PT/EN");
        JButton voltarMCliRestButton = new JButton("MENU CLIENTE");
        JButton okMCliRestButton = new JButton("OK");

        //todo exemplo a verificar
        String[] nomeColunasMCliRest = new String[]{
                "ZONA", "TOTAL", "DISPONÍVEIS"
        };

        Object[][] dados = new Object[][]{
                {"ZONA", "TOTAL", "DISPONÍVEIS"},
                {"Esplanada", 20, 5},
                {"Interior Ñ Fumadores", 20, 10},
                {"Interior Fumadores", 5, 2},
        };
        //criação da tabela
        JTable tabelaMCliRest = new JTable(dados, nomeColunasMCliRest);


//Calendário
        UtilDateModel model3 = new UtilDateModel();

        ResourceBundle b = ResourceBundle.getBundle("Text");

        Properties p = convertResourceBundleToProperties(b);
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model3, p);
        JDatePickerImpl datePicker3 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());


        mCliRestSuperPanel.add(norteMCliRestSubPanel, "North");
        mCliRestSuperPanel.add(centroMCliRestSubPanel, "Center");
        mCliRestSuperPanel.add(sulMCliRestSubPanel, "South");

        JPanel norteMCliRestSSPanel = new JPanel();
        norteMCliRestSSPanel.setLayout(new FlowLayout());
        norteMCliRestSSPanel.add(mCliRestLabel);
        norteMCliRestSubPanel.add(norteMCliRestSSPanel, BorderLayout.CENTER);
        norteMCliRestSubPanel.add(ptEnMCliRestButton, BorderLayout.EAST);

        JPanel centroMCliRestSSPanel = new JPanel();
        centroMCliRestSSPanel.setLayout(new GridLayout(1, 2));
        centroMCliRestSubPanel.add(centroMCliRestSSPanel);

        JPanel centroMCliRestSSPanel1 = new JPanel();
        centroMCliRestSSPanel1.setLayout(new GridBagLayout());
        centroMCliRestSubPanel.add(centroMCliRestSSPanel1);

        JPanel centroMCliRestSSPanel2 = new JPanel();
        centroMCliRestSSPanel2.setLayout(new GridBagLayout());
        centroMCliRestSubPanel.add(centroMCliRestSSPanel2);

        JPanel centroMCliRestSSPanel3 = new JPanel();
        centroMCliRestSSPanel3.setLayout(new GridBagLayout());
        centroMCliRestSubPanel.add(centroMCliRestSSPanel3);

        JPanel centroMCliRestSSPanel4 = new JPanel();
        centroMCliRestSSPanel4.setLayout(new BorderLayout());
        centroMCliRestSubPanel.add(centroMCliRestSSPanel4, BorderLayout.CENTER);

        JPanel centroMCliRestSSPanel5 = new JPanel();
        centroMCliRestSSPanel5.setLayout(new GridBagLayout());
        centroMCliRestSubPanel.add(centroMCliRestSSPanel5);

        JPanel centroMCliRestSSPanel6 = new JPanel();
        centroMCliRestSSPanel6.setLayout(new GridBagLayout());
        centroMCliRestSubPanel.add(centroMCliRestSSPanel6);

        JPanel centroMCliRestSSPanel7 = new JPanel();
        centroMCliRestSSPanel7.setLayout(new GridBagLayout());
        centroMCliRestSubPanel.add(centroMCliRestSSPanel7);

        centroMCliRestSSPanel.add(fhoraFMCliRestLabel);
        centroMCliRestSSPanel1.add(fDataMCliRestLabel);
        centroMCliRestSSPanel1.add(datePicker3);
        centroMCliRestSSPanel1.add(fHoraFMCliRestJCBox);

        centroMCliRestSSPanel2.add(fvaloresMedCPMCliRestLabel);
        centroMCliRestSSPanel2.add(fvaloresMCMCliRestRButton);
        centroMCliRestSSPanel2.add(fvaloresMPMCliRestRButton);
        centroMCliRestSSPanel3.add(dez);
        centroMCliRestSSPanel3.add(dezVinte);
        centroMCliRestSSPanel3.add(vinteTrinta);
        centroMCliRestSSPanel3.add(trintaQuarenta);
        centroMCliRestSSPanel3.add(quarenta);

        centroMCliRestSSPanel4.add(fPontMCliRestLabel);
        centroMCliRestSSPanel5.add(um);
        centroMCliRestSSPanel5.add(dois);
        centroMCliRestSSPanel5.add(tres);
        centroMCliRestSSPanel5.add(quatro);
        centroMCliRestSSPanel5.add(cinco);

        centroMCliRestSSPanel6.add(fLotMCliRestLabel);
        centroMCliRestSSPanel6.add(tabelaMCliRest);

        centroMCliRestSSPanel7.add(fCidMCliRestLabel);
        centroMCliRestSSPanel7.add(fCidMCliRestJCBox);

        sulMCliRestSubPanel.setLayout(new FlowLayout());
        sulMCliRestSubPanel.add(voltarMCliRestButton);
        sulMCliRestSubPanel.add(okMCliRestButton);


        voltarMCliRestButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENUCLIENTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });

        //todo ver os encaminhamentos
        okMCliRestButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, LOGIN_CARD);
            this.setSize(500, 180);
        });
    }
    //todo ver como criar o apagar e editar comentário na seleção da tabela e ver a questão do OK
    //////MENU CLIENTE – CONSULTAR COMENTÁRIOS//////////

    private void construirPanelMCliComentarios(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliComSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteMCliComSubPanel = new JPanel();
        norteMCliComSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliComSubPanel = new JPanel();
        JPanel sulMCliComSubPanel = new JPanel();

        JLabel mCliFilComLabel = new JLabel("CONSULTAR COMENTÁRIOS:");

        JLabel mCliFComLabel = new JLabel("PRÓPRIOS");
        JLabel mCliFComCliLabel = new JLabel("CLIENTE");
        JLabel mCliFComRestLabel = new JLabel("RESTAURANTE");
        JLabel mCliFComDatasLabel = new JLabel("INTERVALO DATAS");
        JLabel mCliFComDataILabel = new JLabel("De");
        JLabel mCliFComDataFLabel = new JLabel("Até");

//todo faltou visualizar
        String[] nomeColunasMCliCom = new String[]{
                "DATA", "RESTAURNATE"
        };

        Object[][] data = new Object[][]{
                {"DATA", "RESTAURANTE"},
                {"dd/MM/yyy", "A"},
                {"dd/MM/yyy", "B"},
                {"dd/MM/yyy", "C"},
        };
        //criação da tabela
        JTable tabelaMCliFCom = new JTable(data, nomeColunasMCliCom);

        //JPopupMenu popupMenu = new JPopupMenu();
        //JMenuItem menuItemAdd = new JMenuItem("Responder");

        JTextField mCliFComCliText = new JTextField(17);
        JTextField mCliFComRestText = new JTextField(17);

//Adição do calendário
        UtilDateModel model4 = new UtilDateModel();
        UtilDateModel model5 = new UtilDateModel();

        ResourceBundle b = ResourceBundle.getBundle("Text");

        Properties p = convertResourceBundleToProperties(b);
        JDatePanelImpl datePanel3 = new JDatePanelImpl(model4, p);
        JDatePickerImpl datePicker4 = new JDatePickerImpl(datePanel3, new DateLabelFormatter());
        JDatePanelImpl datePanel4 = new JDatePanelImpl(model5, p);
        JDatePickerImpl datePicker5 = new JDatePickerImpl(datePanel4, new DateLabelFormatter());


        JButton ptEnMCliRestButton = new JButton("PT/EN");
        JButton voltarMCliComButton = new JButton("MENU CLIENTE");
        JButton okMCliComButton = new JButton("OK");

        mCliComSuperPanel.add(norteMCliComSubPanel, "North");
        mCliComSuperPanel.add(centroMCliComSubPanel, "Center");
        mCliComSuperPanel.add(sulMCliComSubPanel, "South");

        JPanel norteMCliComSSPanel = new JPanel();
        norteMCliComSSPanel.setLayout(new FlowLayout());
        norteMCliComSSPanel.add(mCliFilComLabel);
        norteMCliComSubPanel.add(norteMCliComSSPanel, BorderLayout.CENTER);
        norteMCliComSubPanel.add(ptEnMCliRestButton, BorderLayout.EAST);

        JPanel centroMCliComSSPanel = new JPanel();
        centroMCliComSSPanel.setLayout(new FlowLayout());
        centroMCliComSubPanel.add(centroMCliComSSPanel, BorderLayout.WEST);

        JPanel centroMCliComSSPanel1 = new JPanel();
        centroMCliComSSPanel1.setLayout(new FlowLayout());
        centroMCliComSubPanel.add(centroMCliComSSPanel1, BorderLayout.WEST);

        JPanel centroMCliComSSPanel2 = new JPanel();
        centroMCliComSSPanel2.setLayout(new FlowLayout());
        centroMCliComSubPanel.add(centroMCliComSSPanel2, BorderLayout.WEST);

        JPanel centroMCliComSSPanel3 = new JPanel();
        centroMCliComSSPanel3.setLayout(new FlowLayout());
        centroMCliComSubPanel.add(centroMCliComSSPanel3, BorderLayout.WEST);

        JPanel centroMCliComSSPanel4 = new JPanel();
        centroMCliComSSPanel4.setLayout(new FlowLayout());
        centroMCliComSubPanel.add(centroMCliComSSPanel4, BorderLayout.CENTER);

        centroMCliComSSPanel.add(mCliFComLabel);
        centroMCliComSSPanel.add(tabelaMCliFCom);

        centroMCliComSSPanel1.add(mCliFComCliLabel);
        centroMCliComSSPanel1.add(mCliFComCliText);

        centroMCliComSSPanel1.add(mCliFComRestLabel);
        centroMCliComSSPanel1.add(mCliFComRestText);

        centroMCliComSSPanel2.add(mCliFComDatasLabel);
        centroMCliComSSPanel3.add(mCliFComDataILabel);
        centroMCliComSSPanel3.add(datePicker4);
        centroMCliComSSPanel3.add(mCliFComDataFLabel);
        centroMCliComSSPanel3.add(datePicker5);

        sulMCliComSubPanel.setLayout(new FlowLayout());
        sulMCliComSubPanel.add(voltarMCliComButton);
        sulMCliComSubPanel.add(okMCliComButton);


        voltarMCliComButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENUCLIENTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });

        //todo ver os encaminhamentos para responder comentário
        okMCliComButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, LOGIN_CARD);
            this.setSize(500, 180);
        });

    }

    ////////////////////MENU CLIENTE - ATUALIZAR DADOS /////////////////////////
    private void construirPanelMCliAtDados(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliAtDadosSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteAtDadosMCliSubPanel = new JPanel();
        norteAtDadosMCliSubPanel.setLayout(new BorderLayout());
        JPanel centroAtDadosMCliSubPanel = new JPanel();
        JPanel sulAtDadosMCliSubPanel = new JPanel();

        JLabel atDadosMCliLabel = new JLabel("ATUALIZAR DADOS");
        atDadosMCliLabel.setForeground(Color.BLUE);
        JLabel nomeCliMCliLabel = new JLabel("Nome");
        //nomeCliMCliLabel.setBounds(50,80,100,20);
        JLabel emailCliMCliLabel = new JLabel("E-mail");
        JLabel moradaCliMCliLabel = new JLabel("Morada");
        JLabel telemovelCliMCliLabel = new JLabel("Telemóvel");
        JLabel usernameCliMCliLabel = new JLabel("Username");
        JLabel passwordCliMCliLabel = new JLabel("Password");
        JLabel confirmarPasswordCliMCliLabel = new JLabel("Confirmar password: ");

        JTextField nomeCliMCliText = new JTextField(20);
        nomeCliMCliText.setMargin(new Insets(3, 3, 3, 3));
        JTextField emailCliMCliText = new JTextField(20);
        JTextField moradaCliMCliText = new JTextField(20);
        JTextField telemovelCliMCliText = new JTextField(20);
        JTextField usernameCliMCliText = new JTextField(20);

        JPasswordField passwordCliMCliField = new JPasswordField(20);
        JPasswordField confirmarPassawordCliMCliField = new JPasswordField(20);

        JButton ptEnAtDadosMCliButton = new JButton("PT/EN");
        JButton voltarCliMCliButton = new JButton("MENU CLIENTE");
        JButton atualizarCliMCliButton = new JButton("ATUALIZAR");

        mCliAtDadosSuperPanel.add(norteAtDadosMCliSubPanel, "North");
        mCliAtDadosSuperPanel.add(centroAtDadosMCliSubPanel, "Center");
        mCliAtDadosSuperPanel.add(sulAtDadosMCliSubPanel, "South");

        JPanel norteAtDadosMCliSSPanel = new JPanel();
        norteAtDadosMCliSSPanel.setLayout(new FlowLayout());
        norteAtDadosMCliSSPanel.add(atDadosMCliLabel);
        norteAtDadosMCliSubPanel.add(norteAtDadosMCliSSPanel, BorderLayout.CENTER);
        norteAtDadosMCliSubPanel.add(ptEnAtDadosMCliButton, BorderLayout.EAST);

        JPanel centroAtDadosMCliSSPanel = new JPanel();
        centroAtDadosMCliSSPanel.setLayout(new GridLayout(7, 2));
        centroAtDadosMCliSubPanel.add(centroAtDadosMCliSSPanel);
        centroAtDadosMCliSSPanel.add(nomeCliMCliLabel);
        centroAtDadosMCliSSPanel.add(nomeCliMCliText);
        centroAtDadosMCliSSPanel.add(emailCliMCliLabel);
        centroAtDadosMCliSSPanel.add(emailCliMCliText);
        centroAtDadosMCliSSPanel.add(moradaCliMCliLabel);
        centroAtDadosMCliSSPanel.add(moradaCliMCliText);
        centroAtDadosMCliSSPanel.add(telemovelCliMCliLabel);
        centroAtDadosMCliSSPanel.add(telemovelCliMCliText);
        centroAtDadosMCliSSPanel.add(usernameCliMCliLabel);
        centroAtDadosMCliSSPanel.add(usernameCliMCliText);
        centroAtDadosMCliSSPanel.add(passwordCliMCliLabel);
        centroAtDadosMCliSSPanel.add(passwordCliMCliField);
        centroAtDadosMCliSSPanel.add(confirmarPasswordCliMCliLabel);
        centroAtDadosMCliSSPanel.add(confirmarPassawordCliMCliField);

        sulAtDadosMCliSubPanel.setLayout(new FlowLayout());
        sulAtDadosMCliSubPanel.add(voltarCliMCliButton);
        sulAtDadosMCliSubPanel.add(atualizarCliMCliButton);


        atualizarCliMCliButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENUCLIENTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
        });

        voltarCliMCliButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, LOGIN_CARD);
            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
        });
    }

    //////MENU CLIENTE – RESERVAS - HISTÓRICO//////////

    private void construirPanelMCliHistRes(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliHistResSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteMCliHistResSubPanel = new JPanel();
        norteMCliHistResSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliHistResSubPanel = new JPanel();
        JPanel sulMCliHistResSubPanel = new JPanel();

        JLabel mCliTitHistResLabel = new JLabel("VISUALIZAR HISTÓRICO DE RESERVAS:");


//todo faltou visualizar – aumentar tamanho da coluna e tornar possível seleção para visualizar, comentar e pontuar
        String[] nomeColunasMCliHistRes = new String[]{
                "DATA", "RESTAURANTE"
        };

        Object[][] data = new Object[][]{
                {"DATA", "RESTAURANTE"},
                {"dd/MM/yyy", "A"},
                {"dd/MM/yyy", "B"},
                {"dd/MM/yyy", "C"},
        };
        //criação da tabela
        JTable tabelaMCliHistRes = new JTable(data, nomeColunasMCliHistRes);

        JButton ptEnMCliRestButton = new JButton("PT/EN");
        JButton voltarMCliHistResButton = new JButton("MENU CLIENTE");

        mCliHistResSuperPanel.add(norteMCliHistResSubPanel, "North");
        mCliHistResSuperPanel.add(centroMCliHistResSubPanel, "Center");
        mCliHistResSuperPanel.add(sulMCliHistResSubPanel, "South");

        JPanel norteMCliHistResSSPanel = new JPanel();
        norteMCliHistResSSPanel.setLayout(new FlowLayout());
        norteMCliHistResSSPanel.add(mCliTitHistResLabel);
        norteMCliHistResSubPanel.add(norteMCliHistResSSPanel, BorderLayout.CENTER);
        norteMCliHistResSubPanel.add(ptEnMCliRestButton, BorderLayout.EAST);

        JPanel centroMCliHistResSSPanel = new JPanel();
        centroMCliHistResSSPanel.setLayout(new FlowLayout());
        centroMCliHistResSubPanel.add(centroMCliHistResSSPanel, BorderLayout.WEST);


        centroMCliHistResSSPanel.add(tabelaMCliHistRes);

        sulMCliHistResSubPanel.setLayout(new FlowLayout());
        sulMCliHistResSubPanel.add(voltarMCliHistResButton);


        voltarMCliHistResButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENUCLIENTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });
    }

    //////MENU CLIENTE – RESERVAS - ACTIVAS//////////

    private void construirPanelMCliResAct(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliResActSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteMCliResActSubPanel = new JPanel();
        norteMCliResActSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliResActSubPanel = new JPanel();
        JPanel sulMCliResActSubPanel = new JPanel();

        JLabel mCliTitHistResLabel = new JLabel("VISUALIZAR RESERVAS ACTIVAS:");


//todo faltou visualizar – aumentar tamanho da coluna e tornar possível seleção para visualizar, editar e cancelar
        String[] nomeColunasMCliResAct = new String[]{
                "DATA", "RESTAURNATE"
        };

        Object[][] dados = new Object[][]{
                {"DATA", "RESTAURANTE"},
                {"dd/MM/yyy", "A"},
                {"dd/MM/yyy", "B"},
                {"dd/MM/yyy", "C"},
        };
        //criação da tabela
        JTable tabelaMCliResAct = new JTable(dados, nomeColunasMCliResAct);

        JButton ptEnMCliRestButton = new JButton("PT/EN");
        JButton voltarMCliResActButton = new JButton("MENU CLIENTE");

        mCliResActSuperPanel.add(norteMCliResActSubPanel, "North");
        mCliResActSuperPanel.add(centroMCliResActSubPanel, "Center");
        mCliResActSuperPanel.add(sulMCliResActSubPanel, "South");

        JPanel norteMCliResActSSPanel = new JPanel();
        norteMCliResActSSPanel.setLayout(new FlowLayout());
        norteMCliResActSSPanel.add(mCliTitHistResLabel);
        norteMCliResActSubPanel.add(norteMCliResActSSPanel, BorderLayout.CENTER);
        norteMCliResActSubPanel.add(ptEnMCliRestButton, BorderLayout.EAST);

        JPanel centroMCliResActSSPanel = new JPanel();
        centroMCliResActSSPanel.setLayout(new FlowLayout());
        centroMCliResActSubPanel.add(centroMCliResActSSPanel, BorderLayout.WEST);

        centroMCliResActSSPanel.add(tabelaMCliResAct);

        sulMCliResActSubPanel.setLayout(new FlowLayout());
        sulMCliResActSubPanel.add(voltarMCliResActButton);

        voltarMCliResActButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENUCLIENTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });
    }

    //////MENU CLIENTE – FAZER RESERVAS//////////
    private void construirPanelMCliFazerRes(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliFazerResSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteMCliFResSubPanel = new JPanel();
        norteMCliFResSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliFResSubPanel = new JPanel();
        JPanel sulMCliFResSubPanel = new JPanel();

        JLabel mCliTitFResLabel = new JLabel("FAZER RESERVAS");
        JLabel tipoResMCliFResLabel = new JLabel("TIPO DE RESERVA:");
        JLabel nomeResMCliFResLabel = new JLabel("RESTAURANTE:");
//        JLabel diaMCliFResLabel = new JLabel("DIA");
//        JLabel horaMCliFResLabel = new JLabel("HORA");
//        JLabel horaDeMCliFResLabel = new JLabel("De");
//        JLabel horaAteMCliFResLabel = new JLabel("Até");
//        JLabel qtdePessoasMCliFResLabel = new JLabel("QUANTIDADE DE PESSOAS");
//        JLabel msgMCliFResLabel = new JLabel("Contatar diretamente o restaurante no caso de reservas para mais de 20 pessoas");
//        JLabel qtdePratosMCliFResLabel = new JLabel("QUANTIDADE");
//        JLabel pratosMCliFResLabel = new JLabel("PRATOS");
//

        JTextField nomeResMCliFResText = new JTextField(20);


        JRadioButton presencialMCliFResRButton = new JRadioButton("PRESENCIAL");
        JRadioButton takeAwayMCliFResRButton = new JRadioButton("TAKE-AWAY");

        ButtonGroup group = new ButtonGroup();
        group.add(presencialMCliFResRButton);
        group.add(takeAwayMCliFResRButton);


//        JComboBox horaDeMCliFResCBox = new JComboBox();
//        horaDeMCliFResCBox.addItem("");
//        horaDeMCliFResCBox.addItem("11h");
//        horaDeMCliFResCBox.addItem("11h30");
//        horaDeMCliFResCBox.addItem("12h");
//        horaDeMCliFResCBox.addItem("12h30");
//        horaDeMCliFResCBox.addItem("13h");
//        horaDeMCliFResCBox.addItem("13h30");
//        horaDeMCliFResCBox.addItem("14h");
//
//
//        JComboBox horaAteMCliFResCBox = new JComboBox();
//        horaAteMCliFResCBox.addItem("");
//        horaAteMCliFResCBox.addItem("12h");
//        horaAteMCliFResCBox.addItem("12h30");
//        horaAteMCliFResCBox.addItem("13h");
//        horaAteMCliFResCBox.addItem("13h30");
//        horaAteMCliFResCBox.addItem("14h");
//        horaAteMCliFResCBox.addItem("14h30");
//        horaAteMCliFResCBox.addItem("15h");
//        horaAteMCliFResCBox.addItem("15h30");
//
//
//        JComboBox qtdePessoasMCliFResCBox = new JComboBox();
//        qtdePessoasMCliFResCBox.addItem("");
//        qtdePessoasMCliFResCBox.addItem("1");
//        qtdePessoasMCliFResCBox.addItem("2");
//        qtdePessoasMCliFResCBox.addItem("3");
//        qtdePessoasMCliFResCBox.addItem("4");
//        qtdePessoasMCliFResCBox.addItem("5");
//        qtdePessoasMCliFResCBox.addItem("6");
//        qtdePessoasMCliFResCBox.addItem("7");
//        qtdePessoasMCliFResCBox.addItem("8");
//        qtdePessoasMCliFResCBox.addItem("9");
//        qtdePessoasMCliFResCBox.addItem("10");
//        qtdePessoasMCliFResCBox.addItem("11");
//        qtdePessoasMCliFResCBox.addItem("12");
//        qtdePessoasMCliFResCBox.addItem("13");
//        qtdePessoasMCliFResCBox.addItem("14");
//        qtdePessoasMCliFResCBox.addItem("15");
//        qtdePessoasMCliFResCBox.addItem("16");
//        qtdePessoasMCliFResCBox.addItem("17");
//        qtdePessoasMCliFResCBox.addItem("18");
//        qtdePessoasMCliFResCBox.addItem("19");
//        qtdePessoasMCliFResCBox.addItem("20");
//
//
//        JComboBox qtdePratosMCliFResCBox = new JComboBox();
//        qtdePratosMCliFResCBox.addItem("");
//        qtdePratosMCliFResCBox.addItem("1");
//        qtdePratosMCliFResCBox.addItem("2");
//        qtdePratosMCliFResCBox.addItem("3");
//        qtdePratosMCliFResCBox.addItem("4");
//        qtdePratosMCliFResCBox.addItem("5");
//        qtdePratosMCliFResCBox.addItem("6");
//        qtdePratosMCliFResCBox.addItem("7");
//        qtdePratosMCliFResCBox.addItem("8");
//        qtdePratosMCliFResCBox.addItem("9");
//        qtdePratosMCliFResCBox.addItem("10");
//        qtdePratosMCliFResCBox.addItem("11");
//        qtdePratosMCliFResCBox.addItem("12");
//        qtdePratosMCliFResCBox.addItem("13");
//        qtdePratosMCliFResCBox.addItem("14");
//        qtdePratosMCliFResCBox.addItem("15");
//        qtdePratosMCliFResCBox.addItem("16");
//        qtdePratosMCliFResCBox.addItem("17");
//        qtdePratosMCliFResCBox.addItem("18");
//        qtdePratosMCliFResCBox.addItem("19");
//        qtdePratosMCliFResCBox.addItem("20");
//
//
////todo possibilitar que o prato possa ser selecionado
//        String[] nomeColunasMCliFRes = new String[]{
//                "NOME", "DESCRIÇÃO", "PREÇO", "TIPO"
//        };
//
//        Object[][] dados = new Object[][]{
//                {"NOME", "DESCRIÇÃO", "PREÇO", "TIPO"},
//                {"Sardinha", "Assada", "15.0", "Carta"},
//                {"Peru", "Ensopado", "15.0", "Prato do Dia"},
//                {"Bifana", "Frita", "15.0", "Carta"},
//
//        };
//        //criação da tabela
//        JTable tabelaMCliFRes = new JTable(dados, nomeColunasMCliFRes);

        JButton ptEnMCliFResButton = new JButton("PT/EN");
        JButton voltarMCliFResButton = new JButton("MENU CLIENTE");
        JButton confirmarMCliFResButton = new JButton("OK");

//        //Adição do calendário
//        UtilDateModel model1 = new UtilDateModel();
//        UtilDateModel model6 = new UtilDateModel();
//
//        ResourceBundle b = ResourceBundle.getBundle("Text");
//
//        Properties p = convertResourceBundleToProperties(b);
//        JDatePanelImpl datePanel5 = new JDatePanelImpl(model6, p);
//        JDatePickerImpl datePicker6 = new JDatePickerImpl(datePanel5, new DateLabelFormatter());
//

        mCliFazerResSuperPanel.add(norteMCliFResSubPanel, "North");
        mCliFazerResSuperPanel.add(centroMCliFResSubPanel, "Center");
        mCliFazerResSuperPanel.add(sulMCliFResSubPanel, "South");

        JPanel norteMCliFResSSPanel = new JPanel();
        norteMCliFResSSPanel.setLayout(new FlowLayout());
        norteMCliFResSSPanel.add(mCliTitFResLabel);
        norteMCliFResSubPanel.add(norteMCliFResSSPanel, BorderLayout.CENTER);
        norteMCliFResSubPanel.add(ptEnMCliFResButton, BorderLayout.EAST);

        JPanel centroMCliFResSSPanel = new JPanel();
        centroMCliFResSSPanel.setLayout(new FlowLayout());
        centroMCliFResSubPanel.add(centroMCliFResSSPanel, BorderLayout.WEST);

        JPanel centroMCliFResSSPanel1 = new JPanel();
        centroMCliFResSSPanel1.setLayout(new FlowLayout());
        centroMCliFResSubPanel.add(centroMCliFResSSPanel1, BorderLayout.WEST);

        JPanel centroMCliFResSSPanel2 = new JPanel();
        centroMCliFResSSPanel2.setLayout(new FlowLayout());
        centroMCliFResSubPanel.add(centroMCliFResSSPanel2, BorderLayout.WEST);

//        JPanel centroMCliFResSSPanel3 = new JPanel();
//        centroMCliFResSSPanel3.setLayout(new GridLayout(1, 1));
//        centroMCliFResSubPanel.add(centroMCliFResSSPanel3, BorderLayout.WEST);
//
//        JPanel centroMCliFResSSPanel4 = new JPanel();
//        centroMCliFResSSPanel4.setLayout(new FlowLayout());
//        centroMCliFResSubPanel.add(centroMCliFResSSPanel4, BorderLayout.WEST);
//
//        JPanel centroMCliFResSSPanel5 = new JPanel();
//        centroMCliFResSSPanel5.setLayout(new FlowLayout());
//        centroMCliFResSubPanel.add(centroMCliFResSSPanel5, BorderLayout.WEST);
//
//        JPanel centroMCliFResSSPanel6 = new JPanel();
//        centroMCliFResSSPanel6.setLayout(new FlowLayout());
//        centroMCliFResSubPanel.add(centroMCliFResSSPanel6, BorderLayout.WEST);
//
//        JPanel centroMCliFResSSPanel7 = new JPanel();
//        centroMCliFResSSPanel7.setLayout(new FlowLayout());
//        centroMCliFResSubPanel.add(centroMCliFResSSPanel7, BorderLayout.WEST);

        centroMCliFResSSPanel.add(tipoResMCliFResLabel);
        centroMCliFResSSPanel1.add(presencialMCliFResRButton);
        centroMCliFResSSPanel1.add(takeAwayMCliFResRButton);
        centroMCliFResSSPanel2.add(nomeResMCliFResLabel);
        centroMCliFResSSPanel2.add(nomeResMCliFResText);

//        centroMCliFResSSPanel3.add(diaMCliFResLabel);
//        centroMCliFResSSPanel3.add(datePicker6);
//
//        centroMCliFResSSPanel3.add(horaMCliFResLabel);
//        centroMCliFResSSPanel3.add(horaDeMCliFResLabel);
//        centroMCliFResSSPanel3.add(horaDeMCliFResCBox);
//        centroMCliFResSSPanel3.add(horaAteMCliFResLabel);
//        centroMCliFResSSPanel3.add(horaAteMCliFResCBox);
//        centroMCliFResSSPanel4.add(qtdePessoasMCliFResLabel);
//
//        centroMCliFResSSPanel4.add(qtdePessoasMCliFResCBox);
//        centroMCliFResSSPanel7.add(msgMCliFResLabel);
//        centroMCliFResSSPanel5.add(pratosMCliFResLabel);
//        centroMCliFResSSPanel5.add(tabelaMCliFRes);
//        centroMCliFResSSPanel6.add(qtdePratosMCliFResLabel);
//        centroMCliFResSSPanel6.add(qtdePratosMCliFResCBox);

        sulMCliFResSubPanel.setLayout(new FlowLayout());
        sulMCliFResSubPanel.add(voltarMCliFResButton);
        sulMCliFResSubPanel.add(confirmarMCliFResButton);

        presencialMCliFResRButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MCLIFAZERRESP_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
        });

        takeAwayMCliFResRButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MCLIFAZERRESTA_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
        });


        voltarMCliFResButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENUCLIENTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
        });

        //todo ver os encaminhamentos
        confirmarMCliFResButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, LOGIN_CARD);
            this.setSize(500, 180);
        });
    }

    //////MENU CLIENTE – FAZER RESERVA TAKE-AWAY//////////
    private void construirPanelMCliFazerResTA(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliFazerResTASuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteMCliFResTASubPanel = new JPanel();
        norteMCliFResTASubPanel.setLayout(new BorderLayout());
        JPanel centroMCliFResTASubPanel = new JPanel();
        JPanel sulMCliFResTASubPanel = new JPanel();

        JLabel mCliTitFResTALabel = new JLabel("FAZER RESERVAS TAKE-AWAY");
        JLabel horaMCliFResTALabel = new JLabel("HORA");
        JLabel horaDeMCliFResTALabel = new JLabel("De");
        JLabel horaAteMCliFResTALabel = new JLabel("Até");

        JLabel qtdePratosMCliFResTALabel = new JLabel("QUANTIDADE");
        JLabel pratosMCliFResTALabel = new JLabel("PRATOS");

        JComboBox horaDeMCliFResTACBox = new JComboBox();
        horaDeMCliFResTACBox.addItem("");
        horaDeMCliFResTACBox.addItem("11h");
        horaDeMCliFResTACBox.addItem("11h30");
        horaDeMCliFResTACBox.addItem("12h");
        horaDeMCliFResTACBox.addItem("12h30");
        horaDeMCliFResTACBox.addItem("13h");
        horaDeMCliFResTACBox.addItem("13h30");
        horaDeMCliFResTACBox.addItem("14h");

        JComboBox horaAteMCliFResTACBox = new JComboBox();
        horaAteMCliFResTACBox.addItem("");
        horaAteMCliFResTACBox.addItem("12h");
        horaAteMCliFResTACBox.addItem("12h30");
        horaAteMCliFResTACBox.addItem("13h");
        horaAteMCliFResTACBox.addItem("13h30");
        horaAteMCliFResTACBox.addItem("14h");
        horaAteMCliFResTACBox.addItem("14h30");
        horaAteMCliFResTACBox.addItem("15h");
        horaAteMCliFResTACBox.addItem("15h30");

        JComboBox qtdePratosMCliFResTACBox = new JComboBox();
        qtdePratosMCliFResTACBox.addItem("");
        qtdePratosMCliFResTACBox.addItem("1");
        qtdePratosMCliFResTACBox.addItem("2");
        qtdePratosMCliFResTACBox.addItem("3");
        qtdePratosMCliFResTACBox.addItem("4");
        qtdePratosMCliFResTACBox.addItem("5");
        qtdePratosMCliFResTACBox.addItem("6");
        qtdePratosMCliFResTACBox.addItem("7");
        qtdePratosMCliFResTACBox.addItem("8");
        qtdePratosMCliFResTACBox.addItem("9");
        qtdePratosMCliFResTACBox.addItem("10");
        qtdePratosMCliFResTACBox.addItem("11");
        qtdePratosMCliFResTACBox.addItem("12");
        qtdePratosMCliFResTACBox.addItem("13");
        qtdePratosMCliFResTACBox.addItem("14");
        qtdePratosMCliFResTACBox.addItem("15");
        qtdePratosMCliFResTACBox.addItem("16");
        qtdePratosMCliFResTACBox.addItem("17");
        qtdePratosMCliFResTACBox.addItem("18");
        qtdePratosMCliFResTACBox.addItem("19");
        qtdePratosMCliFResTACBox.addItem("20");


//todo possibilitar que o prato possa ser selecionado
        String[] nomeColunasMCliFResTA = new String[]{
                "NOME", "DESCRIÇÃO", "PREÇO", "TIPO"
        };

        Object[][] dados = new Object[][]{
                {"NOME", "DESCRIÇÃO", "PREÇO", "TIPO"},
                {"Sardinha", "Assada", "15.0", "Carta"},
                {"Peru", "Ensopado", "15.0", "Prato do Dia"},
                {"Bifana", "Frita", "15.0", "Carta"},

        };
        //criação da tabela
        JTable tabelaMCliFResTA = new JTable(dados, nomeColunasMCliFResTA);

        JButton ptEnMCliFResTAButton = new JButton("PT/EN");
        JButton voltarMCliFResTAButton = new JButton("MENU CLIENTE");
        JButton confirmarMCliFResTAButton = new JButton("OK");

        mCliFazerResTASuperPanel.add(norteMCliFResTASubPanel, "North");
        mCliFazerResTASuperPanel.add(centroMCliFResTASubPanel, "Center");
        mCliFazerResTASuperPanel.add(sulMCliFResTASubPanel, "South");

        JPanel norteMCliFResTASSPanel = new JPanel();
        norteMCliFResTASSPanel.setLayout(new FlowLayout());
        norteMCliFResTASSPanel.add(mCliTitFResTALabel);
        norteMCliFResTASubPanel.add(norteMCliFResTASSPanel, BorderLayout.CENTER);
        norteMCliFResTASubPanel.add(ptEnMCliFResTAButton, BorderLayout.EAST);

        JPanel centroMCliFResTASSPanel = new JPanel();
        centroMCliFResTASSPanel.setLayout(new FlowLayout());
        centroMCliFResTASubPanel.add(centroMCliFResTASSPanel, BorderLayout.WEST);

        JPanel centroMCliFResTASSPanel1 = new JPanel();
        centroMCliFResTASSPanel1.setLayout(new FlowLayout());
        centroMCliFResTASubPanel.add(centroMCliFResTASSPanel1, BorderLayout.WEST);

        JPanel centroMCliFResTASSPanel2 = new JPanel();
        centroMCliFResTASSPanel2.setLayout(new FlowLayout());
        centroMCliFResTASubPanel.add(centroMCliFResTASSPanel2, BorderLayout.WEST);

        JPanel centroMCliFResTASSPanel3 = new JPanel();
        centroMCliFResTASSPanel3.setLayout(new GridLayout(1, 1));
        centroMCliFResTASubPanel.add(centroMCliFResTASSPanel3, BorderLayout.WEST);

        centroMCliFResTASSPanel.add(horaMCliFResTALabel);
        centroMCliFResTASSPanel.add(horaDeMCliFResTALabel);
        centroMCliFResTASSPanel.add(horaDeMCliFResTACBox);
        centroMCliFResTASSPanel.add(horaAteMCliFResTALabel);
        centroMCliFResTASSPanel.add(horaAteMCliFResTACBox);
        centroMCliFResTASSPanel1.add(pratosMCliFResTALabel);
        centroMCliFResTASSPanel1.add(tabelaMCliFResTA);
        centroMCliFResTASSPanel2.add(qtdePratosMCliFResTALabel);
        centroMCliFResTASSPanel2.add(qtdePratosMCliFResTACBox);

        sulMCliFResTASubPanel.setLayout(new FlowLayout());
        sulMCliFResTASubPanel.add(voltarMCliFResTAButton);
        sulMCliFResTASubPanel.add(confirmarMCliFResTAButton);


        voltarMCliFResTAButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENURESTAURANTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
        });

        //todo ver os encaminhamentos
        confirmarMCliFResTAButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, LOGIN_CARD);
            this.setSize(500, 180);
        });




        this.setVisible(true);
    }
}