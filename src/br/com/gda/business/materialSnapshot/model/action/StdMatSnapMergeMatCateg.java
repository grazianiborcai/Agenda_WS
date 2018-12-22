package br.com.gda.business.materialSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatSnapMergeMatCateg implements ActionStd<MatSnapInfo> {
	private ActionStd<MatSnapInfo> actionHelper;	
	
	
	public StdMatSnapMergeMatCateg(DeciTreeOption<MatSnapInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiMatSnapMergeMatCateg(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatSnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatSnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
