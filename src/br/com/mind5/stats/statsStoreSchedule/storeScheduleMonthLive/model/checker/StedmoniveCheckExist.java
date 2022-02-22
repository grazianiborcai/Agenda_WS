package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action.StdStedmoniveDaoSelect;

public final class StedmoniveCheckExist extends ModelCheckerTemplateAction<StedmoniveInfo, StedmoniveInfo> {
	
	public StedmoniveCheckExist(ModelCheckerOption option) {
		super(option, StedmoniveInfo.class);
	}
	
	
	
	@Override protected ActionStd<StedmoniveInfo> buildActionHook(DeciTreeOption<StedmoniveInfo> option) {
		ActionStd<StedmoniveInfo> select = new StdStedmoniveDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_STR_SCH_MTH_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STR_SCH_MTH_LIVE_NOT_FOUND;
	}
}
