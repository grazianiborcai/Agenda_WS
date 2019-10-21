package br.com.mind5.business.companyList.model.action;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdComplisMergeToSelect implements ActionStd<ComplisInfo> {
	private ActionStd<ComplisInfo> actionHelper;	
	
	
	public StdComplisMergeToSelect(DeciTreeOption<ComplisInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiComplisMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<ComplisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<ComplisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
