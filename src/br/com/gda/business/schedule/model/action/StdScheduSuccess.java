package br.com.gda.business.schedule.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.commom.ActionStdDummy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

public class StdScheduSuccess implements ActionStd<ScheduInfo> {
	private ActionStd<ScheduInfo> actionHelper;
	
	
	public StdScheduSuccess(DeciTreeOption<ScheduInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<ScheduInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<ScheduInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<ScheduInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new ScheduInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<ScheduInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<ScheduInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
