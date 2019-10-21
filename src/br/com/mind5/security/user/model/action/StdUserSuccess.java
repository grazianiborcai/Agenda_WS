package br.com.mind5.security.user.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;

public final class StdUserSuccess implements ActionStd<UserInfo> {
	private ActionStd<UserInfo> actionHelper;
	
	
	public StdUserSuccess(DeciTreeOption<UserInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<UserInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<UserInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<UserInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new UserInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UserInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UserInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
