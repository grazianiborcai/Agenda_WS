package br.com.mind5.config.sysOwnerSignup.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.config.sysOwnerSignup.model.decisionTree.RootSysonupSelectEnabled;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SysonupCheckEnabled extends ModelCheckerTemplateActionV2<SysonupInfo, SysonupInfo> {
	
	public SysonupCheckEnabled(ModelCheckerOption option) {
		super(option, SysonupInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<SysonupInfo> buildActionHook(DeciTreeOption<SysonupInfo> option) {
		ActionStdV2<SysonupInfo> select = new RootSysonupSelectEnabled(option).toAction();
		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_OWNER_SIGNUP_ENABLED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_OWNER_SIGNUP_DISABLED;
	}
}
