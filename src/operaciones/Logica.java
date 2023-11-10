package operaciones;

import java.util.ArrayList;
import java.util.Iterator;

public class Logica {
	
	double imc;
	ArrayList<PersonaVO> listPersonas;
	
	public Logica() {
		listPersonas = new ArrayList<PersonaVO>();
	}
	
	public String registrarPersona(PersonaVO per) {
		String resultado = "Registro de persona exitoso\n";
		resultado+="Documento: " + per.getDocumento() + "\n";
		resultado+="Nombre: " + per.getNombre() + "\n";
		resultado+="Edad: " + per.getEdad() + "\n";
		resultado+="Peso: " + per.getPeso() + "\n";
		resultado+="Talla: " + per.getTalla() + "\n";
		imc = per.getPeso() / (per.getTalla() * per.getTalla());
		String imcMsj = calcularIMC(imc);
		
		per.setImcMsj(imcMsj);
		resultado+="" +imcMsj+"\n";
		per.setImc(this.imc);
		
		listPersonas.add(per);
		
		return resultado;
	}
	
	public String calcularIMC(double imc){
		
		String conclusion = "";
		
		if (imc < 18) {
			conclusion = "Anorexia";
		}else if(imc >= 18 && imc < 20) {
			conclusion = "Delgadez";
		}else if(imc >= 20 && imc < 27) {
			conclusion = "Normalidad";
		}else if(imc >= 27 && imc < 30) {
			conclusion = "Obesidad (Grado 1)";
		}else if(imc >= 30 && imc < 35) {
			conclusion = "Obesidad (Grado 2)";
		}else if(imc >= 35 && imc < 40) {
			conclusion = "Obesidad (Grado 3)";
		}else if(imc >= 40) {
			conclusion = "Obesidad morbida";
		}
		
		return "IMC: "+imc+" segun su imc usted tiene: "+conclusion;
	}
	
	public String consultarLista() {
		String resultado = "";
		PersonaVO p = null;
		
		for (int i = 0; i < listPersonas.size(); i++) {
			p = listPersonas.get(i);
			resultado+="Documento: " + p.getDocumento() + "\n";
			resultado+="Nombre: " + p.getNombre() + "\n";
			resultado+="Edad: " + p.getEdad() + "\n";
			resultado+="Peso: " + p.getPeso() + "\n";
			resultado+="Talla: " + p.getTalla() + "\n";
			resultado+="" + p.getImcMsj() + "\n";
			resultado+="***********************\n";
		}
		
		return resultado;
	}

	public String consultarPromedio() {
		String resultado = "";
		double suma = 0;
		for (int i = 0; i < listPersonas.size(); i++) {
			suma = suma + listPersonas.get(i).getImc();
		}
		double prom = suma/listPersonas.size();
		resultado = calcularIMC(prom);
		return resultado;
	}
}
