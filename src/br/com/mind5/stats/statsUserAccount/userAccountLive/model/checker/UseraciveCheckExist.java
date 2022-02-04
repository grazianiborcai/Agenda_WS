package br.com.mind5.stats.statsUserAccount.userAccountLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveInfo;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.action.StdUseraciveDaoSelect;

public final class UseraciveCheckExist extends ModelCheckerTemplateAction<UseraciveInfo, UseraciveInfo> {
	
	public UseraciveCheckExist(ModelCheckerOption option) {
		super(option, UseraciveInfo.class);
	}
	
	
	
	@Override protected ActionStd<UseraciveInfo> buildActionHook(DeciTreeOption<UseraciveInfo> option) {
		ActionStd<UseraciveInfo> select = new StdUseraciveDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_USER_ACCT_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_USER_ACCT_LIVE_NOT_FOUND;
	}
}
