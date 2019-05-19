package br.com.gda.business.materialTextSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatextsnapMergeMatext implements ActionStd<MatextsnapInfo> {
	private ActionStd<MatextsnapInfo> actionHelper;	
	
	
	public StdMatextsnapMergeMatext(DeciTreeOption<MatextsnapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMatextsnapMergeMatext(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatextsnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatextsnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
