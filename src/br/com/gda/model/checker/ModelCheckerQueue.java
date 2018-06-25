package br.com.gda.model.checker;

import java.sql.Connection;
import java.util.List;


public final class ModelCheckerQueue<T> extends ModelCheckerTemplate<T>{
	private List<ModelChecker<T>> queueChecker; //TODO: renomear variáveis de Stack para Queue nas subclasses
	private ModelChecker<T> failedChecker;
	
	public ModelCheckerQueue(List<ModelChecker<T>> stack) {
		super();	
		queueChecker = stack;
	}
	
	
	
	@Override protected boolean checkHook(T recordInfo, Connection conn, String schemaName) {		
		for (ModelChecker<T> eachChecker : this.queueChecker) {
			boolean resultChecker = eachChecker.check(recordInfo);
			
			if (resultChecker == RESULT_FAILED) {
				failedChecker = eachChecker;
				return RESULT_FAILED;
			}
		}
		
		return RESULT_SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return failedChecker.getFailureExplanation();
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return failedChecker.getFailureCode();
	}
}
