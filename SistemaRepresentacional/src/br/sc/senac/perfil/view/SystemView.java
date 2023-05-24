package br.sc.senac.perfil.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemView extends JFrame {

    JPanel pnlSystemView = new JPanel();
    JMenuBar menuBar = new JMenuBar();

    public SystemView() {
        initComponents();
        initMenuBar();
        listener();
    }

    public void initComponents() {
        setTitle("Tela de sistema");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pnlSystemView);
        setVisible(true);
        pnlSystemView.setLayout(null);
        setJMenuBar(menuBar);
    }

    public void initMenuBar() {
        JMenu cadastrosMenu = new JMenu("Cadastrar Usuário");
        JMenu pesquisarMenu = new JMenu("Fazer o Teste");
        JMenu sairMenu = new JMenu("Sair");

        JMenuItem cadastrarItem = new JMenuItem("Cadastrar Usuário");
        JMenuItem testarItem = new JMenuItem("Fazer o teste:");
        JMenuItem sairItem = new JMenuItem("Sair");

        cadastrosMenu.add(cadastrarItem);
        pesquisarMenu.add(testarItem);
        sairMenu.add(sairItem);

        menuBar.add(cadastrosMenu);
        menuBar.add(pesquisarMenu);
        menuBar.add(sairMenu);

        cadastrarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginView();
                dispose();
            }
        });

        testarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new QuestionarioView();
                dispose();
            }
        });

        sairItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = "Sair";
                int opcaoEscolhida = JOptionPane.showConfirmDialog(null, msg, "Sistema", JOptionPane.YES_NO_OPTION);
                if (opcaoEscolhida == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public void listener() {

        ImageIcon addUser = new ImageIcon("C:\\Users\\thais.oliveira8\\Desktop\\SistemaRepresentacional\\src\\br\\sc\\senac\\perfil\\img\\cadastrar.jpg");
        JButton btnCadastrar = new JButton("Cadastrar Usuário", addUser);
        btnCadastrar.setBounds(450, 300, 150, 100);
        pnlSystemView.add(btnCadastrar);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginView();
                dispose();
            }
        });

        ImageIcon searchUser = new ImageIcon("C:\\Users\\thais.oliveira8\\Desktop\\SistemaRepresentacional\\src\\br\\sc\\senac\\perfil\\img\\testar.jpg");
        JButton btnTestar = new JButton("Fazer o teste", searchUser);
        btnTestar.setBounds(650, 300, 150, 100);
        pnlSystemView.add(btnTestar);

        btnTestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new QuestionarioView();
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SystemView();
            }
        });
    }
}
