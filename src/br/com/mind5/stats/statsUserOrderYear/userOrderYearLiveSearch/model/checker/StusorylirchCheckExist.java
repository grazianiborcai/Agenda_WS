package br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.action.StdStusorylirchDaoSelect;

public final class StusorylirchCheckExist extends ModelCheckerTemplateAction<StusorylirchInfo, StusorylirchInfo> {
	
	public StusorylirchCheckExist(ModelCheckerOption option) {
		super(option, StusorylirchInfo.class);
	}
	
	
	
	@Override protected ActionStd<StusorylirchInfo> buildActionHook(DeciTreeOption<StusorylirchInfo> option) {
		ActionStd<StusorylirchInfo> select = new StdStusorylirchDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_USER_YEAR_LIVE_S_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_USER_YEAR_LIVE_S_NOT_FOUND;
	}
}
