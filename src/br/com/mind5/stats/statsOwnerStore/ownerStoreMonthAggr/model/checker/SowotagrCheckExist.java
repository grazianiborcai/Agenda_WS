package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.action.SowotagrVisiDaoSelect;

public final class SowotagrCheckExist extends ModelCheckerTemplateAction<SowotagrInfo, SowotagrInfo> {
	
	public SowotagrCheckExist(ModelCheckerOption option) {
		super(option, SowotagrInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowotagrInfo> buildActionHook(DeciTreeOption<SowotagrInfo> option) {
		ActionStd<SowotagrInfo> select = new ActionStdCommom<SowotagrInfo>(option, SowotagrVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWN_STR_MTH_AGGR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWN_STR_MTH_AGGR_NOT_FOUND;
	}
}
