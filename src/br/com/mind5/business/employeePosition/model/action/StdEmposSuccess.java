package br.com.mind5.business.employeePosition.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmposSuccess implements ActionStd<EmposInfo> {
	private ActionStd<EmposInfo> actionHelper;
	
	
	public StdEmposSuccess(DeciTreeOption<EmposInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<EmposInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<EmposInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<EmposInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new EmposInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmposInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmposInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
