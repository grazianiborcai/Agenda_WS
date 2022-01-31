package br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.action.StdStoraciveDaoSelect;

public final class StoraciveCheckExist extends ModelCheckerTemplateAction<StoraciveInfo, StoraciveInfo> {
	
	public StoraciveCheckExist(ModelCheckerOption option) {
		super(option, StoraciveInfo.class);
	}
	
	
	
	@Override protected ActionStd<StoraciveInfo> buildActionHook(DeciTreeOption<StoraciveInfo> option) {
		ActionStd<StoraciveInfo> select = new StdStoraciveDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_STORE_ACCT_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STORE_ACCT_LIVE_NOT_FOUND;
	}
}
