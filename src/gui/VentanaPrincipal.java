package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import operaciones.Logica;
import operaciones.PersonaVO;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDocumento;
	private JTextField textNombre;
	private JTextField textEdad;
	private JTextField textPeso;
	private JTextField textTalla;
	private JButton btnRegistrar;
	private JButton btnListaPersonas;
	private JButton btnCalcularIMC;
	private JLabel lblTitulo;
	Logica miLogica;
	private JTextArea textArea;

	public VentanaPrincipal() {
		miLogica = new Logica();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel("Calcular IMC");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTitulo.setBounds(222, 11, 83, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDocumento.setBounds(10, 53, 76, 14);
		contentPane.add(lblDocumento);
		
		textDocumento = new JTextField();
		textDocumento.setBounds(81, 50, 119, 20);
		contentPane.add(textDocumento);
		textDocumento.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(222, 53, 58, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(281, 50, 163, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEdad.setBounds(10, 93, 44, 14);
		contentPane.add(lblEdad);
		
		textEdad = new JTextField();
		textEdad.setBounds(48, 90, 86, 20);
		contentPane.add(textEdad);
		textEdad.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPeso.setBounds(166, 93, 46, 14);
		contentPane.add(lblPeso);
		
		textPeso = new JTextField();
		textPeso.setBounds(205, 90, 86, 20);
		contentPane.add(textPeso);
		textPeso.setColumns(10);
		
		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTalla.setBounds(314, 93, 38, 14);
		contentPane.add(lblTalla);
		
		textTalla = new JTextField();
		textTalla.setBounds(350, 90, 92, 20);
		contentPane.add(textTalla);
		textTalla.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Arial", Font.PLAIN, 14));
		lblResultado.setBounds(10, 141, 92, 14);
		contentPane.add(lblResultado);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		contentPane.add(textArea);
	
		JScrollPane scrollArea = new JScrollPane();
		scrollArea.setViewportView(textArea);
		scrollArea.setBounds(10, 166, 501, 183);
		contentPane.add(scrollArea);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(96, 363, 89, 23);
		btnRegistrar.addActionListener(this);
		contentPane.add(btnRegistrar);
		
		btnListaPersonas = new JButton("Lista Personas");
		btnListaPersonas.setBounds(195, 363, 131, 23);
		btnListaPersonas.addActionListener(this);
		contentPane.add(btnListaPersonas);
		
		btnCalcularIMC = new JButton("Calcular Promedio IMC");
		btnCalcularIMC.setBounds(336, 363, 157, 23);
		btnCalcularIMC.addActionListener(this);
		contentPane.add(btnCalcularIMC);
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRegistrar) {
			PersonaVO miPersona = new PersonaVO();
			
			miPersona.setDocumento(textDocumento.getText());
			miPersona.setNombre(textNombre.getText());
			miPersona.setEdad(Integer.parseInt(textEdad.getText()));
			miPersona.setPeso(Double.parseDouble(textPeso.getText()));
			miPersona.setTalla(Double.parseDouble(textTalla.getText()));
			
			String res = miLogica.registrarPersona(miPersona);
			textArea.setText(res);
		}
		
		if (e.getSource()==btnListaPersonas) {
			String resultado = miLogica.consultarLista();
			textArea.setText(resultado);
		}
		
		if (e.getSource()==btnCalcularIMC) {
			String resultado = miLogica.consultarPromedio();
			textArea.setText(resultado);
		}
		
	}
}
