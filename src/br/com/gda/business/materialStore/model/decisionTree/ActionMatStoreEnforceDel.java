package br.com.gda.business.materialStore.model.decisionTree;

import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperTrans;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionMatStoreEnforceDel implements DeciAction<MatStoreInfo> {
	private DeciAction<MatStoreInfo> actionHelper;	
	
	
	public ActionMatStoreEnforceDel(DeciTreeOption<MatStoreInfo> option) {			
		actionHelper = new DeciActionHelperTrans<>(option.recordInfos, new VisitorMatStoreEnforceDel());
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<MatStoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatStoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
