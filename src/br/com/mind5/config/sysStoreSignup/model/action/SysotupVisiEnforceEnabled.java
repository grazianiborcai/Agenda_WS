package br.com.mind5.config.sysStoreSignup.model.action;

import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.config.sysStoreSignup.info.SysotupSetterEnabled;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SysotupVisiEnforceEnabled extends ActionVisitorTemplateEnforce<SysotupInfo> {
	
	public SysotupVisiEnforceEnabled(DeciTreeOption<SysotupInfo> option) {
		super(option);
	}

	
	
	@Override protected SysotupInfo enforceHook(SysotupInfo recordInfo) {
		InfoSetter<SysotupInfo> attrSetter = new SysotupSetterEnabled();
		return attrSetter.setAttr(recordInfo);
	}
}
