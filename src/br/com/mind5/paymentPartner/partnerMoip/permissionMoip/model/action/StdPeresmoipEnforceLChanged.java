package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class StdPeresmoipEnforceLChanged implements ActionStdV1<PeresmoipInfo> {
	private ActionStdV1<PeresmoipInfo> actionHelper;	
	
	
	public StdPeresmoipEnforceLChanged(DeciTreeOption<PeresmoipInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPeresmoipEnforceLChanged());
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PeresmoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PeresmoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
