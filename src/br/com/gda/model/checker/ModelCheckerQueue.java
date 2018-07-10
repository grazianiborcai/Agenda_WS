package br.com.gda.model.checker;

import java.sql.Connection;
import java.util.List;


public final class ModelCheckerQueue<T> extends ModelCheckerTemplateSimple<T>{
	private List<ModelChecker<T>> queueChecker; //TODO: renomear variáveis de Stack para Queue nas subclasses
	private ModelChecker<T> failedChecker;
	
	public ModelCheckerQueue(List<ModelChecker<T>> stack) {
		super();	
		queueChecker = stack;
	}
	
	
	
	@Override protected boolean checkHook(T recordInfo, Connection conn, String schemaName) {		
		for (ModelChecker<T> eachChecker : this.queueChecker) {
			boolean resultChecker = eachChecker.check(recordInfo);
			
			if (resultChecker == FAILED) {
				failedChecker = eachChecker;
				return FAILED;
			}
		}
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return failedChecker.getFailureExplanation();
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return failedChecker.getFailureCode();
	}
}
