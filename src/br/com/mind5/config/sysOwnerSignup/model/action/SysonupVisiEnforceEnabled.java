package br.com.mind5.config.sysOwnerSignup.model.action;

import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.config.sysOwnerSignup.info.SysonupSetterEnabled;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SysonupVisiEnforceEnabled extends ActionVisitorTemplateEnforce<SysonupInfo> {
	
	public SysonupVisiEnforceEnabled(DeciTreeOption<SysonupInfo> option) {
		super(option);
	}

	
	
	@Override protected SysonupInfo enforceHook(SysonupInfo recordInfo) {
		InfoSetter<SysonupInfo> attrSetter = new SysonupSetterEnabled();
		return attrSetter.setAttr(recordInfo);
	}
}
