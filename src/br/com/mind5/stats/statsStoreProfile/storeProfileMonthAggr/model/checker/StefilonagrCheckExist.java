package br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.action.StefilonagrVisiDaoSelect;

public final class StefilonagrCheckExist extends ModelCheckerTemplateAction<StefilonagrInfo, StefilonagrInfo> {
	
	public StefilonagrCheckExist(ModelCheckerOption option) {
		super(option, StefilonagrInfo.class);
	}
	
	
	
	@Override protected ActionStd<StefilonagrInfo> buildActionHook(DeciTreeOption<StefilonagrInfo> option) {
		ActionStd<StefilonagrInfo> select = new ActionStdCommom<StefilonagrInfo>(option, StefilonagrVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_STR_PRF_MTH_AGGR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STR_PRF_MTH_AGGR_NOT_FOUND;
	}
}
