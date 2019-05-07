package br.com.gda.business.materialStore.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatoreMergeMatock implements ActionStd<MatoreInfo> {
	private ActionStd<MatoreInfo> actionHelper;	
	
	
	public StdMatoreMergeMatock(DeciTreeOption<MatoreInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMatoreMergeMatock(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
