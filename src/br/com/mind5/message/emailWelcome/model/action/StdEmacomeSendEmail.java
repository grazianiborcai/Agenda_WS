package br.com.mind5.message.emailWelcome.model.action;

import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmacomeSendEmail implements ActionStd<EmacomeInfo> {
	private ActionStd<EmacomeInfo> actionHelper;	
	
	
	public StdEmacomeSendEmail(DeciTreeOption<EmacomeInfo> option) {			
		actionHelper = new ActionStdHelperAction<EmacomeInfo>(option.recordInfos, new VisiEmacomeSendEmail(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmacomeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmacomeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
