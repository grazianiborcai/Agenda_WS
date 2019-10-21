package br.com.mind5.business.owner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOwnerSuccess implements ActionStd<OwnerInfo> {
	private ActionStd<OwnerInfo> actionHelper;
	
	
	public StdOwnerSuccess(DeciTreeOption<OwnerInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<OwnerInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<OwnerInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<OwnerInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new OwnerInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OwnerInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnerInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
