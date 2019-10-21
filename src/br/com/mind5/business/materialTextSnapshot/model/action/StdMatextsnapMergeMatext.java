package br.com.mind5.business.materialTextSnapshot.model.action;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
