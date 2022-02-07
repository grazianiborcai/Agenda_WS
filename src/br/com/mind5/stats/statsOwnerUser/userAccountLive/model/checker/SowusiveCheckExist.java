package br.com.mind5.stats.statsOwnerUser.userAccountLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.info.SowusiveInfo;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.model.action.StdSowusiveDaoSelect;

public final class SowusiveCheckExist extends ModelCheckerTemplateAction<SowusiveInfo, SowusiveInfo> {
	
	public SowusiveCheckExist(ModelCheckerOption option) {
		super(option, SowusiveInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowusiveInfo> buildActionHook(DeciTreeOption<SowusiveInfo> option) {
		ActionStd<SowusiveInfo> select = new StdSowusiveDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWNER_USER_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWNER_USER_LIVE_NOT_FOUND;
	}
}
