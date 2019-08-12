package br.com.gda.business.schedule.model.action;

import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdScheduMergeMat implements ActionStd<ScheduInfo> {
	private ActionStd<ScheduInfo> actionHelper;	
	
	
	public StdScheduMergeMat(DeciTreeOption<ScheduInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiScheduMergeMat(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<ScheduInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<ScheduInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
