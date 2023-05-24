package br.sc.senac.perfil.view;

import br.sc.senac.perfil.util.ConnectionFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LoginView extends JFrame {
    private JPanel pnlPerfil;
    private JLabel lblnome;
    private JLabel lblcurso;
    private JLabel lblfase;
    private JLabel lbldatanasc;

    private JTextField txtnome;
    private JTextField txtdatanasc;
    private JTextField txtcurso;
    private JButton btnenviar;
    private JTextField txtfase;

    public LoginView() {
        initComponents();
        addListeners();
    }

    private void initComponents() {
        setTitle("Perfil de Usuário");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pnlPerfil);
        setVisible(true);
    }

    private void addListeners() {
        btnenviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtnome.getText();
                String curso = txtcurso.getText();
                String nascimento = txtdatanasc.getText();
                String fase = txtfase.getText();

                try {
                    Connection conn = ConnectionFactory.getConexao();
                    PreparedStatement stmtenviar = conn.prepareStatement("INSERT INTO aluno (nome, curso, nascimento, fase) VALUES (?, ?, ?, ?)");
                    stmtenviar.setString(1, nome);
                    stmtenviar.setString(2, curso);
                    stmtenviar.setString(3, nascimento);
                    stmtenviar.setString(4, fase);
                    stmtenviar.executeUpdate();

                    System.out.println("Dados inseridos!");
                    JOptionPane.showMessageDialog(btnenviar, "Dados inseridos com sucesso!");

                    txtnome.setText("");
                    txtcurso.setText("");
                    txtdatanasc.setText("");
                    txtfase.setText("");
                } catch (NumberFormatException ex) {
                    System.out.println("A fase informada não é um número.");
                } catch (Exception ex) {
                    System.out.println("Erro ao inserir dados no banco!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginView();
            }
        });
    }
}
