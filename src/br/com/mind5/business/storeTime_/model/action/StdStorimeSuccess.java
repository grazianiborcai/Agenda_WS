package br.com.mind5.business.storeTime_.model.action;

import br.com.mind5.business.storeTime_.info.StorimeInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorimeSuccess implements ActionStd<StorimeInfo> {
	private ActionStd<StorimeInfo> actionHelper;
	
	
	public StdStorimeSuccess(DeciTreeOption<StorimeInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult(option));
	}
	
	
	
	private DeciResult<StorimeInfo> buildDeciResult(DeciTreeOption<StorimeInfo> option) {
		final boolean SUCCESS = true;
		
		DeciResultHelper<StorimeInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;		
		deciResult.resultset = option.recordInfos;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StorimeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StorimeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
