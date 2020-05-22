package br.com.mind5.masterData.sysEnvironment.model.action;

import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSysenvDaoSelect extends ActionStdTemplateV2<SysenvInfo> {

	public StdSysenvDaoSelect(DeciTreeOption<SysenvInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SysenvInfo> buildVisitorHook(DeciTreeOption<SysenvInfo> option) {
		return new VisiSysenvDaoSelect(option);
	}
}
