package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.decisionTree.StusorygrarchRootSelectByUser;

public final class StusorygrarchCheckExistUser extends ModelCheckerTemplateAction<StusorygrarchInfo, StusorygrarchInfo> {
	
	public StusorygrarchCheckExistUser(ModelCheckerOption option) {
		super(option, StusorygrarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<StusorygrarchInfo> buildActionHook(DeciTreeOption<StusorygrarchInfo> option) {
		ActionStd<StusorygrarchInfo> select = new StusorygrarchRootSelectByUser(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_USER_YEAR_AGGR_S_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_USER_YEAR_AGGR_S_NOT_FOUND;
	}
}
