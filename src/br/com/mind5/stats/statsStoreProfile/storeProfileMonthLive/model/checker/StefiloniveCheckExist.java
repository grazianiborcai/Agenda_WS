package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.action.StefiloniveVisiDaoSelect;

public final class StefiloniveCheckExist extends ModelCheckerTemplateAction<StefiloniveInfo, StefiloniveInfo> {
	
	public StefiloniveCheckExist(ModelCheckerOption option) {
		super(option, StefiloniveInfo.class);
	}
	
	
	
	@Override protected ActionStd<StefiloniveInfo> buildActionHook(DeciTreeOption<StefiloniveInfo> option) {
		ActionStd<StefiloniveInfo> select = new ActionStdCommom<StefiloniveInfo>(option, StefiloniveVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_STR_PRF_MTH_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STR_PRF_MTH_LIVE_NOT_FOUND;
	}
}
