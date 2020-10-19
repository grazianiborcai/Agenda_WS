package br.com.mind5.config.sysStoreSignup.model.action;

import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.config.sysStoreSignup.info.SysotupSetterEnabled;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSysotupEnforceEnabled extends ActionVisitorTemplateEnforceV2<SysotupInfo> {
	
	public VisiSysotupEnforceEnabled(DeciTreeOption<SysotupInfo> option) {
		super(option);
	}

	
	
	@Override protected SysotupInfo enforceHook(SysotupInfo recordInfo) {
		InfoSetter<SysotupInfo> attrSetter = new SysotupSetterEnabled();
		return attrSetter.setAttr(recordInfo);
	}
}
