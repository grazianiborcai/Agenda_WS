package br.com.mind5.config.sysDistrictSearch.model.action;

import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSysdistrSuccess extends ActionStdSuccessTemplate<SysdistrInfo> {
	
	public StdSysdistrSuccess(DeciTreeOption<SysdistrInfo> option) {
		super(option);
	}
}
