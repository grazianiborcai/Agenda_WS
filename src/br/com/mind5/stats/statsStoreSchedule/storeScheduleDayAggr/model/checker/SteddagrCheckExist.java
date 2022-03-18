package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.action.SteddagrVisiDaoSelect;

public final class SteddagrCheckExist extends ModelCheckerTemplateAction<SteddagrInfo, SteddagrInfo> {
	
	public SteddagrCheckExist(ModelCheckerOption option) {
		super(option, SteddagrInfo.class);
	}
	
	
	
	@Override protected ActionStd<SteddagrInfo> buildActionHook(DeciTreeOption<SteddagrInfo> option) {
		ActionStd<SteddagrInfo> select = new ActionStdCommom<SteddagrInfo>(option, SteddagrVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_STR_SCH_DAY_AGGR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STR_SCH_DAY_AGGR_NOT_FOUND;
	}
}
