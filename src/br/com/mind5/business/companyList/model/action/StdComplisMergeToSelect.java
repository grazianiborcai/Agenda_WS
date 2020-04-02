package br.com.mind5.business.companyList.model.action;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdComplisMergeToSelect implements ActionStdV1<ComplisInfo> {
	private ActionStdV1<ComplisInfo> actionHelper;	
	
	
	public StdComplisMergeToSelect(DeciTreeOption<ComplisInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiComplisMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<ComplisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<ComplisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
