package br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.info.StusoryliInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.model.action.StusoryliVisiDaoSelect;

public final class StusoryliCheckExist extends ModelCheckerTemplateAction<StusoryliInfo, StusoryliInfo> {
	
	public StusoryliCheckExist(ModelCheckerOption option) {
		super(option, StusoryliInfo.class);
	}
	
	
	
	@Override protected ActionStd<StusoryliInfo> buildActionHook(DeciTreeOption<StusoryliInfo> option) {
		ActionStd<StusoryliInfo> select = new ActionStdCommom<StusoryliInfo>(option, StusoryliVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_USER_YEAR_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_USER_YEAR_LIVE_NOT_FOUND;
	}
}
