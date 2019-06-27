package br.com.gda.payment.creditCard.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCrecardEnforceLChanged implements ActionStd<CrecardInfo> {
	private ActionStd<CrecardInfo> actionHelper;	
	
	
	public StdCrecardEnforceLChanged(DeciTreeOption<CrecardInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiCrecardEnforceLChanged());
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
