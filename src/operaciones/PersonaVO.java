package operaciones;

public class PersonaVO {
	String documento,nombre,imcMsj;
	int edad;
	double peso,talla,imc;
	
	public PersonaVO() {
		
	}

	public PersonaVO(String documento, String nombre, int edad, double peso, double talla, double imc) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.talla = talla;
		this.imc = imc;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getTalla() {
		return talla;
	}

	public void setTalla(double talla) {
		this.talla = talla;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}
	
	public String getImcMsj() {
		return imcMsj;
	}

	public void setImcMsj(String imcMsj) {
		this.imcMsj = imcMsj;
	}
	
	
}
