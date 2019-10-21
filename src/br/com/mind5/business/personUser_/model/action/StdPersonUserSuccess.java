package br.com.mind5.business.personUser_.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personUser_.info.PersonUserInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersonUserSuccess implements ActionStd<PersonUserInfo> {
	private ActionStd<PersonUserInfo> actionHelper;
	
	
	public StdPersonUserSuccess(DeciTreeOption<PersonUserInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<PersonUserInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<PersonUserInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<PersonUserInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new PersonUserInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersonUserInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonUserInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
