package br.com.mind5.security.userSnapshot.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class StdUserapMergePhonap extends ActionStdTemplate<UserapInfo> {

	public StdUserapMergePhonap(DeciTreeOption<UserapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<UserapInfo> buildVisitorHook(DeciTreeOption<UserapInfo> option) {
		return new VisiUserapMergePhonap(option);
	}
}
