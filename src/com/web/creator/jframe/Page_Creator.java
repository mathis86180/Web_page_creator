package com.web.creator.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.web.creator.classes.Column;
import com.web.creator.classes.Row;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Page_Creator extends JFrame {

	private JPanel contentPane;
	private final String StartingPage = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<meta charset=\"UTF-8\">\r\n" + 
			"<!-- Latest compiled and minified CSS -->\r\n" + 
			"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\r\n" + 
			"\r\n" + 
			"<!-- Optional theme -->\r\n" + 
			"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\r\n" + 
			"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js\"></script>\r\n" + 
			"<!-- Latest compiled and minified JavaScript -->\r\n" + 
			"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\r\n" + 
			"<title>Insert title here</title>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n";
	private final String startingSection = "<section><div class=\"container\">\r\n";
	private final String endingSection = "</div></section>\r\n";
	private final String EndingPage = "</body>\r\n" + "</html>";
	private JTextArea textAreaPage;
	private JButton btnNewButton_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page_Creator frame = new Page_Creator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Page_Creator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Zone textArea
		 */
		textAreaPage = new JTextArea();
		textAreaPage.setBounds(10, 11, 674, 689);
		contentPane.add(textAreaPage);
		textAreaPage.setText(StartingPage);
		
		JButton btnNewButton = new JButton("Créer une nouvelle section");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateNewSection();
			}
		});
		btnNewButton.setBounds(694, 12, 180, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Ajouter fin de page");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateEndPage();
			}
		});
		btnNewButton_1.setBounds(694, 46, 180, 23);
		contentPane.add(btnNewButton_1);
	}
	
	private void CreateNewSection() {
		textAreaPage.setText(textAreaPage.getText() + startingSection);
		List<Row> lr = new ArrayList<>();
		Column c = null;
		Row r = null;
		String div = null;
		String nbRows = JOptionPane.showInputDialog(null, "Entrez le nombre de rows pour la section", "test", JOptionPane.INFORMATION_MESSAGE);
		//Début de la loop de création des rows
		for(int i=1; i <= Integer.parseInt(nbRows);i++) {
			r = new Row(i);
			lr.add(r);
			String nbCol = JOptionPane.showInputDialog(null, "Entrez le nombre de colonnes pour la row n° " + r.getIdRow(), "test", JOptionPane.INFORMATION_MESSAGE);
			r.setNbColumns(Integer.parseInt(nbCol));
			textAreaPage.setText(textAreaPage.getText() + "<row>\r\n");
			//Début de la loop d'ajout des colonnes dans la row
			for(int j =1; j <= Integer.parseInt(nbCol); j++) {
				c = new Column(j);
				r.listColumns = new ArrayList<>();
				System.out.println(r.listColumns.size());
				r.listColumns.clear();
				r.listColumns.add(c);
				for(Column col : r.listColumns) {
					String sizeCol = JOptionPane.showInputDialog(null, "Entrez la taille de la colonne n° " + c.getIdColumn(), "test", JOptionPane.INFORMATION_MESSAGE);
					col.setSizeColumn(Integer.parseInt(sizeCol));
					div = CreateCol(Integer.parseInt(sizeCol));
					c = col;
					c.setTextColumn(div);
					textAreaPage.setText(textAreaPage.getText() + c.getTextColumn() + "\r\n");
				}
			}
			textAreaPage.setText(textAreaPage.getText() + "</row>\r\n" + endingSection);
		}
		
		//test
		for(Row myR : lr) {
			System.out.println("ID Row: " + myR.getIdRow());
			System.out.println("NB COL : " + myR.getNbColumns());
			for(Column myC : myR.listColumns) {
				System.out.println("ID Column : " + myC.getIdColumn());
				System.out.println("SIZE Column : " + myC.getSizeColumn());
				System.out.println("TEXT Column : " + myC.getTextColumn());
			}
			System.out.println("-----------------------------------");
		}
	}
	
	public String CreateCol(Integer sizeCol) {
		
		String div = null;
		
		switch (sizeCol) {
		case 1:
			div = "<div class=\"col-lg-1\"></div>";
			break;
		case 2:
			div = "<div class=\"col-lg-2\"></div>";
			break;
		case 3:
			div = "<div class=\"col-lg-3\"></div>";
			break;
		case 4:
			div = "<div class=\"col-lg-4\"></div>";
			break;
		case 5:
			div = "<div class=\"col-lg-5\"></div>";
			break;
		case 6:
			div = "<div class=\"col-lg-6\"></div>";
			break;
		case 7:
			div = "<div class=\"col-lg-7\"></div>";
			break;
		case 8:
			div = "<div class=\"col-lg-8\"></div>";
			break;
		case 9:
			div = "<div class=\"col-lg-9\"></div>";
			break;
		case 10:
			div = "<div class=\"col-lg-10\"></div>";
			break;
		case 11:
			div = "<div class=\"col-lg-11\"></div>";
			break;
		case 12:
			div = "<div class=\"col-lg-12\"></div>";
			break;
		}
		
		return div;
	}
	
	private void CreateEndPage() {
		textAreaPage.setText(textAreaPage.getText() + EndingPage);
	}
}
