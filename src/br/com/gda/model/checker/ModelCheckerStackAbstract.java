package br.com.gda.model.checker;

import java.util.ArrayList;
import java.util.List;


public abstract class ModelCheckerStackAbstract<T> extends ModelCheckerAbstract<T>{
	private List<ModelCheckerAbstract<T>> stackChecker;
	private ModelCheckerAbstract<T> failedChecker;
	
	public ModelCheckerStackAbstract() {
		super();	
		stackChecker = buildStackCheckerHook();
	}
	
	
	
	protected List<ModelCheckerAbstract<T>> buildStackCheckerHook() {
		//Template method: to be overwritten by subclasses
		return new ArrayList<>();
	}
	
	
	
	@Override protected boolean checkHook(T recordInfo) {		
		for (ModelCheckerAbstract<T> eachChecker : this.stackChecker) {
			boolean resultChecker = eachChecker.check(recordInfo);
			if (resultChecker != eachChecker.getExpectedResult()) {
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
