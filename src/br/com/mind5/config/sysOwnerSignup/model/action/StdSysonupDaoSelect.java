package br.com.mind5.config.sysOwnerSignup.model.action;

import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSysonupDaoSelect extends ActionStdTemplate<SysonupInfo> {

	public StdSysonupDaoSelect(DeciTreeOption<SysonupInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SysonupInfo> buildVisitorHook(DeciTreeOption<SysonupInfo> option) {
		return new VisiSysonupDaoSelect(option);
	}
}
