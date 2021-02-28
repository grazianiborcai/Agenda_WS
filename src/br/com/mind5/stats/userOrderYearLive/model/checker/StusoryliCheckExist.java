package br.com.mind5.stats.userOrderYearLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userOrderYearLive.info.StusoryliInfo;
import br.com.mind5.stats.userOrderYearLive.model.action.StdStusoryliDaoSelect;

public final class StusoryliCheckExist extends ModelCheckerTemplateAction<StusoryliInfo, StusoryliInfo> {
	
	public StusoryliCheckExist(ModelCheckerOption option) {
		super(option, StusoryliInfo.class);
	}
	
	
	
	@Override protected ActionStd<StusoryliInfo> buildActionHook(DeciTreeOption<StusoryliInfo> option) {
		ActionStd<StusoryliInfo> select = new StdStusoryliDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_USER_YEAR_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_USER_YEAR_LIVE_NOT_FOUND;
	}
}
