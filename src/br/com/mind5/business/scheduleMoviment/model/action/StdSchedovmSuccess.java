package br.com.mind5.business.scheduleMoviment.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class StdSchedovmSuccess implements ActionStdV1<SchedovmInfo> {
	private ActionStdV1<SchedovmInfo> actionHelper;
	
	
	public StdSchedovmSuccess(DeciTreeOption<SchedovmInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult(option.recordInfos));
	}
	
	
	
	private DeciResult<SchedovmInfo> buildDeciResult(List<SchedovmInfo> recordInfos) {
		final boolean SUCCESS = true;
		
		DeciResultHelper<SchedovmInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<SchedovmInfo> results = new ArrayList<>();
		results.addAll(recordInfos);
		deciResult.resultset = results;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedovmInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedovmInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
