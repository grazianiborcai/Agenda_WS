package br.com.mind5.business.moonCalendar.model.action;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMooncalMergeToSelect implements ActionStdV1<MooncalInfo> {
	private ActionStdV1<MooncalInfo> actionHelper;	
	
	
	public StdMooncalMergeToSelect(DeciTreeOption<MooncalInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMooncalMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MooncalInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MooncalInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
