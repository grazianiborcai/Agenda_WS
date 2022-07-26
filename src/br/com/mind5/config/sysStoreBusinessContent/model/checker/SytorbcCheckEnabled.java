package br.com.mind5.config.sysStoreBusinessContent.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.config.sysStoreBusinessContent.model.decisionTree.SytorbcRootSelectEnabled;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SytorbcCheckEnabled extends ModelCheckerTemplateAction<SytorbcInfo, SytorbcInfo> {
	
	public SytorbcCheckEnabled(ModelCheckerOption option) {
		super(option, SytorbcInfo.class);
	}
	
	
	
	@Override protected ActionStd<SytorbcInfo> buildActionHook(DeciTreeOption<SytorbcInfo> option) {
		ActionStd<SytorbcInfo> select = new SytorbcRootSelectEnabled(option).toAction();		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_STORE_BC_ENABLED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_STORE_BC_DISABLED;
	}
}
