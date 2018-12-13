package br.com.gda.business.personSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPersonSnapMergeSnap implements ActionStd<PersonSnapInfo> {
	private ActionStd<PersonSnapInfo> actionHelper;	
	
	
	public StdPersonSnapMergeSnap(DeciTreeOption<PersonSnapInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPersonSnapMergeSnap(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersonSnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonSnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
