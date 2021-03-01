package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.decisionTree.RootStusorygerchSelect;

public final class StusorygerchCheckExist extends ModelCheckerTemplateAction<StusorygerchInfo, StusorygerchInfo> {
	
	public StusorygerchCheckExist(ModelCheckerOption option) {
		super(option, StusorygerchInfo.class);
	}
	
	
	
	@Override protected ActionStd<StusorygerchInfo> buildActionHook(DeciTreeOption<StusorygerchInfo> option) {
		ActionStd<StusorygerchInfo> select = new RootStusorygerchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_USER_YEAR_STGN_S_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_USER_YEAR_STGN_S_NOT_FOUND;
	}
}
