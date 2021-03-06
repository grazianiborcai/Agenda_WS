package br.com.mind5.security.username.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StdUsernameDaoSelect extends ActionStdTemplate<UsernameInfo> {

	public StdUsernameDaoSelect(DeciTreeOption<UsernameInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<UsernameInfo> buildVisitorHook(DeciTreeOption<UsernameInfo> option) {
		return new VisiUsernameDaoSelect(option);
	}
}
