package br.com.mind5.security.username.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StdUsernameMergeToSelect extends ActionStdTemplate<UsernameInfo> {

	public StdUsernameMergeToSelect(DeciTreeOption<UsernameInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<UsernameInfo> buildVisitorHook(DeciTreeOption<UsernameInfo> option) {
		return new VisiUsernameMergeToSelect(option);
	}
}
