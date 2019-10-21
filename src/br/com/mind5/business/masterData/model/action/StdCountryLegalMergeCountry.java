package br.com.mind5.business.masterData.model.action;

import br.com.mind5.business.masterData.info.CountryLegalInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCountryLegalMergeCountry implements ActionStd<CountryLegalInfo> {
	private ActionStd<CountryLegalInfo> actionHelper;	
	
	
	public StdCountryLegalMergeCountry(DeciTreeOption<CountryLegalInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCountryLegalMergeCountry(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CountryLegalInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CountryLegalInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
