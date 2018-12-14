package br.com.gda.business.userSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.commom.ActionStdDummy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdUserSnapSuccess implements ActionStd<UserSnapInfo> {
	private ActionStd<UserSnapInfo> actionHelper;
	
	
	public StdUserSnapSuccess(DeciTreeOption<UserSnapInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<UserSnapInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<UserSnapInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<UserSnapInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new UserSnapInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<UserSnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UserSnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
