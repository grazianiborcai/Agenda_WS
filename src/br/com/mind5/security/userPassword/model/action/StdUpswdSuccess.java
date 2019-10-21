package br.com.mind5.security.userPassword.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class StdUpswdSuccess implements ActionStd<UpswdInfo> {
	private ActionStd<UpswdInfo> actionHelper;
	
	
	public StdUpswdSuccess(DeciTreeOption<UpswdInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<UpswdInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<UpswdInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<UpswdInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new UpswdInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UpswdInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UpswdInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
