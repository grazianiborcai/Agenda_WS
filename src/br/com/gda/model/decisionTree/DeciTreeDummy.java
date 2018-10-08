package br.com.gda.model.decisionTree;

import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;

public final class DeciTreeDummy<T> implements DeciTree<T> {
	private DeciResultHelper<T> dummyResult;
	private List<T> dummyResultset;
	
	
	
	public DeciTreeDummy(List<T> dummyRecords) {
		checkArgument(dummyRecords);
		dummyResultset = dummyRecords;
		
		buildDummyResult();
	}
	
	
	
	private void checkArgument(List<T> dummyRecords) {
		if (dummyRecords == null)
			throw new NullPointerException("dummyRecords" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private void buildDummyResult() {
		dummyResult = new DeciResultHelper<>();
		
		dummyResult.resultset = dummyResultset;
		dummyResult.finishedWithSuccess = true;
		dummyResult.hasResultset = true;
	}
	
	
	
	@Override public void makeDecision() {
		//Do nothing
	}

	
	
	@Override public DeciChoice getDecisionMade() {
		return DeciChoice.PASSED;
	}

	
	
	@Override public DeciResult<T> getDecisionResult() {
		return dummyResult;
	}

	
	
	@Override public ActionStd<T> toAction() {
		return new DeciTreeAdapter<>(this);
	}
}
