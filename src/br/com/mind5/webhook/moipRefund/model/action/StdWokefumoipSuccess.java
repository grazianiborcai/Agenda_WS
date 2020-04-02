package br.com.mind5.webhook.moipRefund.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

public final class StdWokefumoipSuccess implements ActionStdV1<WokefumoipInfo> {
	private ActionStdV1<WokefumoipInfo> actionHelper;
	
	
	public StdWokefumoipSuccess(DeciTreeOption<WokefumoipInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult(option));
	}
	
	
	
	private DeciResult<WokefumoipInfo> buildDeciResult(DeciTreeOption<WokefumoipInfo> option) {
		final boolean SUCCESS = true;
		
		DeciResultHelper<WokefumoipInfo> deciResult = new DeciResultHelper<>();
		
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<WokefumoipInfo> resultset = new ArrayList<>();
		resultset.add(new WokefumoipInfo());
		deciResult.resultset = resultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<WokefumoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<WokefumoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
