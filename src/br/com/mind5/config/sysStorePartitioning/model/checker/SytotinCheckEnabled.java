package br.com.mind5.config.sysStorePartitioning.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.decisionTree.RootSytotinSelectEnabled;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SytotinCheckEnabled extends ModelCheckerTemplateAction<SytotinInfo, SytotinInfo> {
	
	public SytotinCheckEnabled(ModelCheckerOption option) {
		super(option, SytotinInfo.class);
	}
	
	
	
	@Override protected ActionStd<SytotinInfo> buildActionHook(DeciTreeOption<SytotinInfo> option) {
		ActionStd<SytotinInfo> select = new RootSytotinSelectEnabled(option).toAction();		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_STORE_PARTITION_ENABLED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_STORE_PARTITION_DISABLED;
	}
}
