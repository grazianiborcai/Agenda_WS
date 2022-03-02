package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.decisionTree.SowusagrRootSelectMonth;

public final class SowusagrCheckExistMonth extends ModelCheckerTemplateAction<SowusagrInfo, SowusagrInfo> {
	
	public SowusagrCheckExistMonth(ModelCheckerOption option) {
		super(option, SowusagrInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowusagrInfo> buildActionHook(DeciTreeOption<SowusagrInfo> option) {
		ActionStd<SowusagrInfo> select = new SowusagrRootSelectMonth(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWN_USR_MTH_AGGR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWN_USR_MTH_AGGR_NOT_FOUND;
	}
}
