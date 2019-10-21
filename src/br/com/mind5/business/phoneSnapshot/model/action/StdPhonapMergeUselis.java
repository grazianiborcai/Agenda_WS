package br.com.mind5.business.phoneSnapshot.model.action;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhonapMergeUselis implements ActionStd<PhonapInfo> {
	private ActionStd<PhonapInfo> actionHelper;	
	
	
	public StdPhonapMergeUselis(DeciTreeOption<PhonapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPhonapMergeUselis(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PhonapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PhonapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
