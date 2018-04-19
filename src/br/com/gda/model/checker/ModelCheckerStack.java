package br.com.gda.model.checker;

import java.sql.Connection;
import java.util.List;


public final class ModelCheckerStack<T> extends ModelCheckerTemplate<T>{
	private List<ModelChecker<T>> stackChecker;
	private ModelChecker<T> failedChecker;
	
	public ModelCheckerStack(List<ModelChecker<T>> stack) {
		super();	
		stackChecker = stack;
	}
	
	
	
	@Override protected boolean checkHook(T recordInfo, Connection conn, String schemaName) {		
		for (ModelChecker<T> eachChecker : this.stackChecker) {
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
