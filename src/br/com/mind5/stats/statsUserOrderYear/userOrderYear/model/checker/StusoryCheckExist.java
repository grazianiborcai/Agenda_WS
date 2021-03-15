package br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.info.StusorygrInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.model.action.StdStusorygrDaoSelect;

public final class StusoryCheckExist extends ModelCheckerTemplateAction<StusorygrInfo, StusorygrInfo> {
	
	public StusoryCheckExist(ModelCheckerOption option) {
		super(option, StusorygrInfo.class);
	}
	
	
	
	@Override protected ActionStd<StusorygrInfo> buildActionHook(DeciTreeOption<StusorygrInfo> option) {
		ActionStd<StusorygrInfo> select = new StdStusorygrDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_USER_YEAR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_USER_YEAR_NOT_FOUND;
	}
}
