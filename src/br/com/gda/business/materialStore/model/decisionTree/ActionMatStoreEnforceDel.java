package br.com.gda.business.materialStore.model.decisionTree;

import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionMatStoreEnforceDel implements ActionStd<MatStoreInfo> {
	private ActionStd<MatStoreInfo> actionHelper;	
	
	
	public ActionMatStoreEnforceDel(DeciTreeOption<MatStoreInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisitorMatStoreEnforceDel());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatStoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatStoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
