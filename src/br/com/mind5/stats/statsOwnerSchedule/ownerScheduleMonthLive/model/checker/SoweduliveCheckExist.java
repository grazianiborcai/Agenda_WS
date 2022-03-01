package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action.SoweduliveVisiDaoSelect;

public final class SoweduliveCheckExist extends ModelCheckerTemplateAction<SoweduliveInfo, SoweduliveInfo> {
	
	public SoweduliveCheckExist(ModelCheckerOption option) {
		super(option, SoweduliveInfo.class);
	}
	
	
	
	@Override protected ActionStd<SoweduliveInfo> buildActionHook(DeciTreeOption<SoweduliveInfo> option) {
		ActionStd<SoweduliveInfo> select = new ActionStdCommom<SoweduliveInfo>(option, SoweduliveVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_OWNER_SCHED_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWNER_SCHED_LIVE_NOT_FOUND;
	}
}
