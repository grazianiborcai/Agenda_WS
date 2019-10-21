package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class StdSchedinapSuccess implements ActionStd<SchedinapInfo> {
	private ActionStd<SchedinapInfo> actionHelper;
	
	
	public StdSchedinapSuccess(DeciTreeOption<SchedinapInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult(option.recordInfos));
	}
	
	
	
	private DeciResult<SchedinapInfo> buildDeciResult(List<SchedinapInfo> recordInfos) {
		final boolean SUCCESS = true;
		
		DeciResultHelper<SchedinapInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<SchedinapInfo> results = new ArrayList<>();
		results.addAll(recordInfos);
		deciResult.resultset = results;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedinapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedinapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
