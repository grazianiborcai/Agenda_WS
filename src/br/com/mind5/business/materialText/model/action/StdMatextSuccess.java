package br.com.mind5.business.materialText.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextSuccess implements ActionStd<MatextInfo> {
	private ActionStd<MatextInfo> actionHelper;
	
	
	public StdMatextSuccess(DeciTreeOption<MatextInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<MatextInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<MatextInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<MatextInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new MatextInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatextInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatextInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
