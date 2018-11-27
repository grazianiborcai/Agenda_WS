package br.com.gda.business.person.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.commom.ActionStdDummy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPersonSuccess implements ActionStd<PersonInfo> {
	private ActionStd<PersonInfo> actionHelper;
	
	
	public StdPersonSuccess(DeciTreeOption<PersonInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<PersonInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<PersonInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<PersonInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new PersonInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersonInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
