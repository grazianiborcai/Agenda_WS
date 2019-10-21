package br.com.mind5.business.materialSnapshot.model.action;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatsnapMergeMatextsnap implements ActionStd<MatsnapInfo> {
	private ActionStd<MatsnapInfo> actionHelper;	
	
	
	public StdMatsnapMergeMatextsnap(DeciTreeOption<MatsnapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMatsnapMergeMatextsnap(option.conn, option.schemaName));
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
