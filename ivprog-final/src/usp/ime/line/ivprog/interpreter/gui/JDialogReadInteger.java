package usp.ime.line.ivprog.interpreter.gui;
/** 
 * Instituto de Matemática e Estatística da Universidade de São Paulo (IME-USP)
 * iVProg is a open source and free software of Laboratório de Informática na 
 * Educação (LInE) licensed under GNU GPL2.0 license.
 * Prof. Dr. Leônidas de Oliveira Brandão - leo@ime.usp.br
 * Romenig da Silva Ribeiro - romenig@ime.usp.br | romenig@gmail.com
 * @author Romenig
 */

import javax.swing.JDialog;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.FlowLayout;

import usp.ime.line.ivprog.view.FlatUIColors;
import usp.ime.line.ivprog.view.language.ResourceBundleIVP;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class JDialogReadInteger extends JDialog {
	private static JDialogReadInteger instance;
	private JButton btnOk;
	private JButton btnCancelar;
	private JPanel contentPane; 
	private JPanel textFieldPanel;
	private JCustomTextField customTextField;
	private JLabel textLabel;

	//Singleton
	public static JDialogReadInteger getInstance(){
		if(instance != null){ 
			return instance;
		} else {
			instance = new JDialogReadInteger();
			return instance;
		}
	}
	
	public JDialogReadInteger() {
		init();
		initTextPanel();
		initTextField();
		initBtnPanel();
		setLocationRelativeTo(null);
		pack();
	}
	
    private void initBtnPanel() {
		JPanel btnsPanel = new JPanel();
		getContentPane().add(btnsPanel, BorderLayout.SOUTH);
		btnsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    	
    	btnOk = new JButton(ResourceBundleIVP.getString("Btn.OK"));
		btnsPanel.add(btnOk);
		
		btnCancelar = new JButton(ResourceBundleIVP.getString("Btn.cancel"));
		btnsPanel.add(btnCancelar);
    }

    private void initTextPanel() {
		textFieldPanel = new JPanel();
		contentPane.add(textFieldPanel, BorderLayout.CENTER);
		textFieldPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		textLabel = new JLabel(ResourceBundleIVP.getString("JDialogReadInteger.textLabel.text"));
		textFieldPanel.add(textLabel);
    }

	private void init(){
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.setBackground(FlatUIColors.MAIN_BG);
        setContentPane(contentPane);
	}

    private void initTextField() {
		customTextField = new JCustomTextField();
		customTextField.setColumns(20);
		textFieldPanel.add(customTextField);
    }

}
