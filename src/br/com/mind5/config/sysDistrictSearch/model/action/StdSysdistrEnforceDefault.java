package br.com.mind5.config.sysDistrictSearch.model.action;

import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSysdistrEnforceDefault extends ActionStdTemplate<SysdistrInfo> {

	public StdSysdistrEnforceDefault(DeciTreeOption<SysdistrInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SysdistrInfo> buildVisitorHook(DeciTreeOption<SysdistrInfo> option) {
		return new VisiSysdistrEnforceDefault(option);
	}
}
