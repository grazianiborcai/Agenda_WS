package br.com.mind5.security.userHome.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userHome.info.UsomeInfo;

public final class StdUsomeMergeUsername extends ActionStdTemplate<UsomeInfo> {

	public StdUsomeMergeUsername(DeciTreeOption<UsomeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<UsomeInfo> buildVisitorHook(DeciTreeOption<UsomeInfo> option) {
		return new VisiUsomeMergeUsername(option);
	}
}
