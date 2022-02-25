package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchhInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.decisionTree.RootSowedularchSelectMonth;

public final class SowedularchCheckExistMonth extends ModelCheckerTemplateAction<SowedularchhInfo, SowedularchhInfo> {
	
	public SowedularchCheckExistMonth(ModelCheckerOption option) {
		super(option, SowedularchhInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowedularchhInfo> buildActionHook(DeciTreeOption<SowedularchhInfo> option) {
		ActionStd<SowedularchhInfo> select = new RootSowedularchSelectMonth(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWN_SCH_MTH_SRCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWN_SCH_MTH_SRCH_NOT_FOUND;
	}
}
