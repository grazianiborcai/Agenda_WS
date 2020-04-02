package br.com.mind5.message.emailWelcome.model.action;

import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmacomeSendEmail implements ActionStdV1<EmacomeInfo> {
	private ActionStdV1<EmacomeInfo> actionHelper;	
	
	
	public StdEmacomeSendEmail(DeciTreeOption<EmacomeInfo> option) {			
		actionHelper = new ActionStdHelperAction<EmacomeInfo>(option.recordInfos, new VisiEmacomeSendEmail(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmacomeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmacomeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
