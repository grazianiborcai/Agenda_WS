package br.com.mind5.config.sysStoreSignup.model.action;

import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSysotupDaoSelect extends ActionStdTemplateV2<SysotupInfo> {

	public StdSysotupDaoSelect(DeciTreeOption<SysotupInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SysotupInfo> buildVisitorHook(DeciTreeOption<SysotupInfo> option) {
		return new VisiSysotupDaoSelect(option);
	}
}
