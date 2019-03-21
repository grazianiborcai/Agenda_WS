package br.com.gda.business.materialMovement.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatmovMergeMat implements ActionStd<MatmovInfo> {
	private ActionStd<MatmovInfo> actionHelper;	
	
	
	public StdMatmovMergeMat(DeciTreeOption<MatmovInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiMatmovMergeMat(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatmovInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatmovInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
