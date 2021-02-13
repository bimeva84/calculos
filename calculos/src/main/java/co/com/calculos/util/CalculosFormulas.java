package co.com.calculos.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public final class CalculosFormulas {
	/**
	 * 
	 * @param formula
	 * @return
	 * @throws ScriptException
	 */
	public static Double calculoScriptEngine(String formula) throws ScriptException {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        Object obj = engine.eval(formula);
        return Double.valueOf(obj.toString());
    }
}
