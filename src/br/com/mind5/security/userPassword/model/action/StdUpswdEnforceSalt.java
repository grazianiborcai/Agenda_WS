package br.com.mind5.security.userPassword.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class StdUpswdEnforceSalt extends ActionStdTemplateV2<UpswdInfo> {

	public StdUpswdEnforceSalt(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<UpswdInfo> buildVisitorHook(DeciTreeOption<UpswdInfo> option) {
		return new VisiUpswdEnforceSalt(option);
	}
}
