package br.com.gda.business.materialSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperAction;
import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatsnapInsertMatextsnap implements ActionStd<MatsnapInfo> {
	private ActionStd<MatsnapInfo> actionHelper;	
	
	
	public StdMatsnapInsertMatextsnap(DeciTreeOption<MatsnapInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiMatsnapInsertMatextsnap(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatsnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatsnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
