package br.com.gda.business.customerSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customerSnapshot.info.CusnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.commom.ActionStdDummy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCusSuccess_ implements ActionStd<CusnapInfo> {
	private ActionStd<CusnapInfo> actionHelper;
	
	
	public StdCusSuccess_(DeciTreeOption<CusnapInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<CusnapInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<CusnapInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<CusnapInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new CusnapInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
