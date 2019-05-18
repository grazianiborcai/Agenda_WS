package br.com.gda.business.materialSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatsnapMergeMatCateg implements ActionStd<MatsnapInfo> {
	private ActionStd<MatsnapInfo> actionHelper;	
	
	
	public StdMatsnapMergeMatCateg(DeciTreeOption<MatsnapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiMatsnapMergeMatCateg(option.conn, option.schemaName));
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
