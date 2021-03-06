/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.newtonpaiva.gc.ui.convenio;

import br.newtonpaiva.gc.ui.contrato.TelaContrato;
import br.newtonpaiva.gc.ui.utils.TelaPesquisa;
import br.newtonpaiva.modelo.Convenio;
import br.newtonpaiva.modelo.Curso;
import br.newtonpaiva.modelo.Empresa;
import br.newtonpaiva.modelo.SituacaoConvenio;
import br.newtonpaiva.modelo.excecoes.ConvenioInvalidoException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme
 */
public class TelaConvenios extends javax.swing.JDialog {

    private final ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle");
    private Convenio convenioSelecionado;
    private Empresa empresaSelecionada;

    /**
     * Creates new form TelaConvenios
     *
     * @param parent
     * @param modal
     */
    public TelaConvenios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //posiciona a tela no centro da tela
        setLocationRelativeTo(parent);
        //ao usuário clicar enter ele aciona o botão Salvar
        getRootPane().setDefaultButton(btnSalvar);
        //monta a lista de cursos
        CursosComponente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panEmpresa = new javax.swing.JPanel();
        lblCnpj = new javax.swing.JLabel();
        jspCnpj = new javax.swing.JFormattedTextField();
        btnPesquisaEmpresa = new javax.swing.JButton();
        lblNomeEmpresa = new javax.swing.JLabel();
        imgLogo = new javax.swing.JLabel();
        cbbCurso = new javax.swing.JComboBox<>();
        lblCurso = new javax.swing.JLabel();
        cbbSituacaoConvenio = new javax.swing.JComboBox<>();
        lblSituacaoConvenio = new javax.swing.JLabel();
        edtVencimento = new javax.swing.JFormattedTextField();
        lblDataEntrada = new javax.swing.JLabel();
        edtAssinatura = new javax.swing.JFormattedTextField();
        lblInicioAtual = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo convênio");
        setResizable(false);

        panEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da empresa"));

        lblCnpj.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCnpj.setText("CNPJ");

        try {
            jspCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jspCnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jspCnpjFocusLot(evt);
            }
        });

        btnPesquisaEmpresa.setText("...");
        btnPesquisaEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panEmpresaLayout = new javax.swing.GroupLayout(panEmpresa);
        panEmpresa.setLayout(panEmpresaLayout);
        panEmpresaLayout.setHorizontalGroup(
            panEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEmpresaLayout.createSequentialGroup()
                .addGroup(panEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panEmpresaLayout.createSequentialGroup()
                        .addComponent(lblCnpj)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panEmpresaLayout.createSequentialGroup()
                        .addComponent(jspCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNomeEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panEmpresaLayout.setVerticalGroup(
            panEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCnpj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jspCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesquisaEmpresa))
                    .addComponent(lblNomeEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbbCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleciona um..." }));

        lblCurso.setText("Curso");

        cbbSituacaoConvenio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleciona um...", "Andamento", "Cancelado", "Finalizado" }));

        lblSituacaoConvenio.setText("Situação do convênio");

        try {
            edtVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblDataEntrada.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDataEntrada.setText("Data de vencimento");

        try {
            edtAssinatura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblInicioAtual.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblInicioAtual.setText("Data de assinatura");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imgLogo)
                .addGap(238, 238, 238))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInicioAtual)
                            .addComponent(edtAssinatura, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDataEntrada)
                            .addComponent(edtVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCurso)
                            .addComponent(cbbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSituacaoConvenio)
                            .addComponent(cbbSituacaoConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imgLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInicioAtual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtAssinatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDataEntrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtVencimento, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCurso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSituacaoConvenio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbSituacaoConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jspCnpjFocusLot(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jspCnpjFocusLot
        //Busca por empresa

    }//GEN-LAST:event_jspCnpjFocusLot

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        SimpleDateFormat format = new SimpleDateFormat(bundle.getString("geral.formato.data"));
        Calendar dataAssintaura = Calendar.getInstance();
        try {
            dataAssintaura.setTime(format.parse(edtAssinatura.getText()));
        } catch (ParseException e) {
            edtAssinatura.getText();
            JOptionPane.showMessageDialog(this, bundle.getString("convenio.data.assinatura.invalida") + "\n" + bundle.getString("datas.formatacao"));
            return;
        }

        Calendar dataVencimento = Calendar.getInstance();
        try {
            dataVencimento.setTime(format.parse(edtVencimento.getText()));
        } catch (ParseException e) {
            edtVencimento.getText();
            JOptionPane.showMessageDialog(this, bundle.getString("convenio.data.vencimento.invalida") + "\n" + bundle.getString("datas.formatacao"));
            return;
        }

        //Inicia uma nova classe de curso
        Curso c = null;
        try {
            if (cbbCurso.getSelectedIndex() > 0) {
                List<Curso> lista = Curso.buscarPorNome((String) cbbCurso.getSelectedItem());
                if (lista.isEmpty()) {
                    JOptionPane.showMessageDialog(null, bundle.getString("curso.nao.existe"));
                    return;
                } else {
                    c = lista.get(0);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaConvenios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, bundle.getString("erro.conexao.banco"));
        }

        Empresa e = null;
        String cnpj = jspCnpj.getText();
        if (!cnpj.equals("  .   .   /    -  ")) {
            try {
                e = Empresa.buscarPorCNPJ(cnpj);
            } catch (SQLException ex) {
                Logger.getLogger(TelaContrato.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, bundle.getString("erro.conexao.banco"));
            }
        }

        String Inserir = "N";
        //Se o Convenio edição é nulo
        if (convenioSelecionado == null) {
            //Inicia uma nova classe
            convenioSelecionado = new Convenio();
            Inserir = "S";
        }

        //Seta a situação do convênio antes de salvar
        switch (cbbSituacaoConvenio.getSelectedIndex()) {
            case 1:
                convenioSelecionado.setSituacao(SituacaoConvenio.ANDAMENTO);
                break;
            case 2:
                convenioSelecionado.setSituacao(SituacaoConvenio.CANCELADO);
                break;
            case 3:
                convenioSelecionado.setSituacao(SituacaoConvenio.FINALIZADO);
                break;
        }
        //Seta as informações na classe
        convenioSelecionado.setCurso(c);
        convenioSelecionado.setDataAssinatura(dataAssintaura);
        convenioSelecionado.setDataVencimento(dataVencimento);
        convenioSelecionado.setEmpresa(e);
        try {
            //Salvar
            convenioSelecionado.salvar();
            //Mensagem de acordo com a açãso (Edição ou inserção)
            if (Inserir.equals(bundle.getString("geral.s"))) {
                JOptionPane.showMessageDialog(null, bundle.getString("convenio.inserir.ok"));
                convenioSelecionado = null;
                Limpar();
            } else {
                JOptionPane.showMessageDialog(null, bundle.getString("convenio.alterar.ok"));
            }
        } catch (ConvenioInvalidoException | SQLException ex) {
            Logger.getLogger(TelaConvenios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        //Limpa os componentes
        Limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnPesquisaEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaEmpresaActionPerformed
        TelaPesquisa tela = new TelaPesquisa(
                null, true);

        tela.setTitle(bundle.getString("contratos.pesquisar.empresa"));

        tela.getCbxTipoFiltro().removeAllItems();
        tela.getCbxTipoFiltro().addItem(bundle.getString("geral.razao"));
        tela.getCbxTipoFiltro().addItem(bundle.getString("geral.cnpj"));

        tela.getTableModel().addColumn(bundle.getString("geral.id"));
        tela.getTableModel().addColumn(bundle.getString("geral.razao"));
        tela.getTableModel().addColumn(bundle.getString("geral.cnpj"));
        tela.getBtnConsultar().addActionListener((ActionEvent evento) -> {
            try {
                //TelaPesquisa tela1 = (TelaPesquisa) ((JButton) e.getSource()).getParent();

                switch (tela.getCbxTipoFiltro().getSelectedIndex()) {
                    case 0:
                        // Obtem o valor informado na tela
                        String razaoSocial = tela.getTxtFiltro().getText();

                        // Consulta a empresa pelo nome
                        List<Empresa> lista = Empresa.buscarPorNome(razaoSocial);

                        // Limpa a tabela
                        tela.getTableModel().setRowCount(0);

                        if (lista.isEmpty()) {
                            JOptionPane.showMessageDialog(this, bundle.getString("empresa.nao.encontrada"));
                            tela.getTxtFiltro().requestFocus();
                        } else {
                            lista.forEach(emp -> {
                                Object[] row = {emp.getId(), emp.getCnpjFormatado(), emp.getNome()};
                                tela.getTableModel().addRow(row);
                            });
                        }
                        break;
                    case 1:
                        // Obtem o valor informado na tela
                        String cnpj = tela.getTxtFiltro().getText();

                        // Consulta a empresa pelo CNPJ
                        Empresa emp = Empresa.buscarPorCNPJ(cnpj);

                        // Limpa a tabela
                        tela.getTableModel().setRowCount(0);

                        if (emp == null) {
                            JOptionPane.showMessageDialog(this, bundle.getString("empresa.nao.encontrada"));
                            tela.getTxtFiltro().requestFocus();
                        } else {
                            Object[] row = {emp.getId(), emp.getCnpjFormatado(), emp.getNome()};
                            tela.getTableModel().addRow(row);
                        }
                        break;
                }
            } catch (SQLException ex) {
                Logger.getLogger(TelaContrato.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, bundle.getString("erro.conexao.banco"));
            }

        });

        tela.getTblResultadoPesquisa().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                // Verifica se foi um duplo clique e se alguma linha foi selecionada
                if (e.getClickCount() == 2
                        && tela.getTblResultadoPesquisa().getSelectedRowCount() > 0) {

                    try {
                        // Pega a linha selecionada
                        int rowSelected = tela.getTblResultadoPesquisa().getSelectedRow();

                        // Recupera o ID da empresa
                        Object id = tela.getTableModel().getValueAt(rowSelected, 0);

                        // Recupera os demais dados da empresa
                        empresaSelecionada = Empresa.buscarPorId((int) id);

                        // Mostra os dados da empresa na tela principal
                        jspCnpj.setText(empresaSelecionada.getCnpj());
                        lblNomeEmpresa.setText(empresaSelecionada.getNome());

                        // Fecha a tela
                        tela.setVisible(false);
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaContrato.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(TelaConvenios.this, bundle.getString("erro.conexao.banco"));
                    }
                }
            }
        });

        tela.setVisible(true);
    }//GEN-LAST:event_btnPesquisaEmpresaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConvenios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            TelaConvenios dialog = new TelaConvenios(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisaEmpresa;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbbCurso;
    private javax.swing.JComboBox<String> cbbSituacaoConvenio;
    private javax.swing.JFormattedTextField edtAssinatura;
    private javax.swing.JFormattedTextField edtVencimento;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JFormattedTextField jspCnpj;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblDataEntrada;
    private javax.swing.JLabel lblInicioAtual;
    private javax.swing.JLabel lblNomeEmpresa;
    private javax.swing.JLabel lblSituacaoConvenio;
    private javax.swing.JPanel panEmpresa;
    // End of variables declaration//GEN-END:variables

    private void Limpar() {
        //limpa os componentes
        edtAssinatura.setText("");
        edtVencimento.setText("");
        jspCnpj.setText("");
        cbbCurso.setSelectedIndex(0);
        cbbSituacaoConvenio.setSelectedIndex(0);
        lblNomeEmpresa.setText("");
    }

    private void CursosComponente() {
        //busca os dados para preencher o curao
        try {
            List<Curso> lista = Curso.buscarTodos();
            // Limpa o componente
            cbbCurso.removeAllItems();
            cbbCurso.addItem(bundle.getString("geral.seleciona.um"));
            lista.forEach(emp -> {
                cbbCurso.addItem(emp.getCurso());
            });
        } catch (SQLException ex) {
            Logger.getLogger(TelaContrato.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, bundle.getString("erro.conexao.banco"));
        }
    }

}
