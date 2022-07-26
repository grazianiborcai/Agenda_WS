package br.com.mind5.config.sysDistrictSearch.model.action;

import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.config.sysDistrictSearch.info.SysdistrSetterDefault;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SysdistrVisiEnforceDefault extends ActionVisitorTemplateEnforce<SysdistrInfo> {
	
	public SysdistrVisiEnforceDefault(DeciTreeOption<SysdistrInfo> option) {
		super(option);
	}

	
	
	@Override protected SysdistrInfo enforceHook(SysdistrInfo recordInfo) {
		InfoSetter<SysdistrInfo> attrSetter = new SysdistrSetterDefault();
		return attrSetter.setAttr(recordInfo);
	}
}
