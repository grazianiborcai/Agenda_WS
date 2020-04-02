package br.com.mind5.masterData.moonPhase.model.action;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMoonaseMergeMoonasarch implements ActionStdV1<MoonaseInfo> {
	private ActionStdV1<MoonaseInfo> actionHelper;	
	
	
	public StdMoonaseMergeMoonasarch(DeciTreeOption<MoonaseInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMoonaseMergeMoonasarch(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MoonaseInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MoonaseInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
