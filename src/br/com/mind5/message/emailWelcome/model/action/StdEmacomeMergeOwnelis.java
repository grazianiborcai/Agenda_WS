package br.com.mind5.message.emailWelcome.model.action;

import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmacomeMergeOwnelis extends ActionStdTemplate<EmacomeInfo> {

	public StdEmacomeMergeOwnelis(DeciTreeOption<EmacomeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmacomeInfo> buildVisitorHook(DeciTreeOption<EmacomeInfo> option) {
		return new VisiEmacomeMergeOwnelis(option);
	}
}
