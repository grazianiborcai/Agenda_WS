package br.com.mind5.config.sysStoreSignup.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.config.sysStoreSignup.model.decisionTree.RootSysotupSelectEnabled;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SysotupCheckEnabled extends ModelCheckerTemplateActionV2<SysotupInfo, SysotupInfo> {
	
	public SysotupCheckEnabled(ModelCheckerOption option) {
		super(option, SysotupInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<SysotupInfo> buildActionHook(DeciTreeOption<SysotupInfo> option) {
		ActionStdV1<SysotupInfo> select = new RootSysotupSelectEnabled(option).toAction();
		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_STORE_SIGNUP_ENABLED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_STORE_SIGNUP_DISABLED;
	}
}
