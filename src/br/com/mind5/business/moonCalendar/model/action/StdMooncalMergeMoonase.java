package br.com.mind5.business.moonCalendar.model.action;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMooncalMergeMoonase implements ActionStd<MooncalInfo> {
	private ActionStd<MooncalInfo> actionHelper;	
	
	
	public StdMooncalMergeMoonase(DeciTreeOption<MooncalInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMooncalMergeMoonase(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MooncalInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MooncalInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}