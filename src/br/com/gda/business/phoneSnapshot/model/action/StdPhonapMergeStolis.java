package br.com.gda.business.phoneSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPhonapMergeStolis implements ActionStd<PhonapInfo> {
	private ActionStd<PhonapInfo> actionHelper;	
	
	
	public StdPhonapMergeStolis(DeciTreeOption<PhonapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPhonapMergeStolis(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PhonapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PhonapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
