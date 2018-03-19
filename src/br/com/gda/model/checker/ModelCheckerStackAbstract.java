package br.com.gda.model.checker;

import java.util.List;

import br.com.gda.common.SystemMessage;


public abstract class ModelCheckerStackAbstract<T> extends ModelCheckerAbstract<T>{
	private List<ModelCheckerAbstract<T>> stackChecker;
	private ModelCheckerAbstract<T> failedChecker;
	
	public ModelCheckerStackAbstract() {
		super();	
		stackChecker = buildStackCheckerHook();
	}
	
	
	
	protected List<ModelCheckerAbstract<T>> buildStackCheckerHook() {
		//Template method: to be overwritten by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
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
