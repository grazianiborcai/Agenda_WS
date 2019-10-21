package br.com.mind5.business.scheduleLine.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class StdSchedineSuccess implements ActionStd<SchedineInfo> {
	private ActionStd<SchedineInfo> actionHelper;
	
	
	public StdSchedineSuccess(DeciTreeOption<SchedineInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult(option.recordInfos));
	}
	
	
	
	private DeciResult<SchedineInfo> buildDeciResult(List<SchedineInfo> recordInfos) {
		final boolean SUCCESS = true;
		
		DeciResultHelper<SchedineInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<SchedineInfo> results = new ArrayList<>();
		results.addAll(recordInfos);
		deciResult.resultset = results;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedineInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedineInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
