package br.com.mind5.security.jwtToken.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;

public final class StdJwtokenSuccess implements ActionStdV1<JwtokenInfo> {
	private ActionStdV1<JwtokenInfo> actionHelper;
	
	
	public StdJwtokenSuccess(DeciTreeOption<JwtokenInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<JwtokenInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<JwtokenInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<JwtokenInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new JwtokenInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<JwtokenInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<JwtokenInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
