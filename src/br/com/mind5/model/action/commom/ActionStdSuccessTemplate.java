package br.com.mind5.model.action.commom;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public abstract class ActionStdSuccessTemplate<T extends InfoRecord> implements ActionStd<T> {
	private ActionStd<T> helper;
	
	
	public ActionStdSuccessTemplate(DeciTreeOption<T> option) {
		helper = new ActionStdDummy<>(buildDeciResult(option));
	}
	
	
	
	private DeciResult<T> buildDeciResult(DeciTreeOption<T> option) {
		final boolean SUCCESS = true;
		
		DeciResultHelper<T> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<T> dummyResultset = new ArrayList<>();
		dummyResultset.addAll(option.recordInfos);
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<T> actionHandler) {
		helper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return helper.executeAction();
	}
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		return helper.getDecisionResult();
	}
}
