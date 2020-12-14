package br.com.mind5.stats.userStore.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userStore.info.StusoreInfo;
import br.com.mind5.stats.userStore.model.decisionTree.RootStusoreExist;

public final class StusoreCheckExist extends ModelCheckerTemplateAction<StusoreInfo, StusoreInfo> {
	
	public StusoreCheckExist(ModelCheckerOption option) {
		super(option, StusoreInfo.class);
	}
	
	
	
	@Override protected ActionStd<StusoreInfo> buildActionHook(DeciTreeOption<StusoreInfo> option) {
		ActionStd<StusoreInfo> select = new RootStusoreExist(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STAT_STORE_USER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STORE_USER_NOT_FOUND;
	}
}
