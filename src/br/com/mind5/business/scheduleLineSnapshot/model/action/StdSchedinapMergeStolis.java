package br.com.mind5.business.scheduleLineSnapshot.model.action;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedinapMergeStolis implements ActionStd<SchedinapInfo> {
	private ActionStd<SchedinapInfo> actionHelper;	
	
	
	public StdSchedinapMergeStolis(DeciTreeOption<SchedinapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSchedinapMergeStolis(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedinapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedinapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
