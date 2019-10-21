package br.com.mind5.business.orderItemSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class StdOrdemrapSuccess implements ActionStd<OrdemrapInfo> {
	private ActionStd<OrdemrapInfo> actionHelper;
	
	
	public StdOrdemrapSuccess(DeciTreeOption<OrdemrapInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<OrdemrapInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<OrdemrapInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<OrdemrapInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new OrdemrapInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrdemrapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdemrapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
