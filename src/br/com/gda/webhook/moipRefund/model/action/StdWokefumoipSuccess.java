package br.com.gda.webhook.moipRefund.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.commom.ActionStdDummy;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.webhook.moipRefund.info.WokefumoipInfo;

public final class StdWokefumoipSuccess implements ActionStd<WokefumoipInfo> {
	private ActionStd<WokefumoipInfo> actionHelper;
	
	
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
	
	
	
	@Override public void addPostAction(ActionLazy<WokefumoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<WokefumoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
