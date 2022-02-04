package br.com.mind5.stats.statsUserAccount.userAccountLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.SuseraciveInfo;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.action.StdSuseraciveDaoSelect;

public final class SuseraciveCheckExist extends ModelCheckerTemplateAction<SuseraciveInfo, SuseraciveInfo> {
	
	public SuseraciveCheckExist(ModelCheckerOption option) {
		super(option, SuseraciveInfo.class);
	}
	
	
	
	@Override protected ActionStd<SuseraciveInfo> buildActionHook(DeciTreeOption<SuseraciveInfo> option) {
		ActionStd<SuseraciveInfo> select = new StdSuseraciveDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_USER_ACCT_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_USER_ACCT_LIVE_NOT_FOUND;
	}
}
