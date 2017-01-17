package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class VentanaEstadisticas extends JFrame {

	/**
	 * Serial number
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelS, panelN, panelE, panelO, panelReservasTot, panelGananciasTot, panelCarriba;
	private JTextArea txtReservas;
	private JTextField txtNumeroTot;
	private JComboBox comboBoxCifra, comboBoxPeriodo;
	private JButton btnVolver;
	private JTabbedPane tabbedPane;
	private JLabel lblHoy;
	private JTextField txtHoy;
	private JLabel lblMesActual;
	private JLabel lblAnyoActual;
	private JTextField txtMes;
	private JTextField txtAnyo;
	private JLabel lblTotal;
	private JTextField txtTotal;
	private JPanel panelCabajo;


	/**
	 * Create the frame.
	 */
	public VentanaEstadisticas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelS = new JPanel();
		contentPane.add(panelS, BorderLayout.SOUTH);
		
		VentanaEstadisticas ve = this;
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaAdministrador va = new VentanaAdministrador();
				va.setVisible(true);
				ve.dispose();
			}
		});
		panelS.add(btnVolver);
		
		panelN = new JPanel();
		contentPane.add(panelN, BorderLayout.NORTH);
		
		panelO = new JPanel();
		contentPane.add(panelO, BorderLayout.WEST);
		
		panelE = new JPanel();
		contentPane.add(panelE, BorderLayout.EAST);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		panelReservasTot = new JPanel();

		tabbedPane.addTab("Número de reservas", panelReservasTot );
		panelReservasTot.setLayout(new GridLayout(2, 1, 0, 0));
		
		panelCarriba = new JPanel();
		panelReservasTot.add(panelCarriba);
		panelCarriba.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblSeleccionarPeriodo = new JLabel("Seleccionar periodo: ");
		panelCarriba.add(lblSeleccionarPeriodo);
		
		JLabel lblNmeroTotalDe = new JLabel("Número total de reservas: ");
		panelCarriba.add(lblNmeroTotalDe);
		
		JPanel panelCombos = new JPanel();
		panelCarriba.add(panelCombos);
		panelCombos.setLayout(new GridLayout(1, 2, 0, 0));
		
		comboBoxPeriodo = new JComboBox();
		comboBoxPeriodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object ob=comboBoxPeriodo.getSelectedItem();
				if(ob=="Año"){
					
					txtReservas.setText("");
					txtNumeroTot.setText("");
					comboBoxCifra.setEnabled(true);
					comboBoxCifra.setModel(new DefaultComboBoxModel<>(new String[]{"", "2017", "2016", "2015", "2014", "2013"}));
				}else if(ob=="Mes"){
					txtNumeroTot.setText("");
					txtReservas.setText("");
					comboBoxCifra.setEnabled(true);
					comboBoxCifra.setModel(new DefaultComboBoxModel<>(new String[]{"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
				}else if(ob=="Hoy"){
					Date d = new Date();
					int dia=d.getDate();
					txtReservas.setText("");
					txtNumeroTot.setText("");
					comboBoxCifra.setModel(new DefaultComboBoxModel<>(new String[]{""+dia+""}));
					comboBoxCifra.setEnabled(false);
					
					int year=(d.getYear()+1900);
					int month=d.getMonth()+1;
					int day=d.getDate();
					int diaTot=0;
					if(month<10){
						 diaTot =(year*100000+month*100+day);
					}else{
						 diaTot =(year*10000+month*100+day);
					}
					
					String hoy=""+diaTot+"";
					ArrayList<String>a = VentanaLogin.bd.sacarReservasHoy(hoy);
					txtReservas.setText(String.format("%20s%20s%20s\n","USUARIO","CODIGO","FECHA"));
					for(int i=0;i<a.size();i++){
						txtReservas.append(a.get(i));
					}
					txtNumeroTot.setText(""+VentanaLogin.bd.contarReservasHoy(hoy)+""); //Sacamos en el txt el número total de reservas
					
					
				}else if(ob=="Todos"){
					comboBoxCifra.setEnabled(false);
					comboBoxCifra.setModel(new DefaultComboBoxModel<>(new String[]{""}));
					txtReservas.setText("");
					txtNumeroTot.setText("");
					ArrayList<String>a = VentanaLogin.bd.sacarReservasTodos();
					txtReservas.setText(String.format("%20s%20s%20s\n","USUARIO","CODIGO","FECHA"));
					for(int i=0;i<a.size();i++){
						txtReservas.append(a.get(i));
					}
					txtNumeroTot.setText(""+VentanaLogin.bd.contarReservasTodo()+""); //Sacamos en el txt el número total de reservas
					
				}else{
					comboBoxCifra.setModel(new DefaultComboBoxModel<>(new String []{""}));
				}
			}
		});
		comboBoxPeriodo.setModel(new DefaultComboBoxModel(new String[] {"", "Todos", "Año", "Mes", "Hoy"}));
		panelCombos.add(comboBoxPeriodo);
		
		comboBoxCifra = new JComboBox();
		comboBoxCifra.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				Object ob=comboBoxPeriodo.getSelectedItem();
				if(ob=="Año"){	
					txtReservas.setText("");
					txtNumeroTot.setText("");
					String anyo=(String)comboBoxCifra.getSelectedItem();
					ArrayList<String>a = VentanaLogin.bd.sacarReservasAnyo(anyo);
					txtReservas.setText(String.format("%20s%20s%20s\n","USUARIO","CODIGO","FECHA"));
					for(int i=0;i<a.size();i++){
						txtReservas.append(a.get(i));
					}
					
					txtNumeroTot.setText(""+VentanaLogin.bd.contarReservasAnyo(anyo)+""); //Sacamos en el txt el número total de reservas
					
				}else if(ob=="Mes"){
					txtReservas.setText("");
					txtNumeroTot.setText("");
					Date d = new Date();
					int anyo=d.getYear()+1900;
					String mes=(String)comboBoxCifra.getSelectedItem();
					ArrayList<String>a = VentanaLogin.bd.sacarReservasMes(anyo+mes);
					txtReservas.setText(String.format("%20s%20s%20s\n","USUARIO","CODIGO","FECHA"));
					for(int i=0;i<a.size();i++){
						txtReservas.append(a.get(i));
					}
					txtNumeroTot.setText(""+VentanaLogin.bd.contarReservasMes(anyo+mes)+""); //Sacamos en el txt el número total de reservas
					
				}else{
					
				}
			}
		});
		panelCombos.add(comboBoxCifra);
		
		txtNumeroTot = new JTextField();
		txtNumeroTot.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtNumeroTot.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroTot.setEditable(false);
		panelCarriba.add(txtNumeroTot);
		txtNumeroTot.setColumns(10);
		
		panelCabajo = new JPanel();
		panelReservasTot.add(panelCabajo);
		panelCabajo.setLayout(new GridLayout(1, 1, 0, 0));
		
		txtReservas = new JTextArea();
		panelCabajo.add(txtReservas);
		txtReservas.setEditable(false);
		txtReservas.setColumns(10);
		
		panelGananciasTot = new JPanel();
		tabbedPane.addTab("Ganancias total", panelGananciasTot );
		panelGananciasTot.setLayout(new GridLayout(4, 2, 0, 0));
		
		lblHoy = new JLabel("Hoy: ");
		lblHoy.setHorizontalAlignment(SwingConstants.CENTER);
		panelGananciasTot.add(lblHoy);
		
		txtHoy = new JTextField();
		txtHoy.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtHoy.setHorizontalAlignment(SwingConstants.CENTER);
		txtHoy.setBackground(Color.GREEN);
		txtHoy.setEditable(false);
		panelGananciasTot.add(txtHoy);
		txtHoy.setColumns(10);
		
		lblMesActual = new JLabel("Mes actual: ");
		lblMesActual.setHorizontalAlignment(SwingConstants.CENTER);
		panelGananciasTot.add(lblMesActual);
		
		txtMes = new JTextField();
		txtMes.setHorizontalAlignment(SwingConstants.CENTER);
		txtMes.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtMes.setBackground(Color.GREEN);
		txtMes.setEditable(false);
		panelGananciasTot.add(txtMes);
		txtMes.setColumns(10);
		
		lblAnyoActual = new JLabel("Año actual: ");
		lblAnyoActual.setHorizontalAlignment(SwingConstants.CENTER);
		panelGananciasTot.add(lblAnyoActual);
		
		txtAnyo = new JTextField();
		txtAnyo.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtAnyo.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnyo.setBackground(Color.GREEN);
		txtAnyo.setEditable(false);
		panelGananciasTot.add(txtAnyo);
		txtAnyo.setColumns(10);
		
		lblTotal = new JLabel("Total: ");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		panelGananciasTot.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setBackground(Color.GREEN);
		txtTotal.setEditable(false);
		panelGananciasTot.add(txtTotal);
		txtTotal.setColumns(10);
		txtTotal.setText(""+VentanaLogin.bd.gananciasTotal()+" €");
	
		fechasGanancias();
	
		//Añadimos scroll
		
		JScrollPane scroll = new JScrollPane(txtReservas);
		panelCabajo.add(scroll);
	}
	
	/**
	 * Método relacionado con la devolución de total de precios dependiendo de las fechas en las que estamos
	 */
	private void fechasGanancias(){
		//Obtenemos la fecha del sistema
		
		Date da = new Date();
		int month=(da.getMonth()+1);
		int year=0;
		int day = da.getDate();
		int diaTot=0;
		int anyoMes=0;
		if(month<10){	
			year = (da.getYear()+1900);
			diaTot=year*10000+0+month*100+day;
			anyoMes=year*100+month;
		}else{
			year = (da.getYear()+1900);
			diaTot=year*10000+month*100+day;
			anyoMes=year+month;
		}
	
		txtAnyo.setText(""+VentanaLogin.bd.gananciasAnyo(""+year+"")+" €"); //Devuelve el total del año actual
		
		txtMes.setText(""+VentanaLogin.bd.gananciasMes(""+anyoMes+"")+" €"); //Devuelve el total del mes actual
		
		txtHoy.setText(""+VentanaLogin.bd.gananciasHoy(""+diaTot+"")+" €"); //Devuelve el total de hoy
	}

}
