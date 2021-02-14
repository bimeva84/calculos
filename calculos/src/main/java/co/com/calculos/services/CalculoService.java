package co.com.calculos.services;

import java.util.List;

import javax.script.ScriptException;

import co.com.calculos.dto.ResponseDto;

public interface CalculoService {
	public ResponseDto agregarOperando(Integer operando);
	public ResponseDto calcular(String operador) throws ScriptException;
	public void llenarOperandos(List<Integer> ingresados);
	public ResponseDto limpiar();
}
