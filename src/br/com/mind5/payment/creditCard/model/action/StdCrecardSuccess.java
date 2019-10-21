package br.com.mind5.payment.creditCard.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class StdCrecardSuccess implements ActionStd<CrecardInfo> {
	private ActionStd<CrecardInfo> actionHelper;
	
	
	public StdCrecardSuccess(DeciTreeOption<CrecardInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult(option));
	}
	
	
	
	private DeciResult<CrecardInfo> buildDeciResult(DeciTreeOption<CrecardInfo> option) {
		final boolean SUCCESS = true;
		
		DeciResultHelper<CrecardInfo> deciResult = new DeciResultHelper<>();
		
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<CrecardInfo> resultset = new ArrayList<>();
		
		if (option.recordInfos != null)		
			resultset.addAll(option.recordInfos);
		
		deciResult.resultset = resultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CrecardInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CrecardInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
