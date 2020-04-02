package br.com.mind5.business.personList.model.action;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersolisMergeToSelect implements ActionStdV1<PersolisInfo> {
	private ActionStdV1<PersolisInfo> actionHelper;	
	
	
	public StdPersolisMergeToSelect(DeciTreeOption<PersolisInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPersolisMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PersolisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersolisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
