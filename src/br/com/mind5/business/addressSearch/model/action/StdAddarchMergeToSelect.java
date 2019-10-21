package br.com.mind5.business.addressSearch.model.action;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddarchMergeToSelect implements ActionStd<AddarchInfo> {
	private ActionStd<AddarchInfo> actionHelper;	
	
	
	public StdAddarchMergeToSelect(DeciTreeOption<AddarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiAddarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AddarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AddarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
