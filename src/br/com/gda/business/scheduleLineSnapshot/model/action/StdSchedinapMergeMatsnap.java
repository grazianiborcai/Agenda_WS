package br.com.gda.business.scheduleLineSnapshot.model.action;

import br.com.gda.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSchedinapMergeMatsnap implements ActionStd<SchedinapInfo> {
	private ActionStd<SchedinapInfo> actionHelper;	
	
	
	public StdSchedinapMergeMatsnap(DeciTreeOption<SchedinapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiSchedinapMergeMatsnap(option.conn, option.schemaName));
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
