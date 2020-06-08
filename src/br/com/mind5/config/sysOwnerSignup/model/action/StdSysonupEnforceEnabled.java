package br.com.mind5.config.sysOwnerSignup.model.action;

import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSysonupEnforceEnabled extends ActionStdTemplateV2<SysonupInfo> {

	public StdSysonupEnforceEnabled(DeciTreeOption<SysonupInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SysonupInfo> buildVisitorHook(DeciTreeOption<SysonupInfo> option) {
		return new VisiSysonupEnforceEnabled(option);
	}
}
