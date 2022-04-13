package br.com.mind5.business.storeLunchTimeSearch.model.checker;

import br.com.mind5.business.storeLunchTimeSearch.info.StuntmarchInfo;
import br.com.mind5.business.storeLunchTimeSearch.model.decisionTree.StuntmarchRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmarchCheckExist extends ModelCheckerTemplateAction<StuntmarchInfo, StuntmarchInfo> {
	
	public StuntmarchCheckExist(ModelCheckerOption option) {
		super(option, StuntmarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<StuntmarchInfo> buildActionHook(DeciTreeOption<StuntmarchInfo> option) {
		ActionStd<StuntmarchInfo> select = new StuntmarchRootSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_LTIME_SEARCH_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_LTIME_SEARCH_NOT_FOUND;
	}
}
