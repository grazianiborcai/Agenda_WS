package br.com.mind5.security.userPassword.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class StdUpswdEnforceLength extends ActionStdTemplate<UpswdInfo> {

	public StdUpswdEnforceLength(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<UpswdInfo> buildVisitorHook(DeciTreeOption<UpswdInfo> option) {
		return new VisiUpswdEnforceLength(option);
	}
}
