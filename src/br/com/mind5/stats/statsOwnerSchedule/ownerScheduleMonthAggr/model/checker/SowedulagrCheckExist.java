package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action.StdStedmonagrDaoSelect;

public final class SowedulagrCheckExist extends ModelCheckerTemplateAction<SowedulagrInfo, SowedulagrInfo> {
	
	public SowedulagrCheckExist(ModelCheckerOption option) {
		super(option, SowedulagrInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowedulagrInfo> buildActionHook(DeciTreeOption<SowedulagrInfo> option) {
		ActionStd<SowedulagrInfo> select = new StdStedmonagrDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_STR_SCH_MTH_AGGR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STR_SCH_MTH_AGGR_NOT_FOUND;
	}
}
