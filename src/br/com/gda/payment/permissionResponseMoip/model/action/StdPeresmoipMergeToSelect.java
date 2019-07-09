package br.com.gda.payment.permissionResponseMoip.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.permissionResponseMoip.info.PeresmoipInfo;

public final class StdPeresmoipMergeToSelect implements ActionStd<PeresmoipInfo> {
	private ActionStd<PeresmoipInfo> actionHelper;	
	
	
	public StdPeresmoipMergeToSelect(DeciTreeOption<PeresmoipInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPeresmoipMergeToSelect(option.conn, option.schemaName));
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
