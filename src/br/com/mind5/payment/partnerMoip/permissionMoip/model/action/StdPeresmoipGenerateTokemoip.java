package br.com.mind5.payment.partnerMoip.permissionMoip.model.action;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class StdPeresmoipGenerateTokemoip implements ActionStd<PeresmoipInfo> {
	private ActionStd<PeresmoipInfo> actionHelper;	
	
	
	public StdPeresmoipGenerateTokemoip(DeciTreeOption<PeresmoipInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiPeresmoipGenerateTokemoip(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PeresmoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PeresmoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
