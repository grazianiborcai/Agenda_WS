package br.com.mind5.config.sysDistrictSearch.model.action;

import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.config.sysDistrictSearch.info.SysdistrSetterDefault;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSysdistrEnforceDefault extends ActionVisitorTemplateEnforce<SysdistrInfo> {
	
	public VisiSysdistrEnforceDefault(DeciTreeOption<SysdistrInfo> option) {
		super(option);
	}

	
	
	@Override protected SysdistrInfo enforceHook(SysdistrInfo recordInfo) {
		InfoSetter<SysdistrInfo> attrSetter = new SysdistrSetterDefault();
		return attrSetter.setAttr(recordInfo);
	}
}
