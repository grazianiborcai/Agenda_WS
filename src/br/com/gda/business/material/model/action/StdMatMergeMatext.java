package br.com.gda.business.material.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatMergeMatext implements ActionStd<MatInfo> {
	private ActionStd<MatInfo> actionHelper;	
	
	
	public StdMatMergeMatext(DeciTreeOption<MatInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiMatMergeMatext(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
