package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.info.StusorygrInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.model.action.StdStusorygrDaoSelect;

public final class StusorygrCheckExist extends ModelCheckerTemplateAction<StusorygrInfo, StusorygrInfo> {
	
	public StusorygrCheckExist(ModelCheckerOption option) {
		super(option, StusorygrInfo.class);
	}
	
	
	
	@Override protected ActionStd<StusorygrInfo> buildActionHook(DeciTreeOption<StusorygrInfo> option) {
		ActionStd<StusorygrInfo> select = new StdStusorygrDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_USER_YEAR_AGGR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_USER_YEAR_AGGR_NOT_FOUND;
	}
}
