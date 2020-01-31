package br.com.mind5.business.personListRestricted.model.action;

import br.com.mind5.business.personListRestricted.info.PersoresInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersoresMergePersolis implements ActionStd<PersoresInfo> {
	private ActionStd<PersoresInfo> actionHelper;	
	
	
	public StdPersoresMergePersolis(DeciTreeOption<PersoresInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPersoresMergePersolis(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersoresInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersoresInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
