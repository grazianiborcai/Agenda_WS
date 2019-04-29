package br.com.gda.business.storeList.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdStolisMergeCurrency implements ActionStd<StolisInfo> {
	private ActionStd<StolisInfo> actionHelper;	
	
	
	public StdStolisMergeCurrency(DeciTreeOption<StolisInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiStolisMergeCurrency(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StolisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StolisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
