package br.com.mind5.config.sysOwnerSignup.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.config.sysOwnerSignup.model.decisionTree.SysonupRootSelectEnabled;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SysonupCheckEnabled extends ModelCheckerTemplateAction<SysonupInfo, SysonupInfo> {
	
	public SysonupCheckEnabled(ModelCheckerOption option) {
		super(option, SysonupInfo.class);
	}
	
	
	
	@Override protected ActionStd<SysonupInfo> buildActionHook(DeciTreeOption<SysonupInfo> option) {
		ActionStd<SysonupInfo> select = new SysonupRootSelectEnabled(option).toAction();
		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_OWNER_SIGNUP_ENABLED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_OWNER_SIGNUP_DISABLED;
	}
}
