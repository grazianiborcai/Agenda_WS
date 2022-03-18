package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.action.SteddiveVisiDaoSelect;

public final class SteddiveCheckExist extends ModelCheckerTemplateAction<SteddiveInfo, SteddiveInfo> {
	
	public SteddiveCheckExist(ModelCheckerOption option) {
		super(option, SteddiveInfo.class);
	}
	
	
	
	@Override protected ActionStd<SteddiveInfo> buildActionHook(DeciTreeOption<SteddiveInfo> option) {
		ActionStd<SteddiveInfo> select = new ActionStdCommom<SteddiveInfo>(option, SteddiveVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_STR_SCH_DAY_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STR_SCH_DAY_LIVE_NOT_FOUND;
	}
}
