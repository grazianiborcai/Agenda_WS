package br.com.gda.business.schedule.model.action;

import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdScheduEnforceLChanged implements ActionStd<ScheduInfo> {
	private ActionStd<ScheduInfo> actionHelper;	
	
	
	public StdScheduEnforceLChanged(DeciTreeOption<ScheduInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiScheduEnforceLChanged());
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
