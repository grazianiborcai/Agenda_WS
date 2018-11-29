package br.com.gda.business.person.model.action;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPersonFilterCpfFilled implements ActionStd<PersonInfo> {
	private ActionStd<PersonInfo> actionHelper;	
	
	
	public StdPersonFilterCpfFilled(DeciTreeOption<PersonInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPersonFilterCpfFilled());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersonInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
