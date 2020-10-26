package br.com.mind5.config.sysOwnerConfig.model.action;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSysonfigMergeSytotin extends ActionStdTemplateV2<SysonfigInfo> {

	public StdSysonfigMergeSytotin(DeciTreeOption<SysonfigInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SysonfigInfo> buildVisitorHook(DeciTreeOption<SysonfigInfo> option) {
		return new VisiSysonfigMergeSytotin(option);
	}
}
