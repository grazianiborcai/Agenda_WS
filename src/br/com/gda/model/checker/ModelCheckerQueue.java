package br.com.gda.model.checker;

import java.sql.Connection;
import java.util.List;


public final class ModelCheckerQueue<T> extends ModelCheckerTemplateSimple<T>{
	private List<ModelChecker<T>> queueChecker;
	private ModelChecker<T> failedChecker;
	
	public ModelCheckerQueue(List<ModelChecker<T>> queue) {
		super();	
		queueChecker = queue;
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
		return failedChecker.getFailMessage();
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return failedChecker.getFailCode();
	}
}
