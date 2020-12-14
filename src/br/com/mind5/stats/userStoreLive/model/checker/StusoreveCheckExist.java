package br.com.mind5.stats.userStoreLive.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userStoreLive.info.StusoreveInfo;
import br.com.mind5.stats.userStoreLive.model.action.StdStusoreveDaoSelect;

public final class StusoreveCheckExist extends ModelCheckerTemplateAction<StusoreveInfo, StusoreveInfo> {
	
	public StusoreveCheckExist(ModelCheckerOption option) {
		super(option, StusoreveInfo.class);
	}
	
	
	
	@Override protected ActionStd<StusoreveInfo> buildActionHook(DeciTreeOption<StusoreveInfo> option) {
		ActionStd<StusoreveInfo> select = new StdStusoreveDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_STORE_USER_LIVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STORE_USER_LIVE_NOT_FOUND;
	}
}
