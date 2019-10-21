package br.com.mind5.business.cartItem.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdDummy;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class StdCartemSuccess implements ActionStd<CartemInfo> {
	private ActionStd<CartemInfo> actionHelper;
	
	
	public StdCartemSuccess(DeciTreeOption<CartemInfo> option) {
		actionHelper = new ActionStdDummy<>(buildDeciResult());
	}
	
	
	
	private DeciResult<CartemInfo> buildDeciResult() {
		final boolean SUCCESS = true;
		
		DeciResultHelper<CartemInfo> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		List<CartemInfo> dummyResultset = new ArrayList<>();
		dummyResultset.add(new CartemInfo());
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CartemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
