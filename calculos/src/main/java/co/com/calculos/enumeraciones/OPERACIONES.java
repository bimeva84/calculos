package co.com.calculos.enumeraciones;

public enum OPERACIONES {
	
	SUMA("SUMA","+"),
	RESTA("RESTA","-"),
	MULTIPLICACION("MULTIPLICACION","*"),
	DIVISION("DIVISION","/"),
	POTENCIACION("POTENCIACION","Math.pow");
	
	
	final String nombre;
	final String operador;
	
	private OPERACIONES (String nombre, String operador) {
		this.nombre = nombre;
		this.operador = operador;
	}
	
	/**
	 * Retorna el nombre de la enumeración
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	public String getOperador() {
		return operador;
	}
}
