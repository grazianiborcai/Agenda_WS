package br.com.mind5.security.username.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StdUsernameMergeAuthGrRole extends ActionStdTemplateV2<UsernameInfo> {

	public StdUsernameMergeAuthGrRole(DeciTreeOption<UsernameInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<UsernameInfo> buildVisitorHook(DeciTreeOption<UsernameInfo> option) {
		return new VisiUsernameMergeAuthGrRole(option);
	}
}
