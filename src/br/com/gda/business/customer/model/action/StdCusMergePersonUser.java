package br.com.gda.business.customer.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCusMergePersonUser implements ActionStd<CusInfo> {
	private ActionStd<CusInfo> actionHelper;	
	
	
	public StdCusMergePersonUser(DeciTreeOption<CusInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiCusMergePersonUser(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
