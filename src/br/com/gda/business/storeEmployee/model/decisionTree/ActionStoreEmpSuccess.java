package br.com.gda.business.storeEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperDummy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionStoreEmpSuccess implements DeciAction<StoreEmpInfo> {
	DeciAction<StoreEmpInfo> actionHelper;
	
	
	public ActionStoreEmpSuccess(DeciTreeOption<StoreEmpInfo> option) {
		actionHelper = new DeciActionHelperDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<StoreEmpInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<StoreEmpInfo> deciResult = new DeciResultHelper<>();
		deciResult.finishedWithSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<StoreEmpInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new StoreEmpInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<StoreEmpInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreEmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
