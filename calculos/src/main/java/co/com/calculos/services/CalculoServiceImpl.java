package co.com.calculos.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.script.ScriptException;

import org.springframework.stereotype.Service;

import co.com.calculos.enumeraciones.OPERACIONES;
import co.com.calculos.util.CalculosFormulas;
import co.com.calculos.util.Constantes;
import co.com.calculos.dto.ResponseDto;

@Service
public class CalculoServiceImpl implements CalculoService {
	
	ResponseDto response;

	private static List<Integer> operandos = new ArrayList<>();
	

	@Override
	public ResponseDto agregarOperando(Integer operando) {
		response = new ResponseDto();
		
		operandos.add(operando);
		
		response.setBody(Constantes.OK);
		response.setStatus(200);
		return response;
	}

	@Override
	public ResponseDto calcular(String operador) throws ScriptException {
		response = new ResponseDto();
		Double resultado;
		String formula = null;
		Integer[] arregloNumeros = { 20, 2, 4, 2, 5 };
		List<Integer> numeros = Arrays.asList(arregloNumeros);
		llenarOperandos(numeros);
		
		switch (OPERACIONES.valueOf(operador)) {
		case SUMA:
			formula = organizarFormula(OPERACIONES.SUMA.getOperador());
			break;
		case RESTA:
			formula = organizarFormula(OPERACIONES.RESTA.getOperador());
			break;
		case MULTIPLICACION:
			formula = organizarFormula(OPERACIONES.MULTIPLICACION.getOperador());
			break;
		case DIVISION:
			formula = organizarFormula(OPERACIONES.DIVISION.getOperador());
			break;
		case POTENCIACION:
			formula = organizarFormula(OPERACIONES.POTENCIACION.getOperador());
			break;

		default:
			break;
		}
		
		resultado = CalculosFormulas.calculoScriptEngine(formula);
		
		response.setBody(resultado);
		response.setStatus(200);
		return response;
	}
	
	/**
	 * 
	 * @param operador
	 * @return
	 */
	private String organizarFormula(String operador) {
		String formulaFinal = "";
		if(OPERACIONES.POTENCIACION.getOperador().equals(operador)) {
			for (int i = 0; i < operandos.size(); i++) {
				if(formulaFinal.isEmpty()) {
					formulaFinal = operador + "("+ operandos.get(i) + "," + operandos.get(i+1) +")";
					i++;
				}else {
					formulaFinal = operador + "("+ formulaFinal + "," + operandos.get(i) +")";
				}
			}
			return formulaFinal;
		}else {
			for (Integer operando : operandos) {
				formulaFinal += operando.toString() + operador;
			}
			return formulaFinal.substring(0,formulaFinal.length()-1);
		}
		
	}
	
	/**
	 * 
	 */
	@Override
	public void llenarOperandos(List<Integer> ingresados) {
		operandos = ingresados;
	}

}
