package br.com.mind5.config.sysStoreSignup.model.action;

import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSysotupDaoSelect extends ActionStdTemplate<SysotupInfo> {

	public StdSysotupDaoSelect(DeciTreeOption<SysotupInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SysotupInfo> buildVisitorHook(DeciTreeOption<SysotupInfo> option) {
		return new VisiSysotupDaoSelect(option);
	}
}
