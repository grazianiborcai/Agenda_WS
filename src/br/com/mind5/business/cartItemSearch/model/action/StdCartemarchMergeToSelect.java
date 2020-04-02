package br.com.mind5.business.cartItemSearch.model.action;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartemarchMergeToSelect implements ActionStdV1<CartemarchInfo> {
	private ActionStdV1<CartemarchInfo> actionHelper;	
	
	
	public StdCartemarchMergeToSelect(DeciTreeOption<CartemarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCartemarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CartemarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartemarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
