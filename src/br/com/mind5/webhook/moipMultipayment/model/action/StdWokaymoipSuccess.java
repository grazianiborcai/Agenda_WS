package br.com.mind5.webhook.moipMultipayment.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

public final class StdWokaymoipSuccess implements ActionStd<WokaymoipInfo> {
	private ActionStd<WokaymoipInfo> actionHelper;
	
	
	public StdWokaymoipSuccess(DeciTreeOption<WokaymoipInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult(option));
	}
	
	
	
	private DeciResult<WokaymoipInfo> buildDeciResult(DeciTreeOption<WokaymoipInfo> option) {
		final boolean SUCCESS = true;
		
		DeciResultHelper<WokaymoipInfo> deciResult = new DeciResultHelper<>();
		
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<WokaymoipInfo> resultset = new ArrayList<>();
		resultset.add(new WokaymoipInfo());
		deciResult.resultset = resultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<WokaymoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<WokaymoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
