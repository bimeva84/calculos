package co.com.calculos.dto;

public class ResponseDto {
	
	/**
	 * Cadena de errores ocurridos durante la ejecución del servicio
	 */
	StringBuilder error = new StringBuilder();
	
	/**
	 * Código que identifica el estado de ejecución del servicio
	 */
	Integer status;
		
	/**
	 * Objeto que contiene información extraída por el servicio
	 */
	Object body;
	
	
	/**
	 * Métodos GET y SET 
	 */
	

	/**
	 * Método que retorna el valor de la variable error
	 * @return error
	 */
	public StringBuilder getError() {
		return error;
	}

	/**
	 * Método set para la variable error
	 * @param error 
	 */
	public void setError(StringBuilder error) {
		this.error = error;
	}

	/**
	 * Método que retorna el valor de la variable status
	 * @return status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Método set para la variable status
	 * @param status 
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Método que retorna el valor de la variable body
	 * @return body
	 */
	public Object getBody() {
		return body;
	}

	/**
	 * Método set para la variable body
	 * @param body 
	 */
	public void setBody(Object body) {
		this.body = body;
	}
	
}
