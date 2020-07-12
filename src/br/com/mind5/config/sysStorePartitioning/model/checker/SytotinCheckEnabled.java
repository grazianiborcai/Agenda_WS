package br.com.mind5.config.sysStorePartitioning.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.decisionTree.RootSytotinSelectEnabled;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SytotinCheckEnabled extends ModelCheckerTemplateActionV2<SytotinInfo, SytotinInfo> {
	
	public SytotinCheckEnabled(ModelCheckerOption option) {
		super(option, SytotinInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<SytotinInfo> buildActionHook(DeciTreeOption<SytotinInfo> option) {
		ActionStdV1<SytotinInfo> select = new RootSytotinSelectEnabled(option).toAction();		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_STORE_PARTITION_ENABLED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_STORE_PARTITION_DISABLED;
	}
}
