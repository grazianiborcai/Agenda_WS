package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.decisionTree.RootSowedulagrSelectMonth;

public final class SowedulagrCheckExistMonth extends ModelCheckerTemplateAction<SowedulagrInfo, SowedulagrInfo> {
	
	public SowedulagrCheckExistMonth(ModelCheckerOption option) {
		super(option, SowedulagrInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowedulagrInfo> buildActionHook(DeciTreeOption<SowedulagrInfo> option) {
		ActionStd<SowedulagrInfo> select = new RootSowedulagrSelectMonth(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWN_SCH_MTH_AGGR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWN_SCH_MTH_AGGR_NOT_FOUND;
	}
}
