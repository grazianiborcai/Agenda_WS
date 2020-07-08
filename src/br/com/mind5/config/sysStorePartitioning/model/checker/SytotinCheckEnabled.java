package br.com.mind5.config.sysStorePartitioning.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.action.LazySytotinDaoSelect;
import br.com.mind5.config.sysStorePartitioning.model.action.StdSytotinEnforceEnabled;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SytotinCheckEnabled extends ModelCheckerTemplateActionV2<SytotinInfo, SytotinInfo> {
	
	public SytotinCheckEnabled(ModelCheckerOption option) {
		super(option, SytotinInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<SytotinInfo> buildActionHook(DeciTreeOption<SytotinInfo> option) {
		ActionStdV1<SytotinInfo> enforceEnabled = new StdSytotinEnforceEnabled(option);
		ActionLazyV1<SytotinInfo> select = new LazySytotinDaoSelect(option.conn, option.schemaName);
		
		enforceEnabled.addPostAction(select);
		
		return enforceEnabled;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_STORE_PARTITIONING_ENABLED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_STORE_PARTITIONING_DISABLED;
	}
}
