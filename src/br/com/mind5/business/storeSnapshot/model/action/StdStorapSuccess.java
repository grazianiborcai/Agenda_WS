package br.com.mind5.business.storeSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorapSuccess implements ActionStd<StorapInfo> {
	private ActionStd<StorapInfo> actionHelper;
	
	
	public StdStorapSuccess(DeciTreeOption<StorapInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult(option.recordInfos));
	}
	
	
	
	private DeciResult<StorapInfo> buildDeciResult(List<StorapInfo> recordInfos) {
		final boolean SUCCESS = true;
		
		DeciResultHelper<StorapInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<StorapInfo> results = new ArrayList<>();
		results.addAll(recordInfos);
		deciResult.resultset = results;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StorapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StorapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
