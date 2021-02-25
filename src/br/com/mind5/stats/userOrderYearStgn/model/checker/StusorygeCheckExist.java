package br.com.mind5.stats.userOrderYearStgn.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userOrderYearStgn.info.StusorygeInfo;
import br.com.mind5.stats.userOrderYearStgn.model.action.StdStusorygeDaoSelect;

public final class StusorygeCheckExist extends ModelCheckerTemplateAction<StusorygeInfo, StusorygeInfo> {
	
	public StusorygeCheckExist(ModelCheckerOption option) {
		super(option, StusorygeInfo.class);
	}
	
	
	
	@Override protected ActionStd<StusorygeInfo> buildActionHook(DeciTreeOption<StusorygeInfo> option) {
		ActionStd<StusorygeInfo> select = new StdStusorygeDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_USER_YEAR_STGN_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_USER_YEAR_STGN_NOT_FOUND;
	}
}
