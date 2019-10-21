package br.com.mind5.business.materialStore.model.action;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatoreMergeMat implements ActionStd<MatoreInfo> {
	private ActionStd<MatoreInfo> actionHelper;	
	
	
	public StdMatoreMergeMat(DeciTreeOption<MatoreInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMatoreMergeMat(option.conn, option.schemaName));
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
