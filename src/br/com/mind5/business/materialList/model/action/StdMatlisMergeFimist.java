package br.com.mind5.business.materialList.model.action;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatlisMergeFimist implements ActionStd<MatlisInfo> {
	private ActionStd<MatlisInfo> actionHelper;	
	
	
	public StdMatlisMergeFimist(DeciTreeOption<MatlisInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMatlisMergeFimist(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatlisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatlisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}