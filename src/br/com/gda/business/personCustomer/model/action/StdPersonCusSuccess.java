package br.com.gda.business.personCustomer.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.commom.ActionStdDummy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPersonCusSuccess implements ActionStd<PersonCusInfo> {
	private ActionStd<PersonCusInfo> actionHelper;
	
	
	public StdPersonCusSuccess(DeciTreeOption<PersonCusInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<PersonCusInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<PersonCusInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<PersonCusInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new PersonCusInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersonCusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonCusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
