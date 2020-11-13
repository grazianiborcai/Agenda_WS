package br.com.mind5.config.sysStoreSignup.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.config.sysStoreSignup.model.decisionTree.RootSysotupSelectEnabled;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SysotupCheckEnabled extends ModelCheckerTemplateAction<SysotupInfo, SysotupInfo> {
	
	public SysotupCheckEnabled(ModelCheckerOption option) {
		super(option, SysotupInfo.class);
	}
	
	
	
	@Override protected ActionStd<SysotupInfo> buildActionHook(DeciTreeOption<SysotupInfo> option) {
		ActionStd<SysotupInfo> select = new RootSysotupSelectEnabled(option).toAction();
		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_STORE_SIGNUP_ENABLED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_STORE_SIGNUP_DISABLED;
	}
}
