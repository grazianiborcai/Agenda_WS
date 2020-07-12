package br.com.mind5.config.sysConfig.model.action;

import br.com.mind5.config.sysConfig.info.SysonfigInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSysonfigMergeToSelect extends ActionStdTemplateV2<SysonfigInfo> {

	public StdSysonfigMergeToSelect(DeciTreeOption<SysonfigInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SysonfigInfo> buildVisitorHook(DeciTreeOption<SysonfigInfo> option) {
		return new VisiSysonfigMergeToSelect(option);
	}
}
