package br.com.gda.business.customerSearch.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdCusarchMergeLangu implements ActionStd<CusarchInfo> {
	private ActionStd<CusarchInfo> actionHelper;	
	
	
	public StdCusarchMergeLangu(DeciTreeOption<CusarchInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiCusarchMergeLangu(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
