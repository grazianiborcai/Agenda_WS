package br.com.mind5.business.material.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatSuccess implements ActionStd<MatInfo> {
	private ActionStd<MatInfo> actionHelper;
	
	
	public StdMatSuccess(DeciTreeOption<MatInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<MatInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<MatInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<MatInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new MatInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
