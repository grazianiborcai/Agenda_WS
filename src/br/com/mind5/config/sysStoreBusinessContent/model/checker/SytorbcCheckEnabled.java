package br.com.mind5.config.sysStoreBusinessContent.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.config.sysStoreBusinessContent.model.decisionTree.RootSytorbcSelectEnabled;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SytorbcCheckEnabled extends ModelCheckerTemplateActionV2<SytorbcInfo, SytorbcInfo> {
	
	public SytorbcCheckEnabled(ModelCheckerOption option) {
		super(option, SytorbcInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<SytorbcInfo> buildActionHook(DeciTreeOption<SytorbcInfo> option) {
		ActionStdV1<SytorbcInfo> select = new RootSytorbcSelectEnabled(option).toAction();		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_STORE_BC_ENABLED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_STORE_BC_DISABLED;
	}
}
