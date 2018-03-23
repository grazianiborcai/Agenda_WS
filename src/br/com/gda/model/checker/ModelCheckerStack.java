package br.com.gda.model.checker;

import java.util.List;


public final class ModelCheckerStack<T> extends ModelCheckerAbstract<T>{
	private List<ModelCheckerAbstract<T>> stackChecker;
	private ModelCheckerAbstract<T> failedChecker;
	
	public ModelCheckerStack(List<ModelCheckerAbstract<T>> stack) {
		super();	
		stackChecker = stack;
	}
	
	
	
	@Override protected boolean checkHook(T recordInfo) {		
		for (ModelCheckerAbstract<T> eachChecker : this.stackChecker) {
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
