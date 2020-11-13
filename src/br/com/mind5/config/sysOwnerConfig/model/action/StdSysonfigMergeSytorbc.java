package br.com.mind5.config.sysOwnerConfig.model.action;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSysonfigMergeSytorbc extends ActionStdTemplate<SysonfigInfo> {

	public StdSysonfigMergeSytorbc(DeciTreeOption<SysonfigInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SysonfigInfo> buildVisitorHook(DeciTreeOption<SysonfigInfo> option) {
		return new VisiSysonfigMergeSytorbc(option);
	}
}
