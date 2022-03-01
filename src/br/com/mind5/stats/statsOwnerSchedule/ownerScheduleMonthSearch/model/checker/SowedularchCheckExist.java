package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action.SowedularchVisiRootSelect;

public final class SowedularchCheckExist extends ModelCheckerTemplateAction<SowedularchInfo, SowedularchInfo> {
	
	public SowedularchCheckExist(ModelCheckerOption option) {
		super(option, SowedularchInfo.class);
	}
	
	
	
	@Override protected ActionStd<SowedularchInfo> buildActionHook(DeciTreeOption<SowedularchInfo> option) {
		ActionStd<SowedularchInfo> select = new ActionStdCommom<SowedularchInfo>(option, SowedularchVisiRootSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWN_SCH_MTH_SRCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWN_SCH_MTH_SRCH_NOT_FOUND;
	}
}
