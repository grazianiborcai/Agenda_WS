package br.com.gda.business.owner.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdOwnerMergePerson implements ActionStd<OwnerInfo> {
	private ActionStd<OwnerInfo> actionHelper;	
	
	
	public StdOwnerMergePerson(DeciTreeOption<OwnerInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiOwnerMergePerson(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OwnerInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnerInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
