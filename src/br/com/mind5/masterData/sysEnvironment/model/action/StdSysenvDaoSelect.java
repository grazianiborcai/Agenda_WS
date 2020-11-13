package br.com.mind5.masterData.sysEnvironment.model.action;

import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSysenvDaoSelect extends ActionStdTemplate<SysenvInfo> {

	public StdSysenvDaoSelect(DeciTreeOption<SysenvInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SysenvInfo> buildVisitorHook(DeciTreeOption<SysenvInfo> option) {
		return new VisiSysenvDaoSelect(option);
	}
}
